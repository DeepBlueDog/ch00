function bookcheck(){
    var url="../book";
    var booknumber = document.getElementById("booknumber");
    var bookname = document.getElementById("bookname");
    var author1 = document.getElementById("author1");
    var author2 = document.getElementById("author2");
    var translator1 = document.getElementById("translator1");
    var translator2 = document.getElementById("translator2");
    var publishor = document.getElementById("publishor");
    var language = document.getElementById("language");
    var price = document.getElementById("price");
    var quantity = document.getElementById("quantity");
    var abstractText = document.getElementById("abstractText");
    var params = "booknumber=" + booknumber.value + "&bookname=" + bookname.value + "&author1=" + author1.value + "&author2=" + author2.value + "&translator1=" + translator1.value
        + "&translator2=" + translator2.value + "&publishor=" + publishor.value + "&language=" + language.value + "&price=" + price.value + "&quantity=" + quantity.value
        + "&abstractText=" + abstractText.value;
    sendRequest(url, params, "POST", showresult);
}

function showresult(){
    var result=document.getElementById("errMsg");
    console.log(xmlHttpRequest.readyState);
    if(xmlHttpRequest.readyState === 4){
        console.log(xmlHttpRequest.status);
        if(xmlHttpRequest.status === 200){
            var info=xmlHttpRequest.responseText;
            if(info === "success"){
                window.location.href="success.html";
            }else
            {
                result.innerHTML=info;
            }
        }
    }
    return false;
}