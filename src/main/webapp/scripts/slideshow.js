var n_img = 3;
var current = 1;

function nextImg(){
    current++;
    if(current > n_img){
        current = 1;
    }

    var i;
    for(i = n_img; i > 0; i--)
        document.querySelector("#image-slider img:nth-child(" + i + ")").style.display = "none";


    document.querySelector("#image-slider img:nth-child(" + current + ")").style.display = "block";
}

function prevImg(){
    current--;
    if(current == 0){
        current = n_img;
    }

    var i;
    for(i = n_img; i > 0; i--)
        document.querySelector("#image-slider img:nth-child(" + i + ")").style.display = "none";


    document.querySelector("#image-slider img:nth-child(" + current + ")").style.display = "block";
}