<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="Add KPacSet"
       onclick="window.location.href='sets/showAddKnowledgePackageSetForm'; return false;"
       class="btn btn-primary"/>
<div>
    <table:table>
        <c:forEach items="${knowledgePackageSets}" var="knowledgePackageSet">
            <tr>
                <td>
                    <a href="http://localhost:8080/sets/set/${knowledgePackageSet.id}">
                        <p><c:out value="${knowledgePackageSet.title}"/></p>
                    </a>
                </td>
                <td>
                    <form:form method="DELETE" action="/sets/${knowledgePackageSet.id}">
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
</body>
</html>
