<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<base href="http://demos.telerik.com/kendo-ui/treelist/dragdrop">

</head>
<body>
	function onBound() { } function toolbarEvent() { } function
	treeSelect() { }
	</script>
<body>

	<div id="top-pane">
		<div id="top" class="pane-content">
			<div id="grid" title="그리드"></div>
			<script>
				jQuery(function() {
					jQuery("#grid").kendoGrid(
							{
								"editable" : {
									"mode" : "incell"
								},
								"columns" : [ {
									"field" : "column_name",
									"editable" : false,
									"title" : "1"
								}, {
									"field" : "data_type",
									"title" : "2"
								}, {
									"field" : "character_maximum_length",
									"editable" : false,
									"title" : "3"
								}, {
									"field" : "is_nullable",
									"title" : "4"
								} ],
								"pageable" : true,
								"sortable" : true,
								"dataSource" : {
									"schema" : {
										"model" : {
											"id" : "column_name"
										}
									},
									"batch" : true,
									"pageSize" : 20.0,
									"transport" : {
										"read" : {
											"dataType" : "json",
											"type" : "POST",
											"contentType" : "application/json",
											"url" : "/sql/db/table/info/list"
										},
										"parameterMap" : function parameterMap(
												options, type) {
											if (type === "read") {
												return JSON.stringify(options);
											}
										}
									}
								},
								"scrollable" : true,
								"height" : 450.0
							});
				})
			</script>
		</div>
	</div>
	<div id="middle-pane">
		<div class="pane-content">
			<h3>Inner splitter / middle-middle pane</h3>
		</div>
	</div>















	{columns=[ 
	
	usernum, userid, userpwd, username, age, address, hp1, hp2,
	hp3, departnum, userrolelevel, gender 
	
	], 
	
	type=select, 
	
	list=[

	{usernum=7, address=ㅁㄷㄱㅈㄷㅁㅈㄳㅁㅈㄷㄱ, gender=W, userrolelevel=10, hp1=4293,
	userpwd=123473, hp3=5234, hp2=234, departnum=null, userid=sjflsajdf,
	age=48, username=홍길동}, {usernum=10, address=232323,
	gender=M,userrolelevel=10, hp1=232, userpwd=qweqw, hp3=2323, hp2=232,
	departnum=null, userid=qwedd, age=23, username=qweqweq수정},

	{usernum=11,address=서울시 노원구 월계2동 , gender=W, userrolelevel=1, hp1=010,
	userpwd=1234, hp3=6670, hp2=9999, departnum=null, userid=imagine,
	age=29, username=임혜진}, 
	
	{usernum=12, address=서울시 도봉구 , gender=M,
	userrolelevel=10, hp1=011, userpwd=2345, hp3=8888, hp2=888,
	departnum=null, userid=tallah, age=31, username=임선묵}
	
	] }
















	</div>
	<div id="middle-pane">
		<div class="pane-content">
			<!-- jsp 관련된 것 -->
			<div id="grid" title="그리드"></div>
			<script>
				jQuery(function() {
					jQuery("#grid")
							.kendoGrid(
									{
										"toolbar" : [ {
											"name" : "create",
											"text" : "생성"
										}, {
											"name" : "save",
											"text" : "저장"
										}, {
											"name" : "excel",
											"text" : "엑셀저장"
										} ],
										"excel" : {
											"allPages" : true,
											"filterable" : true,
											"fileName" : "상품정보.xlsx",
											"proxyURL" : "/sql/goods/excel"
										},
										"editable" : {
											"mode" : "incell"
										},
										"columns" : [ {
											"field" : "giNum",
											"title" : "제품번호"
										}, {
											"field" : "giName",
											"title" : "제품이름"
										}, {
											"field" : "giDesc",
											"title" : "제품설명"
										}, {
											"field" : "viNum",
											"title" : "회사번호"
										}, {
											"field" : "giCredat",
											"format" : "{0:yyyy-MM-dd}",
											"title" : "생산일자"
										}, {
											"field" : "giCretim",
											"title" : "생산시간"
										}, {
											"title" : "삭제",
											"command" : "destroy"
										} ],
										"pageable" : true,
										"navigatable" : true,
										"sortable" : true,
										"dataSource" : {
											"schema" : {
												"model" : {
													"id" : "giNum",
													"fields" : {
														"giName" : {
															"type" : "string",
															"validation" : {
																"required" : true
															}
														},
														"giCredat" : {
															"editable" : true,
															"type" : "date"
														},
														"giCretim" : {
															"editable" : false
														},
														"giNum" : {
															"editable" : false,
															"type" : "number"
														},
														"viNum" : {
															"defaultValue" : 1.0,
															"validation" : {
																"min" : 1.0,
																"required" : true
															}
														}
													}
												}
											},
											"batch" : true,
											"pageSize" : 20.0,
											"transport" : {
												"read" : {
													"dataType" : "json",
													"type" : "POST",
													"contentType" : "application/json",
													"url" : "/sql/goods/list"
												},
												"create" : {
													"dataType" : "json",
													"type" : "POST",
													"contentType" : "application/json",
													"url" : "/sql/goods/create"
												},
												"destroy" : {
													"dataType" : "json",
													"type" : "POST",
													"contentType" : "application/json",
													"url" : "/sql/goods/delete"
												},
												"update" : {
													"dataType" : "json",
													"type" : "POST",
													"contentType" : "application/json",
													"url" : "/sql/goods/update"
												},
												"parameterMap" : function parameterMap(
														options, type) {
													if (type === "read") {
														return JSON
																.stringify(options);
													} else {
														var str = JSON
																.stringify(options.models);
														return str;
													}
												}
											}
										}
									});
				})
			</script>
		</div>
</body>

</html>