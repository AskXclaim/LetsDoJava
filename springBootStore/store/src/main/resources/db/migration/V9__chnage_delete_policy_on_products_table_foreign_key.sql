-- Drop the old constraint
ALTER TABLE products
DROP FOREIGN KEY products_categories_id_fk;

-- Recreate with RESTRICT
ALTER TABLE products
ADD CONSTRAINT products_categories_id_fk
FOREIGN KEY (category_id)
REFERENCES categories (id)
ON DELETE RESTRICT