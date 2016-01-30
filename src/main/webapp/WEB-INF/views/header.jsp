<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<table border = "1" style="width: 100%;vertical-align: top;">
<tr>
   	  <td align = "center" ><img src = "<c:url value='/images/logo?filename=cyklosoft_logo.jpg'/>"  align = "middle"/></td> 
      <td><h2><spring:message code="main.legend"/></h2></td>
  	  <td>
      <table>
      <tr>
        <security:authorize access="isAnonymous()">
      		<a href="<c:url value="/login"/>"><spring:message code="login.login"/></a>
      		| <a href="<c:url value="/register"/>"><spring:message code="login.register"/></a>
		</security:authorize>
		
	    <security:authorize access="isAuthenticated()">
	    <td>
	    <table>
	    	<tr>
	    	<td>
     			<spring:message code="login.legend"/> ${wholeName} &nbsp;<a href="<c:url value="/j_spring_security_logout" />" >
     			<spring:message code="login.logout"/></a>
     		</td>
     		</tr>
     		</table>
     		</td>
		</security:authorize>
		
     

</tr></table>
      </td>
    </tr>
    </table>


