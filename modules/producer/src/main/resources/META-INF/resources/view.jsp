<%@ include file="/init.jsp" %>


<h1>Producer</h1><br>
<portlet:actionURL name="producer" var="producer"/>


<form action="${producer}" method="Post">
    Input your message: <label>
    <input type="text" name="<portlet:namespace/>message">
</label>
    <input type="Submit" value="SUBMIT">

</form>