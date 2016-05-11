<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees | <s:property value="#session.company.name"/></title>
</head>
<body>
List of employees
<s:a action="create-employee-form" class="btn btn-primary">Add new employee</s:a>
<h2>Unassigned</h2>
<ul>
    <s:iterator value="unassigned" var="u">
        <li style="padding: 0.5em 0">
            <s:property value="#u.fullName"/> is an unassigned <s:property value="#u.role.name"/>.

            <s:a action="delete-employee" class="btn btn-danger">
                <s:param name="employeeId" value="%{#e.id}"/>
                Delete
            </s:a>
        </li>
    </s:iterator>
</ul>

<h2>Other Employees</h2>
<ul>
    <s:iterator value="employees" var="e">
        <li>
            <s:if test="#e.sector.name == \"sectorless\"">
                <s:property value="#e.fullName"/> is an unassigned <s:property value="#e.role.name"/>.
            </s:if>
            <s:else>
                <s:property value="#e.fullName"/> working as <s:property value="#e.role.name"/> on <s:property
                    value="#e.sector.name"/>
            </s:else>

            <s:a action="delete-employee" class="btn btn-danger">
                <s:param name="employeeId" value="%{#e.id}"/>
                Delete
            </s:a>
        </li>
    </s:iterator>
</ul>

</body>
</html>
