CREATE TABLE status (
	id		INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
	description	TEXT
);

INSERT INTO status (description) VALUES ("Created");
INSERT INTO status (description) VALUES ("Accepted");
INSERT INTO status (description) VALUES ("Refused");
INSERT INTO status (description) VALUES ("Confirmed by user 1");
INSERT INTO status (description) VALUES ("Confirmed by user 2");
INSERT INTO status (description) VALUES ("Finished");


CREATE TABLE achievement (
	id		INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
	title		TEXT,
	description	TEXT
);

INSERT INTO achievement (title, description) VALUES ("First blood", "You have just finished your first game, welcome in club.");
INSERT INTO achievement (title, description) VALUES ("3 to 0", "wow, we got a badass over here! This match was like execution!");
INSERT INTO achievement (title, description) VALUES ("2 in a row", "Nice, you have just won 2nd game in a row, keep going like that!");


CREATE TABLE user (
	id		INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
	email		TEXT,
	password	TEXT,
	user_name	TEXT,
	avatar		TEXT,
	score		INTEGER
);


CREATE TABLE user_achievement (
	id		INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
	user_id		INTEGER NOT NULL,
	achievement_id	INTEGER NOT NULL,
	FOREIGN KEY (user_id)		REFERENCES user(id),
	FOREIGN KEY (achievement_id)    REFERENCES achievement(id)
);


CREATE TABLE game (
        id              INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
        user1	        INTEGER NOT NULL,
        user2           INTEGER NOT NULL,
        score_user1	INTEGER,
        score_user2    	INTEGER,
        game_date	TEXT,
        status_id       INTEGER(8) NOT NULL,
	FOREIGN KEY (user1)           REFERENCES user(id),
	FOREIGN KEY (user2)           REFERENCES user(id),
	FOREIGN KEY (status_id)       REFERENCES status(id)
);
