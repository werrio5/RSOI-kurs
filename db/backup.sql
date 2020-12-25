PGDMP     !                    x            rsoi-db    13.1    13.1 5    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    rsoi-db    DATABASE     f   CREATE DATABASE "rsoi-db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "rsoi-db";
                postgres    false            �            1259    16484 	   employees    TABLE     �   CREATE TABLE public.employees (
    "employeeId" integer NOT NULL,
    fio text NOT NULL,
    "isAvailable" boolean NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            �            1259    16482    employees_employeeId_seq    SEQUENCE     �   ALTER TABLE public.employees ALTER COLUMN "employeeId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."employees_employeeId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �            1259    16440    routes    TABLE        CREATE TABLE public.routes (
    "routeId" integer NOT NULL,
    sign text NOT NULL,
    "transportNeeded" integer NOT NULL
);
    DROP TABLE public.routes;
       public         heap    postgres    false            �            1259    16450    routesStops    TABLE     �   CREATE TABLE public."routesStops" (
    "routesStopsId" integer NOT NULL,
    "routeId" integer NOT NULL,
    "stopId" integer NOT NULL,
    "stopOrder" integer
);
 !   DROP TABLE public."routesStops";
       public         heap    postgres    false            �            1259    16448    routesStops_routesStopsId_seq    SEQUENCE     �   ALTER TABLE public."routesStops" ALTER COLUMN "routesStopsId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."routesStops_routesStopsId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    207            �            1259    16438    routes_routeId_seq    SEQUENCE     �   ALTER TABLE public.routes ALTER COLUMN "routeId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."routes_routeId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    16494    schedule    TABLE     �   CREATE TABLE public.schedule (
    "recordId" integer NOT NULL,
    "workOrder" integer NOT NULL,
    route integer NOT NULL,
    driver integer NOT NULL,
    transport integer NOT NULL
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            �            1259    16492    schedule_recordId_seq    SEQUENCE     �   ALTER TABLE public.schedule ALTER COLUMN "recordId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."schedule_recordId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            �            1259    16407    stops    TABLE     L   CREATE TABLE public.stops (
    "stopId" integer NOT NULL,
    name text
);
    DROP TABLE public.stops;
       public         heap    postgres    false            �            1259    16405    stops_stopId_seq    SEQUENCE     �   ALTER TABLE public.stops ALTER COLUMN "stopId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."stops_stopId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    16417    timings    TABLE     �   CREATE TABLE public.timings (
    "timingId" integer NOT NULL,
    departure integer NOT NULL,
    destination integer,
    "time" integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.timings;
       public         heap    postgres    false            �            1259    16415    timings_timingId_seq    SEQUENCE     �   ALTER TABLE public.timings ALTER COLUMN "timingId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."timings_timingId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    16474 	   transport    TABLE     �   CREATE TABLE public.transport (
    "transportId" integer NOT NULL,
    number text NOT NULL,
    "isAvailable" boolean NOT NULL
);
    DROP TABLE public.transport;
       public         heap    postgres    false            �            1259    16472    transport_transportId_seq    SEQUENCE     �   ALTER TABLE public.transport ALTER COLUMN "transportId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."transport_transportId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �          0    16484 	   employees 
   TABLE DATA           E   COPY public.employees ("employeeId", fio, "isAvailable") FROM stdin;
    public          postgres    false    211   p:       �          0    16440    routes 
   TABLE DATA           D   COPY public.routes ("routeId", sign, "transportNeeded") FROM stdin;
    public          postgres    false    205   �:       �          0    16450    routesStops 
   TABLE DATA           Z   COPY public."routesStops" ("routesStopsId", "routeId", "stopId", "stopOrder") FROM stdin;
    public          postgres    false    207   �:       �          0    16494    schedule 
   TABLE DATA           U   COPY public.schedule ("recordId", "workOrder", route, driver, transport) FROM stdin;
    public          postgres    false    213   �:       �          0    16407    stops 
   TABLE DATA           /   COPY public.stops ("stopId", name) FROM stdin;
    public          postgres    false    201   ;       �          0    16417    timings 
   TABLE DATA           M   COPY public.timings ("timingId", departure, destination, "time") FROM stdin;
    public          postgres    false    203   .;       �          0    16474 	   transport 
   TABLE DATA           I   COPY public.transport ("transportId", number, "isAvailable") FROM stdin;
    public          postgres    false    209   [;       �           0    0    employees_employeeId_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."employees_employeeId_seq"', 1, true);
          public          postgres    false    210            �           0    0    routesStops_routesStopsId_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."routesStops_routesStopsId_seq"', 4, true);
          public          postgres    false    206                        0    0    routes_routeId_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."routes_routeId_seq"', 1, true);
          public          postgres    false    204                       0    0    schedule_recordId_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."schedule_recordId_seq"', 1, true);
          public          postgres    false    212                       0    0    stops_stopId_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."stops_stopId_seq"', 2, true);
          public          postgres    false    200                       0    0    timings_timingId_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."timings_timingId_seq"', 2, true);
          public          postgres    false    202                       0    0    transport_transportId_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."transport_transportId_seq"', 2, true);
          public          postgres    false    208            [           2606    16491    employees employees_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY ("employeeId");
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    211            W           2606    16454    routesStops routesStops_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT "routesStops_pkey" PRIMARY KEY ("routesStopsId");
 J   ALTER TABLE ONLY public."routesStops" DROP CONSTRAINT "routesStops_pkey";
       public            postgres    false    207            S           2606    16447    routes routes_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY ("routeId");
 <   ALTER TABLE ONLY public.routes DROP CONSTRAINT routes_pkey;
       public            postgres    false    205            `           2606    16498    schedule schedule_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY ("recordId");
 @   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pkey;
       public            postgres    false    213            M           2606    16411    stops stops_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.stops
    ADD CONSTRAINT stops_pkey PRIMARY KEY ("stopId");
 :   ALTER TABLE ONLY public.stops DROP CONSTRAINT stops_pkey;
       public            postgres    false    201            Q           2606    16424    timings timings_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.timings
    ADD CONSTRAINT timings_pkey PRIMARY KEY ("timingId");
 >   ALTER TABLE ONLY public.timings DROP CONSTRAINT timings_pkey;
       public            postgres    false    203            Y           2606    16481    transport transport_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY ("transportId");
 B   ALTER TABLE ONLY public.transport DROP CONSTRAINT transport_pkey;
       public            postgres    false    209            \           1259    16510 
   fki_driver    INDEX     A   CREATE INDEX fki_driver ON public.schedule USING btree (driver);
    DROP INDEX public.fki_driver;
       public            postgres    false    213            N           1259    16436    fki_end    INDEX     B   CREATE INDEX fki_end ON public.timings USING btree (destination);
    DROP INDEX public.fki_end;
       public            postgres    false    203            ]           1259    16504 	   fki_route    INDEX     ?   CREATE INDEX fki_route ON public.schedule USING btree (route);
    DROP INDEX public.fki_route;
       public            postgres    false    213            O           1259    16430 	   fki_start    INDEX     B   CREATE INDEX fki_start ON public.timings USING btree (departure);
    DROP INDEX public.fki_start;
       public            postgres    false    203            T           1259    16471    fki_stop    INDEX     F   CREATE INDEX fki_stop ON public."routesStops" USING btree ("stopId");
    DROP INDEX public.fki_stop;
       public            postgres    false    207            U           1259    16460 
   fki_stopId    INDEX     K   CREATE INDEX "fki_stopId" ON public."routesStops" USING btree ("routeId");
     DROP INDEX public."fki_stopId";
       public            postgres    false    207            ^           1259    16516    fki_transport    INDEX     G   CREATE INDEX fki_transport ON public.schedule USING btree (transport);
 !   DROP INDEX public.fki_transport;
       public            postgres    false    213            f           2606    16505    schedule driver    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT driver FOREIGN KEY (driver) REFERENCES public.employees("employeeId") NOT VALID;
 9   ALTER TABLE ONLY public.schedule DROP CONSTRAINT driver;
       public          postgres    false    211    213    2907            b           2606    16431    timings end    FK CONSTRAINT     �   ALTER TABLE ONLY public.timings
    ADD CONSTRAINT "end" FOREIGN KEY (destination) REFERENCES public.stops("stopId") NOT VALID;
 7   ALTER TABLE ONLY public.timings DROP CONSTRAINT "end";
       public          postgres    false    201    203    2893            c           2606    16461    routesStops route    FK CONSTRAINT     �   ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT route FOREIGN KEY ("routeId") REFERENCES public.routes("routeId") NOT VALID;
 =   ALTER TABLE ONLY public."routesStops" DROP CONSTRAINT route;
       public          postgres    false    205    2899    207            e           2606    16499    schedule route    FK CONSTRAINT     }   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT route FOREIGN KEY (route) REFERENCES public.routes("routeId") NOT VALID;
 8   ALTER TABLE ONLY public.schedule DROP CONSTRAINT route;
       public          postgres    false    205    2899    213            a           2606    16425    timings start    FK CONSTRAINT     ~   ALTER TABLE ONLY public.timings
    ADD CONSTRAINT start FOREIGN KEY (departure) REFERENCES public.stops("stopId") NOT VALID;
 7   ALTER TABLE ONLY public.timings DROP CONSTRAINT start;
       public          postgres    false    201    203    2893            d           2606    16466    routesStops stop    FK CONSTRAINT     �   ALTER TABLE ONLY public."routesStops"
    ADD CONSTRAINT stop FOREIGN KEY ("stopId") REFERENCES public.stops("stopId") NOT VALID;
 <   ALTER TABLE ONLY public."routesStops" DROP CONSTRAINT stop;
       public          postgres    false    2893    201    207            g           2606    16511    schedule transport    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT transport FOREIGN KEY (transport) REFERENCES public.transport("transportId") NOT VALID;
 <   ALTER TABLE ONLY public.schedule DROP CONSTRAINT transport;
       public          postgres    false    213    2905    209            �      x�3�ttt�,����� -      �      x�3�T642�4����� J�      �      x�3�4A.0m����� Y�      �      x�3�4�@�=... �      �      x�3�,.�/P0�2�0��b���� H�a      �      x�3�4�4�4�2R@�!����� +�W      �      x�3�L442NL�,�2�4�L����� 4	     