<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
</head>
<body>


<s:form action="update-employee" method="post">
    <s:hidden name="employeeId" value="employeeId"/>

    <s:textfield label="Full Name"
                 name="fullName"
                 id="fullName"
                 placeholder="Full Name"
                 class="form-control"/>

    <s:textfield label="SSN"
                 name="socialSecurityNumber"
                 id="ssn"
                 placeholder="Social Security Number"
                 class="form-control"/>

    <s:textfield label="Email"
                 name="email"
                 id="email"
                 placeholder="Email address"
                 class="form-control"/>

    <%--<sx:datetimepicker label="Date of Birth"--%>
    <%--name="dob"--%>
    <%--displayFormat="dd-MMM-yyyy"/>--%>

    <s:select list="roles"
              headerKey="-1"
              headerValue="Select Role"
              listKey="id"
              listValue="name"
              name="roleId"/>

    <s:select list="sectors"
              headerKey="-1"
              headerValue="Select Sector"
              listKey="id"
              listValue="name"
              name="sectorId"/>

    <s:submit class="btn btn-success" label="Update"/>
</s:form>


</body>
</html>
