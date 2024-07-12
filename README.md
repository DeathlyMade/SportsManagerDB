
# SportsManagerDB

SportsManagerDB is a comprehensive database management system designed to manage information related to sports, players, coaches, teams, and the tournaments they participate in. This system aims to provide an efficient way to store, retrieve, and manage all sports-related data.






## Project Overview

SportsManagerDB is designed to streamline the management of sports data. It supports the organization of players, coaches, teams, and tournaments, making it easier to keep track of all relevant information in a structured manner.



## Features

- Player Management: Store and manage information about players, including their personal details and career statistics like trophies won
- Coach Management: Maintain details about coaches, their teams, and salary.
- Team Management: Maintain details about teams, their sport, the tournaments they play in and their stadium
- Tournament Management: Track tournaments, including participating teams, match schedules, and results.
- Comprehensive Queries: Perform complex queries to retrieve specific information about players, teams, coaches, and tournaments.



## Database Schema

The database schema includes the following main entities:

- Sports: Stores the names of various sports
- Players: Stores player details such as name, age, position, trophies won, etc.
- Coaches: Stores coach details including name, salary, team, etc.
- Teams: Stores team information including team name, sport, coaches, stadium, etc.
- Tournaments: Stores tournament details such as name, sport, etc.
- Games: Stores match details including teams involved, venue, winner and tournament association.
- Team-Tournament: Stores team and the tournament they are playing in 



## Usage
To use SportsManagerDB, follow these steps:

1. Start the application:

- Ensure your database server is running.
- Start the application by running the main script or executable.

2. Perform CRUD Operations:

- Create: Add new players, coaches, teams, and tournaments.
- Read: Retrieve information about players, coaches, teams, and tournaments.
- Update: Modify existing records.
- Delete: Remove records from the database.