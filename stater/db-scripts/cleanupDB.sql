USE `full-stack-ecommerce` ;

-- clean up previous database tables 

SET foreign_key_checks=0;

TRUNCATE customer;
TRUNCATE orders;
TRUNCATE order_item;
TRUNCATE address;

SET foreign_key_checks=1;
