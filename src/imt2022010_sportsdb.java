//STEP 1. Import required packages
import java.util.*;
import java.sql.*;
import java.sql.Date;

public class imt2022010_sportsdb {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/sportsdb";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "Qwerty12%";// add password

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;

      // String createSport = "CREATE TABLE sport (" +
      //          "sport_id INT, " +
      //          "sport_name VARCHAR(30), " +
      //          "CONSTRAINT pk_sport PRIMARY KEY (sport_id)" +
      //          ")";
      // String createTeam = "CREATE TABLE team (" +
      //          "team_id INT, " +
      //          "team_name VARCHAR(30), " +
      //          "sport_id INT, " +
      //          "stadium VARCHAR(30)," +
      //          "CONSTRAINT pk_team PRIMARY KEY (team_id), " +
      //          "CONSTRAINT fk_team_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE" +
      //          ")";
      // String createTournament = "CREATE TABLE tournament (" +
      //          "tournament_id INT, " +
      //          "tournament_name VARCHAR(30), " +
      //          "sport_id INT, " +
      //          "CONSTRAINT pk_tournament PRIMARY KEY (tournament_id), " +
      //          "CONSTRAINT fk_tournament_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE" +
      //          ")";
      // String createPlayer = "CREATE TABLE player (" +
      //          "player_id INT, " +
      //          "fname VARCHAR(30), " +
      //          "minit CHAR(1), " +
      //          "lname VARCHAR(30), " +
      //          "bdate DATE, " +
      //          "sex CHAR(1), " +
      //          "sport_id INT," +
      //          "position VARCHAR(30)," +
      //          "team_id INT," +
      //          "trophies_won INT," +
      //          "CONSTRAINT fk_player_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE," +
      //          "CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE SET NULL," +
      //          "CONSTRAINT pk_player PRIMARY KEY (player_id) " +
      //          ")";
      // String createCoach = "CREATE TABLE coach (" +
      //          "coach_id INT, " +
      //          "fname VARCHAR(30), " +
      //          "minit CHAR(1), " +
      //          "lname VARCHAR(30), " +
      //          "salary INT," +
      //          "sport_id INT," +
      //          "team_id INT UNIQUE," +
      //          "CONSTRAINT fk_coach_sport FOREIGN KEY (sport_id) REFERENCES sport(sport_id) ON DELETE CASCADE," +
      //          "CONSTRAINT pk_coach PRIMARY KEY (coach_id), " +
      //          "CONSTRAINT fk_coach_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE SET NULL" +
      //         ")";
      // String createGame = "CREATE TABLE game (" +
      //          "match_id INT, " +
      //          "team1_id INT, " +
      //          "team2_id INT, " +
      //          "date DATE, " +
      //          "tournament_id INT, " +
      //          "venue VARCHAR(30), " +
      //          "winner_id INT, " +
      //          "CONSTRAINT pk_match PRIMARY KEY (match_id), " +
      //          "CONSTRAINT fk_match_team1 FOREIGN KEY (team1_id) REFERENCES team(team_id) ON DELETE CASCADE, " +
      //          "CONSTRAINT fk_match_team2 FOREIGN KEY (team2_id) REFERENCES team(team_id) ON DELETE CASCADE, " +
      //          "CONSTRAINT fk_match_tournament FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id) ON DELETE CASCADE, " +
      //          "CONSTRAINT fk_match_winner FOREIGN KEY (winner_id) REFERENCES team(team_id) ON DELETE CASCADE" +
      //          ")";
      // String createTeamTournament = "CREATE TABLE team_tournament (" +
      //          "team_id INT, " +
      //          "tournament_id INT, " +
      //          "CONSTRAINT pk_team_tournament PRIMARY KEY (team_id, tournament_id), " +
      //          "CONSTRAINT fk_team_tournament_team FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE, " +
      //          "CONSTRAINT fk_team_tournament_tournament FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id) ON DELETE CASCADE" +
      //          ")";
      // STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         //INSERT, UPDATE, DELETE
         // stmt.executeUpdate(createSport);
         // stmt.executeUpdate(createTeam);
         // stmt.executeUpdate(createTournament);
         // stmt.executeUpdate(createPlayer);
         // stmt.executeUpdate(createCoach);
         // stmt.executeUpdate(createGame);
         // stmt.executeUpdate(createTeamTournament);
         Scanner sc=new Scanner(System.in);
         try {
            conn.setAutoCommit(false);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         while(true){
            System.out.println("\n********* Menu *********");
            System.out.println("1. Add a Sport to the database");
            System.out.println("2. Add a Team to the database");
            System.out.println("3. Add a Tournament to the database");
            System.out.println("4. Add a Player to the database");
            System.out.println("5. Add a Coach to the database");
            System.out.println("6. Add a Game to the database");
            System.out.println("7. Enroll a team in a tournament");
            System.out.println("8. Display all sports");
            System.out.println("9. Display all players");
            System.out.println("10. Display all coaches");
            System.out.println("11. Display all teams");
            System.out.println("12. Display all tournaments");
            System.out.println("13. Display all games");
            System.out.println("14. Delete a Sport from the database");
            System.out.println("15. Delete a Player from the database");
            System.out.println("16. Delete a Coach from the database");
            System.out.println("17. Delete a Team from the database");
            System.out.println("18. Delete a Tournament from the database");
            System.out.println("19. Delete a Game from the database");
            System.out.println("20. Update a Sport in the database");
            System.out.println("21. Update a Player in the database");
            System.out.println("22. Update a Coach in the database");
            System.out.println("23. Update a Team in the database");
            System.out.println("24. Update a Tournament in the database");
            System.out.println("25. Update a Game in the database");
            System.out.println("26. Remove a team from a tournament");
            System.out.println("27. Display details of a player");
            System.out.println("28. Display details of a coach");
            System.out.println("29. Display details of a game");
            System.out.println("30. Display all players in a team");
            System.out.println("31. Display the coach of a team");
            System.out.println("32. Display all games in a tournament");
            System.out.println("33. Display all tournaments a team is enrolled in");
            System.out.println("34. Display all teams enrolled in a tournament");
            System.out.println("35. Best Male Player in a sport");
            System.out.println("36. Best Female Player in a sport");
            System.out.println("37. Display the team of a Player");
            System.out.println("38. Display all games of a team in a tournament");
            System.out.println("39. Display all games on a particular date");
            System.out.println("40. Display the most paid coach in a sport");
            System.out.println("41. Commit the Changes");
            System.out.println("42. Rollback the Changes");
            System.out.println("43. Exit");
            System.out.println("************************");
            System.out.println();
            System.out.println("Enter your option: ");
            int op=sc.nextInt();
            if(op==1)
            {
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               sc.nextLine();
               System.out.print("Sport Name: ");
               String sn=sc.nextLine();
               String insertSport = "INSERT INTO sport VALUES (" + sid + ", '" + sn + "')";
               stmt.executeUpdate(insertSport);
            }
            else if(op==2)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               sc.nextLine();
               System.out.print("Team Name: ");
               String tn=sc.nextLine();
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               sc.nextLine();
               System.out.print("Stadium: ");
               String st=sc.nextLine();
               String insertTeam = "INSERT INTO team VALUES (" + tid + ", '" + tn + "', " + sid + ", '" + st + "')";
               stmt.executeUpdate(insertTeam);
            }
            else if(op==3)
            {
               System.out.print("Tournament ID: ");
               int tid=sc.nextInt();
               sc.nextLine();
               System.out.print("Tournament Name: ");
               String tn=sc.nextLine();
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String insertTournament = "INSERT INTO tournament VALUES (" + tid + ", '" + tn + "', " + sid + ")";
               stmt.executeUpdate(insertTournament);
            }
            else if(op==4)
            {
               try{
               //INSERT, UPDATE, DELETE
               //stmt.executeUpdate(createSport);
               //stmt.executeUpdate(createPlayer);
               //stmt.executeUpdate(createCoach);
               System.out.print("Player ID: ");
               int pid=sc.nextInt();
               System.out.print("First Name: ");
               String fn=sc.next();
               System.out.print("Middle Initial: ");
               String mn=sc.next();
               System.out.print("Last Name: ");
               String ln=sc.next();
               System.out.print("Birth Date (YYYY-MM-DD): ");
               String bd=sc.next();
               System.out.print("Sex: ");
               String sx=sc.next();
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               System.out.print("Position: ");
               String pos=sc.next();
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               System.out.println("Number of Trophies Won: ");
               int tw=sc.nextInt();
               String insertPlayer = "INSERT INTO player VALUES (" + pid + ", '" + fn + "', '" + mn + "', '" + ln + "', '" + bd + "', '" + sx + "', " + sid + ", '" + pos + "', " + tid + ", " + tw + ", NULL)";
               stmt.executeUpdate(insertPlayer);

               System.out.print("Enter the Coach ID of the player: ");
               int cid2=sc.nextInt();
               String updatePlayer = "UPDATE player SET player.coach_id = " + cid2 + " WHERE player.team_id = " + tid;
               stmt.executeUpdate(updatePlayer);
               }catch(SQLException se3){
                  System.out.println("Rolling back data here....");
                  try{
                     if(conn!=null)
                        conn.rollback(); //--------------------------------------------------------------------------------> rollback
                  }catch(SQLException se4){
                     System.out.println("Rollback failed....");
                        se4.printStackTrace();
                  }
               }
            }
            else if(op==5)
            {
               try{
               //INSERT, UPDATE, DELETE
               //stmt.executeUpdate(createSport);
               //stmt.executeUpdate(createPlayer);
               //stmt.executeUpdate(createCoach);
               System.out.print("Coach ID: ");
               int cid=sc.nextInt();
               System.out.print("First Name: ");
               String fn=sc.next();
               System.out.print("Middle Initial: ");
               String mn=sc.next();
               System.out.print("Last Name: ");
               String ln=sc.next();
               System.out.print("Salary: ");
               int sal=sc.nextInt();
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String insertCoach = "INSERT INTO coach VALUES (" + cid + ", '" + fn + "', '" + mn + "', '" + ln + "', " + sal + ", " + sid + ", NULL)";
               stmt.executeUpdate(insertCoach);
               System.out.print("Enter the Team ID of the coach: ");
               int tid=sc.nextInt();
               String updateCoach = "UPDATE coach SET team_id = " + tid + " WHERE coach_id = " + cid;
               stmt.executeUpdate(updateCoach);
               String updatePlayer = "UPDATE player SET player.coach_id = " + cid + " WHERE player.team_id = " + tid;
               stmt.executeUpdate(updatePlayer);
               }catch(SQLException se3){
                  se3.printStackTrace();
                  System.out.println("Rolling back data here....");
                  try{
                     if(conn!=null)
                        conn.rollback(); //--------------------------------------------------------------------------------> rollback
                  }catch(SQLException se4){
                     System.out.println("Rollback failed....");
                        se4.printStackTrace();
                  }
               }
            }
            else if(op==6)
            {
               System.out.print("Match ID: ");
               int mid=sc.nextInt();
               System.out.print("Team1 ID: ");
               int t1id=sc.nextInt();
               System.out.print("Team2 ID: ");
               int t2id=sc.nextInt();
               System.out.print("Match Date(YYYY-MM-DD): ");
               String dt=sc.next();
               System.out.print("Tournament ID: ");
               int tid=sc.nextInt();
               sc.nextLine();
               System.out.print("Venue: ");
               String vn=sc.nextLine();
               System.out.print("Team ID of Winning Team: ");
               int wid=sc.nextInt();
               String insertGame = "INSERT INTO game VALUES (" + mid + ", " + t1id + ", " + t2id + ", '" + dt + "', " + tid + ", '" + vn + "', " + wid + ")";
               stmt.executeUpdate(insertGame);
            }
            else if(op==7)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               System.out.print("Tournament ID: ");
               int toid=sc.nextInt();
               String insertTeamTournament = "INSERT INTO team_tournament VALUES (" + tid + ", " + toid + ")";
               stmt.executeUpdate(insertTeamTournament);
            }
            else if(op==8)
            {
               //STEP 3: Query to database
               String query = "SELECT sport_id, sport_name FROM sport";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer sport_id = rs.getInt("sport_id");
               String sport_name = rs.getString("sport_name");

               // Display values
               System.out.print("Sport ID: " + sport_id);
               System.out.println(", Sport Name: " + sport_name);
               }
               rs.close();
            }
            else if(op==9)
            {
               //STEP 3: Query to database
               String query = "SELECT player_id, fname, minit, lname, bdate, sex, player.sport_id, sport_name, position, player.team_id, team_name, trophies_won, player.coach_id FROM player INNER JOIN (team INNER JOIN sport ON team.sport_id = sport.sport_id) ON player.team_id = team.team_id";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer player_id = rs.getInt("player_id");
               String fname = rs.getString("fname");
               String minit = rs.getString("minit");
               String lname = rs.getString("lname");
               Date birthDate = rs.getDate("bdate", null);
               String sex = rs.getString("sex");
               Integer sport_id = rs.getInt("sport_id");
               String sport_name = rs.getString("sport_name");
               String position = rs.getString("position");
               Integer team_id = rs.getInt("team_id");
               String team_name = rs.getString("team_name");
               Integer trophies_won = rs.getInt("trophies_won");
               Integer coach_id = rs.getInt("coach_id");
               // Display values
               System.out.print("Player ID: " + player_id);
               System.out.print(", First Name: " + fname);
               System.out.print(", Middle Initial: " + minit);
               System.out.print(", Last Name: " + lname);
               System.out.print(", Birth Date: " + birthDate.toString());
               System.out.print(", Sex: " + sex);
               System.out.print(", Sport ID: " + sport_id);
               System.out.print(", Sport Name: " + sport_name);
               System.out.print(", Position: " + position);
               System.out.print(", Team ID: " + team_id);
               System.out.print(", Team Name: " + team_name);
               System.out.print(", Number of Trophies Won: " + trophies_won);
               System.out.println(", Coach ID: " + coach_id);
               }
               rs.close();
            }
            else if(op==10)
            {
               //STEP 3: Query to database
               String query = "SELECT coach_id, fname, minit, lname, salary, coach.sport_id, sport_name, coach.team_id, team_name FROM coach INNER JOIN (sport INNER JOIN team ON team.sport_id = sport.sport_id) ON coach.team_id = team.team_id";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer coach_id = rs.getInt("coach_id");
               String fname = rs.getString("fname");
               String minit = rs.getString("minit");
               String lname = rs.getString("lname");
               Integer salary = rs.getInt("salary");
               Integer sport_id = rs.getInt("sport_id");
               String sport_name = rs.getString("sport_name");
               Integer team_id = rs.getInt("team_id");
               String team_name = rs.getString("team_name");

               // Display values
               System.out.print("Coach ID: " + coach_id);
               System.out.print(", First Name: " + fname);
               System.out.print(", Middle Initial: " + minit);
               System.out.print(", Last Name: " + lname);
               System.out.print(", Salary: " + salary);
               System.out.print(", Sport ID: " + sport_id);
               System.out.print(", Sport Name: " + sport_name);
               System.out.print(", Team ID: " + team_id);
               System.out.println(", Team Name: " + team_name);
               }
               rs.close();
            }
            else if(op==11)
            {
               //STEP 3: Query to database
               String query = "SELECT team_id, team_name, team.sport_id, sport_name, stadium FROM team INNER JOIN sport ON team.sport_id = sport.sport_id";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer team_id = rs.getInt("team_id");
               String team_name = rs.getString("team_name");
               Integer sport_id = rs.getInt("sport_id");
               String stadium = rs.getString("stadium");
               String sport_name = rs.getString("sport_name");

               // Display values
               System.out.print("Team ID: " + team_id);
               System.out.print(", Team Name: " + team_name);
               System.out.print(", Sport ID: " + sport_id);
               System.out.print(", Sport Name: " + sport_name);
               System.out.println(", Stadium: " + stadium);
               }
               rs.close();
            }
            else if(op==12)
            {
               //STEP 3: Query to database
               String query = "SELECT tournament_id, tournament_name, tournament.sport_id, sport_name FROM tournament INNER JOIN sport ON tournament.sport_id = sport.sport_id";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer tournament_id = rs.getInt("tournament_id");
               String tournament_name = rs.getString("tournament_name");
               Integer sport_id = rs.getInt("sport_id");
               String sport_name = rs.getString("sport_name");

               // Display values
               System.out.print("Tournament ID: " + tournament_id);
               System.out.print(", Tournament Name: " + tournament_name);
               System.out.print(", Sport ID: " + sport_id);
               System.out.println(", Sport Name: " + sport_name);
               }
               rs.close();
            }
            else if(op==13)
            {
               //STEP 3: Query to database
               String query = "SELECT match_id, team1_id, team2_id, date, tournament_id, venue, winner_id FROM game";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

               // Retrieve by column name
               Integer match_id = rs.getInt("match_id");
               Integer team1_id = rs.getInt("team1_id");
               Integer team2_id = rs.getInt("team2_id");
               Date date = rs.getDate("date", null);
               Integer tournament_id = rs.getInt("tournament_id");
               String venue = rs.getString("venue");
               Integer winner_id = rs.getInt("winner_id");

               // Display values
               System.out.print("Match ID: " + match_id);
               System.out.print(", Team1 ID: " + team1_id);
               System.out.print(", Team2 ID: " + team2_id);
               System.out.print(", Match Date: " + date.toString());
               System.out.print(", Tournament ID: " + tournament_id);
               System.out.print(", Venue: " + venue);
               System.out.println(", Team ID of the Winning Team: " + winner_id);
               }
               rs.close();
            }
            else if(op==14)
            {
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String deleteSport = "DELETE FROM sport WHERE sport_id = " + sid;
               stmt.executeUpdate(deleteSport);
            }
            else if(op==15)
            {
               System.out.print("Player ID: ");
               int pid=sc.nextInt();
               String deletePlayer = "DELETE FROM player WHERE player_id = " + pid;
               stmt.executeUpdate(deletePlayer);
            }
            else if(op==16)
            {
               System.out.print("Coach ID: ");
               int cid=sc.nextInt();
               String deleteCoach = "DELETE FROM coach WHERE coach_id = " + cid;
               stmt.executeUpdate(deleteCoach);
            }
            else if(op==17)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               String deleteTeam = "DELETE FROM team WHERE team_id = " + tid;
               stmt.executeUpdate(deleteTeam);
            }
            else if(op==18)
            {
               System.out.print("Tournament ID: ");
               int tid=sc.nextInt();
               String deleteTournament = "DELETE FROM tournament WHERE tournament_id = " + tid;
               stmt.executeUpdate(deleteTournament);
            }
            else if(op==19)
            {
               System.out.print("Match ID: ");
               int mid=sc.nextInt();
               String deleteGame = "DELETE FROM game WHERE match_id = " + mid;
               stmt.executeUpdate(deleteGame);
            }
            else if(op==20)
            {
               System.out.print("Enter the Sport ID of the sport you want to update: ");
               int sid=sc.nextInt();
               System.out.print(", Sport Name: ");
               String sn=sc.next();
               String updateSport = "UPDATE sport SET sport_name = '" + sn + "' WHERE sport_id = " + sid;
               stmt.executeUpdate(updateSport);
            }
            else if(op==21)
            {
               System.out.println("Enter the Player ID of the player you want to update: ");
               int pid=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the fields you want to update (separated by space): ");
               System.out.println("(fname(First Name), minit(Middle Initial), lname(Last Name), bdate(Birth Date), sex(Sex), sport_id(Sport ID), position(Position), team_id(Team ID), trophies_won(Number of Trophies Won))");
               String f=sc.nextLine();
               String[] fields=f.split(" ");
               for(int i=0;i<fields.length;i++)
               {
                  fields[i]=fields[i].trim();
                  String data_type="SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'player' AND COLUMN_NAME = '" + fields[i] + "'";
                  System.out.println("Enter the new value for " + fields[i] + ": ");
                  if(data_type.equals("INT"))
                  {
                     int val=sc.nextInt();
                     String updatePlayer = "UPDATE player SET " + fields[i] + " = " + val + " WHERE player_id = " + pid;
                     stmt.executeUpdate(updatePlayer);
                  }
                  else
                  {
                     String val=sc.nextLine();
                     String updatePlayer = "UPDATE player SET " + fields[i] + " = '" + val + "' WHERE player_id = " + pid;
                     stmt.executeUpdate(updatePlayer);
                  }
               }
            }
            else if(op==22)
            {
               System.out.println("Enter the Coach ID of the coach you want to update: ");
               int cid=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the fields you want to update (separated by space): ");
               System.out.println("(fname(First Name), minit(Middle Initial), lname(Last Name), salary(Salary), sport_id(Sport ID), team_id(Team ID))");
               String f=sc.nextLine();
               String[] fields=f.split(" ");
               for(int i=0;i<fields.length;i++)
               {
                  fields[i]=fields[i].trim();
                  String data_type="SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'coach' AND COLUMN_NAME = '" + fields[i] + "'";
                  System.out.println("Enter the new value for " + fields[i] + ": ");
                  if(data_type.equals("INT"))
                  {
                     int val=sc.nextInt();
                     String updateCoach = "UPDATE coach SET " + fields[i] + " = " + val + " WHERE coach_id = " + cid;
                     stmt.executeUpdate(updateCoach);
                  }
                  else
                  {
                     String val=sc.nextLine();
                     String updateCoach = "UPDATE coach SET " + fields[i] + " = '" + val + "' WHERE coach_id = " + cid;
                     stmt.executeUpdate(updateCoach);
                  }
               }
            }
            else if(op==23)
            {
               System.out.println("Enter the Team ID of the team you want to update: ");
               int tid=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the fields you want to update (separated by space): ");
               System.out.println("(team_name(Team Name), sport_id(Sport ID), stadium(Stadium))");
               String f=sc.nextLine();
               String[] fields=f.split(" ");
               for(int i=0;i<fields.length;i++)
               {
                  fields[i]=fields[i].trim();
                  String data_type="SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'team' AND COLUMN_NAME = '" + fields[i] + "'";
                  System.out.println("Enter the new value for " + fields[i] + ": ");
                  if(data_type.equals("INT"))
                  {
                     int val=sc.nextInt();
                     String updateTeam = "UPDATE team SET " + fields[i] + " = " + val + " WHERE team_id = " + tid;
                     stmt.executeUpdate(updateTeam);
                  }
                  else
                  {
                     String val=sc.nextLine();
                     String updateTeam = "UPDATE team SET " + fields[i] + " = '" + val + "' WHERE team_id = " + tid;
                     stmt.executeUpdate(updateTeam);
                  }
               }
            }
            else if(op==24)
            {
               System.out.println("Enter the Tournament ID of the tournament you want to update: ");
               int tid=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the fields you want to update (separated by space): ");
               System.out.println("(tournament_name(Tournament Name), sport_id(Sport ID))");
               String f=sc.nextLine();
               String[] fields=f.split(" ");
               for(int i=0;i<fields.length;i++)
               {
                  fields[i]=fields[i].trim();
                  String data_type="SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'tournament' AND COLUMN_NAME = '" + fields[i] + "'";
                  System.out.println("Enter the new value for " + fields[i] + ": ");
                  if(data_type.equals("INT"))
                  {
                     int val=sc.nextInt();
                     String updateTournament = "UPDATE tournament SET " + fields[i] + " = " + val + " WHERE tournament_id = " + tid;
                     stmt.executeUpdate(updateTournament);
                  }
                  else
                  {
                     String val=sc.nextLine();
                     String updateTournament = "UPDATE tournament SET " + fields[i] + " = '" + val + "' WHERE tournament_id = " + tid;
                     stmt.executeUpdate(updateTournament);
                  }
               }
            }
            else if(op==25)
            {
               System.out.println("Enter the Match ID of the game you want to update: ");
               int mid=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the fields you want to update (separated by space): ");
               System.out.println("(team1_id(Team1 ID), team2_id(Team2 ID), date(Match Date), tournament_id(Tournament ID), venue(Venue), winner_id(Team ID of the Winning Team))");
               String f=sc.nextLine();
               String[] fields=f.split(" ");
               for(int i=0;i<fields.length;i++)
               {
                  fields[i]=fields[i].trim();
                  String data_type="SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'game' AND COLUMN_NAME = '" + fields[i] + "'";
                  System.out.println("Enter the new value for " + fields[i] + ": ");
                  if(data_type.equals("INT"))
                  {
                     int val=sc.nextInt();
                     String updateGame = "UPDATE game SET " + fields[i] + " = " + val + " WHERE match_id = " + mid;
                     stmt.executeUpdate(updateGame);
                  }
                  else
                  {
                     String val=sc.nextLine();
                     String updateGame = "UPDATE game SET " + fields[i] + " = '" + val + "' WHERE match_id = " + mid;
                     stmt.executeUpdate(updateGame);
                  }
               }
            }
            else if(op==26)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               System.out.print("Tournament ID: ");
               int toid=sc.nextInt();
               String deleteTeamTournament = "DELETE FROM team_tournament WHERE team_id = " + tid + " AND tournament_id = " + toid;
               stmt.executeUpdate(deleteTeamTournament);
            }
            else if(op==27)
            {
               System.out.print("Enter the Player ID: ");
               int pid=sc.nextInt();
               String query = "SELECT player_id, fname, minit, lname, bdate, sex, player.sport_id, sport_name, position, player.team_id, team_name, trophies_won, player.coach_id FROM player INNER JOIN (sport INNER JOIN team ON team.sport_id = sport.sport_id) ON player.team_id = team.team_id AND player_id = " + pid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer player_id = rs.getInt("player_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  Date birthDate = rs.getDate("bdate", null);
                  String sex = rs.getString("sex");
                  Integer sport_id = rs.getInt("sport_id");
                  String sport_name = rs.getString("sport_name");
                  String position = rs.getString("position");
                  Integer team_id = rs.getInt("team_id");
                  String team_name = rs.getString("team_name");
                  Integer trophies_won = rs.getInt("trophies_won");
                  Integer coach_id = rs.getInt("coach_id");
                  // Display values
                  System.out.print("Player ID " + player_id);
                  System.out.print(", First Name " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.print(", Last Name: " + lname);
                  System.out.print(", Birth Date: " + birthDate.toString());
                  System.out.print(", Sex: " + sex);
                  System.out.print(", Sport ID: " + sport_id);
                  System.out.print(", Sport Name: " + sport_name);
                  System.out.print(", Position: " + position);
                  System.out.print(", Team ID: " + team_id);
                  System.out.print(", Team Name: " + team_name);
                  System.out.print(", Number of Trophies Won: " + trophies_won);
                  System.out.println(", Coach ID: " + coach_id);
               }
               rs.close();
            }
            else if(op==28)
            {
               System.out.print("Enter the Coach ID: ");
               int cid=sc.nextInt();
               String query = "SELECT coach_id, fname, minit, lname, salary, coach.sport_id, sport_name, coach.team_id,team_name FROM coach INNER JOIN (sport INNER JOIN team ON team.sport_id = sport.sport_id) ON coach.team_id = team.team_id AND coach_id = " + cid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer coach_id = rs.getInt("coach_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  Integer salary = rs.getInt("salary");
                  Integer sport_id = rs.getInt("sport_id");
                  String sport_name = rs.getString("sport_name");
                  Integer team_id = rs.getInt("team_id");
                  String team_name = rs.getString("team_name");

                  // Display values
                  System.out.print("Coach ID: " + coach_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.print(", Last Name: " + lname);
                  System.out.print(", Salary: " + salary);
                  System.out.print(", Sport ID: " + sport_id);
                  System.out.print(", Sport Name: " + sport_name);
                  System.out.println(", Team ID: " + team_id);
                  System.out.println(", Team Name: " + team_name);
               }
               rs.close();
            }
            else if(op==29)
            {
               System.out.print("Enter the Match ID: ");
               int mid=sc.nextInt();
               String query = "SELECT match_id, team1_id, team2_id, date, tournament_id, venue, winner_id FROM game WHERE match_id = " + mid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer match_id = rs.getInt("match_id");
                  Integer team1_id = rs.getInt("team1_id");
                  Integer team2_id = rs.getInt("team2_id");
                  Date date = rs.getDate("date", null);
                  Integer tournament_id = rs.getInt("tournament_id");
                  String venue = rs.getString("venue");
                  Integer winner_id = rs.getInt("winner_id");

                  // Display values
                  System.out.print("Match ID: " + match_id);
                  System.out.print(", Team1 ID: " + team1_id);
                  System.out.print(", Team2 ID: " + team2_id);
                  System.out.print(", Match Date: " + date.toString());
                  System.out.print(", Tournament ID: " + tournament_id);
                  System.out.print(", Venue: " + venue);
                  System.out.println(", Team ID of the Winning Team: " + winner_id);
               }
               rs.close();
            }
            else if(op==30)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               String query = "SELECT player_id, fname, minit, lname FROM player WHERE team_id = " + tid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer player_id = rs.getInt("player_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  System.out.print("Player ID: " + player_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.println(", Last Name: " + lname);
               }
               rs.close();
            }
            else if(op==31)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               String query = "SELECT coach_id, fname, minit, lname FROM coach WHERE team_id = " + tid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer coach_id = rs.getInt("coach_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  System.out.print("Coach ID: " + coach_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.println(", Last Name: " + lname);
               }
               rs.close();
            }
            else if(op==32)
            {
               System.out.print("Tournament ID: ");
               int tid=sc.nextInt();
               String query = "SELECT match_id, team1_id, team2_id, venue, date, winner_id FROM game WHERE tournament_id = " + tid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer match_id = rs.getInt("match_id");
                  Integer team1_id = rs.getInt("team1_id");
                  Integer team2_id = rs.getInt("team2_id");
                  String venue = rs.getString("venue");
                  Date date = rs.getDate("date", null);
                  Integer winner_id = rs.getInt("winner_id");
                  System.out.print("Match ID: " + match_id);
                  System.out.print(", Team1 ID: " + team1_id);
                  System.out.print(", Team2 ID: " + team2_id);
                  System.out.print(", Match Date: " + date.toString());
                  System.out.print(", Venue: " + venue);
                  System.out.println(", Team ID of the Winning Team: " + winner_id);
               }
               rs.close();
            }
            else if(op==33)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               String query = "SELECT tournament_id,tournament_name FROM team_tournament, tournament WHERE team_id = " + tid + "WHERE team_tournament.tournament_id = tournament.tournament_id";
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer tournament_id = rs.getInt("tournament_id");
                  String tournament_name = rs.getString("tournament_name");
                  System.out.print("Tournament ID: " + tournament_id);
                  System.out.println(", Tournament Name: " + tournament_name);
               }
               rs.close();
            }
            else if(op==34)
            {
               System.out.print("Tournament ID: ");
               int tid=sc.nextInt();
               String query = "SELECT team_id, team_name FROM team_tournament, team WHERE tournament_id = " + tid;
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer team_id = rs.getInt("team_id");
                  String team_name = rs.getString("team_name");
                  System.out.print("Team ID " + team_id);
                  System.out.println(", Team Name " + team_name);
               }
               rs.close();
            }
            else if(op==35)
            {
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String query = "SELECT player_id, fname, minit, lname, trophies_won FROM player where trophies_won= (SELECT MAX(trophies_won) FROM player WHERE sex = 'M' AND sport_id = " + sid + ") AND sex = 'M' AND sport_id = " + sid;
               ResultSet rs = stmt.executeQuery(query);
               // STEP 4: Extract data from result set
               while (rs.next()) {

                  // Retrieve by column name
                  Integer player_id = rs.getInt("player_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  Integer trophies_won = rs.getInt("trophies_won");
                  // Display values
                  System.out.print("Player ID: " + player_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.print(", Last Name: " + lname);
                  System.out.println(", Number of Trophies Won: " + trophies_won);
                  }
                  rs.close();
            }
            else if(op==36)
            {  
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String query = "SELECT player_id, fname, minit, lname, trophies_won FROM player where trophies_won= (SELECT MAX(trophies_won) FROM player WHERE sex = 'F' AND sport_id = " + sid + ")";
               ResultSet rs = stmt.executeQuery(query);

               // STEP 4: Extract data from result set
               while (rs.next()) {

                  // Retrieve by column name
                  Integer player_id = rs.getInt("player_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  Integer trophies_won = rs.getInt("trophies_won");
                  // Display values
                  System.out.print("Player ID: " + player_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.print(", Last Name: " + lname);
                  System.out.println(", Number of Trophies Won: " + trophies_won);
                  }
                  rs.close();
            }
            else if(op==37)
            {
               System.out.print("Player ID: ");
               int pid=sc.nextInt();
               String query = "SELECT player.team_id AS team_id, team_name FROM player, team WHERE player_id = " + pid + " AND player.team_id = team.team_id";
               ResultSet rs = stmt.executeQuery(query);
               // STEP 4: Extract data from result set
               while(rs.next())
               {
                  Integer team_id = rs.getInt("team_id");
                  String team_name = rs.getString("team_name");

                  System.out.print("Team ID: " + team_id);
                  System.out.println(", Team Name: " + team_name);
               }
               rs.close();
            }
            else if(op==38)
            {
               System.out.print("Team ID: ");
               int tid=sc.nextInt();
               System.out.print("Tournament ID: ");
               int toid=sc.nextInt();
               String query = "SELECT match_id, team1_id, team2_id, venue, winner_id FROM game WHERE tournament_id = " + toid + " AND (team2_id = " + tid + " OR team1_id = " + tid + ")";
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer match_id = rs.getInt("match_id");
                  Integer team1_id = rs.getInt("team1_id");
                  Integer team2_id = rs.getInt("team2_id");
                  String venue = rs.getString("venue");
                  Integer winner_id = rs.getInt("winner_id");
                  System.out.print("Match ID: " + match_id);
                  System.out.print(", Team1 ID: " + team1_id);
                  System.out.print(", Team2 ID: " + team2_id);
                  System.out.print(", Venue: " + venue);
                  System.out.println(", Team ID of Winning Team: " + winner_id);
               }
               rs.close();
            }
            else if(op==39)
            {
               System.out.print("Enter the date: ");
               String dt=sc.next();
               String query = "SELECT match_id, team1_id, team2_id, venue, winner_id FROM game WHERE date = '" + dt + "'";
               ResultSet rs = stmt.executeQuery(query);
               while(rs.next())
               {
                  Integer match_id = rs.getInt("match_id");
                  Integer team1_id = rs.getInt("team1_id");
                  Integer team2_id = rs.getInt("team2_id");
                  String venue = rs.getString("venue");
                  Integer winner_id = rs.getInt("winner_id");
                  System.out.print("Match ID: " + match_id);
                  System.out.print(", Team1 ID: " + team1_id);
                  System.out.print(", Team2 ID: " + team2_id);
                  System.out.print(", Venue: " + venue);
                  System.out.println(", Team ID of Winning Team: " + winner_id);
               }
               rs.close();
            }
            else if(op==40)
            {
               System.out.print("Sport ID: ");
               int sid=sc.nextInt();
               String query = "SELECT coach_id, fname, minit, lname, salary FROM coach WHERE salary = (SELECT MAX(salary) FROM coach WHERE sport_id = " + sid + ")";
               ResultSet rs = stmt.executeQuery(query);
               // STEP 4: Extract data from result set
               while (rs.next()) {

                  // Retrieve by column name
                  Integer coach_id = rs.getInt("coach_id");
                  String fname = rs.getString("fname");
                  String minit = rs.getString("minit");
                  String lname = rs.getString("lname");
                  Integer salary = rs.getInt("salary");
                  // Display values
                  System.out.print("Coach ID: " + coach_id);
                  System.out.print(", First Name: " + fname);
                  System.out.print(", Middle Initial: " + minit);
                  System.out.print(", Last Name: " + lname);
                  System.out.println(", Salary: " + salary);
                  }
                  rs.close();
            }
            else if(op==41)
            {
               System.out.println("Committing data here....");
               try{
                  if(conn!=null)
                     conn.commit(); //--------------------------------------------------------------------------------> commit
               }catch(SQLException se1){
                  System.out.println("Commit failed....");
                     se1.printStackTrace();
               }
            }
            else if(op==42)
            {
               System.out.println("Rolling back data here....");
               try{
                  if(conn!=null)
                     conn.rollback(); //--------------------------------------------------------------------------------> rollback
               }catch(SQLException se2){
                  System.out.println("Rollback failed....");
                     se2.printStackTrace();
               }
            }
            else
            {
               break;
            }
         }
         // STEP 5: Clean-up environment
         stmt.close();
         conn.close();
      } catch (SQLException se) { // Handle errors for JDBC
         se.printStackTrace();
         System.out.println("Rolling back data here....");
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("End of Code");
   } // end main
} // end class

// Note : By default autocommit is on. you can set to false using

