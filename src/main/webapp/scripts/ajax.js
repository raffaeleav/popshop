function addCapoCartAjax(id) {

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.readyState == 4 && this.status == 200)
            alert("Elemento aggiunto al carrello!");
    }

    xhttp.open("GET", "add-abbigliamento?id="+id, true);
    xhttp.send();
}

function addScarpeCartAjax(id) {

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.readyState == 4 && this.status == 200)
            alert("Elemento aggiunto al carrello!");
    }

    xhttp.open("GET", "add-footwear?id="+id, true);
    xhttp.send();
}

function addAccessorioCartAjax(id) {

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.readyState == 4 && this.status == 200)
            alert("Elemento aggiunto al carrello!");
    }

    xhttp.open("GET", "add-accessorio?id="+id, true);
    xhttp.send();
}

