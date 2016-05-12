<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sectors</title>
</head>
<body>
<s:a action="sector-create-form" class="btn btn-success">
    <s:param name="departmentId" value="departmentId"/>
    Add new Sector
</s:a>

<ul>
    <s:iterator value="sectors" var="s">
        <li>
            <s:property value="#s.name"/>
            <s:a action="delete-sector" class="btn btn-danger">
                <s:param name="sectorId" value="%{#s.id}"/>
                Delete
            </s:a>
        </li>
    </s:iterator>
</ul>
</body>
</html>
