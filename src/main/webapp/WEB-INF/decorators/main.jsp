<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <title><decorator:title default="Companies Portal"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link href="<s:url value='/assets/css/style.css'/>" rel="stylesheet" type="text/css" media="print"/>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
<script language="JavaScript" type="text/javascript" src="<s:url value='/assets/js/app.js'/>"></script>
</body>
</html>
