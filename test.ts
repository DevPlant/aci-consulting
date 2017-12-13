class HerosComponentController implements ng.IComponentController {

  constructor() {}

  public $onInit () {
    console.log('init')
    this.heros = [];
  }
}

class HerosComponent implements ng.IComponentOptions {

  public controller: ng.Injectable<ng.IControllerConstructor>;
  public controllerAs: string;
  public template: string;

  constructor() {
    this.controller = HerosComponentController;
    this.controllerAs = "$ctrl";
    this.template = `
      <ul>
        <li ng-repeat="hero in $ctrl.heros">{{ hero }}</li>
      </ul>
    `;
  }
}

angular
  .module("mySuperAwesomeApp", [])
  .component("heros", new HerosComponent());