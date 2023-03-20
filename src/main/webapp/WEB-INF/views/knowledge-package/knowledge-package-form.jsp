<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="addKnowledgePackage" method="post" modelAttribute="formDataKnowledgePackageDTO" >
    <label for="title">Enter title</label>
    <form:input type="text" path="title" name="title"/>
    <br/>
    <label for="description">Enter description</label>
    <form:input type="text" path="description" name="description"/>
    <br/>
    <form:select path="knowledgePackageSetId">
        <c:forEach items="${knowledgePackageSets}" var="knowledgePackageSet">
        <form:option value="${knowledgePackageSet.id}" var="knowledgePackageSet">
            ${knowledgePackageSet.title}
        </form:option>
        </c:forEach>
    </form:select>
    <form:button>Add</form:button>
</form:form>
<a href="http://localhost:8080/kpacs">
    <button>Back</button>
</a>
</body>
</html>