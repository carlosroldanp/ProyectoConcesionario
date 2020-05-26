-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2020 a las 18:54:35
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_concesionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(10) NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `apellido1`, `apellido2`, `telefono`) VALUES
(1, 'Marcos', 'Martínez', 'Fernández', 687613920),
(2, 'Carlos', 'García', 'Martínez', 699788130),
(3, 'Manuel', 'Rodríguez', 'Fernández', 654122233),
(4, 'Alberto', 'Sánchez', 'Muñoz', 676256548),
(5, 'Daniel', 'Palomar', 'López', 626362412),
(6, 'Juan', 'Ruiz', 'Gómez', 689122254),
(7, 'Agustín', 'Fernández', 'Pascal', 644788968),
(8, 'Pedro', 'García', 'Moreno', 630456878),
(9, 'Alfonso', 'Campos', 'Sanz', 645878238),
(10, 'Carlos', 'Sáez', 'Rodríguez', 655201540);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE `coches` (
  `id_coche` int(10) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(150) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`id_coche`, `marca`, `modelo`, `tipo`) VALUES
(1, 'Mercedes', 'Clase A', 'Deportivo'),
(2, 'Citroën', 'C4 Cactus', 'SUV'),
(3, 'Audi', 'A6', 'Berlina'),
(4, 'Land Rover', 'Range Rover Velar', 'Todoterreno'),
(5, 'Renault', 'Captur', 'SUV'),
(6, 'Seat', 'León', 'Deportivo'),
(7, 'Ford', 'Mondeo', 'Berlina'),
(8, 'Land Rover', 'Discovery', 'Todoterreno'),
(9, 'Chevrolet', 'Camaro', 'Deportivo'),
(10, 'Ford', 'Focus', 'Deportivo'),
(11, 'Tesla', 'Roadster', 'Deportivo Eléctrico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modalidades`
--

CREATE TABLE `modalidades` (
  `id_modalidad` int(10) NOT NULL,
  `tipo_modalidad` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modalidades`
--

INSERT INTO `modalidades` (`id_modalidad`, `tipo_modalidad`) VALUES
(1, 'Profesional'),
(2, 'Particular');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(10) NOT NULL,
  `precio_venta` float NOT NULL,
  `id_coche` int(10) NOT NULL,
  `id_cliente` int(10) NOT NULL,
  `id_modalidad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `precio_venta`, `id_coche`, `id_cliente`, `id_modalidad`) VALUES
(1, 25000, 11, 8, 2),
(2, 15000, 3, 7, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `coches`
--
ALTER TABLE `coches`
  ADD PRIMARY KEY (`id_coche`);

--
-- Indices de la tabla `modalidades`
--
ALTER TABLE `modalidades`
  ADD PRIMARY KEY (`id_modalidad`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_coche` (`id_coche`) USING BTREE,
  ADD KEY `id_cliente` (`id_cliente`) USING BTREE,
  ADD KEY `id_modalidad` (`id_modalidad`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `coches`
--
ALTER TABLE `coches`
  MODIFY `id_coche` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `modalidades`
--
ALTER TABLE `modalidades`
  MODIFY `id_modalidad` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `fk_venta_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `fk_venta_coche` FOREIGN KEY (`id_coche`) REFERENCES `coches` (`id_coche`),
  ADD CONSTRAINT `fk_venta_modalidad` FOREIGN KEY (`id_modalidad`) REFERENCES `modalidades` (`id_modalidad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
