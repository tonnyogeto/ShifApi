--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4 (Ubuntu 16.4-1.pgdg22.04+2)
-- Dumped by pg_dump version 17.0 (Ubuntu 17.0-1.pgdg22.04+1)

-- Started on 2024-11-08 23:23:08 EAT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 862 (class 1247 OID 25490)
-- Name: plan; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.plan AS ENUM (
    'monthly',
    'annually'
);


--
-- TOC entry 856 (class 1247 OID 25472)
-- Name: status; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.status AS ENUM (
    'approved',
    'rejected',
    'pending'
);


--
-- TOC entry 217 (class 1259 OID 25479)
-- Name: claims; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.claims (
    id integer NOT NULL,
    hospital_visit_id integer NOT NULL,
    status public.status NOT NULL
);


--
-- TOC entry 221 (class 1259 OID 25521)
-- Name: claim_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.claim_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 221
-- Name: claim_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.claim_id_seq OWNED BY public.claims.id;


--
-- TOC entry 225 (class 1259 OID 25525)
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


--
-- TOC entry 216 (class 1259 OID 25460)
-- Name: hospital_visits; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.hospital_visits (
    id integer NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id integer NOT NULL
);


--
-- TOC entry 222 (class 1259 OID 25522)
-- Name: hospital_visit_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.hospital_visit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 222
-- Name: hospital_visit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.hospital_visit_id_seq OWNED BY public.hospital_visits.id;


--
-- TOC entry 219 (class 1259 OID 25507)
-- Name: payments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.payments (
    id integer NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id integer NOT NULL,
    amount_paid numeric NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 25523)
-- Name: payment_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 223
-- Name: payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.payment_id_seq OWNED BY public.payments.id;


--
-- TOC entry 218 (class 1259 OID 25495)
-- Name: user_payment_plan; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_payment_plan (
    id integer NOT NULL,
    user_id integer NOT NULL,
    payment_plan public.plan NOT NULL,
    amount numeric NOT NULL
);


--
-- TOC entry 224 (class 1259 OID 25524)
-- Name: user_payment_plan_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.user_payment_plan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_payment_plan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.user_payment_plan_id_seq OWNED BY public.user_payment_plan.id;


--
-- TOC entry 215 (class 1259 OID 25451)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    image bytea NOT NULL,
    id_number character varying(50)
);


--
-- TOC entry 220 (class 1259 OID 25520)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 220
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3260 (class 2606 OID 25483)
-- Name: claims claims_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.claims
    ADD CONSTRAINT claims_pkey PRIMARY KEY (id);


--
-- TOC entry 3266 (class 2606 OID 25532)
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- TOC entry 3258 (class 2606 OID 25465)
-- Name: hospital_visits hospital_visits_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospital_visits
    ADD CONSTRAINT hospital_visits_pkey PRIMARY KEY (id);


--
-- TOC entry 3264 (class 2606 OID 25514)
-- Name: payments payments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT payments_pkey PRIMARY KEY (id);


--
-- TOC entry 3262 (class 2606 OID 25501)
-- Name: user_payment_plan user_payment_plan_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_payment_plan
    ADD CONSTRAINT user_payment_plan_pkey PRIMARY KEY (id);


--
-- TOC entry 3254 (class 2606 OID 25459)
-- Name: users users_id_number_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_number_key UNIQUE (id_number);


--
-- TOC entry 3256 (class 2606 OID 25457)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3267 (class 1259 OID 25533)
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- TOC entry 3269 (class 2606 OID 25484)
-- Name: claims claims_hospital_visit_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.claims
    ADD CONSTRAINT claims_hospital_visit_id_fkey FOREIGN KEY (hospital_visit_id) REFERENCES public.hospital_visits(id);


--
-- TOC entry 3268 (class 2606 OID 25466)
-- Name: hospital_visits hospital_visits_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospital_visits
    ADD CONSTRAINT hospital_visits_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3271 (class 2606 OID 25515)
-- Name: payments payments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT payments_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3270 (class 2606 OID 25502)
-- Name: user_payment_plan user_payment_plan_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_payment_plan
    ADD CONSTRAINT user_payment_plan_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2024-11-08 23:23:08 EAT

--
-- PostgreSQL database dump complete
--
