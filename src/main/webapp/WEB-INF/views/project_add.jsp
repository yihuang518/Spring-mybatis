<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Management</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<s:url value="/resources/css/home.css" />" type="text/css">
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
		<s:url value="/project/add" var="formUrl" />
			<f:form action="${formUrl}" method="post"	modelAttribute="project" class="col-md-8 col-md-offset-2">
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name" class="form-control" name="name" />
					<f:errors path="name"/>
				</div>
				<div class="form-group">
					<label for="project-type">Project Type</label>
					<select name="type" class="selectpicker" id="project-type">
						<option></option>
						<option value="single">Single Year</option>
						<option value="multi">Multi Year</option>
					</select>
 				</div>
				<div class="form-group">
					<label for="sponsor">Sponsor</label>
					<input type="text" id="sponsor" class="form-control" name="sponsor" />
				</div>
				<div class="form-group">
					<label for="date">Date</label>
					<input type="text" id="date" class="form-control" name="date" />
				</div>
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<input type="text" id="funds" class="form-control" name="authorized_funds" />
				</div>
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<input type="text" id="hours" class="form-control" name="authorized_hours" />
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<textarea id="description" rows="5" class="form-control"></textarea>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</f:form>
		</div>
	</div>
</body>
</html>