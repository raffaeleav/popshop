<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>PopShop</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css"/>
        <script src="${pageContext.request.contextPath}/scripts/form-validation.js"></script>
    </head>

    <body>
        <div id="header">
            <h1>PopShop</h1>
        </div>

        <div id="navigation">
            <ul id="navbar">
                <li> <a href="${pageContext.request.contextPath}/index.html">Home</a> </li>
                <li> <a href="show-abbigliamento">Abbigliamento</a> </li>
                <li> <a href="show-footwear">Footwear</a> </li>
                <li> <a href="show-accessori">Accessori</a> </li>
                <li> <a href="show-carrello">Carrello</a> </li>
                <li> <a href="show-profile">Il mio profilo</a> </li>
                <li id="search-bar">
                    <form id="search-form" name="search-form" action="show-ricerca"
                          onsubmit="return searchValidation()" method="get">
                        <input id="search-text" name="search-text" type="text">
                        <input id="search-button" type="submit" value="Cerca">
                    </form>
                </li>
            </ul>
        </div>

        <div id="content">
                <p>Questa e-mail è gia stata utilizzata.</p>
        </div>

        <div id="footer">
            <p>Instagram:@popshop   E-mail:support@popshop.it   Telefono:XXXXXXXXXX</p>
        </div>
    </body>
</html>