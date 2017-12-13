class DynamicAccordionGroupController {

    constructor(){
    }

}


var DynamicAccordionGroupComponent = {
    controller: DynamicAccordionGroupController,
    controllerAs: "$accordionGroupCtrl",
    bindings: {
        viewData: "<"
    },
    templateUrl: "src/components/dynamic-view/accordion-group/dynamic-accordion-group.component.html"
};

angular.module('aci-app').component("dynamicAccordionGroup", DynamicAccordionGroupComponent);