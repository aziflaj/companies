<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee | <s:property value="#session.company.name"/></title>
</head>
<body>

<h3>Add New Employee</h3>

<s:form action="create-employee" method="post">
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
              name="employeeId"/>

    <%--<s:select list="sectors"--%>
              <%--headerKey="-1"--%>
              <%--headerValue="Select Sector"--%>
              <%--listKey="id"--%>
              <%--listValue="name"--%>
              <%--name="sectorId"/>--%>

    <s:submit class="btn btn-success" label="Create Sector"/>
</s:form>

</body>
</html>
