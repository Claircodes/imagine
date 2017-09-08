<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url var="readUrl" value="/goods/list" />
<c:url var="createUrl" value="/goods/create" />
<c:url var="updateUrl" value="/goods/update" />
<c:url var="deleteUrl" value="/goods/delete" />
<c:url var="vendorComboUrl" value="/vendor/combo" />
<c:url var="vendor_readUrl" value="/vendor/list" />
<c:url var="vendor_createUrl" value="/vendor/create" />
<c:url var="vendor_updateUrl" value="/vendor/update" />
<c:url var="vendor_deleteUrl" value="/vendor/delete" />
</head>
<body>
	<script>
		$(document).ready(function() {
			if (!"${vendorcombolist}") {
				location.href = "${vendorComboUrl}";
			}
		})

	</script>
	<br>
	<br>
	<br> ${readUrl}
	<br>

	<kendo:grid title="그리드1" name="grid1" pageable="true" sortable="true" scrollable="true" height="450">
		<kendo:grid-editable mode="incell" />
		<kendo:grid-toolbar>
			<kendo:grid-toolbarItem name="create" text="생성" />
			<kendo:grid-toolbarItem name="save" text="저장" />
			<kendo:grid-toolbarItem name="update" text="수정" />
			<kendo:grid-toolbarItem name="delete" text="삭제" />
		</kendo:grid-toolbar>
		<kendo:grid-columns>
			<kendo:grid-column selectable="true" width="50px" />
			<kendo:grid-column title="회사번호" field="viNum" editable="false" />
			<kendo:grid-column title="회사이름" field="viName" />
			<kendo:grid-column title="회사설명" field="viDesc" />
			<kendo:grid-column title="회사주소" field="viAddress" />
			<kendo:grid-column title="회사번호" field="viPhone" />
			<kendo:grid-column title="생산일자" field="viCredat" format="{0:yyyyMMdd}" />
			<kendo:grid-column title="생산시간" field="viCretim" />
			<kendo:grid-column command="destroy" title="삭제" />
		</kendo:grid-columns>
		
				<kendo:dataSource pageSize="20" batch="true">
			<!--데이터가 왔다갔다 하는걸 정의 -->
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${vendor_readUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-create url="${vendor_createUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-update url="${vendor_updateUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-destroy url="${vendor_deleteUrl}" dataType="json" type="POST" contentType="application/json" />
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
		</kendo:dataSource>
		
	</kendo:grid>


	<kendo:grid title="그리드2" name="grid2" pageable="true" sortable="true" scrollable="true" height="450">
		<kendo:grid-editable mode="incell" />
		<kendo:grid-toolbar>
			<kendo:grid-toolbarItem name="create" text="생성" />
			<kendo:grid-toolbarItem name="save" text="저장" />
			<kendo:grid-toolbarItem name="update" text="수정" />
			<kendo:grid-toolbarItem name="delete" text="삭제" />
		</kendo:grid-toolbar>
		<kendo:grid-columns>
			<kendo:grid-column selectable="true" width="50px" />
			<kendo:grid-column title="제품번호" field="giNum" editable="false" />
			<kendo:grid-column title="제품이름" field="giName" />
			<kendo:grid-column title="제품설명" field="giDesc" />
			<kendo:grid-column title="회사번호" field="viNum">
				<kendo:grid-column-values value="${vendorcombolist}" />
			</kendo:grid-column>
			<kendo:grid-column title="생산일자" field="giCredat" format="{0:yyyyMMdd}" />
			<kendo:grid-column title="생산시간" field="giCretim" />
			<kendo:grid-column command="destroy" title="삭제" />
		</kendo:grid-columns>
		<kendo:dataSource pageSize="20" batch="true">
			<!--데이터가 왔다갔다 하는걸 정의 -->
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-destroy url="${deleteUrl}" dataType="json" type="POST" contentType="application/json" />
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
			<!-- 입력받는 걸 정의 -->
			<kendo:dataSource-schema>
				<kendo:dataSource-schema-model id="giNum">
					<!-- 테이블들의 기본키라고 생각 id="giNum" -->
					<kendo:dataSource-schema-model-fields>
						<kendo:dataSource-schema-model-field name="giName" type="string">
						</kendo:dataSource-schema-model-field>
						<kendo:dataSource-schema-model-field name="viNum" type="string">
						</kendo:dataSource-schema-model-field>
						<kendo:dataSource-schema-model-field name="giCredat" editable="true" type="date">
						</kendo:dataSource-schema-model-field>
						<kendo:dataSource-schema-model-field name="giCretim" editable="false">
						</kendo:dataSource-schema-model-field>
					</kendo:dataSource-schema-model-fields>

				</kendo:dataSource-schema-model>
			</kendo:dataSource-schema>
		</kendo:dataSource>
	</kendo:grid>
</body>
</html>