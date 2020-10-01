# CarRentalServer
Car Rental RestAPI with Spring Boot and OAuth2, JWT REST Protection.

This basic application shows how to work Spring Security and Spring REST.
I also use MySQL for data resource and Data JPA to access the database.
There are two different roles:

- ADMIN: has full permission on the car rental and users data.

- USER: has full permission on the car rental data.

#### The application features:

- Add, update and delete Car entity,

- Add, update and delete Client entity,

- Set and Finish a rent process,

- List all cars and clients,

- List active and inactive rent process,

- Add new user (who can access the api),

- Get JWT token for authentication

#### Run Spring Boot application:

`mvn spring-boot:run`

Note: If you setup your mysql connection correctly in the application.yml the database will be automatically generated.

#### Usage:

- Request access token from `localhost:8080/oauth/token` with Basic Auth (Username: `car-rental-client` Password: `car-rental-secret`) and in the request body with one of users from users table.

- With `access-token` now you can access the api. Send a GET method to `localhost:8080/api/rents` with Bearer token.

- If you set it well now you can see all the renting process.

- Try `/api/cars` and `/api/clients` to list the cars and clients.

- If you login as ADMIN role you can also check `/users/all` for the users.

#### Availabe users:

|Username|Password|Role|
|---|---|---|
|admin|admin|ADMIN|
|simple-user|rally|USER|

