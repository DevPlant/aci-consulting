export default class DynamicPageController {

    constructor(CommunicationService) {
        this.CommunicationService = CommunicationService;

        this.pageId = 1;
        this.error = null;
        this.page = null;
    }

    loadPage() {
        console.log('load page '+this.pageId);
        this.CommunicationService.getPageById(this.pageId).then((page) => {
            console.log('Got Page: '+page);
            this.page = page;
            this.error = null;
        }).catch((error) => {
            this.page = null;
            this.error = error;
        });
    }

}