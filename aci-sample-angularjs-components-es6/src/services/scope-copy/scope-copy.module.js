import angular from 'angular';
import ScopeCopyService from './scope-copy.service';

// Create a module for the SourceCopyService
export default angular.module('services.scopeCopy', [])
    .service(ScopeCopyService.$name, ScopeCopyService)
    .name;