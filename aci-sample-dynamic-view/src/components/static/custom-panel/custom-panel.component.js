class CustomPanelController {

    constructor() {
        console.log('init custom panel');
    }

}


var CustomPanelComponent = {
    controller: CustomPanelController,
    controllerAs: "$customPanelCtrl",
    templateUrl: "src/components/static/custom-panel/custom-panel.component.html"
};

angular.module('aci-app').component("customPanel", CustomPanelComponent);