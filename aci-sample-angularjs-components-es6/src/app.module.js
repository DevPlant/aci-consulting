// Import for external dependency
import angular from 'angular';
// Import for our defined HomeComponentModule
import HomeComponentModule from './components/home/home.component.module';
// ES6 can import CSS like this
import './style.css';

// Create the App Module, Add Dependency to Home ("aci-home")
angular.module('aci-app', [HomeComponentModule]);

// Bootstrap the app ( no ng-app needed )
angular.element(document).ready(() => {
    console.log('Bootstrap!');
    angular.bootstrap(document, ['aci-app']);
    console.log('Bootstrap done!');
});