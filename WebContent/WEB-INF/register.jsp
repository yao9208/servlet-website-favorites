<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />
	<h2>Favorite sites Register</h2>
	<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>
	<form method="POST">
           <table>
               <tr>
                  <td style="font-size: x-large">Email Adrress:</td>
               	  <td>
                   <input type="text" name="email" value="${form.email }"/>
                  </td>
              </tr>
              <tr>
                  <td style="font-size: x-large">First Name:</td>
                  <td><input type="text" name="firstName" value="${form.firstName }"/></td>
              </tr>
              <tr>
                  <td style="font-size: x-large">Last Name:</td>
                  <td><input type="text" name="lastName" value="${form.lastName }"/></td>
              </tr>
              <tr>
               	  <td style="font-size: x-large">Password:</td>
                  <td><input type="password" name="password" value="${form.password }"/></td>
              </tr>
              <tr>
               	  <td style="font-size: x-large">Confirm Password:</td>
                  <td><input type="password" name="confirm" value="${form.confirm }"/></td>
              </tr>
              <tr>
                  <td colspan="2" style="text-align: center;">
                  <input type="submit" name="button" value="Register" />
                  </td>
             </tr>
       </table>
        </form>
<jsp:include page="template-bottom.jsp" />