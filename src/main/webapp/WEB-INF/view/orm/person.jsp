<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<page:template>
	<jsp:body>
<c:url value="/queryFindAllUsersJPA" var="queryFindAllUsersJPA" />
<c:url value="/newContact" var="newContact" />
	        <div class="container">
            <div class="form-group col-xs-4">
			<br>
			<h3>Persons List</h3>
        <%--<form:form action="result"  method="post">--%>
            <%--<input name="lastName" value=""/>--%>
            <%--<button type="submit" class="btn btn-primary"  value="send">Primary</button>--%>
            <%--&lt;%&ndash;<input type="submit" value="send"/>&ndash;%&gt;--%>
        <%--</form:form>--%>


        <p>Parameter from home ${userId}</p>
        <a href="${queryFindAllUsersJPA}" class="list-group-item">Find All Users</a>

				<a href="${newContact}" class="list-group-item">New Users</a>

			<c:if test="${!empty resultTask}">
				<table class="table table-striped table-bordered table-hover">
					<thead class="thead-dark">
						<th scope="row">ID</th>
						<th scope="row">Task Name</th>
						<th scope="row">lastName</th>
						<th scope="row">userName</th>
						<th scope="row">Edit</th>
						<th scope="row">Delete</th>
					</thead>
					<tbody>
					<c:forEach  items="${resultTask}" var="person">
						<tr>
							<td>${person.taskID}</td>
							<td>${person.taskName}</td>
							<td>${person.taskDescription}</td>
							<td>${person.userEntity.userFIO}</td>
							<td><a href="<c:url value='/edit?id=${person.taskID}' />" >Edit</a></td>
							<td><a href="<c:url value='deleteContact?id=${person.taskID}' />" >Delete</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>

		<%--</div>--%>
			<%--<form action="result" method="post">--%>
				<%--<label for="id_label_multiple">--%>

					<%--<select class="js-example-basic-multiple js-states form-control" multiple="multiple" id="id_label_multiple">--%>
						<%--<c:forEach  items="${resultObject}" var="person">--%>
						<%--<option value="${person.lastName}">${person.lastName}</option>--%>
									<%--</c:forEach>--%>
					<%--</select>--%>

				<%--<button type="submit" class="btn btn-primary "  value="send">Primary</button>--%>
				<%--</label>--%>
			<%--</form>--%>
        <%--</div>--%>
        <!-- /.container -->

	</jsp:body>
</page:template>