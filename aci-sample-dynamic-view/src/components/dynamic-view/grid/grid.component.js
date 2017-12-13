class DynamicGridController {

    constructor(){
    }

}


var DynamicGridComponent = {
    controller: DynamicGridController,
    controllerAs: "$gridCtrl",
    bindings: {
        viewData: "<"
    },
    templateUrl: "src/components/dynamic-view/grid/grid.component.html"
};

angular.module('aci-app').component("dynamicGrid", DynamicGridComponent);