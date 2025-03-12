# Repo for the recipe book web app

## Description

A web application for creating and managing a recipe book. The frontend is built with Angular, and the backend is powered by Spring Boot. It follows a microservices architecture with a gateway to handle the services. The entire project is fully dockerized for easy deployment and scalability.
<br>
(Note: Frontend is not yet fully implemented, namely the view for a single recipe type is not done yet)

## Running the project

### For dev mode

Simply run
```
docker-compose up
```

Frontend at: [http://localhost:4200/](http://localhost:4200/)

### For prod mode

Run
```
docker-compose -f docker-compose.yml up
```

Frontend at: [http://localhost:8080/](http://localhost:8080/)

### Note

Keep in mind that you should the containers and images before switching modes. <br>
For example with:
```
docker-compose down --rmi all
```

## Credits

It more or less follows a project by Michał (psysiu) Wójcik https://git.pg.edu.pl/p650304.
