export default class CommunicationService {

    constructor($http, $log, $q) {
        this.$http = $http;
        this.$log = $log;
        this.$q = $q;
    }


    getPageById(pageId) {
        return this.$http.get(`/api/page/${pageId}`).then((response) => {
            return response.data;
        }).catch((error) => {
            this.$log.error('XHR Failed for getPageById:' + JSON.stringify(error));
            return this.$q.reject("Page does not exist!");
        });
    }


    static get $name() {
        return 'CommunicationService';
    }

}