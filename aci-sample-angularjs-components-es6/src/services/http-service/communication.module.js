import angular from 'angular';
import CommunicationService from './communication.service';

// Create a module for the SourceCopyService
export default angular.module('services.communicationService', [])
    .service(CommunicationService.$name, CommunicationService)
    .name;