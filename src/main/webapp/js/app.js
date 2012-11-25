/*****************************************************/
/*              INITS                                 */
/******************************************************/
window.GP = Em.Application.create({
    gpDevhelper : GPDevHelper.create(),

    ready: function(){
        console.log("Application initialized");
        //GP.gpDevhelper.createUsers(5);
        GP.dataSource.getAllAvatars();
        GP.dataSource.getAllUsers();

    }
});


/******************************************************/
/*              CONSTANTS                             */
/******************************************************/

GP.CONSTANTS = {
    API:
    {
        BASE_URL:'/groupong',
        AVATARS:'/avatars',
        USERS:'/users',
        USER:'/user',
        ACHIEVEMENTS:'/achievements',
        MATCH:'/match'

    }
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
    avatar: null,
    score: null,
    rank: null,
    matches: [],

    challenges: function(){
        return this.get('matches').filterProperty('statusId', 1).filterProperty('user1Id',this.get('id'));
    }.property('matches.@each'),

    pending: function(){
        var filteredArray = [];
        this.get('matches').map(function(i) {
            if (Em.isEqual(i.statusId,2) || Em.isEqual(i.statusId,5)){
                filteredArray.push(i);
            }
        });
        return filteredArray;

    }.property('matches.@each'),

    finished: function(){
        return this.get('matches').filterProperty('statusId',6);
    }.property('matches.@each')
});

GP.Achievement = Em.Object.extend({
    id: null,
    title: null,
    description: null
});

GP.Match = Em.Object.extend({
    id: null,
    user1Id: null,
    user2Id: null,
    scoreUser1: null,
    scoreUser2: null,
    date: null,
    statusId: null,
    status:null,

    user1: function(){
        return GP.get('router.userController').findProperty('id',this.get('user1Id'));
    }.property('user1Id'),

    user2: function(){
        return GP.get('router.userController').findProperty('id',this.get('user2Id'));
    }.property('user2Id'),

    fromNow: function(){
        console.log("from now ---> " + JSON.stringify(this));
        return this.get('date').fromNow();
    }.property('date').cacheable('false'),

    toConfirm: function(){
        return Em.isEqual(this.get('statusId'), 5);
    }.property('statusId'),

    isUser1: function(context){
        debugger;
        return Em.isEqual(this.get('user1Id'));
    }.property()
});

GP.Status = Em.Object.extend({
    id: null,
    description: null
});

GP.Avatar = Em.Object.extend({
    id: null,
    url: null
})


/******************************************************/
/*              CONTROLLERS                           */
/******************************************************/

//main application controller
GP.ApplicationController = Em.Controller.extend({

    loggedUser: null,

    isUserLogged: function(){
        return (!Em.none(this.loggedUser));
    }.property('loggedUser'),

    loggedUserId: function(){
        if (GP.get('router.applicationController.isUserLogged')){
            return this.loggedUser.get('id');
        }else{
            return null;
        }
    }.property('loggedUser').cacheable(false),

    createMatch: function(event){
        var targetUser = event.context.target;
        GP.dataSource.createMatch(targetUser);
        console.log(JSON.stringify(event.context.target));
    }
});

GP.ModalController = Em.Controller.extend({
    showChallengeModal: function(event){
        var user = event.context;
        /*if (Em.none(GP.get('router.applicationController.loggedUser'))){
            var message = "You need to be logged in to challenge someone!!";
            GP.get('router').get('applicationController').connectOutlet('smallModal', 'smallModal', message);
            $('#smallModal').reveal();
        }
        else if (Em.isEqual(user.get('id'), GP.get('router.applicationController.loggedUser').get('id'))){
            var message = "You cannot challenge yourself!";
            GP.get('router').get('applicationController').connectOutlet('smallModal', 'smallModal', message);
            $('#smallModal').reveal();
        }else{*/
            var context = {
                title: 'Do you want to challenge ' + user.get('username') + '?',
                lead: 'If you confirm, he will receive a notification and will confirm the challenge',
                second: '.. if he is not too afraid to accept it',
                imgSrc: 'images/challenge.png',
                target: user,
                actionChallenge: true
            }
            GP.get('router').get('applicationController').connectOutlet('modal', 'modal', context);
            $('#myModal').reveal();
        //}
    },

    showLoginModal: function(){
        GP.get('router').get('applicationController').connectOutlet('modal', 'modalLogin');
        $('#myModal').reveal();
    },

    showAccept: function(event){
        var user = event.context;

        if (!Em.none(GP.get('router.applicationController.loggedUser')) && Em.isEqual(user.get('id'), GP.get('router.applicationController.loggedUser').get('id'))){
            var message = "You cannot challenge yourself!";
            GP.get('router').get('applicationController').connectOutlet('smallModal', 'smallModal', context);
            $('#smallModal').reveal();
        }else{
            var context = {
                title: 'Do you want to challenge ' + user.get('username') + '?',
                lead: 'If you confirm, he will receive a notification and will confirm the challenge',
                second: '.. if he is not too afraid to accept it',
                imgSrc: 'images/challenge.png',
                actionChallenge: true
            }
            GP.get('router').get('applicationController').connectOutlet('modal', 'modal', context);
            $('#myModal').reveal();
        }

    },

    login: function(){
        $('#incorrectLogin').hide('fast');
        var email = $('#loginEmail').val();
        var password = $('#loginPassword').val();
        var result = GP.dataSource.login(email,password);
        if (result){
            $('#myModal').trigger('reveal:close')
        }else{
           $('#incorrectLogin').show('fast');
        }

    }
});

GP.SmallModalController = Em.Controller.extend();

GP.AvatarController = Em.ArrayController.extend(GP.Clearable,{
});

GP.AchievementController = Em.ArrayController.extend(GP.Clearable,{
    sortProperties: ['id'],

    contentWithIndexes: function(){
        return this.map(function(i, idx) {
            return {item: i, index: idx+1};
        });
    }.property('content.@each')
});

GP.UserController = Em.ArrayController.extend(GP.Clearable,{
    sortProperties: ['score'],
    sortAscending: false,

    init: function(){
        this._super();
        console.log("initializing controller");

    },


    addUser: function(user){
        var exists = this.filterProperty('id', user.get('id'));

        if (Em.empty(exists)){
            this.addObject(user);
        }
    },

    contentWithIndexes: function(){
        return this.map(function(i, idx) {
            return {item: i, index: idx+1};
        });
    }.property('content.@each')

});

GP.LadderController = Em.Controller.extend({

});

GP.ProfileController = Em.Controller.extend({
    user: null
});

GP.ModalLoginController = Em.Controller.extend({

})





/******************************************************/
/*              VIEWS                                 */
/******************************************************/

//main application view
GP.ApplicationView = Ember.View.extend({
    templateName: 'application',
    classNames: ['container']
});

GP.LadderView = Em.View.extend({
    templateName: 'ladder'
});

GP.ProfileView = Em.View.extend({
    templateName: 'profile',
    tagName: 'span'
});

GP.ModalView = Em.View.extend({
    templateName: 'modal'
});

GP.ModalLoginView = Em.View.extend({
    templateName: 'modalLogin'
});

GP.SmallModalView = Em.View.extend({
    templateName: 'smallModal'
});


/******************************************************/
/*              ROUTER                                */
/******************************************************/

GP.Router = Em.Router.extend({
    root: Ember.Route.extend({
        index: Ember.Route.extend({
            route: '/',
            redirectsTo: 'ladder'
        }),
        ladder: Ember.Route.extend({
            route: '/ladder',
            enter: function(router) {
                console.log("entering ladder from", router.get('currentState.name'));
            },
            connectOutlets: function(router){
                router.get('applicationController').connectOutlet('ladder');
            },
            exit: function(router){
                //router.get('applicationController').disconnectOutlet('ladder');
            }
        }),
        profile: Em.Route.extend({
            route: '/profile/:id',
            enter: function(router) {
                console.log("entering ladder from", router.get('currentState.name'));
            },
            connectOutlets: function(router, context){
                console.log("connecting in");
                //console.log(JSON.stringify(context.id));
                router.get('applicationController').connectOutlet('profile');
            },

            /*serialize: function(router, context){
                console.log("serializing...");
                console.log(JSON.stringify(context));
                return{
                    userId: context.get('id')
                }
            },*/
            exit: function(router){
                //router.get('applicationController').disconnectOutlet('profile');
            }
        }),
        /*profile: Em.Route.extend({
            route: '/lastMatches',
            enter: function(router) {
                router.get('applicationController').connectOutlet('profile');
            },
            exit: function(router){
                //router.get('applicationController').disconnectOutlet('profile');
            }
        }),*/
        showLadder: function(router){
            router.transitionTo('ladder');
        },
        showProfile: function(router, event){
            var user = event.context;
            router.get('profileController').set('user',user);
            router.transitionTo('profile', user);
        }
    })
});

/******************************************************/
/*              UTILITY OBJECTS                       */
/******************************************************/

/**
 * Datasource to communicate in the API
 */
GP.dataSource = Ember.Object.create({

    getAllAvatars: function(){
        $.ajax({
            type:'GET',
            url: GP.CONSTANTS.API.BASE_URL + GP.CONSTANTS.API.AVATARS,
            dataType:'json',
            success: function(data){
                if (Em.isArray(data)){
                    data.map(function(item){
                        var avatar = GP.parseAvatar(item);
                        GP.get('router.avatarController').addObject(avatar);
                    })
                }
            }
        });
    },

    getAllUsers: function(){
        $.ajax({
            type:'GET',
            url: GP.CONSTANTS.API.BASE_URL + GP.CONSTANTS.API.USERS,
            dataType:'json',
            success: function(data){
                if (Em.isArray(data)){
                    data.map(function(item){
                        var avatar = GP.parseUser(item);
                        GP.get('router.userController').addObject(avatar);
                    })
                }
            }
        });
    },

    login: function(email, password){
        var result = null;
        var data = {
            email: email,
            password: password
        }

        $.ajax({
            type:'GET',
            async: false,
            url: GP.CONSTANTS.API.BASE_URL + GP.CONSTANTS.API.USER,
            data: data,
            dataType:'json',
            success: function(data){
                if (!Em.none(data)){
                    var user = GP.get('router.userController').findProperty('id',data.id);
                    GP.get('router.applicationController').set('loggedUser', user);
                    result = true;
                }else{
                    result = false;
                }
            }
        });

        return result;
    },

    getAllAchievements: function(){
        $.ajax({
            type:'GET',
            url: GP.CONSTANTS.API.BASE_URL + GP.CONSTANTS.API.ACHIEVEMENTS,
            dataType:'json',
            success: function(data){
                if (Em.isArray(data)){
                    data.map(function(item){
                        var achievement = GP.parseAchievement(item);
                        GP.get('router.achievementController').addObject(achievement);
                    })
                }
            }
        });
    },

    createMatch: function(targetUser){
        var data = {
            "user1Id": 7, //GP.get('router.applicationController.loggedUserId'),
            "user2Id": targetUser.get('id'),
            "date": moment().add('days',3).unix()*1000,
            "statusId": 1
        }
        $.ajax({
            type:'POST',
            url: GP.CONSTANTS.API.BASE_URL + GP.CONSTANTS.API.MATCH,
            data: JSON.stringify(data),
            dataType:'json',
            contentType:'application/json; charset=UTF-8',
            success: function(data){
                debugger;
            }
        })
    }

});

/******************************************************/
/*              UTILITY FUNCTIONS                     */
/******************************************************/
GP.parseAvatar = function(json){
    var avatar = GP.Avatar.create();
    avatar.set('id',json.id);
    avatar.set('url',json.url);
    return avatar;
};

GP.parseUser = function(json){
    var user = GP.User.create();
    user.set('id',json.id);
    user.set('password',json.password);
    user.set('email',json.email);
    user.set('avatar',json.avatar);
    user.set('score',json.score);
    user.set('username',json.userName);
    user.set('rank',json.rank);
    user.set('matches',GP.parseMatches(json.matches));
    return user;
};

GP.parseMatches = function(json){
    var matches = [];

    if (Em.isArray(json)){
        json.map(function(item){
            var match = GP.Match.create();
            match.set('id',item.id);
            match.set('user1Id', item.user1Id);
            match.set('user2Id', item.user2Id);
            match.set('scoreUser1', item.scoreUser1);
            match.set('scoreUser2', item.scoreUser2);
            match.set('date', moment(item.date, "YYYY-MM-DD HH:mm:ss"));
            match.set('status', item.status);
            match.set('statusId', item.statusId);
            matches.push(match);
        });
    }
    return matches;
}

GP.parseAchievement = function(json){
    var achievement = GP.Achievement.create();
    achievement.set('id',json.id);
    achievement.set('title',json.title);
    achievement.set('description',json.description);
    return achievement;
}

GP.initialize();

