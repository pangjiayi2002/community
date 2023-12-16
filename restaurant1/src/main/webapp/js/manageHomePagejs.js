function onclickbutton(index){
    var button1=document.getElementById("centerdivbutton1");
    var button2=document.getElementById("centerdivbutton2");
    var button3=document.getElementById("centerdivbutton3");
    var div1=document.getElementById("center1div");
    var div2=document.getElementById("center2div");
    var div3=document.getElementById("center3div");
    if(index==1){
        button1.style.backgroundColor="#000";
        button2.style.backgroundColor="#333";
        button3.style.backgroundColor="#333";
        div1.style.display="block";
        div2.style.display="none";
        div3.style.display="none";
    }else if(index==2){
        button2.style.backgroundColor="#000";
        button1.style.backgroundColor="#333";
        button3.style.backgroundColor="#333";
        div2.style.display="block";
        div1.style.display="none";
        div3.style.display="none";
    }else if(index==3){
        button3.style.backgroundColor="#000";
        button1.style.backgroundColor="#333";
        button2.style.backgroundColor="#333";
        div3.style.display="block";
        div1.style.display="none";
        div2.style.display="none";
    }
}

var xmlHttp;
function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function updatediv1On(index){
    alert("hit");
    var updatedivs=document.getElementsByClassName("center1_2div");
    updatedivs[index].style.display="block";
}
function updatediv1Close(index){
    var updatedivs=document.getElementsByClassName("center1_2div");
    updatedivs[index].style.display="none";
}
function updatediv1Yes(index){
    var id=document.getElementsByClassName("center1_2divinput1")[index].value;
    var username=document.getElementsByClassName("center1_2divinput2")[index].value;
    var password=document.getElementsByClassName("center1_2divinput3")[index].value;
    var restaurant=document.getElementsByClassName("center1_2divinput4")[index].value;
    var params ="id=" + encodeURIComponent(id)+"&username="+encodeURIComponent(username)+"&password="+encodeURIComponent(password)+"&restaurant="+encodeURIComponent(restaurant);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center1_2div");
                updatedivs[index].style.direction="none";
                alert("修改成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center1_2div");
                updatedivs[index].style.direction="none";
                alert("修改失败！");
            }
        }
    };
    xmlHttp.open("POST", "UpdateResturantManage", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function deletediv1On(index){
    var updatedivs=document.getElementsByClassName("center1_3div");
    updatedivs[index].style.display="block";
}
function deletediv1Close(index){
    var updatedivs=document.getElementsByClassName("center1_3div");
    updatedivs[index].style.display="block";
}
function deletediv1Yes(id,index){
    var params ="id=" + encodeURIComponent(id);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center1_3div");
                updatedivs[index].style.direction="none";
                alert("删除成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center1_3div");
                updatedivs[index].style.direction="none";
                alert("删除失败！");
            }
        }
    };
    xmlHttp.open("POST", "DeleteResturantManage", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

 function adddiv1On(){
    alert("hit");
    document.getElementById("center1_1div").style.display="block";
}
function adddiv1Close(){
    var div=document.getElementById("center1_1div");
    div.style.display="none";
}
function adddiv1Yes(){
    var id=document.getElementById("center1_1divinput1").value;
    var username=document.getElementById("center1_1divinput2").value;
    var password=document.getElementById("center1_1divinput3").value;
    var restaurant=document.getElementById("center1_1divinput4").value;
    var params ="id=" + encodeURIComponent(id)+"&username=" + encodeURIComponent(username)+"&password=" + encodeURIComponent(password)+"&restaurant=" + encodeURIComponent(restaurant);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var div=document.getElementById("center1_1div");
                div.style.direction="none";
                alert("添加成功！");
            } else {
                var div=document.getElementById("center1_1div");
                div.style.direction="none";
                alert("添加失败！");
            }
        }
    };
    xmlHttp.open("POST", "AddResturantManage", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}


function updatediv2On(index){
    var updatedivs=document.getElementsByClassName("center2_2div");
    updatedivs[index].style.display="block";
}
function updatediv2Close(index){
    var updatedivs=document.getElementsByClassName("center2_2div");
    updatedivs[index].style.display="none";
}
function updatediv2Yes(index){
    var id=document.getElementsByClassName("center2_2divinput1")[index].value;
    var name=document.getElementsByClassName("center2_2divinput2")[index].value;
    var introduction=document.getElementsByClassName("center2_2divinput3").value;
    var cover=document.getElementsByClassName("center2_2divinput4").value;
    var location=document.getElementsByClassName("center2_2divinput5")[index].value;
    var time=document.getElementsByClassName("center2_2divinput6")[index].value;
    var params ="id=" + encodeURIComponent(id)+"&name=" + encodeURIComponent(name)+"&introduction=" + encodeURIComponent(introduction)+"&cover=" + encodeURIComponent(cover)+"&location=" + encodeURIComponent(location)+"&time=" + encodeURIComponent(time);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center2_2div");
                updatedivs[index].style.direction="none";
                alert("修改成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center2_2div");
                updatedivs[index].style.direction="none";
                alert("修改失败！");
            }
        }
    };
    xmlHttp.open("POST", "UpdateResturant", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function deletediv2On(index){
    var updatedivs=document.getElementsByClassName("center2_3div");
    updatedivs[index].style.display="block";
}
function deletediv2Close(index){
    var updatedivs=document.getElementsByClassName("center2_3div");
    updatedivs[index].style.display="none";
}
function deletediv2Yes(id,index){
    var params ="id=" + encodeURIComponent(id);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center2_3div");
                updatedivs[index].style.direction="none";
                alert("删除成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center2_3div");
                updatedivs[index].style.direction="none";
                alert("删除失败！");
            }
        }
    };
    xmlHttp.open("POST", "DeleteResturant", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function adddiv2On(){
    var div=document.getElementById("center2_1div");
    div.style.display="block";
}
function adddiv2Close(){
    var div=document.getElementById("center2_1div");
    div.style.display="none";
}
function adddiv2Yes(){
    var id=document.getElementById("center2_1divinput1").value;
    var name=document.getElementById("center2_1divinput2").value;
    var introduction=document.getElementById("center2_1divinput3").value;
    var cover=document.getElementById("center2_1divinput4").value;
    var location=document.getElementById("center2_1divinput5").value;
    var time=document.getElementById("center2_1divinput6").value;
    var params ="id=" + encodeURIComponent(id)+"&name=" + encodeURIComponent(name)+"&introduction=" + encodeURIComponent(introduction)+"&cover=" + encodeURIComponent(cover)+"&location=" + encodeURIComponent(location)+"&time=" + encodeURIComponent(time);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var div=document.getElementById("center2_1div");
                div.style.direction="none";
                alert("添加成功！");
            } else {
                var div=document.getElementById("center2_1div");
                div.style.direction="none";
                alert("添加失败！");
            }
        }
    };
    xmlHttp.open("POST", "AddResturant", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function updatediv3On(index){
    var updatedivs=document.getElementsByClassName("center3_2div");
    updatedivs[index].style.display="block";
}
function updatediv3Close(index){
    var updatedivs=document.getElementsByClassName("center3_2div");
    updatedivs[index].style.display="none";
}
function updatediv3Yes(index){
    var id=document.getElementsByClassName("center3_2divinput1")[index].value;
    var title=document.getElementsByClassName("center3_2divinput2")[index].value;
    var content=document.getElementsByClassName("center3_2divinput3")[index].value;
    var sender=document.getElementsByClassName("center3_2divinput4")[index].value;
    var sendertype=document.getElementsByClassName("center3_2divinput5")[index].value;
    var restuarant=document.getElementsByClassName("center3_2divinput6")[index].value;
    var food=document.getElementsByClassName("center3_2divinput7")[index].value;
    var receiver=document.getElementsByClassName("center3_2divinput8")[index].value;
    var params ="id=" + encodeURIComponent(id)+"&title="+encodeURIComponent(title)+"&content="+encodeURIComponent(content)+"&sender="+encodeURIComponent(sender)+"&sendertype="+encodeURIComponent(sendertype)+"&restuarant="+encodeURIComponent(restuarant)+"&food="+encodeURIComponent(food)+"&receiver="+encodeURIComponent(receiver);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center3_2div");
                updatedivs[index].style.direction="none";
                alert("修改成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center3_2div");
                updatedivs[index].style.direction="none";
                alert("修改失败！");
            }
        }
    };
    xmlHttp.open("POST", "UpdateEvaluate", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function deletediv3On(index){
    var updatedivs=document.getElementsByClassName("center3_3div");
    updatedivs[index].style.display="block";
}
function deletediv3Close(index){
    var updatedivs=document.getElementsByClassName("center3_3div");
    updatedivs[index].style.display="none";
}
function deletediv3Yes(id,index){
    var params ="id=" + encodeURIComponent(id);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var updatedivs=document.getElementsByClassName("center3_3div");
                updatedivs[index].style.direction="none";
                alert("删除成功！");
            } else {
                var updatedivs=document.getElementsByClassName("center3_3div");
                updatedivs[index].style.direction="none";
                alert("删除失败！");
            }
        }
    };
    xmlHttp.open("POST", "DeleteEvaluate", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}

function adddiv3On(){
    var div=document.getElementById("center3_1div");
    div.style.display="block";
}
function adddiv3Close(){
    var div=document.getElementById("center3_1div");
    div.style.display="none";
}
function adddiv3Yes(){
    var id=document.getElementById("center3_1divinput1").value;
    var title=document.getElementById("center3_1divinput2").value;
    var content=document.getElementById("center3_1divinput3").value;
    var sender=document.getElementById("center3_1divinput4").value;
    var sendertype=document.getElementById("center3_1divinput5").value;
    var restuarant=document.getElementById("center3_1divinput6").value;
    var food=document.getElementById("center3_1divinput7").value;
    var receiver=document.getElementById("center3_1divinput8").value;
    var params ="id=" + encodeURIComponent(id)+"&title=" + encodeURIComponent(title)+"&content=" + encodeURIComponent(content)+"&sender=" + encodeURIComponent(sender)+"&sendertype=" + encodeURIComponent(sendertype)+"&restuarant=" + encodeURIComponent(restuarant)+"&food=" + encodeURIComponent(food)+"&receiver=" + encodeURIComponent(receiver);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == XMLHttpRequest.DONE) {
            if (xmlHttp.status == 200) {
                var div=document.getElementById("center3_1div");
                div.style.direction="none";
                alert("添加成功！");
            } else {
                var div=document.getElementById("center3_1div");
                div.style.direction="none";
                alert("添加失败！");
            }
        }
    };
    xmlHttp.open("POST", "AddEvaluate", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(params);
}
