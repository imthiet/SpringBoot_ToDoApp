
<%@ include file = "commom/header.jspf" %>>
<%@ include file = "commom/navigation.jspf" %>>



<div class = "container">
    <h1> Todos of ${name } </h1>
    <hr>

    <table class="table">
        <thead>
        <tr>

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

                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href = "update-todo-jpa?id=${todo.ID}" class = "btn btn-primary">Update</a></td>
                <td><a href = "delete-todo-jpa?id=${todo.ID}" class = "btn btn-warning">Delete</a></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href = "add-todo-jpa" class = "btn btn-success">Add New Todo</a>
</div>

<%@ include file="commom/footer.jspf"%>>