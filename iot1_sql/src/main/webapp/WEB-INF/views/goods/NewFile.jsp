<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<base href="http://demos.telerik.com/kendo-ui/treelist/dragdrop">
<style>
html {
	font-size: 14px;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<title></title>
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.material.min.css" />
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.material.mobile.min.css" />

<script src="https://kendo.cdn.telerik.com/2017.2.621/js/jquery.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2017.2.621/js/kendo.all.min.js"></script>
</head>
<body>
	<div id="mariaTree"></div>
	<script>
		jQuery(function() {
			jQuery("#mariaTree").kendoTreeList({
				"columns" : [ {
					"field" : "Database",
					"title" : "test"
				} ],
				"dataSource" : {
					"schema" : {
						"model" : {
							"id" : "Database"
						}
					},
					"transport" : {
						"read" : {
							"dataType" : "json",
							"type" : "POST",
							"contentType" : "application/json",
							"url" : "/sql/maria/treelist"
						},
						"parameterMap" : function parameterMap(options, type) {
							if (type === "read") {
								return JSON.stringify(options);
							} else {
								return JSON.stringify(options.models);
							}
						}
					}
				}
			});
		})
	</script>

</body>
</html>