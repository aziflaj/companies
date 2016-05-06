<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees | <s:property value="#session.company.name"/></title>
</head>
<body>
List of employees
<ul>
    <s:iterator value="employees" var="e">
        <li>
            <s:property value="#e.fullName"/> working as <s:property value="#e.role.name"/> on <s:property
                value="#e.sector.name"/>
        </li>
    </s:iterator>
</ul>

</body>
</html>
