CREATE TABLE companies 
( 
    company_id                  integer                 GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL PRIMARY KEY, 
    company_name                VARCHAR(50)         NOT NULL, 
    contact_name                VARCHAR(50)         NOT NULL, 
    contact_phone               VARCHAR(30)         NOT NULL, 
    contact_email               VARCHAR(50)         NOT NULL, 
    created                     DATETIME            NOT NULL 
); 
CREATE TABLE customers 
( 
    customer_id                 integer              GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL PRIMARY KEY, 
    company_id                  integer                 NOT NULL, 
    customer_name               VARCHAR(100)     	NOT NULL, 
	customer_company			VARCHAR(100), 
    CONSTRAINT customers_fk_company 
        FOREIGN KEY (company_id) REFERENCES companies (company_id) 
); 

CREATE TABLE orders 
( 
    order_id            		integer              GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL PRIMARY KEY, 
    company_id                  integer                 NOT NULL, 
	customer_id					integer				NOT NULL, 
	order_number				VARCHAR(200), 
    order_date               	TIMESTAMP           NOT NULL, 
	created                     TIMESTAMP           NOT NULL, 
	order_status				integer 			NOT NULL, 
    CONSTRAINT orders_fk_company 
        FOREIGN KEY (company_id) REFERENCES companies (company_id), 
	CONSTRAINT orders_fk_customer 
        FOREIGN KEY (customer_id) REFERENCES customers (customer_id), 
); 

CREATE TABLE order_items 
( 
	order_item_id				integer				GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL PRIMARY KEY, 
	order_id					integer				NOT NULL, 
    listing_sku                 VARCHAR(100), 
	listing_name				VARCHAR(200), 
    quantity_ordered            integer       			NOT NULL, 
	quantity_shipped            integer       			NOT NULL, 
    unit_price                 	DECIMAL(10,2)		NOT NULL, 
	tax                 		DECIMAL(10,2)		NOT NULL, 
	CONSTRAINT order_items_fk_order 
        FOREIGN KEY (order_id) REFERENCES orders (order_id) 
); 
