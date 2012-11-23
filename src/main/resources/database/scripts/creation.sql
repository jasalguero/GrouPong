CREATE TABLE status (
	id	INTEGER PRIMARY KEY,
	description	TEXT
);


CREATE TABLE achievement (
	id		INTEGER PRIMARY KEY,
	title		TEXT,
	description	TEXT
);


CREATE TABLE user (
	id		INTEGER PRIMARY KEY,
	email		TEXT,
	password	TEXT,
	user_name	TEXT,
	avatar		TEXT,
	score		INTEGER
);


CREATE TABLE user_achievement (
	id		INTEGER PRIMARY KEY,
	user_id		INTEGER,
	achievement_id	INTEGER
);


CREATE TABLE game (
        id              INTEGER PRIMARY KEY,
        user1	        INTEGER,
        user2           INTEGER,
        score_user1	INTEGER,
        score_user2    	INTEGER,
        game_date	DATE,
        status_id       INTEGER
);



