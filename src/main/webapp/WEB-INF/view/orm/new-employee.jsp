<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<page:template>
    <jsp:body>
        <div class="container">
            <form:form  action="saveContact" method="GET" modelAttribute="taskEntity">
                <input  type="hidden" id="taskID" name="taskID" value="${taskEntity.taskID}">
                <h2>Employee</h2>
                <div class="form-group col-xs-4">
                    <form:select path="userEntity.userID" items="${users}" itemValue="userID" itemLabel="userFIO" >
                    </form:select>
                    <%--<select  name="userID" id="userID" >--%>
                        <%--<c:forEach var="resultUser" items="${users}">--%>
                            <%--<option value="${resultUser.userID}" >${resultUser.userFIO}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>

                    <label for="taskName" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="taskName" id="taskName" class="form-control" value="${taskEntity.taskName}" required="true" />

                    <label for="taskDescription" class="control-label col-xs-4">Last name:</label>
                    <input type="text" name="taskDescription" id="taskDescription" class="form-control" value="${taskEntity.taskDescription}" required="true"/>
                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>

            </form:form>


        </div>
    </jsp:body>
</page:template>