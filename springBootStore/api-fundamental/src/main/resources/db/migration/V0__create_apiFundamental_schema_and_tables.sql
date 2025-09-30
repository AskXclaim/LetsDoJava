-- Create schema if it doesn't exist
CREATE DATABASE IF NOT EXISTS apifundamental
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- Drop the procedure if it exists (to allow re-running in dev)
DROP PROCEDURE IF EXISTS create_apiFundamental_schema_and_tables;

DELIMITER //

CREATE PROCEDURE create_apiFundamental_schema_and_tables()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            -- Roll back any table creation
            ROLLBACK;
            -- Drop the schema to undo the partial creation
            DROP DATABASE IF EXISTS apifundamental;

            -- You can't SELECT messages in Flyway, but this helps for debugging
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = '❌ Schema and table creation failed. Schema dropped.';
        END;

    START TRANSACTION;

    CREATE TABLE users
    (
        id         BIGINT AUTO_INCREMENT PRIMARY KEY,
        username   VARCHAR(50)  NOT NULL UNIQUE,
        email      VARCHAR(100) NOT NULL UNIQUE,
        password   VARCHAR(50)  NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    CREATE TABLE addresses
    (
        id               BIGINT AUTO_INCREMENT PRIMARY KEY,
        user_id          BIGINT       NOT NULL,
        street           VARCHAR(100) NOT NULL UNIQUE,
        city             VARCHAR(100) NOT NULL UNIQUE,
        state            VARCHAR(100) NOT NULL,
        postcode_zipcode VARCHAR(20)  NOT NULL,
        created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
    );

    CREATE TABLE profiles
    (
        id             BIGINT AUTO_INCREMENT PRIMARY KEY,
        bio            VARCHAR(100) NULL,
        phone          VARCHAR(30)  NULL,
        date_of_birth  DATE         NULL,
        loyalty_points BIT          NULL,
        created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
    );

    CREATE TABLE categories
    (
        id         TINYINT AUTO_INCREMENT PRIMARY KEY,
        name       VARCHAR(100) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    CREATE TABLE products
    (
        id          BIGINT AUTO_INCREMENT PRIMARY KEY,
        category_id TINYINT        NOT NULL,
        name        VARCHAR(100)   NOT NULL,
        description VARCHAR(255)   NOT NULL,
        price       DECIMAL(10, 2) NOT NULL,
        created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE
    );
    COMMIT;

END //

DELIMITER ;


-- Execute the procedure
CALL create_apiFundamental_schema_and_tables();

-- Drop the procedure after execution (optional cleanup)
DROP PROCEDURE create_apiFundamental_schema_and_tables;


