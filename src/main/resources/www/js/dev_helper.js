var avatarUrls =
    [
        'images/avatars/assassin_avatar.png',
        'images/avatars/commissar_avatar.png',
        'images/avatars/dad_avatar.png',
        'images/avatars/designer_avatar.png',
        'images/avatars/diver_avatar.png',
        'images/avatars/engineer_avatar.png',
        'images/avatars/fireman_avatar.png',
        'images/avatars/mom_avatar.png',
        'images/avatars/nurse_avatar.png',
        'images/avatars/witch_avatar.png'


    ]

var GPDevHelper = Em.Object.extend({
    userId: null,

    init: function(){
        this.set('userId',999);
     },

    createUsers: function(numUsers){
        for (var i = 1; i < numUsers + 1; i++){
            var newUser = GP.User.create();
            newUser.set('id',this.userId);
            newUser.set('score', this.get('userId')+ 20);
            newUser.set('username', 'Player' + i);
            newUser.set('avatar_url', avatarUrls[i]);

            this.set('userId', this.get('userId')+1);
            GP.get('router.userController').addUser(newUser);

        }
    }
})


