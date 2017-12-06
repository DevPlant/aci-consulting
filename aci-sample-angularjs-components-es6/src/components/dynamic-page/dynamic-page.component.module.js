import angular from 'angular';

import DynamicPageComponent from "./dynamic-page.component";

import CommunicationModule from "../../services/http-service/communication.module";

//Register a Component into a new module, add module dependencies for ButtonComponentModule
export default angular.module('components.dynamicPage', [CommunicationModule])
    .component(DynamicPageComponent.$name, DynamicPageComponent).name;