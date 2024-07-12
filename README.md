# SCHOOL MICROSERVICESS
***CREATED BY : RIYAN SUGIARTO***

## TECHNOLOGY USED
- Spring Boot
- PostgreSQL For Database
- Spring Cloud (Eureka Server, Gateway)
- Feign Client for communication between microservices

## ACCESSING THE SERVICES AND SERVERS
- Eureka Server(discovery): `http://localhost:8761`
- School Service: `http://localhost:8080`
- Student Service: `http://localhost:8081`
- Gateway: `http://localhost:8765`

## USAGE
Best required to access api endpoints using the api gateway endpoint `http://localhost:8765`


## HOW TO USE
To use the services listed (Eureka Server, School Service, Student Service, and Gateway) after cloning a project, you typically follow these steps:

Start Eureka Server (Discovery Service):

Navigate to the directory where Eureka Server is located (usually indicated as a separate module or project in your cloned repository).
Build and run the Eureka Server application.
Access it via http://localhost:8761 in your web browser to ensure it is up and running. Eureka Server provides a dashboard to view registered services.
Start School Service:

Locate the School Service module in your cloned project.
Build and run the School Service application.
Verify its availability at http://localhost:8080.
Start Student Service:

Similarly, find the Student Service module.
Build and run the Student Service application.
Confirm it is running correctly at http://localhost:8081.
Start Gateway:

The Gateway acts as an entry point and routes requests to the appropriate services.
Locate the Gateway module.
Build and run the Gateway application.
Access it through http://localhost:8765.
Common Steps After Starting Services:
Service Registration:

Each service (School Service and Student Service) should register with Eureka Server upon startup. You can verify this by checking the Eureka Server dashboard (http://localhost:8761).
Service Discovery via Gateway:

Configure the Gateway (http://localhost:8765) to route requests to the School Service (http://localhost:8080) and Student Service (http://localhost:8081). The Gateway typically uses service names registered with Eureka Server.
Testing Endpoints:

Use tools like Postman or curl to test endpoints exposed by the Gateway (http://localhost:8765). For example:
Access http://localhost:8765/schools to retrieve schools via the School Service.
Access http://localhost:8765/students to retrieve students via the Student Service.



Notes:
*Ensure dependencies are correctly set up in each module (Eureka Server, School Service, Student Service, and Gateway) for service registration and discovery.
Check logs for any startup errors or conflicts, especially related to port numbers (8080, 8081, 8761, 8765).
Modify configurations as necessary (e.g., database settings, service URLs) in configuration files (application.properties or application.yml).
By following these steps, you can effectively manage and use the services within your cloned project, leveraging Eureka Server for service discovery and the Gateway for routing requests to the appropriate services.*



## DEPENDENCIES

- Database Posgresql


- Postman Collection


## HOW TO USE API Endpoints

### School Service
Base URL: `/api/v1/schools`
- GET : Retrieve all schools.

        curl --location 'http://localhost:8765/api/v1/schools'

- GET `/{id}`: Retrieve school by ID.

        curl --location 'http://localhost:8765/api/v1/schools/1'

- GET `/students/{school-id}`: Retrieve all students based on school id.

        curl --location 'localhost:8765/api/v1/schools/students/1'

- POST : Create a new school.

      curl --location 'localhost:8765/api/v1/schools' \
      --header 'Content-Type: application/json' \
      --data '{
          "name": "University Of Indonesia"
      }'

### Student Service
Base URL: `/api/v1/students`
- GET : Retrieve all students.


      curl --location 'http://localhost:8765/api/v1/students'
- GET `{id}`: Retrieve student by ID.

      curl --location 'http://localhost:8765/api/v1/students/1'
- GET `/schools/{school-id}`: Retrieve all students based on school id.

        curl --location 'localhost:8765/api/v1/students/3'

- POST : Create a new student.

        curl --location 'localhost:8765/api/v1/students' \
      --header 'Content-Type: application/json' \
      --data-raw '{
        "firstName": "Riyan",
        "lastName": "Sugiarto",
        "email": "riyansugiarto@gmail.com",
        "age": 25,
        "schoolId": 3
      }'

- DELETE `/{id}`: Delete student by ID.

      curl --location --request DELETE 'localhost:8765/api/v1/students/153'



*If you're confused, you can refer to the API documentation in Postman. Below is an example image showing both success and error responses. This documentation provides clear examples of how requests are expected to behave, including what successful and unsuccessful responses look like.*