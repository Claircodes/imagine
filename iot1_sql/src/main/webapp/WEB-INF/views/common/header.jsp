<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="pVar" value="1.3.2"/>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<c:set var="nowUrl" value="${pageContext.request.requestURI}"/>
<script src="<c:url value="/resources/js/jquery-3.2.1.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/js/jquery.fileupload.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/js/jquery.iframe-transport.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/ui/common.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/ui/btsp3.7.7/js/bootstrap.min.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/ui/btsp3.7.7/js/bootstrap-table.js?version=${pVar}"/>"></script>
<script src="<c:url value="/resources/ui/btsp3.7.7/js/bootstrap-table.js?version=${pVar}"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=${pVar}"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/ui/btsp3.7.7/css/bootstrap.min.css?version=${pVar}"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/ui/btsp3.7.7/css/bootstrap-table.css?version=${pVar}"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/ui/common.css?version=${pVar}"/>"/>
<script>
$(document).ready(function(){
	var nowUrl = "${nowUrl}";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
})
var JSException = function(msg){
	alert(msg);
	console.log(msg);
}
var AjaxUtil = function (url, params, type, dataType){
	if(!url){
		alert("url정보가 없습니다.");
		return null;
	}
	this.url = "${rootPath}/" + url;
	
	this.param = JSON.stringify(initData);
	var generateJSON = function(params){
		var paramArr = params.split(",");
		var data = {};
		for(var i=0,max=paramArr.length;i<max;i++){
			var key = paramArr[i]
			if($("#" + key).length>1){
				throw new JSException("동일 ID값이 존재함.");
			}else if($("#" + key).length==0){
				throw new JSException(key+"에 해당하는 ID가 존재하지 않음.");
			}
			data[key] = $("#" + key).val();
		}
		return  JSON.stringify(data);
	}
	this.type = type?type:"POST";
	this.dataType = dataType?dataType:"json";
	this.param = generateJSON(params);
	this.callbackSuccess = function(json){
    	var url = json.url;
    	var data = json.data;
    	var msg = json.msg;
    	if(msg){
    		alert(msg);
    	}
    	if(url){
        	pageMove(url);
    	}
	}
	
	this.setCallbackSuccess = function(callback){
		this.callbackSuccess = callback;
	}
	
	this.send = function(){
		$.ajax({ 
	        type     : this.type
	    ,   url      : this.url
	    ,   dataType : this.dataType 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : this.param
	    ,   success : this.callbackSuccess
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete : function(e) {
		}
		});
	}
}
</script>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/main.jsp">HOME</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li id="m1" ><a href="/board/board_main.jsp">게시판</a></li>
				<li id="m2" ><a href="/goods/goods_list.jsp">상품게시판</a></li>
				<li id="m3" ><a href="/goods/vendor_list.jsp">회사게시판</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="m3">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">정보 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li ><a href="/user/user_info.jsp" >유저정보</a></li>
						<li ><a href="/role/role_select.jsp" >권한정보</a></li>
						<li role="presentation" class="divider"></li>
						<li><a href="/user/logout_ok.jsp">로그아웃</a></li>
					</ul>
					</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
