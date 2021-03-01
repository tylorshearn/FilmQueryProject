### FilmQuery Project

![](Images/denise-jans-Lq6rcifGjOU-unsplash.jpg)

### Description

 This program is intended to allow the user to find film information extracted from a MAMP SQL server powered by Apache through JDBC.

### Implemented Topics and Technologies

* MAMP
* SQL
* Apache powered servers
* JDBC
* Maven build automation tool
* MySQL drivers
* POM files   
* SQL queries
* Predicates and functions
* Object-relational mapping

### Run Instructions

* Run as a Java application on a Java supported IDE of your choosing
* You will be prompted with a menu asking if you'd like to search for a film by   
  ID, keyword, or exit the application
* When you search by ID, input a number between 1 and 1000
* When you search by keyword, input a keyword
* You are able to cycle through menu options until you exit the application

### Lessons Learned

When converting a project to Maven, the MySQL Java connector dependency is not automatically inputted into a POM file. Without the connector, you are presented with a class path issue, resulting in a ClassNotFoundException.

### Thank you for reviewing my application
