<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

	
	<p>
	<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>


	    <form method="POST">
        <table>
        	<tr>
       		 <td style="font-size: x-large">E-mail Address:</td>
        	 <td>
        		<input type="text" name="email" value="${form.email }"/>
       		 </td>
        	</tr>
        	<tr>
       			 <td style="font-size: x-large">Password:</td>
       			<td><input type="password" name="password"  value="${form.password}"/></td>
       		 </tr>
       		 <tr>
        		<td colspan="2" style="text-align: center;">
        		<input type="submit" name="button" value="Login" />
        		 </td>
         	 </tr>
         </table>
        </form>

        </p>
<jsp:include page="template-bottom.jsp" />