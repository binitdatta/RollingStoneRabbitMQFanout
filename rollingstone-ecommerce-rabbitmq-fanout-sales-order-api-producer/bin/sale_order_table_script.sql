create table order_master(
order_id		number(10),
order_no		varchar(20),
user_id			number(10),
user_address_id		number(10),
user_contact_id		number(10),
total_amount		number(13,3),
user_payment_detail_id	number(10),
sales_person_id		number(10)
);


create table order_details(
order_id		number(10),
item_id			number(10),
quantity		number(5),
price_per_unit		number(10,3),
item_total_price	number(10,3)
);
