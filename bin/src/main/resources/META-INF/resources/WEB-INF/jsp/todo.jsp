
<%@ include file="commom/header.jspf"%>>
<%@ include file="commom/navigation.jspf"%>>


<div class="container">
	<h1>Todo Detail</h1>
	<hr>
	<form:form method="post" modelAttribute="todo">

		<fieldset class="mb-2">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-2">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="ID" />

		<form:input type="hidden" path="done" />

		<br />
		<input type="submit" class="btn btn-success" />
	</form:form>



</div>
<%@ include file="commom/footer.jspf"%>>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>


