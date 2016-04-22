<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><decorator:title default="Struts Starter"/></title>
    <link href="<s:url value='/assets/css/style.css'/>" rel="stylesheet" type="text/css" media="print"/>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/assets/js/app.js'/>"></script>
    <decorator:head/>
</head>
<body>
<div class="header">
    HEADER
    <hr/>
</div>

<div class="content">
    <div id="main">
        <h3>Main Content</h3>
        <decorator:body/>
        <hr/>
    </div>
</div>

<div class="footer">
    Footer
</div>
</body>
</html>
