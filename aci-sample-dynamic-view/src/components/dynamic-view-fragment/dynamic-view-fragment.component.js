class DynamicViewFragmentController {

    constructor(CommunicationService){
        console.log('init');
        this.CommunicationService = CommunicationService;
        this.viewData = {};
    }

    $onInit(){
        this.CommunicationService.getViewFragmentByName(this.viewName).then((response)=>{
           this.viewData = response;
        });
    }

}


var DynamicViewFragmentComponent = {
    controller: DynamicViewFragmentController,
    controllerAs: "$dynamicViewCtrl",
    bindings: {
        viewName: "<"
    },
    templateUrl: "src/components/dynamic-view-fragment/dynamic-view-fragment.component.html"
};

angular.module('aci-app').component("viewFragment", DynamicViewFragmentComponent);