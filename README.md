# Customer Management Rest-API using SpringBoot with JWT Auth

---

This code manages customer details using JWT authentication.

The project aims to provide a secure way to manage customer information by implementing JWT (JSON Web Token) authentication. JWT is a widely used standard for securely transmitting information between parties as a JSON object. It allows the server to authenticate and authorize users based on the tokens they provide.

By using JWT authentication, this project ensures that only authorized users can access and modify customer details. This helps protect sensitive customer information and maintain data privacy.

For more information on JWT authentication, refer to the official documentation: https://jwt.io/introduction/

# <span style="color:red; font-size: 24px;">USED TECHSTACK</span>

- JAVA
- Spring Boot
- JWT Authentication
- MySQL DataBase

## Use EndPoint for Registration:-

```
For create Admin:
    POST    =>     http://localhost:9091/auth/register
    BODY:
    {
      "name":"Vikash",
      "email":"Vikash@gmail.com",
      "roles":"admin",
      "password":"123"
    }

Login using Email and password and get Token:-
    POST    =>    http://localhost:9091/auth/login
    BODY:
    {
    "email":"Vikash@gmail.com",
    "password":"123"
    }
```

## EndPoints for Customer Rest_api access

All endpoints needs token in Bearer Token after that access granted

```
## Create a customer
    POST    => http://localhost:9091/api/customers/create
    BODY:
    {
    "firstName": "Ravi",
    "lastName": "Malhotra",
    "street": "Avenue 5",
    "address": "Sector 42",
    "city": "Noida",
    "state": "Uttar Pradesh",
    "email": "ravi.malhotra@example.com",
    "phone": "1234567890"
    }

##  Update a customer
  PUT     => http://localhost:9091/api/customers/update/1
  BODY:
   {
    "firstName": "Ravi",
    "lastName": "Malhotra",
    "street": "Avenue 5",
    "address": "Sector 42",
    "city": "Noida",
    "state": "Uttar Pradesh",
    "email": "ravi.malhotra@example.com",
    "phone": "1234567890"
    }

##  Get a list of customer (API with pagination sorting and searching )
 GET    => http://localhost:9091/api/customers/pagination/0/10/firstName


##  Get a single customer based on ID
GET     => http://localhost:9091/api/customers/4


##  Delete a customer
DELETE   => http://localhost:9091/api/customers/delete/4
```
