# Reading is Good

ReadingIsGood is an online books retail firm which operates only on the Internet. Main
target of ReadingIsGood is to deliver books from its one centralized warehouse to their
customers within the same day. That is why stock consistency is the first priority for their
vision operations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Also you can find json file for import Postman Collection and you can test endpoints.

### Prerequisites

In order to run this project, you will need the following software installed on your machine:

- Java SE Development Kit (JDK) 11
- Apache Maven
- Docker

### Installing And Running

1. Clone the repository 

```shell
git clone https://github.com/mihrinurgrn/reading-is-good.git
```

2. Run the following in order.

```shell
mvn clean package
```

```shell
docker-compose up --build
```
After completing the above steps, you can use the postman collection 

- First, you perform user registration with customer create.
- Then you login and get **jwt token**.
- And you can add a book
- Update stock of a book with bookId (You can increase or decrease the stock)
- You can create an order
- You can see monthly statistics
- You can also make other operations that you see in the postman colllection
