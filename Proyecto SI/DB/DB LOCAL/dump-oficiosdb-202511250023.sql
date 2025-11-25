--
-- PostgreSQL database cluster dump
--

-- Started on 2025-11-25 00:23:16

\restrict NO74Me1gENZb34ZQaSGcSfuQz7nC241fdUa2wMyDSFISDSTWWspyQ1FxZrHRdgZ

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE admin;
ALTER ROLE admin WITH NOSUPERUSER INHERIT CREATEROLE CREATEDB LOGIN NOREPLICATION NOBYPASSRLS;
CREATE ROLE datadog;
ALTER ROLE datadog WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION NOBYPASSRLS;
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;
CREATE ROLE primaryuser;
ALTER ROLE primaryuser WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN REPLICATION NOBYPASSRLS;

--
-- User Configurations
--


--
-- Role memberships
--

GRANT pg_monitor TO datadog WITH INHERIT TRUE GRANTED BY postgres;






\unrestrict NO74Me1gENZb34ZQaSGcSfuQz7nC241fdUa2wMyDSFISDSTWWspyQ1FxZrHRdgZ

--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

\restrict sqpUsPz6WYZyMEvcQvpyjw0FWB1eE0vfCijmfb2X0XtmMj0Wuau9zebWdSN1sgu

-- Dumped from database version 18.1 (Debian 18.1-1.pgdg12+2)
-- Dumped by pg_dump version 18.1

-- Started on 2025-11-25 00:23:17

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

-- Completed on 2025-11-25 00:23:24

--
-- PostgreSQL database dump complete
--

\unrestrict sqpUsPz6WYZyMEvcQvpyjw0FWB1eE0vfCijmfb2X0XtmMj0Wuau9zebWdSN1sgu

--
-- Database "oficiosdb" dump
--

--
-- PostgreSQL database dump
--

\restrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ

-- Dumped from database version 18.1 (Debian 18.1-1.pgdg12+2)
-- Dumped by pg_dump version 18.1

-- Started on 2025-11-25 00:23:24

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
-- TOC entry 3408 (class 1262 OID 16389)
-- Name: oficiosdb; Type: DATABASE; Schema: -; Owner: admin
--

CREATE DATABASE oficiosdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF8';


ALTER DATABASE oficiosdb OWNER TO admin;

\unrestrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ
\connect oficiosdb
\restrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ

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
-- TOC entry 3409 (class 0 OID 0)
-- Name: oficiosdb; Type: DATABASE PROPERTIES; Schema: -; Owner: admin
--

ALTER DATABASE oficiosdb SET "TimeZone" TO 'utc';


\unrestrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ
\connect oficiosdb
\restrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ

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
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: admin
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO admin;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 16422)
-- Name: oficios; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.oficios (
    num_oficio character varying(20) NOT NULL,
    id_persona integer NOT NULL,
    asunto text NOT NULL,
    fecha date NOT NULL,
    hash character varying(64) NOT NULL
);


ALTER TABLE public.oficios OWNER TO admin;

--
-- TOC entry 222 (class 1259 OID 16413)
-- Name: personas; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.personas (
    id_persona integer NOT NULL,
    nombre character varying(100) NOT NULL,
    area character varying(50) NOT NULL
);


ALTER TABLE public.personas OWNER TO admin;

--
-- TOC entry 221 (class 1259 OID 16412)
-- Name: personas_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.personas_id_persona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.personas_id_persona_seq OWNER TO admin;

--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 221
-- Name: personas_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.personas_id_persona_seq OWNED BY public.personas.id_persona;


--
-- TOC entry 220 (class 1259 OID 16399)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    nombre_usuario character varying(50) NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.usuarios OWNER TO admin;

--
-- TOC entry 219 (class 1259 OID 16398)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.usuarios_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuarios_id_usuario_seq OWNER TO admin;

--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 219
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin
--

ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuarios.id_usuario;


--
-- TOC entry 3239 (class 2604 OID 16416)
-- Name: personas id_persona; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.personas ALTER COLUMN id_persona SET DEFAULT nextval('public.personas_id_persona_seq'::regclass);


--
-- TOC entry 3238 (class 2604 OID 16402)
-- Name: usuarios id_usuario; Type: DEFAULT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 3402 (class 0 OID 16422)
-- Dependencies: 223
-- Data for Name: oficios; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.oficios (num_oficio, id_persona, asunto, fecha, hash) FROM stdin;
DG-OF-2025-001	1	Solicitud de informe trimestral de gastos.	2025-09-01	a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
RH-OF-2025-002	2	Confirmación de proceso de reclutamiento para área legal.	2025-09-02	b1a2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
IT-OF-2025-003	3	Autorización para compra de nuevo hardware de red.	2025-09-03	c1b2a3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
AC-OF-2025-004	4	Reporte de quejas ciudadanas mes de agosto.	2025-09-04	d1c2b3a4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
CT-OF-2025-005	5	Comprobantes fiscales pendientes de validación.	2025-09-05	e1d2c3b4a5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
AG-OF-2025-006	6	Respuesta a solicitud de vacaciones del personal.	2025-09-06	f1e2d3c4b5a6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
SV-OF-2025-007	7	Plan de mantenimiento preventivo de equipos.	2025-09-07	g1f2e3d4c5b6a7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
DV-OF-2025-008	8	Aviso de cambios en política de precios.	2025-09-08	h1g2f3e4d5c6b7a8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
DE-OF-2025-009	9	Agenda para la reunión de directores de semana próxima.	2025-09-09	i1h2g3f4e5d6c7b8a9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
CZ-OF-2025-020	10	Notificación de nuevo proveedor de servicios de limpieza.	2025-09-10	j1i2h3g4f5e6d7c8b9a0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-011	11	Requerimiento de apoyo para auditoría interna.	2025-09-11	k1j2i3h4g5f6e7d8c9b0a1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-012	12	Entrega de balance financiero del mes anterior.	2025-09-12	l1k2j3i4h5g6f7e8d9c0b1a2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-013	13	Asignación de equipo para proyecto de modernización.	2025-09-13	m1l2k3j4i5h6g7f8e9d0c1b2a3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-014	14	Autorización para viaje de trabajo a sucursal norte.	2025-09-14	n1m2l3k4j5i6h7g8f9e0d1c2b3a4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-015	15	Notificación de evento corporativo del mes de octubre.	2025-09-15	o1n2m3l4k5j6i7h8g9f0e1d2c3b4a5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-016	16	Documento de políticas internas de comunicación.	2025-09-16	p1o2n3m4l5k6j7i8h9g0f1e2d3c4b5a6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-017	17	Actualización del inventario de bienes muebles.	2025-09-17	q1p2o3n4m5l6k7j8i9h0g1f2e3d4c5b6a7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-018	18	Entrega de documentación para nuevo empleado.	2025-09-18	r1q2p3o4n5m6l7k8j9i0h1g2f3e4d5c6b7a8s9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-019	19	Seguimiento a dictamen médico-legal caso 123.	2025-09-19	s1r2q3p4o5n6m7l8k9j0i1h2g3f4e5d6c7b8a9t0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-020	20	Cierre de ciclo fiscal y revisión de presupuestos.	2025-09-20	t1s2r3q4p5o6n7m8l9k0j1i2h3g4f5e6d7c8b9a0u1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-021	1	Ampliación de plazo para entrega de informe trimestral.	2025-09-21	u1t2s3r4q5p6o7n8m9l0k1j2i3h4g5f6e7d8c9b0a1v2w3x4y5z6a7b8c9d0e1f2
OF-2025-022	5	Aprobación de gastos menores para el área de Contabilidad.	2025-09-22	v1u2t3s4r5q6p7o8n9m0l1k2j3i4h5g6f7e8d9c0b1a2w3x4y5z6a7b8c9d0e1f2
OF-2025-023	10	Revisión final de contrato con nuevo proveedor.	2025-09-23	w1v2u3t4s5r6q7p8o9n0m1l2k3j4i5h6g7f8e9d0c1b2a3x4y5z6a7b8c9d0e1f2
OF-2025-024	15	Preparación de materiales para la siguiente junta de directores.	2025-09-24	x1w2v3u4t5s6r7q8p9o0n1m2l3k4j5i6h7g8f9e0d1c2b3a4y5z6a7b8c9d0e1f2
OF-2025-025	20	Documentación sobre capacitación de sistemas.	2025-09-25	y1x2w3v4u5t6s7r8q9p0o1n2m3l4k5j6i7h8g9f0e1d2c3b4a5z6a7b8c9d0e1f2
\.


--
-- TOC entry 3401 (class 0 OID 16413)
-- Dependencies: 222
-- Data for Name: personas; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.personas (id_persona, nombre, area) FROM stdin;
1	Ana Gabriela Rojas	Recursos Humanos
2	Roberto Cárdenas Soto	Médico Legal
3	Elías Vidal Ríos	Infraestructura y Sistemas
4	Elena Jiménez Gómez	Atención Ciudadana
5	Carlos Fuentes Mora	Contabilidad
6	Lucía Hernández	Asuntos Generales
7	Ricardo Mendoza	Asuntos Generales
8	Sofía Torres	Ventas y Servicios
9	Pedro Sánchez	Ventas y Servicios
10	María García	Dirección Ejecutiva
11	Javier Ortiz	Contabilidad
12	Javier Ortiz	Tesorería
13	Laura Ramírez	Servicios
14	Laura Ramírez	Auditoría
15	Moisés Dávila	Comunicaciones
16	Verónica Castillo	Secretaría Técnica
17	Arturo Peña	Logística
18	Norma Del Río	Recursos Humanos
19	Héctor Guzmán	Médico Legal
20	Estela Flores	Contabilidad
\.


--
-- TOC entry 3399 (class 0 OID 16399)
-- Dependencies: 220
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.usuarios (id_usuario, nombre_usuario, password) FROM stdin;
1	beto	1234
2	axel	2345
3	zamitis	3456
8	raul	1606
9	diego	5678
10	marco	6789
\.


--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 221
-- Name: personas_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.personas_id_persona_seq', 20, true);


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 219
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 10, true);


--
-- TOC entry 3247 (class 2606 OID 16435)
-- Name: oficios oficios_hash_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.oficios
    ADD CONSTRAINT oficios_hash_key UNIQUE (hash);


--
-- TOC entry 3249 (class 2606 OID 16433)
-- Name: oficios oficios_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.oficios
    ADD CONSTRAINT oficios_pkey PRIMARY KEY (num_oficio);


--
-- TOC entry 3245 (class 2606 OID 16421)
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (id_persona);


--
-- TOC entry 3241 (class 2606 OID 16411)
-- Name: usuarios usuarios_nombre_usuario_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_nombre_usuario_key UNIQUE (nombre_usuario);


--
-- TOC entry 3243 (class 2606 OID 16409)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 3250 (class 2606 OID 16436)
-- Name: oficios oficios_id_persona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.oficios
    ADD CONSTRAINT oficios_id_persona_fkey FOREIGN KEY (id_persona) REFERENCES public.personas(id_persona);


--
-- TOC entry 2062 (class 826 OID 16391)
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON SEQUENCES TO admin;


--
-- TOC entry 2064 (class 826 OID 16393)
-- Name: DEFAULT PRIVILEGES FOR TYPES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON TYPES TO admin;


--
-- TOC entry 2063 (class 826 OID 16392)
-- Name: DEFAULT PRIVILEGES FOR FUNCTIONS; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON FUNCTIONS TO admin;


--
-- TOC entry 2061 (class 826 OID 16390)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON TABLES TO admin;


-- Completed on 2025-11-25 00:23:32

--
-- PostgreSQL database dump complete
--

\unrestrict 7bxrkBti7NfrSSfv4CjyW10UwMEaKMxFlqjAxKQhH29VSR21P5bCymxvUVOejGZ

-- Completed on 2025-11-25 00:23:32

--
-- PostgreSQL database cluster dump complete
--

