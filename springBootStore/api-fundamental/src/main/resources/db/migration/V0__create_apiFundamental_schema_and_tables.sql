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

            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = '❌ Schema and table creation failed. Schema dropped.';
        END;

    START TRANSACTION;

    -- USERS TABLE
    CREATE TABLE users
    (
        id         BIGINT AUTO_INCREMENT PRIMARY KEY,
        name   VARCHAR(50)  NOT NULL UNIQUE,
        email      VARCHAR(100) NOT NULL UNIQUE,
        password   VARCHAR(50)  NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    -- Indexes for faster lookups on common fields
    CREATE INDEX idx_users_name ON users (name);
    CREATE INDEX idx_users_email ON users (email);
    CREATE INDEX idx_users_created_at ON users (created_at);

    -- ADDRESSES TABLE
    CREATE TABLE addresses
    (
        id               BIGINT AUTO_INCREMENT PRIMARY KEY,
        user_id          BIGINT       NOT NULL,
        street           VARCHAR(100) NOT NULL UNIQUE,
        city             VARCHAR(100) NOT NULL,
        state            VARCHAR(100) NOT NULL,
        postcode_zipcode VARCHAR(20)  NOT NULL,
        created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
    );

    -- Indexes for addresses (common query filters: user_id, city, postcode)
    CREATE INDEX idx_addresses_user_id ON addresses (user_id);
    CREATE INDEX idx_addresses_city ON addresses (city);
    CREATE INDEX idx_addresses_postcode_zipcode ON addresses (postcode_zipcode);

    -- PROFILES TABLE
    CREATE TABLE profiles
    (
        id             BIGINT AUTO_INCREMENT PRIMARY KEY,
        bio            VARCHAR(100) NULL,
        phone          VARCHAR(30)  NULL,
        date_of_birth  DATE         NULL,
        loyalty_points INT UNSIGNED DEFAULT 0 NULL,
        created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
    );

    -- Since profiles.id = users.id (1:1), indexing created_at might help
    CREATE INDEX idx_profiles_created_at ON profiles (created_at);
    CREATE INDEX idx_profiles_loyalty_points ON profiles (loyalty_points);

    -- CATEGORIES TABLE
    CREATE TABLE categories
    (
        id         TINYINT AUTO_INCREMENT PRIMARY KEY,
        name       VARCHAR(100) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

    -- Index for category name (e.g., for search/autocomplete)
    CREATE UNIQUE INDEX idx_categories_name ON categories (name);

    -- PRODUCTS TABLE
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

    -- Indexes for products (common: category_id for joins, name for searches, price for filtering)
    CREATE INDEX idx_products_category_id ON products (category_id);
    CREATE INDEX idx_products_name ON products (name);
    CREATE INDEX idx_products_price ON products (price);
    CREATE INDEX idx_products_created_at ON products (created_at);

    COMMIT;

END //

DELIMITER ;

-- Execute the procedure
CALL create_apiFundamental_schema_and_tables();

-- Drop the procedure after execution (optional cleanup)
DROP PROCEDURE create_apiFundamental_schema_and_tables;
