

var GPDevHelper = Em.Object.extend({
    userId: null,

    init: function(){
        this.set('userId',999);
     },

    createUsers: function(numUsers){
        for (var i = 1; i < numUsers + 1; i++){
            var newUser = GP.User.create();
            newUser.set('id',this.userId);


            this.set('userId', this.get('userId')+1);
            newUser.set('score', this.get('userId')+ 20);
            newUser.set('username', 'Player' + i);

            GP.get('router.userController').addUser(newUser);

        }
    }
})


