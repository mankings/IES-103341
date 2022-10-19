# Lab 3.2 Notes

## **CRUD RESTful API**
This is an API for a simple employee management system.  

These are the five controller handler methods created:
![Methods](assets/methods.png?raw=true "Methods")

## **Creating the project**
*Spring Initializr* was used, using the following starter dependencies:
* Spring Web
* Spring Data JPA
* MySQL Driver
* DevTools
* Validation

## **Project structure**
* Controller (*EmployeeController*)
* Repository (*EmployeeRepository*)
* Entities (*Employee*)
* Exceptions

## **API testing usinhg Postman**

<div align="center">

### Adding a new employee to the database:
![post1](assets/post1.png?raw=true "post1")
![post2](assets/post2.png?raw=true "post2")

### Get a specific employee given by id:
![get](assets/get.png?raw=true "get")

### Get a specific employee given by email:
![getbyemail](assets/getbyemail.png?raw=true "getbyemail")

### Get all employees:
![getall](assets/getall.png?raw=true "getall")

### Updating a specific employee given by id:
![update](assets/update.png?raw=true "update")

### Delete a specific employee given by id:
![delete](assets/delete.png?raw=true "delete")

</div>
