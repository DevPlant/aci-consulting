class DynamicTabGroupController {

    constructor(){
    }

}


var DynamicTabGroupComponent = {
    controller: DynamicTabGroupController,
    controllerAs: "$tabGroupCtrl",
    bindings: {
        viewData: "<"
    },
    templateUrl: "src/components/dynamic-view/tab-group/dynamic-tab-group.component.html"
};

angular.module('aci-app').component("dynamicTabGroup", DynamicTabGroupComponent);