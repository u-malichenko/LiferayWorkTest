<%@ include file="/init.jsp" %>

<portlet:actionURL name="employeeSubmit" var="employeeSubmit"/>

<h4>Employee Form</h4><br>
<form action="<%=employeeSubmit%>" method="Post">
Name: <label>
	<input type="text" name="<portlet:namespace/>name">
</label><br>
E-mail: <label>
	<input type="text" name="<portlet:namespace/>email">
</label><br>
Mobile: <label>
	<input type="text" name="<portlet:namespace/>mobile">
</label><br>
	<input type="Submit" value="SUBMIT">

</form>