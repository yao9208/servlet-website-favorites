<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />
	<h2>Favorite for ${user.firstName } ${user.lastName }</h2>
	<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>
        <form method="POST" action="add.do">
            <table>
                <tr><td colspan="3"><hr/></td></tr>
                <tr>
                   <td style="font-size: large">URL:</td>
                   <td colspan="2"><input type="text" size="40" name="url" value="${form.url }"/></td>
                </tr>
               <tr>
                   <td style="font-size: large">Comment:</td>
                   <td colspan="2"><input type="text" size="40" name="comment" value="${form.comment }"/></td>
              </tr>
               <tr>
                  <td style="display:none;">userID:</td>
                    <td style="display:none; colspan=2"><input type="text" size="40" value="${user.userID }" name="userID"/></td>
               </tr>
              <tr>
                    <td></td>
                   <td><input type="submit" name="action1" value="Add Favorite"/></td>
               </tr>
               <tr><td colspan="3"><hr/></td></tr>
           </table>
        </form>

    



      <c:forEach var="message" items="${messages}">
        	<p style="font-size: large; color: red" >${message}</p>
      </c:forEach>
	
	 <table>
        <c:forEach var="bean" items="${beans}" >
        	<tr>
        	 <td>
        	     <form method="POST">
        	     <input type="hidden" name="id" value="${bean.userID}" />
        	     </form>
        	     <form method="POST" action="remove.do">
        	     <input type="hidden" name="id" value="${bean.favoriteID}" />
        	     <input type="submit" name="action1" value="X"/>
        	     
        	     </form>
        	   </td>
			 
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
<jsp:include page="template-bottom.jsp" />