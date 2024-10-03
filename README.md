<p align="center">
  <img src="https://github.com/raffaeleav/popshop/assets/114619463/a4f02382-578b-452c-8a01-93437a8e19cc" width="512" heigth="120">
</p>

<p align="center">
   An e-commerce platform developed as a project for the Tecnologie Software per il 
Web (Web Development Technologies) course, part of the Computer Science Bachelor's 
Degree program at the University of Salerno
</p>


## Table of Contents
- [Overview](#Overview)
- [Preview](#Preview)
- [Features](#Features)
- [Site map](#Site-map)
- [Content map](#Content-map)
- [How to replicate](#How-to-replicate)
- [Dependencies](#Dependencies)
- [Built with](#Built-with)


## Overview 
<p>
    PopShop was designed and developed with the goal of gaining practical experience in implementing a complete web application, including both frontend and backend, to manage an online store. The application allows users to explore a wide range of products, add them to the cart, place orders, and manage their account. The website admin can manage products and users through a dedicated administration interface.
</p>


## Preview
<p>
  <img src="https://github.com/raffaeleav/popshop/assets/114619463/82b4fdf6-8242-4557-844c-822b9dac7cba" width="400" heigth="400">
</p>


## Features 
1) Add new items (Admin)
2) Search for items
3) Add an item to the cart
4) Check items in the cart
5) Buy items


## Site map
<p>
  <img src="https://github.com/raffaeleav/popshop/assets/114619463/eee19c3e-277e-4420-930d-0769f62458c5" width="400" heigth="400">
</p>


## Content map
<p>
  <img src="https://github.com/raffaeleav/popshop/assets/114619463/01d8ecdb-d7c2-4fac-9097-1b0f5dc0e3cc" width="400" heigth="400">
</p>


## How to replicate
1) Clone the repository
```bash
git clone https://github.com/raffaeleav/popshop.git
```
2) Switch to the project directory
```bash
cd popshop
```
3) Execute the database script (be sure to change the MySQL server credentials in model.ConPool)
```bash
sudo mysql -u root -p < ./src/main/webapp/database/database.sql
```
4) Build the project
```bash
mvn install
```
5) Copy the .war file to the webapps directory of your Tomcat server
```bash
sudo cp target/popshop-retry-1.0-SNAPSHOT.war /opt/tomcat/apache-tomcat-10.1.30/webapps
```
6) Start the Tomcat server (assuming you have created a tomcat systemd service)
```bash
sudo systemctl start tomcat
```
7) Open the browser and access the webapp running at localhost
```bash
xdg-open 'http://localhost/popshop-retry-1.0-SNAPSHOT'
```


## Dependencies 
- [JDK 19](https://www.oracle.com/java/technologies/downloads/#java19 "JDK 19")
- [Apache Tomcat 10](https://tomcat.apache.org/download-10.cgi)
- [MySQL](https://dev.mysql.com/downloads/installer/)
  - [Connector/J](https://dev.mysql.com/downloads/connector/j/)
- [Maven](https://maven.apache.org/)


## Built with
- [Java](https://www.oracle.com/java/technologies/downloads/#java19 "JDK 19") - used for the backend implementation
- [HTML](https://www.w3schools.com/html/default.asp) - used for the frontend development of the web app
- [CSS](https://www.w3schools.com/css/) - used for formatting and managing the responsive layout of the web app
- [JavaScript](https://www.w3schools.com/js/) - used for form validation 
- [AJAX](https://www.w3schools.com/js/js_ajax_intro.asp) - used for making asynchronous calls
- [SQL](https://www.w3schools.com/sql/) - used for implementing the physical schema of the database
- [Maven](https://maven.apache.org/) - used for for dependency management
