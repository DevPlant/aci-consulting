class DynamicFieldController {

    constructor(){
    }

}


var DynamicFieldComponent = {
    controller: DynamicFieldController,
    controllerAs: "$fieldCtrl",
    bindings: {
        viewData: "<"
    },
    templateUrl: "src/components/dynamic-view/field/field.component.html"
};

angular.module('aci-app').component("dynamicField", DynamicFieldComponent);