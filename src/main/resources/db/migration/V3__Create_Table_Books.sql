﻿CREATE TABLE books (
  id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
  author varchar(255) ,
  launch_date DATE NOT NULL,
  price decimal(65,2) NOT NULL,
  title varchar(255)
)
