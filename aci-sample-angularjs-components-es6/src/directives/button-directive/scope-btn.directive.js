import template from './scope-btn.template.html';

// This Class Simulates the "framework" directives you need to use, these directives simply use scope instead of bindings!
export default class ScopeButtonDirective {

    constructor() {
        this.restrict = 'AE';
        this.template = template;
        this.scope = false;
        this.transclude = false;
    }


    controller($scope) {

    }

    link(scope, element, attrs) {
        console.log('scope', scope);
    }

    // Directive name is camel-case, in HTML we use kebab-case
    static get $name() {
        return 'emfScopeBtn';
    }
}