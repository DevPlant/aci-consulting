// Import component specific CSS
import "./home.component.css";
// Import a class, to be used as controller
import HomeComponentTemplateController from "./home.component.controller";
// Import HTML - the template for this componenet
import HomeComponentTemplate from "./home.component.template.html";

export default {
    // Component name is camel-case, in HTML we use kebab-case
    $name: 'aciHome',
    template: HomeComponentTemplate,
    controller: HomeComponentTemplateController
};
