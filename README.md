# Reading is Good

ReadingIsGood is an online books retail firm which operates only on the Internet. Main
target of ReadingIsGood is to deliver books from its one centralized warehouse to their
customers within the same day. That is why stock consistency is the first priority for their
vision operations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

In order to run this project, you will need the following software installed on your machine:

- Java SE Development Kit (JDK) 11
- Apache Maven
- Docker

### Installing

1. Clone the repository

```bash
git clone https://github.com/your-username/reading-is-good.git

cd reading-is-good
docker build -t reading-is-good .
docker run -p 8080:8080 reading-is-good
Access the application in your web browser at http://localhost:8080
