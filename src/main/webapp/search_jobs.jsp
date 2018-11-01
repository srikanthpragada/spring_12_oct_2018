 <%@include file="header.html"%>
 <script src="/jquery-3.3.1.min.js"></script>
 <script>
  function searchJobs() {
	  $.getJSON("/restjobs/search",  
			   {"title" : $("#title").val()},
			   showJobs);
  }
  
  function showJobs(jobs) {
	  $("#jobs").html("")   // clear elements from UL
	  $.each(jobs,
			  function(idx,job) {
		           $("#jobs").append("<li>" + job.title 
		        		   + " <a target='_blank' href='/jobs/edit/" + job.id + "'>Edit</a> </li>")
	          }
	  )
  }
 </script>
 <h2>Search Jobs</h2>
 Title : <input type="text" id="title" />
 <button onclick="searchJobs()">Search</button>
 <p/>
 <ul id="jobs">
 </ul>
 
 