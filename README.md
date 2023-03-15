# Recipe Management System API

### Frameworks and Language used:
 - Spring
 - Spring boot
 - Java
 - Mysql-Database
 - AWS-Deployment
 
### Data Flow

### Users
 - Controller
 - Service
 - Repository
 - Database
### Recipe
 - Controller
 - Service
 - Repository
 - Database
### Comments
 - Controller
 - Service
 - Repository
 - Database

### Project Summary
- Created a simple REST API of Recipe Management System.
- In this project created 4 models:-
    1. Status
    2. Users
    3. Recipe
    4. Comments
- In the User model you can do the CRUD(Create, Read, Update, Delete) Commands.
- In this project there is one status model which shows the user is active or inactive status. It will not delete the user from table it will change its status.
- In the Recipe model you can do the CRUD(Create, Read, Update, Delete) Commands.
- In the Recipe model you can create a recipe while giving its name, ingredients and instructions you can also assign which user makes this recipe.
- In the Comments model a particular user can create a comment on the recipe.
- All the data are stored in the MYSQL database.

This Application is deployed on the server, you can see by clicking on this swagger link:-
- http://3.143.245.83:8080/swagger-ui/index.html#/
LinkedIn profile Link:-
- https://www.linkedin.com/in/sankalp-trimade-7678a31a5/

The ip address which I have used is:
- 3.143.245.83

### How to use in your system?
 - Just simply clone this repository using git on your system.
 - In your system you should have installed any JDK version     greater than 8.
 - Then open any code editor and then click on Run button to start the server
 - To save your data in database you must first create your db in mysql workbench with name as title_db.
