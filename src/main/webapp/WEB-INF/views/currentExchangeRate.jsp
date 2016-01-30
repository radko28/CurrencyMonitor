<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
  <table class="example"  >
	   <tr class = "tableHeader" >
			<th>Live currency</th>
	   	</tr>
		<tr>
   			<th>Currency</th><th>Exchange rate</th>
		</tr>
			   	
	    <c:forEach items="${liveCurrencyList}" var="currency" >
		    <tr>
   				<td>${currency.key}</td><td>${currency.value}</td>
			</tr>
   		</c:forEach>
  		
  </table>
  <table border = "0">
   	<tr>
		<td>${errorMessageLive}</td>
	</tr>
</table>
  

