<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<s:url value="/blog/add" var="formUrl" />
			<f:form action="${formUrl}" method="post"	modelAttribute="blog" class="col-md-8 col-md-offset-2" accept-charset="utf-8">
				<div class="form-group">
					<label for="title">title</label>
					<input type="text" id="title" class="form-control" name="title" />
				</div>
				<div class="form-group">
					<label for="content">content</label>
					<textarea id="content" rows="5" class="form-control" name="content"></textarea>
				</div>
				<div class="form-group">
					<label for="owner">owner</label>
					<input type="text" id="owner" class="form-control" name="owner" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</f:form>
		</div>
	</div>
</body>
</html>