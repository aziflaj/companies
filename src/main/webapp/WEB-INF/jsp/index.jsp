<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
    <title>Index</title>
    <s:head/>
</head>
<body>

<s:if test="#session.company != null">
    Hello <s:property value="#session.company.name"/>
</s:if>

<s:a action="logout">Logout</s:a>

</body>
</html>
