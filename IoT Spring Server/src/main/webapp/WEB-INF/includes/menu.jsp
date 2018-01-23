<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-static-top" role="navigation">
    <div class="container menu">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value='/home' />">Home</a></li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
				    <li><a href="<c:url value='/IoTRoomData' />">Dashboard</a></li>
				</security:authorize>
				<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE', 'ROLE_RESPONDER')">
                	<li><a href="<c:url value='/firstResponderCommunication' />">First responder communication</a></li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_ADMIN')">
				    <li><a href="<c:url value='/AccessControl' />">Access Control</a></li>
				</security:authorize>
                <li><a href="<c:url value='/logout' />">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>