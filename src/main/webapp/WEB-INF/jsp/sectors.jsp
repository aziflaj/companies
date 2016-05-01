<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sectors</title>
</head>
<body>
<button>Add new sector</button>
<ul>
    <s:iterator value="sectors" var="s">
        <li><s:property value="#s.name"/></li>
    </s:iterator>
</ul>
</body>
</html>
