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

### Technologies

- Sprinboot
- Postgresql
- JPA Hibernate
- Lombok

### Database Design

- Customer table is include some informations about customers like username, password 
- Order table is include some informations about orders like book, customer 
- Book table is include some informations about book like bookname, stock

Also every entity extends Base Entity in Jpa Entities Base entity is includes some usual informations that can be in every entity like Created_at Created_by Modified_at

### Request And Response Types 

Every andpoint has own request and reponse type also every response is look like this

```JSON
{
    "code": 200,
    "data": [
        {
        }
    ],
    "message": null,
    "timeStamp": 1665324335570
}
```

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
