<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script>

	function callback(results) {
		var result = "<table border='1' style='border-collapse:collapse; text-align:center'>";
		result += "<tr><td>vinum</td><td>viname</td><td>videsc</td><td>viaddress</td><td>viphone</td><td>vicredat</td><td>vicretim</td></tr>"
		for (i = 0, max = results.length; i < max; i++) {
			var vendor = results[i];
			result += "<tr><td>" + vendor.viNum + "</td><td>" + vendor.viName + "</td><td>" + vendor.viDesc + "</td><td>" + vendor.viAddress + "</td><td>" + vendor.viPhone + "</td><td>" + vendor.viCredat + "</td><td>" + vendor.viCretim + "</td></tr>";
		}
		result += "</table>";
		$("#vendor_result").html(result);
	}

	$(document).ready(function() {
		$("input[type='button']").click(function() {
			var au = new AjaxUtil("vendor/list");
			au.setCallbackSuccess(callback);
			au.send();
		})
	})
</script>

</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="${rootPath}/vendor/list" method="post">
		<input type="button" value="전송">
	</form>
	<div id="vendor_result"></div>
</body>
</html>