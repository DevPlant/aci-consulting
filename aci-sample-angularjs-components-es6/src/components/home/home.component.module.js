import angular from 'angular';

import ButtonComponentModule from "../button-component/button.component.module";
import HomeComponent from "./home.component";

//Register a Component into a new module, add module dependencies for ButtonComponentModule
export default angular.module('components.home', [ButtonComponentModule])
    .component(HomeComponent.$name, HomeComponent).name;