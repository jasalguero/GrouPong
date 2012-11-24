INSERT INTO user (email, password, user_name, avatar, score) VALUES ("zbigniew@groupon.com", "rollback", "Zbigniew Zabost", "/images/avatars/diver_avatar.png", 1700);
INSERT INTO user (email, password, user_name, avatar, score) VALUES ("bart@groupon.com", "rollback", "Bart B. aka Bobby", "/images/avatars/dad_avatar.png", 2000);
INSERT INTO user (email, password, user_name, avatar, score) VALUES ("jose@groupon.com", "rollback", "Jose A. Salguero", "/images/avatars/assassin_avatar.png", 1200);
INSERT INTO user (email, password, user_name, avatar, score) VALUES ("guest@groupon.com", "rollback", "Santa Claus", "/images/avatars/designer_avatar.png", 1000);


INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (1, 2, 2, 1, '1353765246620', 6);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (3, 1, 1, 2, '1353765247620', 6);

INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (2, 3, 3, 0, '1353765248620', 6);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (3, 2, 2, 1, '1353765249620', 6);

INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (1, 2, 1, 2, '1353765251620', 1);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (1, 3, 1, 2, '1353765251620', 2);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (2, 3, 1, 2, '1353765251620', 3);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (2, 1, 3, 0, '1353765251620', 5);


INSERT INTO user_achievement (user_id, achievement_id) VALUES (1, 1);
INSERT INTO user_achievement (user_id, achievement_id) VALUES (1, 3);

INSERT INTO user_achievement (user_id, achievement_id) VALUES (2, 1);
INSERT INTO user_achievement (user_id, achievement_id) VALUES (2, 2);

INSERT INTO user_achievement (user_id, achievement_id) VALUES (3, 1);


