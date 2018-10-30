<%@include file="header.html"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h1>Add Job</h1>

<sf:form method="post" modelAttribute="job">
Id <br />
	<sf:input type="text" path="id" />
	<sf:errors path="id" />
	<p />

Title <br />
	<sf:input type="text" path="title" />
	<sf:errors path="title" />
	<p />

Min Salary <br />
	<sf:input type="number" path="minsal" />
	<sf:errors path="minsal" />
	<p />

Max Salary <br />
	<sf:input type="number" path="maxsal" />
	<sf:errors path="maxsal" />
	<p />

	<input type="submit" value="Add Job" />

</sf:form>

<h3>${message}</h3>