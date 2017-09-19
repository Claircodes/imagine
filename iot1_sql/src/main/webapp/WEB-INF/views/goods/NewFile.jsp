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

	<div id="grid1" title="그리드1"></div>
	<script>
		jQuery(function() {
			jQuery("#grid1").kendoGrid({
				"toolbar" : [ {
					"name" : "create",
					"text" : "생성"
				}, {
					"name" : "save",
					"text" : "저장"
				}, {
					"name" : "update",
					"text" : "수정"
				}, {
					"name" : "delete",
					"text" : "삭제"
				} ],
				"editable" : {
					"mode" : "incell"
				},
				"columns" : [ {
					"selectable" : true,
					"width" : "50px"
				}, {
					"field" : "viNum",
					"editable" : false,
					"title" : "회사번호"
				}, {
					"field" : "viName",
					"title" : "회사이름"
				}, {
					"field" : "viDesc",
					"title" : "회사설명"
				}, {
					"field" : "viAddress",
					"title" : "회사주소"
				}, {
					"field" : "viPhone",
					"title" : "회사번호"
				}, {
					"field" : "viCredat",
					"format" : "{0:yyyyMMdd}",
					"title" : "생산일자"
				}, {
					"field" : "viCretim",
					"title" : "생산시간"
				}, {
					"title" : "삭제",
					"command" : "destroy"
				} ],
				"pageable" : true,
				"sortable" : true,
				"dataSource" : {
					"batch" : true,
					"pageSize" : 20.0,
					"transport" : {
						"read" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/vendor/list"
						},
						"create" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/vendor/create"
						},
						"update" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/vendor/update"
						},
						"destroy" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/vendor/delete"
						},
						"parameterMap" : function parameterMap(options, type) {
							if (type === "read") {
								return JSON.stringify(options);
							} else {
								return JSON.stringify(options.models);
							}
						}
					}
				},
				"scrollable" : true,
				"height" : 450.0
			});
		})
	</script>
	<div id="grid2" title="그리드2"></div>
	<script>
		jQuery(function() {
			jQuery("#grid2").kendoGrid({
				"toolbar" : [ {
					"name" : "create",
					"text" : "생성"
				}, {
					"name" : "save",
					"text" : "저장"
				}, {
					"name" : "update",
					"text" : "수정"
				}, {
					"name" : "delete",
					"text" : "삭제"
				} ],
				"editable" : {
					"mode" : "incell"
				},
				"columns" : [ {
					"selectable" : true,
					"width" : "50px"
				}, {
					"field" : "giNum",
					"editable" : false,
					"title" : "제품번호"
				}, {
					"field" : "giName",
					"title" : "제품이름"
				}, {
					"field" : "giDesc",
					"title" : "제품설명"
				}, {
					"field" : "viNum",
					"values" : [ {
						"text" : "기아자동차",
						"value" : 1
					}, {
						"text" : "현대자동차",
						"value" : 2
					}, {
						"text" : "메르세데즈-벤츠",
						"value" : 3
					} ],
					"title" : "회사번호"
				}, {
					"field" : "giCredat",
					"format" : "{0:yyyyMMdd}",
					"title" : "생산일자"
				}, {
					"field" : "giCretim",
					"title" : "생산시간"
				}, {
					"title" : "삭제",
					"command" : "destroy"
				} ],
				"pageable" : true,
				"sortable" : true,
				"dataSource" : {
					"schema" : {
						"model" : {
							"id" : "giNum",
							"fields" : {
								"giName" : {
									"type" : "string"
								},
								"giCredat" : {
									"editable" : true,
									"type" : "date"
								},
								"giCretim" : {
									"editable" : false
								},
								"viNum" : {
									"type" : "string"
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
						"update" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/goods/update"
						},
						"destroy" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/goods/delete"
						},
						"parameterMap" : function parameterMap(options, type) {
							if (type === "read") {
								return JSON.stringify(options);
							} else {
								return JSON.stringify(options.models);
							}
						}
					}
				},
				"scrollable" : true,
				"height" : 450.0
			});
		})
	</script>
</body>
</html>
</body>

</html>