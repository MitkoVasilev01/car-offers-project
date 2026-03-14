# FindCar - Car Trading Platform

A full-stack web application for buying and selling cars, built with **Java Spring Boot**, **MySQL**, and **Thymeleaf**.

##  Features
- **User Authentication:** Secure registration and login using Spring Security.
- **Offer Management:** Create, view, edit, and delete car offers (CRUD operations).
- **Image Upload:** Local file storage for multiple car images with automatic thumbnail selection.
- **Dynamic Search & Filtering:** Complex search by Brand, Model, Price, Year, Engine, and Extras.
- **Relational Database:** Designed with Hibernate (One-to-Many, Many-to-Many relationships).
- **Responsive UI:** Built with Bootstrap and custom CSS for a modern look.

##  Tech Stack
- **Backend:** Java 17, Spring Boot 3.4.2, Spring MVC, Spring Data JPA, Spring Security.
- **Database:** MySQL, Hibernate ORM.
- **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap 5.
- **Tools:** Maven, Git, IntelliJ IDEA, Lombok.

##  How to Run Locally 
1. Clone the repository:
   ```bash 
   git clone https://github.com/MitkoVasilev01?tab=repositories
   
2. Open src/main/resources/application.properties and configure your MySQL credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password

3. Run the application via your IDE or terminal:
mvn spring-boot:run

Screenshots:

**Home page:**
![Начална страница](home-page.jpg)

**Offer details:**
![Детайли](offer-details.jpg)


