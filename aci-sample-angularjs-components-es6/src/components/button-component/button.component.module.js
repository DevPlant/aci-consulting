import angular from "angular";

import ButtonComponent from "./button.component";
import ScopeCopyServiceModule from "../../services/scope-copy/scope-copy.module";
import ScopeBtnModule from "../../directives/button-directive/scope-btn.module";

//Register a Component into a new module, add module dependencies for ScopeCopyServiceModule and ScopeBtnModule
export default angular.module('components.button', [ScopeCopyServiceModule, ScopeBtnModule])
    .component(ButtonComponent.$name, ButtonComponent).name;