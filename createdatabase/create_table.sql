--drop table
-- DROP TABLE IF EXISTS public.detail_invoice;
-- DROP TABLE IF EXISTS public.invoice;
-- DROP TABLE IF EXISTS public.cart;
-- DROP TABLE IF EXISTS public.product;
-- DROP TABLE IF EXISTS public.account;
-- DROP TABLE IF EXISTS public.customer;
-- create table customer

CREATE TABLE IF NOT EXISTS public.customer
(
    full_name text COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(10) COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;

--create table account

CREATE TABLE IF NOT EXISTS public.account
(
    account_id character varying(8) COLLATE pg_catalog."default" NOT NULL,
    password character varying(6) COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying(4) COLLATE pg_catalog."default",
    CONSTRAINT account_pkey PRIMARY KEY (account_id),
    CONSTRAINT account_customer_id_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;
	
-- create table product

CREATE TABLE IF NOT EXISTS public.product
(
    product_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    product_name text COLLATE pg_catalog."default" NOT NULL,
    price numeric NOT NULL,
    image text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;

-- create table cart

CREATE TABLE IF NOT EXISTS public.cart
(
    customer_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    product_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    quantity integer DEFAULT 0,
    CONSTRAINT cart_pkey PRIMARY KEY (customer_id, product_id),
    CONSTRAINT cart_customer_id_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT cart_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES public.product (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cart
    OWNER to postgres;
	
-- create table invoice

CREATE TABLE IF NOT EXISTS public.invoice
(
    customer_id character varying(4) COLLATE pg_catalog."default",
    invoice_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    status boolean,
    total numeric,
    date date,
    CONSTRAINT invoice_pkey PRIMARY KEY (invoice_id),
    CONSTRAINT invoice_customer_id_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.invoice
    OWNER to postgres;
	
	
-- create table detail_invoice

CREATE TABLE IF NOT EXISTS public.detail_invoice
(
    product_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    invoice_id character varying(6) COLLATE pg_catalog."default" NOT NULL,
    quantity integer DEFAULT 0,
    CONSTRAINT detail_invoice_pkey PRIMARY KEY (product_id, invoice_id),
    CONSTRAINT detail_invoice_invoice_id_fkey FOREIGN KEY (invoice_id)
        REFERENCES public.invoice (invoice_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT detail_invoice_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES public.product (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detail_invoice
    OWNER to postgres;
	
