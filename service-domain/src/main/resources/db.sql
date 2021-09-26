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