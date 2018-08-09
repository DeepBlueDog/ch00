function formcheck(){
    console.log("执行1");
    var url="../login";
    var username=document.getElementById("userid");
    var password=document.getElementById("userpwd");
    var params = "username=" + username.value + "&password=" + password.value;
    sendRequest(url, params, "POST", showresult);
}

function showresult(){
    var result=document.getElementById("errMsg");
    if(xmlHttpRequest.readyState === 4){
        if(xmlHttpRequest.status === 200){
            var info=xmlHttpRequest.responseText;
            if(info === "success"){
                window.location.href="index.html";
            }else
            {
                result.innerHTML=info;
            }
        }
    }
    return false;
}