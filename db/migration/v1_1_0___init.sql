

CREATE TABLE IF NOT EXISTS 'products'
(
  'id' BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  'name' VARCHAR(255) NOT NULL,
  'brand' VARCHAR(255) NOT NULL,
  'model' VARCHAR(255) NOT NULL,
  'registration_date' DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS 'processors'(
  'product_id' BIGINT  ,
  'frequency_Ghz' DOUBLE,
  FOREIGN KEY (product_id) REFERENCES products(id)

)