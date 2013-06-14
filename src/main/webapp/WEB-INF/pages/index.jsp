<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>

<c:forEach items="${groups}" var="group">
    <c:out value="${group}" /> <br/>
</c:forEach>
<p>---------</p>
<c:forEach items="${products}" var="product">
    <c:out value="${product}" /> <br/>
</c:forEach>

</body>
</html>