INSERT INTO user (email, password, user_name, avatar, score) VALUES ("user1@email.com", "pass1", "user 1", "http://goo.gl/5kLrP", 1000);
INSERT INTO user (email, password, user_name, avatar, score) VALUES ("user2@email.com", "pass2", "user 2", "http://goo.gl/5kLrP", 2000);
INSERT INTO user (email, password, user_name, avatar, score) VALUES ("user3@email.com", "pass3", "user 3", "http://goo.gl/5kLrP", 500);

INSERT INTO user_achievement (user_id, achievement_id) VALUES (1, 1);
INSERT INTO user_achievement (user_id, achievement_id) VALUES (1, 2);
INSERT INTO user_achievement (user_id, achievement_id) VALUES (1, 3);
INSERT INTO user_achievement (user_id, achievement_id) VALUES (2, 1);


INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (1, 2, 0, 3, '1353765246620', 1);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (2, 3, 1, 2, '1353765246620', 2);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (3, 1, 0, 3, '1353765246620', 3);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (3, 2, 1, 2, '1353765246620', 4);
INSERT INTO game (user1, user2, score_user1, score_user2, game_date, status_id) VALUES (1, 3, 0, 3, '1353765246620', 5);

