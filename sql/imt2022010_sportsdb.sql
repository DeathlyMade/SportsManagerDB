CREATE TABLE sport (sport_id INT CHECK(sport_id>0), sport_name VARCHAR(30), CONSTRAINT pk_sport PRIMARY KEY (sport_id));

CREATE TABLE team (team_id INT CHECK(team_id>0), team_name VARCHAR(30), sport_id INT, stadium VARCHAR(30), 
                    CONSTRAINT pk_team PRIMARY KEY (team_id), 
                    CONSTRAINT fk_team_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE);

CREATE TABLE tournament (tournament_id INT CHECK(tournament_id>0), tournament_name VARCHAR(30), sport_id INT,
                            CONSTRAINT pk_tournament PRIMARY KEY (tournament_id),
                            CONSTRAINT fk_tournament_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE);

CREATE TABLE coach (coach_id INT CHECK(coach_id>0), fname VARCHAR(30), minit CHAR(1), lname VARCHAR(30), salary INT, sport_id INT, team_id INT UNIQUE,
                        CONSTRAINT fk_coach_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE,
                        CONSTRAINT pk_coach PRIMARY KEY (coach_id),
                        CONSTRAINT fk_coach_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE SET NULL);

CREATE TABLE player (player_id INT CHECK(player_id>0), fname VARCHAR(30), minit CHAR(1), lname VARCHAR(30), bdate DATE, sex CHAR(1), sport_id INT, 
                        position VARCHAR(30), team_id INT, trophies_won INT, coach_id INT DEFAULT NULL,
                        CONSTRAINT fk_player_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE,
                        CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE SET NULL,
                        CONSTRAINT fk_player_coach FOREIGN KEY(coach_id) REFERENCES coach(coach_id) ON DELETE SET NULL,
                        CONSTRAINT pk_player PRIMARY KEY (player_id));

CREATE TABLE game (match_id INT CHECK(match_id>0), team1_id INT, team2_id INT, date DATE, tournament_id INT, venue VARCHAR(30), winner_id INT,
                        CONSTRAINT pk_match PRIMARY KEY (match_id),
                        CONSTRAINT fk_match_team1 FOREIGN KEY (team1_id) REFERENCES team(team_id) ON DELETE CASCADE,
                        CONSTRAINT fk_match_team2 FOREIGN KEY (team2_id) REFERENCES team(team_id) ON DELETE CASCADE,
                        CONSTRAINT fk_match_tournament FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id) ON DELETE CASCADE,
                        CONSTRAINT fk_match_winner FOREIGN KEY (winner_id) REFERENCES team(team_id) ON DELETE CASCADE);

CREATE TABLE team_tournament (team_id INT CHECK(team_id>0), tournament_id INT CHECK(tournament_id>0),
                                CONSTRAINT pk_team_tournament PRIMARY KEY (team_id, tournament_id),
                                CONSTRAINT fk_team_tournament_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE,
                                CONSTRAINT fk_team_tournament_tournament FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id) ON DELETE CASCADE);

INSERT INTO sport VALUES(1, 'Cricket');
INSERT INTO sport VALUES(2, 'Football');
INSERT INTO sport VALUES(3, 'Basketball');
INSERT INTO team VALUES(1, 'India', 1, 'Wankhede');
INSERT INTO team VALUES(2, 'Australia', 1, 'MCG');
INSERT INTO team VALUES(3, 'Barcelona', 2, 'Camp Nou');
INSERT INTO team VALUES(4, 'Real Madrid', 2, 'Santiago Bernabeu');
INSERT INTO team VALUES(5, 'LA Lakers', 3, 'Staples Center');
INSERT INTO team VALUES(6, 'Golden State Warriors', 3, 'Chase Center');
INSERT INTO tournament VALUES(1, 'IPL', 1);
INSERT INTO tournament VALUES(2, 'World Cup', 1);
INSERT INTO tournament VALUES(3, 'La Liga', 2);
INSERT INTO tournament VALUES(4, 'Champions League', 2);
INSERT INTO tournament VALUES(5, 'NBA', 3);
INSERT INTO tournament VALUES(6, 'NCAA', 3);
INSERT INTO coach VALUES(1, 'Ravi', 'S', 'Shastri', 1000000, 1, 1);
INSERT INTO coach VALUES(2, 'Justin', NULL, 'Langer', 900000, 1, 2);
INSERT INTO coach VALUES(3, 'Ronald', NULL, 'Koeman', 800000, 2, 3);
INSERT INTO coach VALUES(4, 'Zinedine', NULL, 'Zidane', 850000, 2, 4);
INSERT INTO coach VALUES(5, 'Frank', NULL, 'Vogel', 700000, 3, 5);
INSERT INTO player VALUES(1, 'Virat', 'K', 'Kohli', '1988-11-05', 'M', 1, 'Batsman', 1, 5, 1);
INSERT INTO player VALUES(2, 'Rohit', NULL, 'Sharma', '1987-04-30', 'M', 1, 'Batsman', 1, 7, 1);
INSERT INTO player VALUES(3, 'David', NULL, 'Warner', '1986-10-27', 'M', 1, 'Batsman', 2, 3, 2);
INSERT INTO player VALUES(4, 'Lionel', NULL, 'Messi', '1987-06-24', 'M', 2, 'Forward', 3, 6, 3);
INSERT INTO player VALUES(5, 'Cristiano', NULL, 'Ronaldo', '1985-02-05', 'M', 2, 'Forward', 4, 7, 4);
INSERT INTO player VALUES(6, 'Lebron', NULL, 'James', '1984-12-30', 'M', 3, 'Forward', 5, 4, 5);
INSERT INTO player VALUES(7, 'Stephen', NULL, 'Curry', '1988-03-14', 'M', 3, 'Guard', 6, 3, NULL);
INSERT INTO game VALUES(1, 1, 2, '2021-12-25', 2, 'MCG', 1);
INSERT INTO game VALUES(2, 3, 4, '2021-12-25', 4, 'Santiago Bernabeu', 4);
INSERT INTO game VALUES(3, 5, 6, '2021-12-25', 6, 'Staples Center', 5);

