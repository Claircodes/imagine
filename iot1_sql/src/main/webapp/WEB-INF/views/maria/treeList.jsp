<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url var="mUrl" value="/maria/treelist" />

<kendo:treeList name="mariaTree">

	<kendo:treeList-columns>
		<kendo:treeList-column title="test" field="Database" />
	</kendo:treeList-columns>
	<kendo:dataSource>
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${mUrl}" dataType="json"
				type="POST" contentType="application/json" />
			<kendo:dataSource-transport-parameterMap>
				<script>
					function parameterMap(options, type) {
						if (type === "read") {
							return JSON.stringify(options);
						} else {
							return JSON.stringify(options.models);
						}
					}
				</script>
			</kendo:dataSource-transport-parameterMap>
		</kendo:dataSource-transport>
		<kendo:dataSource-schema>
			<kendo:dataSource-schema-model id="Database">
			</kendo:dataSource-schema-model>
		</kendo:dataSource-schema>
	</kendo:dataSource>
</kendo:treeList>
</body>
</html>