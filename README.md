# Kalah Game

A web application implementing 6-Stone variant of Game of Kalah (https://en.wikipedia.org/wiki/Kalah).

 Method  |  URL | Action 
 --- | --- | ---
   POST	| /kalah/play |Updates the game state on a valid move.
   GET |	/kalah/start |	Returns a initialized game.	

Project includes a simple front-end based on JQuery which consumes 
the RESTFul apis and letuser play the game. 

# Technologies Used : 

* Java 8 
* Spring Boot
* Maven
* JQuery
* HTML & CSS


# Usage 

In order to run the application you need Java 8 and Maven.

Please follow these steps.
1) Clone the repository from GitHub.

   $ git clone https://github.com/jazvillagra/kalah-game.git
 
2) Navigate to the location of pom file of project and execute:

   $ mvn package && java -jar target/kalah-game-1.0.0.jar

3) Access game using URL :  http://localhost:8080

