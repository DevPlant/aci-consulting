class DynamicDataGridController {

    constructor() {
        this.data = [];
    }

    $onInit() {

        for (var i = 0; i < 4; i++) {
            var row = [];
            for (var j = 0; j < this.viewData.children.length; j++) {
                var child = this.viewData.children[j];
                row.push("Data: " + i + " - " + j + " " + child.fieldType);
            }
            this.data.push(row);
        }
    }

}


var DynamicGridComponent = {
    controller: DynamicDataGridController,
    controllerAs: "$dataGridCtrl",
    bindings: {
        viewData: "<"
    },
    templateUrl: "src/components/dynamic-view/data-grid/data-grid.component.html"
};

angular.module('aci-app').component("dynamicDataGrid", DynamicGridComponent);