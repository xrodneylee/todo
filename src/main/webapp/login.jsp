<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	System.out.println(request.getParameter("code"));
%>

<html>
<!--  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>todo kit</title>

<link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/ext-all-neptune.css">
<link rel="stylesheet" type="text/css" href="lib/css/todo.css">
<script type="text/javascript" src="lib/extjs/ext-all.js"></script>
<script type="text/javascript" src="lib/extjs/locale/ext-lang-zh_TW.js"></script>

<script type="text/javascript" src="login/app.js"></script>

</head>
<body>

</body>
-->
<head>
    <meta name="google-signin-scope" content="profile email https://www.googleapis.com/auth/calendar">
    <meta name="google-signin-client_id" content="22413843311-hl8i1742jli5b6h1oer2hkr07vg5hrui.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
    <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      };
    </script>
  </body>
</html>