<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new sector</title>
</head>
<body>
<div class="container">
    <s:form action="sector-create" method="post" class="form-horizontal" theme="bootstrap">
        <s:hidden name="departmentId" value="%{departmentId}"/>

        <s:textfield label="Sector name"
                     name="sectorName"
                     id="sectorName"
                     placeholder="Sector Name"
                     class="form-control"/>

        <h3>Manager</h3>
        <s:select list="managers"
                  headerKey="-1"
                  headerValue="Select a Manager"
                  listKey="id"
                  listValue="fullName"
                  name="managerId"/>

        <h3>Employees</h3>
        <s:select list="employees"
                  listKey="id"
                  listValue="fullName"
                  name="employeeIds"
                  multiple="true"/>

        <s:submit class="btn btn-success" label="Create Sector"/>

    </s:form>
</div>
</body>
</html>
