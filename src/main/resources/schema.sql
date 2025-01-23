create table if not exists employees (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

    employeeId VARCHAR (36) NOT NULL UNIQUE,

    first_name VARCHAR (50),
    last_name VARCHAR (50)
);