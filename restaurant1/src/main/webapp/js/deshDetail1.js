function searchOnclick(id){
    window.location.href="SearchEvaluate?id="+id;
}
var xmlHttp;
function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function addOn(){
    var div=document.getElementById("divdiv");
    div.style.display="block";
}
function addClose(){
    var div =document.getElementById("divdiv");
    div.style.display="none";
}
function addYse(restaurant,food){
    var title=document.getElementById("divinput").value;
    var content=document.getElementById("divtex").value;
    var params ="title=" + encodeURIComponent(title)+"&content="+encodeURIComponent(content)+"&restaurant="+encodeURIComponent(restaurant)+"&food="+encodeURIComponent(food);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementById("divdiv");
                updatedivs.style.display="none";
                alert("发表成功！");
            } else {
                var updatedivs=document.getElementById("divdiv");
                updatedivs.style.display="none";
                alert("发表失败！");
            }
        }
    };
    xmlHttp.open("POST", "AddEvaluate", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}
