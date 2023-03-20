<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="addKnowledgePackageSet" method="post" modelAttribute="knowledgePackageSet">
    <label for="title">Enter title</label>
    <form:input type="text" path="title" name="title"/>
    <br/>
    <form:button>Add</form:button>
</form:form>
<a href="http://localhost:8080/sets">
    <button>Back</button>
</a>
</body>
</html>
