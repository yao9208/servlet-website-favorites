<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<p>




      <c:forEach var="message" items="${messages}">
        	<p style="font-size: large; color: red" >${message}</p>
      </c:forEach>

	 <table>
        <c:forEach var="bean" items="${favoriteList}" >
 
			  <tr>  
			  	<td><a href="?action2=addclick&favoriteID=${bean.favoriteID}&url=${bean.url}"> ${bean.url}</a>
				</td>
			</tr>  
			<tr> 
				<td>${bean.comment} </td>
			</tr>  
			<tr>
				<td>${bean.clickCount} clicks</td>
        	 </tr>
        	
         	</c:forEach>
         </table>

</p>
<jsp:include page="template-bottom.jsp" />