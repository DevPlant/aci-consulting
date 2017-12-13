// This would be your "getNextActionButton" written as a component ( simplified )
// ButtonProperties are written to scope using the ScopeCopyService
export default class ButtonComponentController {

    constructor(ScopeCopyService, $scope) {
        this.ScopeCopyService = ScopeCopyService;
        this.scope = $scope;
        this.emfButtonProperties = {
            action: this.onButtonClicked,
            label: 'Next Alert'
        };
    }

    onButtonClicked(parameter) {
        console.log('called on click from directive!');
        alert('Button clicked with parameter: ' + parameter);
    }

    $onInit() {
        console.log('onInit Called! Properties are now copied to $scope');
        this.ScopeCopyService.assignObjectPropertiesToScope(this.emfButtonProperties, this.scope);
    }


}
