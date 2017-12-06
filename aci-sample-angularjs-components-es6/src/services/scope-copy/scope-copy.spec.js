// Tests don't work yet, some issue with grunt ...
describe('scopeCopyService', function () {

    var service;

    beforeEach(inject(function () {
        const $injector = angular.injector(['services.scope-copy']);

        service = function () {
            return $injector.get('ScopeCopyService');
        };
    }));


    // it('has to test assignToScope', function () {
    //     const mockScope = {};
    //     const object = {
    //         name: "Test",
    //         value: 123
    //     };
    //
    //     service.assignToScope(object, mockScope, "key");
    //     expect(mockScope.key.name).toEqual("Test");
    //     expect(mockScope.key.value).toEqual(123);
    // });
    //
    // it('has to test assignObjectPropertiesToScope', function () {
    //     const mockScope = {};
    //     const object = {
    //         name: "Test",
    //         value: 123
    //     };
    //
    //     service.assignObjectPropertiesToScope(object, mockScope);
    //
    //     expect(mockScope.name).toEqual("Test");
    //     expect(mockScope.value).toEqual(123);
    // });

});