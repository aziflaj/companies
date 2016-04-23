<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>
List of companies:
<div class="companies-list">
    <s:iterator value="companies" var="c">
        <div class="company">
            <h1 class="company__name">
                <s:property value="#c.name"/>
                <span>Nipt: <s:property value="#c.nipt"/> </span>
            </h1>
            <div class="company__address">
                <s:property value="#c.address"/>
            </div>
        </div>
    </s:iterator>
</div>
</body>
</html>
