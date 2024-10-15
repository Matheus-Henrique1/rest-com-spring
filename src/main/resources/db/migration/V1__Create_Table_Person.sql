CREATE TABLE IF NOT EXISTS public.person (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	gender varchar(20) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);