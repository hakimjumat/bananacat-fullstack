1.      Download Java 24 from the official Oracle website of other JDK vendors
2.      Select Java SE Development Kit 24
3.      Pick the correct installer. (.exe for Windows) (.dmg for macOS) (.tar.gz or .deb for Linux)
4.      Run the installer
5.      Extract the project package containing the source code
6.      Open the project in an IDE, preferably Visual Studio Code
7.      Install PostgreSQL version 16.4
8.      In \bananacat-fullstack\src\main\resources make sure to edit you application.properties file to setup your database. Change the username and password to fit 
         ![image](https://github.com/user-attachments/assets/495a9e1d-0ef6-4f9e-a718-0a0d0485327a)
        spring.application.name=bananacatbackend
        spring.datasource.url=jdbc:postgresql://localhost:5432/UserAccount --> Database name in psql.
        spring.datasource.username=csci235su  --> Account that has access to database
        spring.datasource.password=csci235su  --> Password to account

10.      In the IDE, navigate to “BananacatbackendApplication.java”
11.      Run the program
12.      Website is running on http://localhost:8080/
