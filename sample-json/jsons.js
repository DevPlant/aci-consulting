var JSONS = {};

JSONS.screens = {
    "screens" : [
        {
            "name" : "screen1",
            "label" : "some value ...",
            "tabs" : [
                {"name":"tab1"}
            ]
        },
        {
            "name" : "screen1",
            "label" : "some value ...",

        }
    ]
};

JSONS.grids = {
    "grids" : [
        {
            "name" : "grid1",
            "label" : "some value ...",

        },
        {
            "name" : "grid2",
            "label" : "some value ...",

        }
    ]
}


console.log("JSON's loaded into application", JSONS);

// Bineinteles trebuie sa puneti JSON-urile voastre si trebuie adaugat acest fisier in init.js si plugins.html  la fel ca celelate fisiee de JS
// Le puteti accessa oriunde in cod folosind var xyz = JSONS.screens; sau var abc = JSONS.grids 
