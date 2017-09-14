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


</body>

</html>