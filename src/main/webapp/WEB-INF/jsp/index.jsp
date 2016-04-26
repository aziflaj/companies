<%--<!DOCTYPE html PUBLIC--%>
<%--"-//W3C//DTD XHTML 1.1 Transitional//EN"--%>
<%--"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%--<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">--%>
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

<a href="#">Logout</a>

</body>
</html>
