# BetterReciper
Web API to help recommend recipe.  
## [Project Documents](https://docs.google.com/document/d/1uFIWpTibYUKOMG5VRGX0oWdeFiEfUgWFPer4GgVscCU/edit?usp=sharing)
## Getting Started
| Name                                                                       | Required version(s) |
|:---------------------------------------------------------------------------|:-------------------:|
| [Docker](https://docs.docker.com/get-docker/)                              | 20.10.12 or higher  |
| [Docker Compose](https://docs.docker.com/compose/install/#install-compose) |  1.29.2 or higher   |
## Installation  
1. Clone this repository to your computer.  
``` bash
git clone https://github.com/BetterReciper/BetterReciper.git 
```  
2. Change directory to the repository.
``` bash
cd BetterReciper
```
3. Set environment variables.  
* MacOS / Linux
```bash
$ export YOUR_KEY=database-encrypt
$ export SPRING_DATASOURCE_URL=your-datasource-url
$ export SPRING_DATASOURCE_USERNAME=your-datasource-username
$ export SPRING_DATASOURCE_PASSWORD=your-datasource-password
$ export GITHUB_CLIENT_ID=github-client-id
$ export GITHUB_CLIENT_SECRET=github-client-secret
$ export AUTH0_AUDIENCE=auth0
$ export JWT=jwt
```
* Window  
```bash
$ set YOUR_KEY=database-encrypt
$ set SPRING_DATASOURCE_URL=your-datasource-url
$ set SPRING_DATASOURCE_USERNAME=your-datasource-username
$ set SPRING_DATASOURCE_PASSWORD=your-datasource-password
$ set GITHUB_CLIENT_ID=your-github-client-id
$ set GITHUB_CLIENT_SECRET=your-github-client-secret
$ set AUTH0_AUDIENCE=your-auth0-audience
$ set JWT=your-jwt
```
4. Run docker with this command.  
````bash
docker run --name=better-reciper -e MYSQL_ROOT_PASSWORD=abc123 -e MYSQL_DATABASE=db -p 3307:3306 -d mysql
````
5. Run a Spring Boot application using this command.
```bash
mvn spring-boot:run
```  
## API Path  
### Base URL  
```
http://localhost:8080
```
you can change PORT in application.properties.  
```
server.port=8080
```
For get the recipe.  
```
/api/recipe
```
For create the recipe.  
```
/api/recipe
```  
For delete the recipe.
```  
/api/recipe/{id}
```  

