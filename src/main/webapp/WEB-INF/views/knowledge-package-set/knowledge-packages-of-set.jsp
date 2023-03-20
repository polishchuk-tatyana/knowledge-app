<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:forEach items="${knowledgePackagesOfSet}" var="knowledgePackage">
        <p><c:out value="${knowledgePackage.id}"/></p>
        <p><c:out value="${knowledgePackage.title}"/></p>
        <p><c:out value="${knowledgePackage.description}"/></p>
        <br/>
    </c:forEach>
</div>
<a href="http://localhost:8080/sets">
    <button>Back</button>
</a>
</body>
</html>
