<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees | <s:property value="#session.company.name"/></title>
</head>
<body>
List of employees
<s:a action="create-employee-form" class="btn btn-primary">Add new employee</s:a>
<ul>
    <s:iterator value="employees" var="e">
        <li>
            <s:property value="#e.fullName"/> working as <s:property value="#e.role.name"/> on <s:property
                value="#e.sector.name"/>

            <s:a action="edit-employee" class="btn btn-success">
                <s:param name="employeeId" value="%{#e.id}"/>
                Update
            </s:a>

            <s:a action="delete-employee" class="btn btn-danger">
                <s:param name="employeeId" value="%{#e.id}"/>
                Delete
            </s:a>
        </li>
    </s:iterator>
</ul>

</body>
</html>
