<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <base href="http://demos.telerik.com/kendo-ui/treelist/mvvm">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.2.621/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2017.2.621/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2017.2.621/js/kendo.all.min.js"></script>
    <link rel="stylesheet" href="../content/shared/styles/examples-offline.css">
    <script src="../content/shared/js/console.js"></script>
</head>
<body>
<div id="example">
    <div class="demo-section k-content wide">
        <div>
            <h4>Select a record</h4>
            <div data-role="treelist"
                 data-selectable="true"
                 data-columns="[
                                 { 'field': 'Name' },
                                 { 'field': 'Position', 'width': 270 },
                              ]"
                 data-bind="source: employees,
                            visible: isVisible,
                            events: {
                              change: onChange
                            }"
                 style="height: 300px"></div>
        </div>
        <div style="padding-top: 2em;">
            <h4>Console</h4>
            <div class="console"></div>
        </div>
    </div>

<script>
    var viewModel = kendo.observable({
        isVisible: true,
        onChange: function(e) {
            var widget = e.sender;
            var dataItem = widget.dataItem(widget.select());
            kendoConsole.log("event :: change(" + kendo.stringify(dataItem, null, 4) + ")");
        },
        
        
        employees: new kendo.data.TreeListDataSource({
            data: [
                { EmployeeID: 1, ReportsTo: null, Name: "Andrew Fuller", Position: "CEO" },
                { EmployeeID: 2, ReportsTo: 1, Name: "Andrew Hopkins", Position: "Sales" },
                { EmployeeID: 3, ReportsTo: 1, Name: "Betty Stewart", Position: "Legal advisor" },
                { EmployeeID: 4, ReportsTo: 1, Name: "Jon Michaels", Position: "Product team lead" },
                { EmployeeID: 5, ReportsTo: 1, Name: "Rebecca Williams", Position: "Software developer" },
                { EmployeeID: 6, ReportsTo: 4, Name: "John Smith", Position: "Marketing associate" },
                { EmployeeID: 7, ReportsTo: 4, Name: "Natasha Andrews", Position: "System administrator" },
                { EmployeeID: 8, ReportsTo: 4, Name: "Victoria Belmont", Position: "Designer" },
                { EmployeeID: 9, ReportsTo: 4, Name: "Emma Watkins", Position: "Software developer" }
            ],
            schema: {
                model: {
                    id: "EmployeeID",
                    parentId: "ReportsTo",
                    fields: {
                        EmployeeId: { type: "number", editable: false, nullable: false },
                        ReportsTo: { nullable: true, type: "number" },
                        Name: { field: "Name", type: "string" },
                        Position: { field: "Position", type: "string" }
                    }
                }
            }
        })
    });
    kendo.bind($("#example"), viewModel);
</script>
</div>


</body>
</html>
