CREATE TABLE IF NOT EXISTS public."user"
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    login character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT login_index_unique UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS customer
(
    id serial NOT NULL PRIMARY KEY,
    created timestamp without time zone NOT NULL,
    address text NOT NULL,
    phone character varying(30) NOT NULL,
    email character varying(255) NOT NULL,
    subscription_date timestamp without time zone NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT user_id_index_unique UNIQUE (user_id),
    CONSTRAINT customer_user_fk FOREIGN KEY (user_id)
        REFERENCES public."user" (id)
);

CREATE TABLE IF NOT EXISTS category
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    name character varying(255)  NOT NULL,
    description character varying(255) NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    name character varying(255)  NOT NULL,
    description text NOT NULL,
    status character varying(255)  NOT NULL,
    price numeric NOT NULL,
    quantity integer NOT NULL,
    sales_counter integer NOT NULL,
    category_id integer,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT category_product FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS review
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    rating integer NOT NULL,
    text character varying(255) NOT NULL,
    product_id integer NOT NULL,
    CONSTRAINT review_pkey PRIMARY KEY (id),
    CONSTRAINT product3_id FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS cart
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    customer_id integer NOT NULL,
    CONSTRAINT cart_pkey PRIMARY KEY (id),
    CONSTRAINT customer_cart_fk FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS payment
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    status character varying(255)  NOT NULL,
    paypal_payment_id character varying(255) NOT NULL,
    CONSTRAINT payment_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."order"
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    total_price numeric NOT NULL,
    status character varying(255)  NOT NULL,
    shipment_address character varying(255) NOT NULL,
    shipment_date timestamp without time zone NOT NULL,
    payment_id integer NOT NULL,
    cart_id integer NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (id),
    CONSTRAINT cart_order_fk FOREIGN KEY (cart_id)
        REFERENCES public.cart (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT payment_order_fk FOREIGN KEY (payment_id)
        REFERENCES public.payment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.order_item
(
    id serial NOT NULL,
    created timestamp without time zone NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL,
    order_id integer NOT NULL,
    CONSTRAINT orderitem_pkey PRIMARY KEY (id),
    CONSTRAINT orderitem_order_fk FOREIGN KEY (order_id)
        REFERENCES public."order" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
