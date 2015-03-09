<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>

<p>
    <a href="manage.do">Back to manage your favorites</a>
</p>

<jsp:include page="template-bottom.jsp" />
