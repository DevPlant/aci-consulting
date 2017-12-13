var notImplementedTemplate = '<h3>Component not implemented ... </h3>';

function FieldRendererDirective($compile) {

    function linker(scope, element, attrs) {
        element.html(getTemplate(scope.value, scope.type));
        $compile(element.contents())(scope);
    }

    function getTemplate(value, type) {
        var template = notImplementedTemplate;
        switch (type) {
            case 'TEXT':
                template = value;
                break;
            case 'LINK':
                template = "<a href=\"https://www.google.com\">" + value + "</a>";
                break;
        }
        console.log(template);
        return template;
    }

    var directiveDefinition = {
        restrict: "E",
        scope: {
            value: '=',
            type: "="
        },
        link: linker
    };

    return directiveDefinition;
}


angular.module('aci-app').directive("fieldRenderer", FieldRendererDirective);