-- public.school definition

-- Drop table

-- DROP TABLE public.school;

CREATE TABLE public.school (
	id int4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT school_pkey PRIMARY KEY (id)
);


-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	age int4 NOT NULL,
	id int4 NOT NULL,
	school_id int4 NULL,
	first_name varchar(20) NULL,
	email varchar(255) NULL,
	last_name varchar(255) NULL,
	CONSTRAINT student_email_key UNIQUE (email),
	CONSTRAINT student_pkey PRIMARY KEY (id)
);