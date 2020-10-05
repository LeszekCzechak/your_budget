
  <h3 align="center">MyBudget</h3>

  <p align="center">
    An application that helps users manage their home budget
    <br />
    <br />
    *
    <a href="https://github.com/github_username/repo_name">View Video</a>
    * (Soon)
  </p>
</p>

MyBudget

<!-- ABOUT THE PROJECT -->
## About The Project

[![SwaggerScreenShot][product-screenshot]](https://photos.app.goo.gl/ZZja7kuAmcqkf1VZA)

It is an application supporting the user in managing the home budget.
Each logged in user can manage their finances by making deposits, transfers and withdrawals for specific purposes or categories of expenses. The application supports currency transfers - in the case of a currency transfer, the current exchange rate is automatically downloaded from an external API in order to convert the transaction.
The application allows you to create and edit: users, accounts, specific expenses (eg "Shell" station) and categories of expenses (eg car).
You can view the current exchange rate at any time.
All data and the history of postings is stored on the PostgreSQL database running on the Heroku server.

### Built With

- Spring Data JPA
- Spring Data Rest
- Spring Security JWT
- Validation
- Spring Web
- Spring Reactive Web
- Lombok
- Springfox Swagger
- PostgreSQL Driver
- Junit
- Mockito

<!-- USAGE EXAMPLES -->
## Usage

The application requires JWT authentication.
After starting the application, available endpoints can be viewed using Swagger at:
http://localhost:8080/swagger-ui/index.html


<!-- CONTACT -->
## Contact

Leszek Czechak - [LinkedIn](https://www.linkedin.com/in/leszek-czechak/) - leszek.czechak@gmail.com

Project Link: [https://github.com/LeszekCzechak/your_budget](https://github.com/LeszekCzechak/your_budget)
