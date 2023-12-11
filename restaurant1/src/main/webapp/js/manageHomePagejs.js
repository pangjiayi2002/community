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
