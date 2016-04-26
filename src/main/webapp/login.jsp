<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container row">
    <s:form action="login" class="col-md-6 col-md-offset-3" method="post">
        <div class="form-group">
            <label for="email">Email address</label>
            <s:textfield name="email" id="email" placeholder="Email" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <s:password name="password" class="form-control" id="password" placeholder="Password"/>
        </div>
        <div class="checkbox">
            <label>
                <s:checkbox name="remember" label="Remember me"/>
            </label>
        </div>
        <button type="submit" class="btn btn-primary pull-right">Log in</button>
    </s:form>
</div>
</body>
</html>
