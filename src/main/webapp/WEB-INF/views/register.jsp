<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>

	<h3><spring:message code="users.create.legend" /></h3>
    <form:form commandName="user" method="post">
	<fieldset>
    <table style="padding-left: 10px; padding-right: 10px;">
    	<tr>
    		<td><form:label	for="username" path="username"><spring:message code="users.table.username"/> *</form:label></td>
			<td style="padding-right: 10px;"><form:input path="username" /></td>
			<td><form:label	for="firstname" path="firstname"><spring:message code="users.table.firstname"/> *</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td colspan="2"><form:errors path="username" cssClass = "errortext"/></td>
			<td colspan="2"><form:errors path="firstname" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    		<td><form:label	for="password" path="password"><spring:message code="password"/> *</form:label></td>
			<td><form:password path="password"/></td>
    		<td><form:label	for="lastname" path="lastname"><spring:message code="users.table.lastname"/> *</form:label></td>
			<td><form:input path="lastname"/></td>		
		</tr>
		<tr>
			<td colspan="2"><form:errors path="password" cssClass = "errortext" /></td>
			<td colspan="2"> <form:errors path="lastname" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    		<td><label for="confirm"><spring:message code="password.confirm"/> *</label></td>
			<td><form:password path="confirm"/></td>
		</tr><tr>
		<tr>
			<td colspan="2"><form:errors path="confirm" cssClass = "errortext" /></td>
		</tr>
		<tr>
    		<td><form:label	for="email" path="email"><spring:message code="users.table.email"/> *</form:label></td>
			<td style="padding-right: 10px;"><form:input path="email" /></td>
			<td><form:label	for="birthdateString" path="birthdateString"><spring:message code="users.table.birthdate"/> *</form:label></td>
			<td><form:input path="birthdateString"  /> <button id="trigger"><spring:message code="calendar" /></button> </td>			
		</tr>
		<tr>
			<td colspan="2"><form:errors path="email" cssClass = "errortext" /></td>
			<td colspan="2"> <form:errors path="birthdateString" cssClass = "errortext" /></td>
		</tr>
		
    	<tr>
    		<td><form:label	for="street" path="street"><spring:message code="users.table.street"/> *</form:label></td>
			<td style="padding-right: 10px;"><form:input path="street" /></td>
			<td><form:label	for="city" path="city"><spring:message code="users.table.city"/> *</form:label></td>
			<td><form:input path="city" /></td>
		</tr>
		<tr>
			<td colspan="2"><form:errors path="street" cssClass = "errortext" /></td>
			<td colspan="2"> <form:errors path="city" cssClass = "errortext" /></td>
		</tr>
		
		<tr>
			<td><form:label	for="zip" path="zip"><spring:message code="users.table.zip"/> *</form:label></td>
			<td style="padding-right: 10px;"><form:input path="zip" /></td>		
			<td><spring:message code="users.table.country"/> *</td>
				<td>
					<form:select path="country">
					  <form:options items="${countryTypeList}" />
				    </form:select>
                 </td>
    	<tr>
		<tr>
			<td colspan="2"><form:errors path="zip" cssClass = "errortext" /></td>
			<td colspan="2"> <form:errors path="country" cssClass = "errortext" /></td>
		</tr>
    	<tr>
    	
    		<td colspan="2" style="text-align: right;"><input type="submit" name="action" value="<spring:message code="button.save" />"/></td>
		 	<td colspan="2"></td>
		</tr>
	</table>
    </fieldset>
    </form:form>
    <script type="text/javascript">
  	Calendar.setup(
    {
      inputField  : "birthdateString",         // ID of the input field
      ifFormat    : "%d.%m.%Y",    // the date format
      button      : "trigger"       // ID of the button
    }
	  );
	</script>
</div>
</body>
</html>
