/*****************************************************/
/*              INITS                                 */
/******************************************************/
var GP = Em.Application.create({
});

GP.ready = function(){

}


/******************************************************/
/*              CONSTANTS                             */
/******************************************************/

GP.CONSTANTS = {
};

/******************************************************/
/*              MIXINS                               */
/******************************************************/

/**
 * Mixing to remove all the objects in an array controller
 */
GP.Clearable = Em.Mixin.create({
    content:[],

    init: function() {
        this._super();
        this.set('content', []);
    },

    /**
     * Remove all the objects in the array
     */
    removeAll: function(){
        var list = this.slice(0);
        this.removeObjects(list);
    },

    /**
     * Removes the first object that matches a property
     * @param propName Property name to match
     * @param value Value of the property to match
     */
    removeItem: function(propName, value){
        var obj = this.findProperty(propName, value);
        this.removeObject(obj);
    }
});


/******************************************************/
/*              MODEL                                 */
/******************************************************/

GP.User = Em.Object.extend({
    id: null,
    user_name: null,
    password: null,
    email: null,
    avatar_url: null,
    score: null
});

GP.Achievement = Em.Object.extend({
    id: null,
    userId: null,
    achievementId: null
});

GP.Game = Em.Object.extend({
    id: null,
    user1: null,
    user2: null,
    score_user1: null,
    score_user2: null,
    game_date: null,
    status_id: null
});

GP.Status = Em.Object.extend({
    id: null,
    description: null
})


/******************************************************/
/*              CONTROLLERS                           */
/******************************************************/

//main application controller
GP.ApplicationController = Em.Controller.extend({

});

GP.UserController = Em.ArrayController.extend({
    sortProperties: ['score'],

    addUser: function(user){
        var exists = this.filterProperty('id', user.get('id'));

        if (Em.empty(exists)){
            this.addObject(user);
        }
    }
});


/******************************************************/
/*              VIEWS                                 */
/******************************************************/

//main application view
GP.ApplicationView = Ember.View.extend({
});


/******************************************************/
/*              ROUTER                                */
/******************************************************/

GP.Router = Ember.Router.extend({
    enableLogging:  true,
    //default root goes to addLabels
    root: Ember.Route.extend({
        index: Ember.Route.extend({
            route: '/',
            redirectsTo: 'ladder'
        }),
        ladder: Ember.Route.extend({
            route: '/ladder',
            connectOutlets: function(router){
                //router.get('applicationController').connectOutlet('addLabel');
            }
        })
    })
});

/******************************************************/
/*              UTILITY OBJECTS                       */
/******************************************************/

/**
 * Datasource to communicate in the API
 */
GP.dataSource = Ember.Object.create({

});

/******************************************************/
/*              UTILITY FUNCTIONS                     */
/******************************************************/



