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

<s:if test="#session.name != null">
    Hello <s:property value="#session.name"/>
</s:if>
<s:else>
    You are not logged in
</s:else>

<s:form action="helloWorld">
    <s:textfield label="Username" name="name"/>
    <s:textfield label="What is the date?" name="dateNow" />
    <s:submit/>
</s:form>
</body>
</html>
