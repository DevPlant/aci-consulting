export default class ScopeCopyService {

    constructor() {

    }

    // Assign object to a specific key in the targetScope, this overwrites old values!
    assignToScope(object, targetScope, key) {
        console.log(targetScope);
        targetScope[key] = object;
        console.log(targetScope);
    }

    // Assign all properties of object to the targetScope, this overwrites old values!
    assignObjectPropertiesToScope(object, targetScope){
        for (let key of Object.keys(object)) {
            targetScope[key] = object[key];
        }
    }

    static get $name() {
        return 'ScopeCopyService';
    }

}