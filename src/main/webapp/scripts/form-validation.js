// funzioni per la validazione del form di registrazione

function nameValidation(){
    let name = document.forms["reg-form"]["reg-name"].value;
    var correct = true;

    if(name == "") {
        document.getElementById("reg-name").style.border = "2px solid red";
        document.getElementById("reg-name").style.color = "red";
        document.getElementById("reg-name-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("reg-name").style.borderStyle = "none";
        document.getElementById("reg-name").style.color = "black";
        document.getElementById("reg-name-label").style.color = "white";
    }

    return correct;
}

function surnameValidation(){
    let surname = document.forms["reg-form"]["reg-surname"].value;
    var correct = true;

    if(surname == "") {
        document.getElementById("reg-surname").style.border = "2px solid red";
        document.getElementById("reg-surname").style.color = "red";
        document.getElementById("reg-surname-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("reg-surname").style.borderStyle = "none";
        document.getElementById("reg-surname").style.color = "black";
        document.getElementById("reg-surname-label").style.color = "white";
    }

    return correct;
}

function mailValidationReg(){
    let mail = document.forms["reg-form"]["reg-mail"].value;
    var correct = true;
    let mailRegExp = /([a-z]|[0-9]){3,}@[a-z]{2,}(\.)[a-z]{2,}/g;

    if(mail == "" || !mailRegExp.test(mail)){
        document.getElementById("reg-mail").style.border = "2px solid red";
        document.getElementById("reg-mail").style.color = "red";
        document.getElementById("reg-mail-label").style.color = "red";
        alert("Il formato dell' e-mail inserita non e' corretto");

        correct = false;
    }

    else {
        document.getElementById("reg-mail").style.borderStyle = "none";
        document.getElementById("reg-mail").style.color = "black";
        document.getElementById("reg-mail-label").style.color = "white";
    }

    return correct;
}

function passwValidationReg(){
    let passw = document.forms["reg-form"]["reg-passw"].value;
    var correct = true;
    let passwRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%?&])[A-Za-z0-9@$!%?&]{8,}/g;

    if(passw == "" || !passwRegExp.test(passw)){
        document.getElementById("reg-passw").style.border = "2px solid red";
        document.getElementById("reg-passw").style.color = "red";
        document.getElementById("reg-passw-label").style.color = "red";
        alert("La password deve contenere almeno otto caratteri, un numero, una lettera maiuscola, una lettera minuscola e un carattere speciale");

        correct = false;
    }

    else {
        document.getElementById("reg-passw").style.borderStyle = "none";
        document.getElementById("reg-passw").style.color = "black";
        document.getElementById("reg-passw-label").style.color = "white";
    }

    return correct;
}

function addressValidation(){
    let address = document.forms["reg-form"]["reg-address"].value;
    var correct = true;

    if(address == "") {
        document.getElementById("reg-address").style.border = "2px solid red";
        document.getElementById("reg-address").style.color = "red";
        document.getElementById("reg-address-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("reg-address").style.borderStyle = "none";
        document.getElementById("reg-address").style.color = "black";
        document.getElementById("reg-address-label").style.color = "white";
    }

    return correct;
}

function creditValidation(){
    let credit = document.forms["reg-form"]["reg-credit"].value;
    var correct = true;
    let passwRegExp = /[0-9]{16,}/g;

    if(credit == "" || !passwRegExp.test(credit)){
        document.getElementById("reg-credit").style.border = "2px solid red";
        document.getElementById("reg-credit").style.color = "red";
        document.getElementById("reg-credit-label").style.color = "red";
        alert("Inserire almeno 16 cifre.")

        correct = false;
    }

    else {
        document.getElementById("reg-credit").style.borderStyle = "none";
        document.getElementById("reg-credit").style.color = "black";
        document.getElementById("reg-credit-label").style.color = "white";
    }

    return correct;
}

function regValidation(){
    return nameValidation() && surnameValidation() && mailValidationReg() && passwValidationReg() &&
        addressValidation() && creditValidation();
}

//funzioni per la validazione del form di login

function mailValidationLog(){
    let mail = document.forms["log-form"]["log-mail"].value;
    var correct = true;
    let mailRegExp = /([a-z]|[0-9]){3,}@[a-z]{2,}(\.)[a-z]{2,}/g;

    if(mail == "" || !mailRegExp.test(mail)){
        document.getElementById("log-mail").style.border = "2px solid red";
        document.getElementById("log-mail").style.color = "red";
        alert("Il formato dell' e-mail inserita non e' corretto");

        correct = false;
    }

    else {
        document.getElementById("log-mail").style.borderStyle = "none";
        document.getElementById("log-mail").style.color = "black";
    }

    return correct;
}

function passwValidationLog(){
    let passw = document.forms["log-form"]["log-passw"].value;
    var correct = true;
    let passwRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%?&])[A-Za-z0-9@$!%?&]{8,}/g;

    if(passw == "" || !passwRegExp.test(passw)){
        document.getElementById("log-passw").style.border = "2px solid red";
        document.getElementById("log-passw").style.color = "red";
        alert("La password deve contenere almeno otto caratteri, un numero, una lettera maiuscola, una lettera minuscola e un carattere speciale");

        correct = false;
    }

    else {
        document.getElementById("log-passw").style.borderStyle = "none";
        document.getElementById("log-passw").style.color = "black";
    }

    return correct;
}

function logValidation(){
    return mailValidationLog() && passwValidationLog();
}

// funzioni per la validazione dei form di inserimento dell' admin

function dbNameValidation(type){
    let name = document.forms["db-add-" + type]["add-" + type + "-name"].value;
    var correct = true;

    if(name == "") {
        document.getElementById("add-" + type + "-name").style.border = "2px solid red";
        document.getElementById("add-" + type + "-name").style.color = "red";
        document.getElementById("add-" + type + "-name-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("add-" + type + "-name").style.borderStyle = "none";
        document.getElementById("add-" + type + "-name").style.color = "black";
        document.getElementById("add-" + type + "-name-label").style.color = "white";
    }

    return correct;
}

function dbBrandValidation(type){
    let brand = document.forms["db-add-" + type]["add-" + type + "-brand"].value;
    var correct = true;

    if(brand == "") {
        document.getElementById("add-" + type + "-brand").style.border = "2px solid red";
        document.getElementById("add-" + type + "-brand").style.color = "red";
        document.getElementById("add-" + type + "-brand-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("add-" + type + "-brand").style.borderStyle = "none";
        document.getElementById("add-" + type + "-brand").style.color = "black";
        document.getElementById("add-" + type + "-brand-label").style.color = "white";
    }

    return correct;
}

function dbPriceValidation(type){
    let price = document.forms["db-add-" + type]["add-" + type + "-price"].value;
    var correct = true;
    let priceRegExp = /[0-9]{0,8}(\.[0-9]{1,4})/g;

    if(price == "" || !priceRegExp.test(price)) {
        document.getElementById("add-" + type + "-price").style.border = "2px solid red";
        document.getElementById("add-" + type + "-price").style.color = "red";
        document.getElementById("add-" + type + "-price-label").style.color = "red";

        correct = false;
    }

    else {
        document.getElementById("add-" + type + "-price").style.borderStyle = "none";
        document.getElementById("add-" + type + "-price").style.color = "black";
        document.getElementById("add-" + type + "-price-label").style.color = "white";
    }

    return correct;
}

function dbValidation(type){
    return dbNameValidation(type) && dbBrandValidation(type) && dbPriceValidation(type);
}

// funzioni per la validazione dei form della barra di ricerca

function searchValidation(){
    let searched = document.forms["search-form"]["search-text"].value;

    if(searched == "") {
        document.getElementById("search-text").style.border = "2px solid red";
        document.getElementById("search-text").style.color = "red";

        return false;
    }

    else {
        document.getElementById("search-text").style.borderStyle = "none";
        document.getElementById("search-text").style.color = "black";

        return true;
    }
}

