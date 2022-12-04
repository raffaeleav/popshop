<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>PopShop</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css"/>
        <script src="${pageContext.request.contextPath}/scripts/form-validation.js"></script>
        <script src="${pageContext.request.contextPath}/scripts/ajax.js"></script>
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
            <div id="grid-container">
                <ul>
                    <c:forEach items="${searchListCapi}" var="capo">
                        <li>
                            <img src="get-capo-picture?id=${capo.id}" alt="${capo.name}">
                            <br><br>
                                ${capo.brand} ${capo.name} - ${capo.price}€
                            <br><br>
                            <form action="add-abbigliamento">
                                <label for="capo-size">Taglia:</label>

                                <select id="capo-size" name="capo-size">
                                    <option value="XS">XS</option>
                                    <option value="S">S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>
                                </select>

                                <input type="button" id="cart-button-search-capo" value="Aggiungi al carrello"
                                       onclick="addCapoCartAjax(${capo.id})">
                            </form>
                        </li>
                    </c:forEach>

                    <c:forEach items="${searchListFootwear}" var="foot">
                        <li>
                            <img src="get-foot-picture?id=${foot.id}" alt="${foot.name}">
                            <br><br>
                                ${foot.brand} ${foot.name} - ${foot.price}€
                            <br><br>
                            <form action="add-footwear">
                                <label for="foot-size">Numero:</label>

                                <select id="foot-size" name="foot-size">
                                    <option value="39">39</option>
                                    <option value="40">40</option>
                                    <option value="41">41</option>
                                    <option value="42">42</option>
                                    <option value="43">43</option>
                                    <option value="44">44</option>
                                    <option value="45">45</option>
                                    <option value="46">46</option>
                                </select>

                                <input type="button" id="cart-button-search-foot" value="Aggiungi al carrello"
                                       onclick="addScarpeCartAjax(${foot.id})">
                            </form>
                        </li>
                    </c:forEach>

                    <c:forEach items="${searchListAccessori}" var="acc">
                        <li>
                            <img src="get-acc-picture?id=${acc.id}" alt="${acc.name}">
                            <br><br>
                                ${acc.brand} ${acc.name} - ${acc.price}€
                            <br><br>
                            <form action="add-accessorio">
                                <input type="button" id="cart-button-search-acc" value="Aggiungi al carrello"
                                       onclick="addAccessorioCartAjax(${acc.id})">
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div id="footer">
            <p>Instagram:@popshop   E-mail:support@popshop.it   Telefono:XXXXXXXXXX</p>
        </div>
    </body>
</html>