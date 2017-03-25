<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ tablib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/app.css'/>" rel="stylesheet" />
<link href="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error !=null}">
						<div class="alert alert-danger">
							<p>Invalid Username or Password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout!=null}">
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username"><i
								class="fa fa-user"></i></label> <input type="text" class="form-control"
								id="username" name="userName" placeholder="Enter Username"
								requried>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password"><i
								class="fa fa-user"></i></label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Enter Password" requried>
						</div>
					</c:if>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-actions">
						<input type="submit" class="btn btn-block btn-primary btn-default"
							value="Log in">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>