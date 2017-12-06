// Import a class, to be used as controller
import ScopeButtonComponentController from "./button.component.controller";
// Import HTML
import ScopeButtonComponentTemplate from "./button.component.template.html";

export default {
    // Component name is camel-case, in HTML we use kebab-case
    $name: 'aciScopeBtnWrapper',
    template: ScopeButtonComponentTemplate,
    controller: ScopeButtonComponentController
};
