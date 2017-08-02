/**
 * 
 */
var scr = document.createElement("script");
scr.src = "/js";
var JObj = function(params) {
			type: "POST"
			,url: "/cal/cal_ok.jsp"
			,dataType: "json" 
			,beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			}
			,data: param
			,success: function(results){	
	    		var str ="";
		    	for(var i=0, max=results.length;i<max;i++){
		    		var result = results[i]; 
		    		str += "<table border='1'>";
		    		str += "<tr><td>";
		    		str += result.calnum +"번";
		    		str += "</td><td>";
		    		str += result.num1; 
		    		str += "</td><td>";
		    		str += result.op;
		    		str += "</td><td>" 
		    		str += result.num2;
		    		str += "</td><td>=</td><td>";
		    		str += result.result;
		    		str += "</td></tr>";
		    		str += "</table>";
		    	}
	 	    	$("#resultDiv").html(str);

			}
			,error: function(xhr, status, e) {
			alert("에러 : "+e);
			}
			,done: function(e) {
				}
			};