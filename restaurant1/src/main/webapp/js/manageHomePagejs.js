function onclickbutton(index){
    var button1=document.getElementById("centerdivbutton1");
    var button2=document.getElementById("centerdivbutton2");
    var button3=document.getElementById("centerdivbutton3");
    if(index==1){
        button1.style.backgroundColor="#000";
        button2.style.backgroundColor="#333";
        button3.style.backgroundColor="#333";
    }else if(index==2){
        button2.style.backgroundColor="#000";
        button1.style.backgroundColor="#333";
        button3.style.backgroundColor="#333";
    }else if(index==3){
        button3.style.backgroundColor="#000";
        button1.style.backgroundColor="#333";
        button2.style.backgroundColor="#333";
    }
}
