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
        <s:textfield label="Sector name"
                     name="sectorName"
                     id="sectorName"
                     placeholder="Sector Name"
                     class="form-control"/>

        <h3>Sector Manager</h3>

        <%-- create employee --%>
        <s:textfield label="Full Name"
                     name="fullName"
                     id="fullName"
                     placeholder="Full Name"
                     class="form-control"/>

        <s:textfield label="SSN"
                     name="ssn"
                     id="ssn"
                     placeholder="Social Security Number"
                     class="form-control"/>

        <sx:datetimepicker label="Date of Birth"
                           name="dob"
                           displayFormat="dd-MMM-yyyy" />

        <%--<s:select list="roles" listKey="id" listValue="name" name="employeeRole"/>--%>

        <s:submit class="btn btn-success" label="Create Sector"/>

    </s:form>
</div>
</body>
</html>
