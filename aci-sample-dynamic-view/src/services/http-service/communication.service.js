class CommunicationService {

    constructor($http, $log, $q) {
        this.$http = $http;
        this.$log = $log;
        this.$q = $q;
    }


    getViewFragmentByName(viewName) {
        return this.$http.get(`http://localhost:8081/api/view?viewName=${viewName}`).then((response) => {
            return response.data;
        }).catch((error) => {
            this.$log.error('XHR Failed for getViewFragmentByName:' + JSON.stringify(error));
            return this.$q.reject("ViewFragment does not exist!");
        });
    }

}

angular.module('aci-app').service("CommunicationService", CommunicationService);