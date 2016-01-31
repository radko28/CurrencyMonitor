<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" />TrangoWorld Boulder</title>
 	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/mainstyle.css"/>" />
 	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/calendar-win2k-1.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/js/calendar.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lang/calendar-en.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/calendar-setup.js"/>"></script>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" width = "100%" height = "700">
    <tr>
        <td height="1" colspan="2" style="vertical-align: top;"><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td height="600" valign = "top" ><tiles:insertAttribute name="menu" /></td>
        <td width="80%" valign = "top"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="5px" colspan="2" style = "background-color:rgb(183,197,63);"><tiles:insertAttribute name="footer" />
        </td>
    </tr> 
</table>
</body>
</html>