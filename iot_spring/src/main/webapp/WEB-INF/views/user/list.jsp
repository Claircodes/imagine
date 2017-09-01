<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<title>유저 리스트</title>
</head>
<script>
	$(document).ready(function(){
		var param = {};
		param = JSON.stringify(param);
		var a = { 
		        type     : "POST"
		    	    ,   url      : "${pageContext.request.contextPath}/user/list"
		    	    ,   dataType : "json" 
		    	    ,   beforeSend: function(xhr) {
		    	        xhr.setRequestHeader("Accept", "application/json");
		    	        xhr.setRequestHeader("Content-Type", "application/json");
		    	    }
		    	    ,   data     : param
		    	    ,   success : function(result){
		    	    	var userList = result.userList;
		    	        
		    			$('#result_tbody').bootstrapTable('destroy');
		    			var resultStr = "";

		    			for (var i = 0, max = userList.length; i < max; i++) {
		    				var user = userList[i];

		    				resultStr += "<tr data-view='"+user.giNum+"'>";
		    				resultStr += "<td class='text-center'>" + user.userNum + "</td>";
		    				resultStr += "<td class='text-center'>" + user.userId + "</td>";
		    				resultStr += "<td class='text-center'>" + user.userName + "</td>";
		    				resultStr += "<td class='text-center'>" + user.age + "</td>";
		    				resultStr += "<td class='text-center'>" + user.address + "</td>";
		    				resultStr += "</tr>";

		    			}
		    			
		    			$("#result_tbody").html(resultStr);
		    			name();
		    	    }
		    	    ,   error : function(xhr, status, e) {
		    		    	alert("에러 : "+e);
		    		},
		    		done : function(e) {
		    		}
		    		};
		$.ajax(a);
	})
	function name() {
		$("#btnsearch").click(function(){
			var param = {};
			param["userName"]="%"+$("#txtSearch").val()+"%";
			param = JSON.stringify(param);
			var a = { 
			        type     : "POST"
			    	    ,   url      : "${pageContext.request.contextPath}/user/list"
			    	    ,   dataType : "json" 
			    	    ,   beforeSend: function(xhr) {
			    	        xhr.setRequestHeader("Accept", "application/json");
			    	        xhr.setRequestHeader("Content-Type", "application/json");
			    	    }
			    	    ,   data     : param
			    	    ,   success : function(result){
			    	    	var userList = result.userList;
			    	        
			    			$('#result_tbody').bootstrapTable('destroy');
			    			var resultStr = "";

			    			for (var i = 0, max = userList.length; i < max; i++) {
			    				var user = userList[i];

			    				resultStr += "<tr data-view='"+user.giNum+"'>";
			    				resultStr += "<td class='text-center'>" + user.userNum + "</td>";
			    				resultStr += "<td class='text-center'>" + user.userId + "</td>";
			    				resultStr += "<td class='text-center'>" + user.userName + "</td>";
			    				resultStr += "<td class='text-center'>" + user.age + "</td>";
			    				resultStr += "<td class='text-center'>" + user.address + "</td>";
			    				resultStr += "</tr>";

			    			}
			    			
			    			$("#result_tbody").html(resultStr);
			    			name();
			    	    }
			    	    ,   error : function(xhr, status, e) {
			    		    	alert("에러 : "+e);
			    		},
			    		done : function(e) {
			    		}
			    		};
			$.ajax(a);
		})
	}

</script>

	<div class="container">
		<table id="table" data-height="460" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="userNum" class="text-center">유저번호</th>
					<th data-field="userId" class="text-center">아이디</th>
					<th data-field="userName" class="text-center">이름</th>
					<th data-field="age" class="text-center">나이</th>
					<th data-field="address" class="text-center">주소</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
			<input type="text" id="txtSearch" >	
		<input type="button" id="btnsearch" value="button">
	</div>

</body>
</html>