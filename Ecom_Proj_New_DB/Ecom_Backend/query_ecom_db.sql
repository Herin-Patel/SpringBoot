CREATE DATABASE IF NOT EXISTS ecom_db;

USE ecom_db;

CREATE TABLE Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(255),
    price DECIMAL(10, 2),
    category VARCHAR(255),
    releaseDate DATE,
    available BOOLEAN,
    quantity INT,
    imageName VARCHAR(255),
    imageType VARCHAR(50),
    imageData LONGBLOB
);

SELECT * FROM Product;