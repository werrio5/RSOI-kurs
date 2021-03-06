--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2020-12-25 15:05:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16484)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    "employeeId" integer NOT NULL,
    fio text NOT NULL,
    "isAvailable" boolean NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16482)
-- Name: employees_employeeId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employees ALTER COLUMN "employeeId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."employees_employeeId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 16440)
-- Name: routes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.routes (
    "routeId" integer NOT NULL,
    sign text NOT NULL,
    "transportNeeded" integer NOT NULL
);


ALTER TABLE public.routes OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16450)
-- Name: routesStops; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."routesStops" (
    "routesStopsId" integer NOT NULL,
    "routeId" integer NOT NULL,
    "stopId" integer NOT NULL,
    "stopOrder" integer
);


ALTER TABLE public."routesStops" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16448)
-- Name: routesStops_routesStopsId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."routesStops" ALTER COLUMN "routesStopsId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."routesStops_routesStopsId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 16438)
-- Name: routes_routeId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.routes ALTER COLUMN "routeId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."routes_routeId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 16494)
-- Name: schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schedule (
    "recordId" integer NOT NULL,
    "workOrder" integer NOT NULL,
    route integer NOT NULL,
    driver integer NOT NULL,
    transport integer NOT NULL
);


ALTER TABLE public.schedule OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16492)
-- Name: schedule_recordId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.schedule ALTER COLUMN "recordId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."schedule_recordId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 16407)
-- Name: stops; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stops (
    "stopId" integer NOT NULL,
    name text
);


ALTER TABLE public.stops OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16405)
-- Name: stops_stopId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.stops ALTER COLUMN "stopId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."stops_stopId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16417)
-- Name: timings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.timings (
    "timingId" integer NOT NULL,
    departure integer NOT NULL,
    destination integer,
    "time" integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.timings OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16415)
-- Name: timings_timingId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.timings ALTER COLUMN "timingId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."timings_timingId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 16474)
-- Name: transport; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transport (
    "transportId" integer NOT NULL,
    number text NOT NULL,
    "isAvailable" boolean NOT NULL
);


ALTER TABLE public.transport OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16472)
-- Name: transport_transportId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.transport ALTER COLUMN "transportId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."transport_transportId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3061 (class 0 OID 16484)
-- Dependencies: 211
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees ("employeeId", fio, "isAvailable") FROM stdin;
1	AAA	t
\.


--
-- TOC entry 3055 (class 0 OID 16440)
-- Dependencies: 205
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.routes ("routeId", sign, "transportNeeded") FROM stdin;
1	#123	1
\.


--
-- TOC entry 3057 (class 0 OID 16450)
-- Dependencies: 207
-- Data for Name: routesStops; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."routesStops" ("routesStopsId", "routeId", "stopId", "stopOrder") FROM stdin;
3	1	1	1
4	1	1	2
\.


--
-- TOC entry 3063 (class 0 OID 16494)
-- Dependencies: 213
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.schedule ("recordId", "workOrder", route, driver, transport) FROM stdin;
1	1	1	1	1
\.


--
-- TOC entry 3051 (class 0 OID 16407)
-- Dependencies: 201
-- Data for Name: stops; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stops ("stopId", name) FROM stdin;
1	stop 1
2	stop 2
\.


--
-- TOC entry 3053 (class 0 OID 16417)
-- Dependencies: 203
-- Data for Name: timings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.timings ("timingId", departure, destination, "time") FROM stdin;
1	1	2	93
2	2	1	2193
\.


--
-- TOC entry 3059 (class 0 OID 16474)
-- Dependencies: 209
-- Data for Name: transport; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transport ("transportId", number, "isAvailable") FROM stdin;
1	a123aa	t
2	2	f
\.


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 210
-- Name: employees_employeeId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."employees_employeeId_seq"', 1, true);


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 206
-- Name: routesStops_routesStopsId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."routesStops_routesStopsId_seq"', 4, true);


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 204
-- Name: routes_routeId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."routes_routeId_seq"', 1, true);


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 212
-- Name: schedule_recordId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."schedule_recordId_seq"', 1, true);


--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 200
-- Name: stops_stopId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."stops_stopId_seq"', 2, true);


--
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 202
-- Name: timings_timingId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."timings_timingId_seq"', 2, true);


--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 208
-- Name: transport_transportId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."transport_transportId_seq"', 2, true);


--
-- TOC entry 2907 (class 2606 OID 16491)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY ("employeeId");


--
-- TOC entry 2903 (class 2606 OID 16454)
-- Name: routesStops routesStops_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT "routesStops_pkey" PRIMARY KEY ("routesStopsId");


--
-- TOC entry 2899 (class 2606 OID 16447)
-- Name: routes routes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY ("routeId");


--
-- TOC entry 2912 (class 2606 OID 16498)
-- Name: schedule schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY ("recordId");


--
-- TOC entry 2893 (class 2606 OID 16411)
-- Name: stops stops_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stops
    ADD CONSTRAINT stops_pkey PRIMARY KEY ("stopId");


--
-- TOC entry 2897 (class 2606 OID 16424)
-- Name: timings timings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timings
    ADD CONSTRAINT timings_pkey PRIMARY KEY ("timingId");


--
-- TOC entry 2905 (class 2606 OID 16481)
-- Name: transport transport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY ("transportId");


--
-- TOC entry 2908 (class 1259 OID 16510)
-- Name: fki_driver; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_driver ON public.schedule USING btree (driver);


--
-- TOC entry 2894 (class 1259 OID 16436)
-- Name: fki_end; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_end ON public.timings USING btree (destination);


--
-- TOC entry 2909 (class 1259 OID 16504)
-- Name: fki_route; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_route ON public.schedule USING btree (route);


--
-- TOC entry 2895 (class 1259 OID 16430)
-- Name: fki_start; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_start ON public.timings USING btree (departure);


--
-- TOC entry 2900 (class 1259 OID 16471)
-- Name: fki_stop; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_stop ON public."routesStops" USING btree ("stopId");


--
-- TOC entry 2901 (class 1259 OID 16460)
-- Name: fki_stopId; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_stopId" ON public."routesStops" USING btree ("routeId");


--
-- TOC entry 2910 (class 1259 OID 16516)
-- Name: fki_transport; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_transport ON public.schedule USING btree (transport);


--
-- TOC entry 2918 (class 2606 OID 16505)
-- Name: schedule driver; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT driver FOREIGN KEY (driver) REFERENCES public.employees("employeeId") NOT VALID;


--
-- TOC entry 2914 (class 2606 OID 16431)
-- Name: timings end; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timings
    ADD CONSTRAINT "end" FOREIGN KEY (destination) REFERENCES public.stops("stopId") NOT VALID;


--
-- TOC entry 2915 (class 2606 OID 16461)
-- Name: routesStops route; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT route FOREIGN KEY ("routeId") REFERENCES public.routes("routeId") NOT VALID;


--
-- TOC entry 2917 (class 2606 OID 16499)
-- Name: schedule route; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT route FOREIGN KEY (route) REFERENCES public.routes("routeId") NOT VALID;


--
-- TOC entry 2913 (class 2606 OID 16425)
-- Name: timings start; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timings
    ADD CONSTRAINT start FOREIGN KEY (departure) REFERENCES public.stops("stopId") NOT VALID;


--
-- TOC entry 2916 (class 2606 OID 16466)
-- Name: routesStops stop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT stop FOREIGN KEY ("stopId") REFERENCES public.stops("stopId") NOT VALID;


--
-- TOC entry 2919 (class 2606 OID 16511)
-- Name: schedule transport; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT transport FOREIGN KEY (transport) REFERENCES public.transport("transportId") NOT VALID;


-- Completed on 2020-12-25 15:05:54

--
-- PostgreSQL database dump complete
--

