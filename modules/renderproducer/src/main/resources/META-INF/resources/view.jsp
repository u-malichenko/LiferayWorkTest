<%@ include file="/init.jsp" %>

<h1>RenderProducer</h1><br>
<portlet:actionURL name="renderProducer" var="renderProducer"/>


<form action="${renderProducer}" method="Post">
	Input your message: <label>
	<input type="text" name="<portlet:namespace/>message">
</label>
	<input type="Submit" value="SUBMIT">

</form>