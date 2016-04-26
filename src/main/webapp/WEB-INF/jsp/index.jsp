<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
    <title>Index</title>
    <s:head/>
</head>
<body>

<s:if test="#session.user != null">
    Hello <s:property value="#session.user.email"/>
</s:if>

<s:a action="logout">Logout</s:a>

</body>
</html>
