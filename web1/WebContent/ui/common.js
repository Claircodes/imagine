/**
 * 공통 함수 java script 파일 
 */
// javascript 객체 비교 프로토 타입 함수 추가
Number.prototype.equals = function(obj){
	if(obj instanceof Number){
		return this.toString() == obj.toString();
	}
	return this==obj;
}
// Ajax +Json 을 이용한 페이지 이동 공통 함수 
function movePageWithAjax(pParams, pUrl, pCallBackFunc, pMethod){
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : pMethod? pMethod:"POST"
	    ,   url      : pUrl
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : pCallBackFunc
	    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
		        var jsonResponse = JSON.parse(xhr.responseText);
		        alert(jsonResponse.msg);
		},
		complete  : function() {
		}
	});
}

//pagination 이벤트 적용 공통 함수 
//*단  ul 태그 >li > a태그 형식이여야하며 
// ul 태그의 class명은 반드시 pagination 이여야함 
function setEvent(pageInfo,objId){
	$("ul[class='pagination']>li:not([class='disabled'])>a").click(function(){
		var thisNowPage = pageInfo.nowPage;
		var goPageNum = new Number(this.innerHTML);
		if(isNaN(goPageNum)){
			if(this.innerHTML=="◀"){
				thisNowPage -= pageInfo.blockCnt;
			}else if(this.innerHTML=="◀◀"){
				thisNowPage = 1;
			}else if(this.innerHTML=="▶"){
				thisNowPage += pageInfo.blockCnt;
			}else if(this.innerHTML=="▶▶"){
				thisNowPage = pageInfo.totalPageCnt;
			}
			if(thisNowPage<=0){
				thisNowPage = 1;
			}else if(thisNowPage>pageInfo.totalPageCnt){
				thisNowPage = pageInfo.totalPageCnt;
			}
			goPageNum = thisNowPage;
		}

		var page = {};
		page["nowPage"] = "" + goPageNum;
		var params = {};
		params["page"] = page;
		params["command"] = "list";
		movePageWithAjax(params, objId, callback);
	})
}
// 하단 페이지 블락을 자동으로 만들어주는 공통 함수 
//param: pageInfo => 페이지 정보 
//param: obId => 생성한 페이지 블럭을 넣어줄 객체 아이디 
function makePagination(pageInfo, objId){
	var sNum = pageInfo.startBlock;
	var eNum = pageInfo.endBlock;
	var nPage = pageInfo.nowPage
	var nTotal = pageInfo.totalPageCnt;
	var pageStr = "";
	if(nPage==1){
		pageStr += "<li class='disabled'><a >◀◀</a></li>";
		pageStr += "<li class='disabled' ><a >◀</a></li>";
	}else{ 
		pageStr += "<li><a>◀◀</a></li>";
		pageStr += "<li><a>◀</a></li>";
	}
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		}
	}
	if(nPage.equals(nTotal)){
		pageStr += "<li class='disabled'><a>▶</a></li>";
		pageStr += "<li class='disabled'><a>▶▶</a></li>";
	}else{ 
		pageStr += "<li><a>▶</a></li>";
		pageStr += "<li><a>▶▶</a></li>";
	}
	$("#" + objId).html(pageStr);
}
//하단 페이지 블락을 자동으로 만들어주는 공통 함수, 처음페이지와 마지막페이지는 화살표가 사라 
function makePagination2(pageInfo, objId){
	var sNum = pageInfo.startBlock;
	var eNum = pageInfo.endBlock;
	var nPage = pageInfo.nowPage
	var nTotal = pageInfo.totalPageCnt;
	var pageStr = "";
	if(nPage!=1){
		pageStr += "<li><a>◀◀</a></li>";
		pageStr += "<li><a>◀</a></li>";
	}
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		}
	}
	if(!nPage.equals(nTotal)){
		pageStr += "<li><a>▶</a></li>";
		pageStr += "<li><a>▶▶</a></li>";
	}
	$("#" + objId).html(pageStr);
}