

var GPDevHelper = Em.Object.extend({
    userId: null,

    init: function(){
        this.set('userId',999);
     },

    createUsers: function(numUsers){
        for (var i = 0; i < numUsers; i++){
            var newUser = GP.User.create();
            newUser.set('id',this.userId);
            GP.get('router.userController').addUser(newUser);

            this.userId = this.userId+1;

        }
    }
})


