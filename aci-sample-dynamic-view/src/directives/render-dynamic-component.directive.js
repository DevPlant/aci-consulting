var tabGroupTemplate = '<dynamic-tab-group view-data="model"/>';
var accordionGroupTemplate = '<dynamic-accordion-group view-data="model"/>';
var gridTemplate = '<dynamic-grid view-data="model"/>';
var gridDataTemplate = '<dynamic-data-grid view-data="model"/>';
var fieldTemplate = '<dynamic-field view-data="model"/>';
var notImplementedTemplate = '<h3>Component not implemented ... </h3>';


function DynamicRenderDirective($compile) {

    function linker(scope, element, attrs) {
        element.html(getTemplate(scope.model));
        $compile(element.contents())(scope);
    }

    function getTemplate(model) {
        console.log(model.elementType);
        var template = notImplementedTemplate;
        switch (model.elementType) {
            case 'TAB_GROUP':
                template = tabGroupTemplate;
                break;
            case 'ACCORDION_GROUP':
                template = accordionGroupTemplate;
                break;
            case 'FIELD':
                template = fieldTemplate;
                break;
            case 'GRID':
                template = gridTemplate;
                break;
            case 'DATA_GRID':
                template = gridDataTemplate;
                break;
            case 'PANEL':
                template = "<" + model.angularComponentName + "/>";
                break;
        }
        console.log(template);
        return template;
    }

    var directiveDefinition = {
        restrict: "E",
        scope: {
            model: '='
        },
        link: linker
    };

    return directiveDefinition;
}


angular.module('aci-app').directive("dynamicRender", DynamicRenderDirective);