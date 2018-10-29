<%@include file="header.html" %>

<h1>Add Job</h1>

<form method="post">
Job Id <br/>
<input type="text" name="id"  value="${job.id}" /> <p/>

Job Title <br/>
<input type="text" name="title" value="${job.title}" /> <p/>

Min Salary <br/>
<input type="number" name="minsal" value="${job.minsal}" /> <p/>

Max Salary <br/>
<input type="number" name="maxsal" value="${job.maxsal}"/> <p/>

<input type="submit" value="Add Job" />

</form>

<h3>${message}</h3>