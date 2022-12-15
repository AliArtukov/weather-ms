Instructions for using the project:

1. First of all, download the project archive to your local computer.
2. At the root of the project, open a terminal and run the docker-compose.iml file with the commands "docker-compose up -d".
3. To view the endpoints of the REST controller, the primary requests and send the requests themselves to the Rest API, 
   open the swagger page in the browser http://localhost:8091/swagger-ui.html or open-api page http://localhost:8091/v3/api-docs.

To view the database diagram, you can open the created png file in the folder src/mine/resources/diagrams/shatner-db-diagram.png
   or open the https://dbdiagram.io/d/63988d0999cb1f3b55a120c2 page to view the database structure.

You can see an example of weather information in the PNG file at src/main/resources/diagram/weather-info.png

From the requirements in those tasks, the technologies used:
1. jdk11
2. spring boot
3. liquibase
4. sql db (postgres)
5. java doc

Of the requirements in the terms of reference, technologies not used:
1. web flux
2. junit
3. mockito

Reason for not using some technologies: Could not share time due to work in the main workplace.