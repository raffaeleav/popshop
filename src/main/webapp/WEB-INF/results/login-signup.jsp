<%@ page contentType="text/html;charset=UTF-8"%>
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
            <p>Per continuare occorre accedere o registrarsi.</p>

            <div class="login-signup">
                <form id="log-form" name="log-form" action="login" onsubmit="return logValidation()" method="post">
                    <h2>Accedi</h2>

                    <div class="log-sig-field">
                        <input id="log-mail" type="text" name="log-mail" placeholder="E-mail">
                    </div>

                    <div class="log-sig-field">
                        <input id="log-passw" type="password" name="log-passw" placeholder="Password">
                    </div>

                    <div class="log-sig-field">
                        <input type="submit" id="log-button" value="Accedi">
                    </div>
                </form>
            </div>

            <div class="login-signup">
                <form id="reg-form" name="reg-form" action="signup" onsubmit="return regValidation()" method="post">
                    <h2>Registrati</h2>

                    <div class="log-sig-field">
                        <label id ="reg-name-label" for="reg-name">Nome:</label>
                        <br>
                        <input id="reg-name" type="text" name="reg-name">
                    </div>

                    <div class="log-sig-field">
                        <label id="reg-surname-label" for="reg-surname">Cognome:</label>
                        <br>
                        <input id="reg-surname" type="text" name="reg-surname">
                    </div>

                    <div class="log-sig-field">
                        <label id="reg-mail-label" for="reg-mail">E-mail:</label>
                        <br>
                        <input id="reg-mail" type="text" name="reg-mail">
                    </div>

                    <div class="log-sig-field">
                        <label id="reg-passw-label" for="reg-passw">Password:</label>
                        <br>
                        <input id="reg-passw" type="password" name="reg-passw">
                    </div>

                    <div class="log-sig-field">
                        <label id="reg-address-label" for="reg-address">Indirizzo:</label>
                        <br>
                        <input id="reg-address" type="text" name="reg-address">
                    </div>

                    <div class="log-sig-field">
                        <label id="reg-credit-label" for="reg-credit">Carta di credito:</label>
                        <br>
                        <input id="reg-credit" type="text" name="reg-credit">
                    </div>

                    <div class="log-sig-field">
                        <input type="submit" id="reg-button" value="Registrati">
                    </div>
                </form>
            </div>
        </div>

        <div id="footer">
            <p>Instagram:@popshop   E-mail:support@popshop.it   Telefono:XXXXXXXXXX</p>
        </div>
    </body>
</html>
