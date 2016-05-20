function delayDisplay(displayNum,className,time){
	var isScreenNum;
	var toScreenNum;
	var divClass=document.getElementsByClassName(className);
	for (var i = divClass.length - 1; i >= 0; i--) {
	divClass[i].style.display="none";
	}
	for(var i=0;i<displayNum;i++){
	divClass[i].style.display="";
	}
	isScreenNum=displayNum;
	toScreenNum=isScreenNum+displayNum;
	window.onscroll=function(){
		var scrollTop=document.documentElement.scrollTop;
		var clientHeight=document.documentElement.clientHeight;
		var scrollHeight=document.body.scrollHeight;
		//alert(scrollTop+clientHeight);
		//alert(scrollHeight);
		if(scrollTop+clientHeight>=scrollHeight){
			//alert(scrollTop+clientHeight);
			sleep(time);
			for(var i=isScreenNum;i<toScreenNum;i++){
				divClass[i].style.display="";
			}
			isScreenNum=toScreenNum;
			toScreenNum=isScreenNum+displayNum;
		}
	}
}
function sleep(time){
  for(var t = Date.now();Date.now() - t <= time;);
}