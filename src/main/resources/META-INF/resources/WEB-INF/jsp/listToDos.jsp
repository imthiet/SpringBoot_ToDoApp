
	<%@ include file = "commom/header.jspf" %>>    
    <%@ include file = "commom/navigation.jspf" %>>
   
	
	
    <div class = "container">
    <h1> Todos of ${name } </h1>
    	<hr>
       
       <table class="table">
			<thead>
				<tr>
					<th>ID</th>  
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
					
					
				</tr>
				
			</thead>       	
       	<tbody>
       	
       	
	       <c:forEach items = "${todos}" var = "todo">
	       
	       		<tr>
	       			<td>${todo.ID}</td>
	       			<td>${todo.description}</td>
	       			<td>${todo.targetDate}</td>
	       			<td>${todo.done}</td>
	       			<td><a href = "update-todo?ID=${todo.ID}" class = "btn btn-primary">Update ${todo.ID}</a></td>
	       			<td><a href = "delete-todo?ID=${todo.ID}" class = "btn btn-warning">Delete ${todo.ID}</a></td>
	       			
	       			
	       		</tr>
	       </c:forEach>
	    </tbody>
       </table>
       <a href = "add-todo" class = "btn btn-success">Add New Todo</a>
    </div>
    	
<%@ include file="commom/footer.jspf"%>>