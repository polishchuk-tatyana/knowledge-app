<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Knowledge Packages</title>
    <link rel="stylesheet" type="text/css" href="scripts/dhtmlx/suite_trial/codebase/suite.css">
    <script src="scripts/dhtmlx/suite_trial/codebase/types/ts-grid/sources/Grid.d.ts" type="text/javascrqipt"></script>
<%--    <script type="text/javascript" src="scripts/jsfile.js"></script>--%>
</head>
<body>
<input type="button"
       value="Add KPac"
       onclick="window.location.href='kpacs/showAddKnowledgePackageForm'; return false;"/>
<div>
    <table:table>
        <c:forEach items="${knowledgePackages}" var="knowledgePackage">
            <tr>
                <td><c:out value="${knowledgePackage.title}"/></td>
                <td><c:out value="${knowledgePackage.description}"/></td>
                <td><c:out value="${knowledgePackage.creatingDate}"/></td>
                <td>
                <td>
                    <form:form method="DELETE" action="/kpacs/${knowledgePackage.id}">
                        <input type="submit" value="Delete">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table:table>
</div>
<a href="http://localhost:8080">
    <button>Home page</button>
</a>
<div style="height: 100%; width: 100%" id="grid"></div>
<script type="text/javascript">
    import {dhx} from "./scripts/dhtmlx/suite_trial";
    const grid = new dhx.Grid("grid", {
        columns: [
            { width: 100, id: "a", header: [{ text: "#" }] },
            { width: 100, id: "b", header: [{ text: "Title" }] },
            { width: 200, id: "c", header: [{ text: "Name" }] },
            { width: 200, id: "d", header: [{ text: "Address" }] }
        ],
        headerRowHeight: 50,
    });
</script>
</body>
</html>