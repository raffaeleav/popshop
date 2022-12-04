<%@ page import="model.UtenteBean" %>
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
            <div id="save-articles">
                <p>Bentornato admin!</p>

                <div class="db-add">
                    <form id="db-add-capo" name="db-add-capo" action="save-abbigliamento" onsubmit="return dbValidation('capo')"
                          enctype="multipart/form-data" method="post">
                        <h2>Aggiungi capo:</h2>

                        <div class="db-add-field">
                            <label id ="add-capo-name-label" for="add-capo-name">Name:</label>
                            <br>
                            <input id="add-capo-name" type="text" name="add-capo-name">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-capo-brand-label" for="add-capo-brand">Brand:</label>
                            <br>
                            <input id="add-capo-brand" type="text" name="add-capo-brand">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-capo-price-label" for="add-capo-price">Prezzo:</label>
                            <br>
                            <input id="add-capo-price" type="text" name="add-capo-price">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-capo-file-label" for="add-capo-file">Immagine:</label>
                            <br>
                            <input id="add-capo-file" type="file" name="add-capo-file">
                        </div>

                        <div class="db-add-field">
                            <input id="add-capo-button" type="submit" name="add-capo-button" value="Salva">
                        </div>
                    </form>
                </div>

                <div class="db-add">
                    <form id="db-add-foot" name="db-add-foot" action="save-footwear" onsubmit="return dbValidation('foot')"
                          enctype="multipart/form-data" method="post">
                        <h2>Aggiungi scarpe:</h2>

                        <div class="db-add-field">
                            <label id ="add-foot-name-label" for="add-foot-name">Brand:</label>
                            <br>
                            <input id="add-foot-name" type="text" name="add-foot-name">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-foot-brand-label" for="add-foot-brand">Nome:</label>
                            <br>
                            <input id="add-foot-brand" type="text" name="add-foot-brand">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-foot-price-label" for="add-foot-price">Prezzo:</label>
                            <br>
                            <input id="add-foot-price" type="text" name="add-foot-price">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-foot-file-label" for="add-foot-file">Immagine:</label>
                            <br>
                            <input id="add-foot-file" type="file" name="add-foot-file">
                        </div>

                        <div class="db-add-field">
                            <input id="add-foot-button" type="submit" name="add-foot-button" value="Salva">
                        </div>
                    </form>
                </div>

                <div class ="db-add">
                    <form id="db-add-acc" name="db-add-acc" action="save-accessorio" onsubmit="return dbValidation('acc')"
                          enctype="multipart/form-data" method="post">
                        <h2>Aggiungi accessorio:</h2>

                        <div class="db-add-field">
                            <label id ="add-acc-name-label" for="add-acc-name">Brand:</label>
                            <br>
                            <input id="add-acc-name" type="text" name="add-acc-name">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-acc-brand-label" for="add-acc-brand">Nome:</label>
                            <br>
                            <input id="add-acc-brand" type="text" name="add-acc-brand">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-acc-price-label" for="add-acc-price">Prezzo:</label>
                            <br>
                            <input id="add-acc-price" type="text" name="add-acc-price">
                        </div>

                        <div class="db-add-field">
                            <label id ="add-acc-file-label" for="add-acc-file">Immagine:</label>
                            <br>
                            <input id="add-acc-file" type="file" name="add-acc-file">
                        </div>

                        <div class="db-add-field">
                            <input id="add-acc-button" type="submit" name="add-acc-button" value="Salva">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div id="footer">
            <p>Instagram:@popshop   E-mail:support@popshop.it   Telefono:XXXXXXXXXX</p>
        </div>
    </body>
</html>