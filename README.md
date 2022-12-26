# Reading is Good

A Java application for tracking books, orders, and customers.

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
