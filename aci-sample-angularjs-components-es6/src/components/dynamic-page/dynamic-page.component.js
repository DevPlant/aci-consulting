// Import a class, to be used as controller
import DynamicPageController from "./dynamic-page.component.controller";
// Import HTML - the template for this componenet
import DynamicPageTemplate from "./dynamic-page.component.template.html";

export default {
    // Component name is camel-case, in HTML we use kebab-case
    $name: 'dynamicPage',
    template: DynamicPageTemplate,
    controller: DynamicPageController
};
