# SpringBootJWTExample
This is an example project for JWT implementation in the Spring Boot Project

## Installation

* Clone the repository 

  ```bash
  git clone https://github.com/harish147/SpringBootJWTExample.git
  ```
* Change the directory to the project directory
  ```bash
  cd SpringBootJWTExample
  ```
* Install dependencies
  ```bash
  mvn install
  ```
## Configure & Run Application

  * Add database configurations in `application.properties`
  * After adding the database configurations, you can run the application using the below command
    ```bash
    mvn spring-boot:run
    ```

## Entities
    
| Entity Name | Fields                 | Constraints                 |
| ----------- | ---------------------- | --------------------------- |
| `UserRole`  | id : Integer           | Primary Key, Auto Increment |
|             | role : String          | Not Null, Unique            |
| `User`      | id : Integer           | Primary Key, Auto Increment |
|             | firstName : String     | Not Null                    |
|             | middleName : String    |                             |
|             | lastName : String      | Not Null                    |
|             | mobileNumber : String  | Not Null, Unique            |
|             | emailId : String       | Not Null, Unique            |
|             | address : String       |                             |
|             | city : String          |                             |
|             | state : String         |                             |
|             | contry : String        |                             |
|             | roles : Set\<UserRole> |                             |
|             | password : String      | Not Null                    |

`Typo Warning`: **contry** field is misspelled

## Usage
    
  * I have created some APIs that are necessary to use the application. are given below,

    | Endpoint            | Type | Parameters                                                                                                                                                                                                                                                         | Authorization | Description                                                                                                   | Response       |
    | ------------------- | ---- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------- | ------------------------------------------------------------------------------------------------------------- | -------------- |
    | /userrole           | POST | role : String                                                                                                                                                                                                                                                      | Not Required  | Creates a new `UserRole`                                                                                      | `UserRole`     |
    | /user               | POST | firstName : String, <br> middleName : String, <br> lastName : String, <br> mobileNumber : String, <br> emailId : String, <br> address : String, <br> city : String, <br> state : String, <br> contry : String, <br> roles : Array\<String>, <br> password : String | Not Required  | Creates a new `User`                                                                                           | `User`         |
    | /auth/generatetoken | POST | username : String, <br> password : String                                                                                                                                                                                                                          | Not Required  | Creates a token for authentication                                                                            | String         |
    | /user               | GET  |                                                                                                                                                                                                                                                                    | Bearer        | Returns all the users, Pass the `Authorization` header with Bearer token retrieved from  `/auth/generatetoken` | Array\<`User`> |

    **Note:** Check the controller package for more API endpoints.
  * First create a `UserRole`
  * Create a `User` with role 
  * Generate Authorization token 
  * Access the restricted endpoint with the help of the Authorization token
