/**
 * 뭐냐 ~~~~
 */


function checkValue(fObj){
	var result ="";
	
	for(var i =0; i<fObj.elements.length;i++){
		if(fObj.elements[i].value!="전송"){
			result+=fObj.elements[i].value;
		}
		if (i%2==1&&fObj.elements[i].value!="" ){
			var checknum = new Number(fObj.elements[i].value);
			try {	
				if (isNaN(checknum)){
					alert("숫자 입력하라고!");
					fObj.elements[i].value="";
					fObj.elements[i].focus();
					return false;
				}
			}catch(e){
				alert(e);
				throw e;
			}
		}
		
		if(i==fObj.elements.length-1){
			fObj.elements[i].value=result;

		}
	}
	return false;
}