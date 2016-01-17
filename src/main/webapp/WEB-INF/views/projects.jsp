<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<s:url value="/resources/css/home.css" />" type="text/css">
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<h1>Projects</h1>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Name</th>
					<th>Sponsor</th>
					<th>Description></th>
				</tr>
				<c:forEach items="${projects}" var="project">
					<tr>
						<td><a href="<s:url value="/project/${project.name}"/>">${project.name}</a></td>
						<td>${project.sponsor}</td>
						<td>${project.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>