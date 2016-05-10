<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List of departments:
<div class="departments-list">
    <ul>
        <s:iterator value="departments" var="department">
            <li>
                <s:a action="all-sectors">
                    <s:param name="departmentId" value="%{#department.id}"/>
                    <s:property value="#department.name"/>
                </s:a>
            </li>
        </s:iterator>
    </ul>
</div>

</body>
</html>
