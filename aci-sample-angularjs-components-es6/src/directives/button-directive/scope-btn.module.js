import angular from 'angular';

import ScopeButtonDirective from './scope-btn.directive';

// Register the directive, declared as a Class, this requires a small hack using a lamda function
export default angular.module('directives.scopeBtn', [])
    .directive(ScopeButtonDirective.$name, () => new ScopeButtonDirective())
    .name;