<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="row">
        <s:form action="login" class="form-horizontal" method="post" theme="bootstrap">
            <s:textfield label="Email"
                         name="email"
                         id="email"
                         placeholder="Email"
                         class="form-control"/>

            <s:password label="Password"
                        name="password"
                        class="form-control"
                        id="password"
                        placeholder="Password"/>

            <s:checkbox name="remember"
                        label="Remember me"/>

            <s:submit class="btn btn-primary pull-right"
                      value="Log In"/>
        </s:form>
    </div>
</div>
</body>
</html>
