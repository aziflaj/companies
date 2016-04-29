<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List of departments:
<div class="companies-list">
    <s:iterator value="departments" var="department">
        <s:property value="#department.name"/>
    </s:iterator>
</div>

</body>
</html>
