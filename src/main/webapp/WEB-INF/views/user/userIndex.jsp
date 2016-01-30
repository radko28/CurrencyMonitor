<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
	<h3><spring:message code="users.historical.legend" /></h3>
    <form:form commandName="historicalCurrency" method="post">
	<fieldset>
    <table style="padding-left: 10px; padding-right: 10px;" >
    	<tr>
    		<th colspan="4" align = "left"><spring:message code="users.historical.currency"/></th>
		</tr>
		<tr>
			<td>USA</td>
			<td>	
				<form:select path="currCode1">
					 <form:options items="${currencyCodeTypeList}" />
				</form:select>
			</td>
			<td>	
				<form:select path="currCode2">
					 <form:options items="${currencyCodeTypeList}" />
				</form:select>
			</td>
			<td>	
				<form:select path="currCode3">
					 <form:options items="${currencyCodeTypeList}" />
				</form:select>
			</td>
		</tr>
    	<tr>
			<th colspan="1"><form:label	for="currDateString" path="currDateString"><spring:message code="users.historical.date"/> *</form:label></th>
			<td colspan="3"><form:input path="currDateString"  /> <button id="trigger"><spring:message code="calendar" /></button> </td>
		</tr>
		<tr>
			<td colspan="4"> <form:errors path="currDateString" cssClass = "errortext" /></td>
		</tr>
		<tr>
			<th colspan="4" align = "left"><spring:message code="users.historical.ratelist"/></th>
		</tr>
    	<tr>
			<td colspan="4">	
		    	<c:forEach items="${historicalCurrencyList}" var="currency" >
				    <tr>
   						<td>${currency.key}</td><td>${currency.value}</td>
					</tr>
	   			</c:forEach>
			</td>
		</tr>
    	<tr>
			<td colspan="4">${errorMessageHistorical}</td>
		</tr>
		
		
    	<tr>
    	
    		<td colspan="2" style="text-align: right;"><input type="submit" name="action" value="<spring:message code="button.view" />"/></td>
		 	<td colspan="2"></td>
		</tr>
	</table>
    </fieldset>
    </form:form>
    <script type="text/javascript">
    
  	Calendar.setup(
    {
      inputField  : "currDateString",         // ID of the input field
      ifFormat    : "%Y-%m-%d",    // the date format
      button      : "trigger"       // ID of the button
    }
	  );
	</script>
</body>
</html>
