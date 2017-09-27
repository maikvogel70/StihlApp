-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Sep 2017 um 15:09
-- Server-Version: 10.1.13-MariaDB
-- PHP-Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `stihlonlinedb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bestellung`
--

CREATE TABLE `bestellung` (
  `ID` int(11) NOT NULL,
  `Bestellnummer` varchar(20) COLLATE latin1_german1_ci NOT NULL,
  `Menge` int(11) NOT NULL,
  `Rabatt` decimal(5,2) DEFAULT NULL,
  `Preis` decimal(7,2) DEFAULT NULL,
  `FK_Fuehrungsschienen` int(11) DEFAULT NULL,
  `FK_Kunde` int(11) NOT NULL,
  `FK_Rechnungsnummer` int(11) NOT NULL,
  `FK_Zubehoer` int(11) DEFAULT NULL,
  `FK_Ketten` int(11) DEFAULT NULL,
  `KettenBestNr` varchar(15) COLLATE latin1_german1_ci DEFAULT NULL,
  `FK_Saege` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bildablage`
--

CREATE TABLE `bildablage` (
  `ID` int(11) NOT NULL,
  `Pfad` varchar(255) COLLATE latin1_german1_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `bildablage`
--

INSERT INTO `bildablage` (`ID`, `Pfad`) VALUES
(1, 'ms150ce.jpg'),
(2, 'ms170.jpg'),
(3, 'ms180.jpg'),
(4, 'ms181.jpg'),
(5, 'ms231.jpg'),
(6, 'ms271.jpg'),
(7, 'ms391.jpg'),
(8, '/produkte/STIHL Akku Geräte.jpg'),
(9, '/produkte/Motorsägen und Kettensägen.jpg'),
(10, '/produkte/KombiSysteme und MultiSystem.jpg'),
(11, '/produkte/Motorsensen und Freischneider.jpg'),
(12, '/produkte/Heckenscheren und Heckenschneider.jpg'),
(13, '/produkte/Reinigungsgeräte.jpg'),
(14, '/produkte/Sprüh- und Spritzgeräte.jpg'),
(15, '/produkte/Erdbohrgeräte und Bohrwerkzeuge.jpg'),
(16, '/produkte/Gesteinschneider und Trennschleifer.jpg'),
(17, '/produkte/Zubehör und Betriebsstoffe.jpg'),
(18, '/produkte/Persönliche Schutzausstattung.jpg'),
(19, '/produkte/STIHL Markenshop.jpg'),
(20, '/MotorsägenKettensägen/Privat.jpg'),
(21, '/MotorsägenKettensägen/Forst.jpg'),
(22, '/MotorsägenKettensägen/LandwirtschaftGaLa.jpg'),
(23, '/MotorsägenKettensägen/Spezial.jpg'),
(24, '/MotorsägenKettensägen/Schneidgarnituren und Zubehör.jpg'),
(25, '/MotorsägenKettensägen/Akku.jpg'),
(26, '/MotorsägenKettensägen/Elektro.jpg'),
(27, '/MotorsägenKettensägen/Ketten- und Schienenberater.jpg'),
(28, 'ms311.jpg'),
(29, 'ms461.jpg'),
(30, 'ms880.jpg'),
(31, 'ms193.jpg'),
(32, 'msa160.jpg'),
(33, 'mse210.jpg'),
(34, '/zubehoer/Feilgerät FG 2.jpg'),
(35, '/zubehoer/Führungsschienenrichter.jpg'),
(36, '/zubehoer/Prüflehre.jpg'),
(37, '/zubehoer/Schärfeset.jpg'),
(38, '/schienen/Duromatic E.jpg'),
(39, '/schienen/Rollomatic E Light.jpg'),
(40, '/schienen/Rollomatic E.jpg');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `einsatzzweck`
--

CREATE TABLE `einsatzzweck` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `FK_Bild` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `einsatzzweck`
--

INSERT INTO `einsatzzweck` (`ID`, `Name`, `FK_Bild`) VALUES
(8, 'Ketten- und Schienenberater', 27),
(6, 'Elektro', 26),
(5, 'Akku', 25),
(3, 'Spezial', 23),
(2, 'LandwirtschaftGaLa', 22),
(1, 'Privat', 20),
(0, 'Forst', 21),
(7, 'Schneidgarnituren und Zubehör', 24);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `fuehrungsschienen`
--

CREATE TABLE `fuehrungsschienen` (
  `ID` int(11) NOT NULL,
  `Bestellnummer` varchar(15) COLLATE latin1_german1_ci NOT NULL,
  `Name` varchar(255) COLLATE latin1_german1_ci DEFAULT NULL,
  `Beschreibung` text COLLATE latin1_german1_ci,
  `AnzahlZaehneUmlenkung` tinyint(4) NOT NULL,
  `Laenge` tinyint(4) NOT NULL,
  `Preis` decimal(7,2) DEFAULT NULL,
  `FK_Bild` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `fuehrungsschienen`
--

INSERT INTO `fuehrungsschienen` (`ID`, `Bestellnummer`, `Name`, `Beschreibung`, `AnzahlZaehneUmlenkung`, `Laenge`, `Preis`, `FK_Bild`) VALUES
(1, '3005 000 7405', 'Rollomatic E Light', 'MS 180/211/231', 9, 30, '67.00', 39),
(2, '3005 000 4805', 'Rollomatic E', 'MS 180/211/231', 9, 30, '55.00', 40),
(3, '3005 000 7409', 'Rollomatic E Light', 'MS 180/211/231', 9, 35, '73.00', 39),
(4, '3005 000 7413', 'Rollomatic E', 'MS 180/211/231', 9, 40, '79.00', 39),
(5, '3005 000 4809', 'Rollomatic E Light', 'MS 180/211/231', 9, 35, '61.00', 39),
(6, '3005 000 4813', 'Rollomatic E', 'MS 180/211/231', 9, 40, '67.00', 40),
(7, '3003 000 5306', 'Rollomatic E', 'MS 271', 11, 32, '57.00', 40),
(8, '3003 000 6811', 'Rollomatic E', 'MS 271', 11, 37, '66.00', 40),
(9, '3003 000 5307', 'Rollomatic E', 'MS 261', 11, 32, '57.00', 40),
(10, '3003 000 6812', 'Duromatic E', 'MS 261', 11, 37, '66.00', 38);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ketten`
--

CREATE TABLE `ketten` (
  `ID` int(11) NOT NULL,
  `TeileBestellnummer` varchar(6) COLLATE latin1_german1_ci NOT NULL,
  `Name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `Beschreibung` text COLLATE latin1_german1_ci,
  `Teilung` varchar(5) COLLATE latin1_german1_ci NOT NULL,
  `Treibglieddicke` decimal(3,1) NOT NULL,
  `Treibgliedanzahl` tinyint(4) NOT NULL,
  `Preis` decimal(7,2) NOT NULL,
  `Laenge` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `ketten`
--

INSERT INTO `ketten` (`ID`, `TeileBestellnummer`, `Name`, `Beschreibung`, `Teilung`, `Treibglieddicke`, `Treibgliedanzahl`, `Preis`, `Laenge`) VALUES
(1, '3617', 'Picco Super (PS)', 'MS 261', '3/8', '1.3', 60, '24.60', 40),
(2, '3686', 'Rapid Micro (RM)', 'MS 261', '.0325', '1.6', 56, '24.20', 32),
(3, '3686', 'Rapid Micro (RM)', 'MS 261', '.0325', '1.6', 62, '27.00', 37),
(4, '3617', 'Picco Super (PS)', 'MS 261', '3/8', '1.3', 60, '24.60', 40),
(5, '3686', 'Rapid Micro (RM)', 'MS 261', '.0325', '1.6', 56, '24.20', 32),
(6, '3686', 'Rapid Micro (RM)', 'MS 261', '.0325', '1.6', 62, '27.00', 37),
(7, '3686', 'Rapid Micro (RM)', 'MS 261', '.0325', '1.6', 67, '29.10', 40),
(8, '3689', 'Rapid Micro 3 (RM3)', 'MS 261', '.0325', '1.6', 56, '24.20', 32),
(9, '3689', 'Rapid Micro 3 (RM3)', 'MS 261', '.0325', '1.6', 62, '27.00', 37),
(10, '3689', 'Rapid Micro 3 (RM3)', 'MS 261', '.0325', '1.6', 67, '29.10', 40),
(11, '3639', 'Rapid Super (RS)', 'MS 261', '.0325', '1.6', 56, '24.20', 32),
(12, '3639', 'Rapid Super (RS)', 'MS 261', '.0325', '1.6', 62, '27.00', 37),
(13, '3639', 'Rapid Super (RS)', 'MS 261', '.0325', '1.6', 67, '29.10', 40),
(14, '3636', 'Picco Micro 3 (PM3)', 'MS 180/211/231', '3/8', '1.3', 44, '18.10', 30),
(15, '3636', 'Picco Micro 3 (PM3)', 'MS 180/211/231', '3/8', '1.3', 50, '20.50', 35),
(16, '3612', 'Picco Duro 3 (PD3)', 'MS 180/211/231', '3/8', '1.3', 44, '18.10', 30),
(17, '3636', 'Picco Micro 3 (PM3)', 'MS 180/211/231', '3/8', '1.3', 55, '22.50', 40),
(18, '3612', 'Picco Duro 3 (PD3)', 'MS 180/211/231', '3/8', '1.3', 50, '20.50', 35),
(19, '3612', 'Picco Duro 3 (PD3)', 'MS 180/211/231', '3/8', '1.3', 55, '22.50', 40),
(20, '3617', 'Picco Super (PS)', 'MS 180/211/231', '3/8', '1.3', 44, '18.10', 30),
(21, '3617', 'Picco Super (PS)', 'MS 180/211/231', '3/8', '1.3', 50, '20.50', 35),
(22, '3617', 'Picco Super (PS)', 'MS 180/211/231', '3/8', '1.3', 55, '22.50', 40),
(23, '3616', 'Picco Super 3 (PS3)', 'MS 180/211/231', '3/8', '1.3', 44, '44.80', 30),
(24, '3616', 'Picco Super 3 (PS3)', 'MS 180/211/231', '3/8', '1.3', 50, '50.90', 35),
(25, '3616', 'Picco Super 3 (PS3)', 'MS 180/211/231', '3/8', '1.3', 55, '55.80', 40);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `ID` int(11) NOT NULL,
  `Name` varchar(128) COLLATE latin1_german1_ci NOT NULL,
  `Adresse` varchar(128) COLLATE latin1_german1_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `produkte`
--

CREATE TABLE `produkte` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `FK_Bild` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `produkte`
--

INSERT INTO `produkte` (`ID`, `name`, `FK_Bild`) VALUES
(1, 'STIHL Akku Geräte', 8),
(2, 'Motorsägen und Kettensägen', 9),
(3, 'KombiSysteme und MultiSystem', 10),
(4, 'Motorsensen und Freischneider', 11),
(5, 'Heckenscheren und Heckenschneider', 12),
(6, 'Reinigungsgeräte', 13),
(7, 'Sprüh- und Spritzgeräte', 14),
(8, 'Erdbohrgeräte und Bohrwerkzeuge', 15),
(9, 'Gesteinschneider und Trennschleifer', 16),
(10, 'Zubehör und Betriebsstoffe', 17),
(11, 'Persönliche Schutzausstattung', 18),
(12, 'STIHL Markenshop', 19);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rechnung`
--

CREATE TABLE `rechnung` (
  `ID` int(11) NOT NULL,
  `Datum` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `saege`
--

CREATE TABLE `saege` (
  `ID` int(11) NOT NULL,
  `Bestellnummer` varchar(12) COLLATE latin1_german1_ci NOT NULL,
  `Kettenteilung` varchar(5) COLLATE latin1_german1_ci DEFAULT NULL,
  `Name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `Beschreibung` text COLLATE latin1_german1_ci,
  `Besonderheiten` varchar(255) COLLATE latin1_german1_ci DEFAULT NULL,
  `KW` decimal(4,2) DEFAULT NULL,
  `PS` decimal(4,2) DEFAULT NULL,
  `Schienenlaenge` tinyint(4) NOT NULL,
  `Gewicht` decimal(4,2) NOT NULL,
  `Hubraum` decimal(5,2) NOT NULL,
  `Preis` decimal(7,2) NOT NULL,
  `FK_Bild` int(11) DEFAULT NULL,
  `FK_Einsatzzweck` int(11) NOT NULL,
  `FK_Bestellung` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `saege`
--

INSERT INTO `saege` (`ID`, `Bestellnummer`, `Kettenteilung`, `Name`, `Beschreibung`, `Besonderheiten`, `KW`, `PS`, `Schienenlaenge`, `Gewicht`, `Hubraum`, `Preis`, `FK_Bild`, `FK_Einsatzzweck`, `FK_Bestellung`) VALUES
(1, 'test17', '1/4', 'MS 150 C-E ', '', '', '1.00', '1.30', 35, '2.80', '23.60', '519.00', 1, 1, NULL),
(2, 'test17', '3/8', 'MS 170', '', '', '1.20', '1.60', 35, '4.10', '30.10', '239.00', 2, 1, NULL),
(3, 'test17', '3/8', 'MS 171', '', '', '1.30', '1.80', 35, '4.30', '31.80', '279.00', 2, 1, NULL),
(4, 'test17', '3/8', 'MS 180 ', '', '', '1.40', '1.90', 35, '4.10', '31.80', '279.00', 3, 1, NULL),
(5, 'test17', '3/8', 'MS 180 C-BE', '', '', '1.40', '1.90', 35, '4.50', '31.80', '349.00', 3, 1, NULL),
(6, 'test17', '3/8', 'MS 181', '', '', '1.50', '2.00', 35, '4.30', '31.80', '349.00', 4, 1, NULL),
(7, 'test17', '3/8', 'MS 181 C-BE', '', '', '1.50', '2.00', 35, '4.60', '31.80', '419.00', 4, 1, NULL),
(8, 'test17', '3/8', 'MS 193 C-E', '', '', '1.30', '1.80', 35, '3.60', '30.10', '509.00', 31, 1, NULL),
(9, 'test17', '3/8', 'MS 211', '', '', '1.70', '2.30', 35, '4.30', '35.20', '399.00', 5, 1, NULL),
(10, 'test17', '3/8', 'MS 211 C-BE', 'MS 211 C-BE', '', '1.70', '2.30', 35, '4.60', '35.20', '469.00', 6, 2, NULL),
(11, 'test17', '3/8', 'MS 211 mit Picco Duro 3', '', '', '1.70', '2.30', 35, '4.30', '35.20', '441.00', 5, 1, NULL),
(12, 'test17', '3/8', 'MS 231', '', '', '2.00', '2.70', 35, '4.80', '42.60', '479.00', 5, 1, NULL),
(13, 'test17', '3/8', 'MS 231 C-BE', '', '', '2.00', '2.70', 35, '5.10', '42.60', '549.00', 5, 1, NULL),
(14, 'test17', '3/8', 'MS 231 C-BE mit Picco Duro 3', '', '', '2.00', '2.70', 35, '5.10', '42.60', '591.00', 5, 1, NULL),
(15, 'test17', '0.325', 'MS 251', '', '', '2.20', '3.00', 35, '4.80', '45.60', '549.00', 5, 1, NULL),
(16, 'test17', '0.325', 'MS 251 C-BEQ', '', '', '2.20', '3.00', 35, '5.20', '45.60', '654.00', 5, 1, NULL),
(17, 'test17', '3/8', 'MS 271', '', '', '2.60', '3.60', 35, '5.60', '50.20', '599.00', 6, 2, NULL),
(18, 'test17', '3/8', 'MS 271 C-BE', '', '', '2.60', '3.60', 35, '6.20', '50.20', '669.00', 6, 2, NULL),
(19, 'test17', '3/8', 'MS 291', '', '', '2.80', '3.80', 35, '5.60', '55.50', '679.00', 7, 2, NULL),
(20, 'test17', '3/8', 'MS 291 C-BE', '', '', '2.80', '3.80', 35, '6.20', '55.50', '749.00', 7, 2, NULL),
(21, 'test17', '3/8', 'MS 311', '', '', '3.10', '4.20', 35, '6.20', '59.00', '789.00', 28, 2, NULL),
(22, 'test17', '3/8', 'MS 391', '', '', '3.30', '4.50', 35, '6.20', '64.10', '869.00', 28, 2, NULL),
(23, 'test17', '3/8', 'MS 201 C-M', 'Leichteste Profi-Motorsäge von STIHL, ideal für Entastungsarbeiten. Serienmäßig mit M-Tronic, dadurch stets optimale Motorleistung, einfaches Starten mit nur einer Startposition, sparsamer 2-MIX-Motor, verliersichere Mutter am Kettenraddeckel, 3/8"-PS-Sägekette für eine sehr hohe Schnittleistung. ', '', '1.80', '2.40', 35, '3.90', '35.20', '849.00', 31, 0, NULL),
(24, 'test17', '3/8', 'MS 241 C-BEM', 'Vielseitige 2,3kW-Benzinmotorsäge mit M-Tronic, STIHL ErgoStart und STIHL Kettenschnellspannung. Die Kraftstoffdosierung wird elektronisch geregelt und automatisch an die Umweltbedingungen angepasst. Die Motorsäge hat immer die optimale Motorleistung. Viele weitere praktische Ausstattungsmerkmale wie leicht zu reinigender HD2-Filter, verliersichere Mutter am Kettenraddeckel, einteilige Haube mit Schnellverschlüssen und Memory-Funktion für zügiges Weiterarbeiten nach Arbeitspausen. ', '', '2.30', '3.10', 35, '4.90', '42.60', '889.00', 5, 0, NULL),
(25, 'test17', '3/8', 'MS 241 C-M', '', '', '2.30', '3.10', 35, '4.50', '42.60', '819.00', 5, 0, NULL),
(26, 'test17', '3/8', 'MS 241 C-M VW', '', '', '2.30', '3.10', 35, '4.80', '42.60', '889.00', 5, 0, NULL),
(27, 'test17', '0.325', 'MS 261 C-M', '', '', '3.00', '4.10', 35, '4.90', '50.20', '959.00', 5, 0, NULL),
(28, 'test17', '0.325', 'MS 261 C-M mit Rapid Duro 3', '', '', '3.00', '4.10', 35, '4.90', '50.20', '989.00', 5, 0, NULL),
(29, 'test17', '0.325', 'MS 261 C-MQ', '', '', '3.00', '4.10', 35, '5.00', '50.20', '994.00', 5, 0, NULL),
(30, 'test17', '0.325', 'MS 261 C-BM', '', '', '3.00', '4.10', 35, '5.10', '50.20', '994.00', 5, 0, NULL),
(31, 'test17', '3/8', 'MS 261 C-M VW', '', '', '3.00', '4.10', 35, '5.10', '50.20', '1029.00', 5, 0, NULL),
(32, 'test17', '3/8', 'MS 362 C-M', '', '', '3.50', '4.80', 35, '5.60', '59.00', '1177.00', 28, 0, NULL),
(33, 'test17', '3/8', 'MS 362 C-M mit Rapid Duro 3', '', '', '3.50', '4.80', 35, '5.60', '59.00', '1229.00', 28, 0, NULL),
(34, 'test17', '3/8', 'MS 362 C-M VW', '', '', '3.50', '4.80', 35, '5.80', '59.00', '1247.00', 28, 0, NULL),
(35, 'test17', '3/8', 'MS 441 C-M', '', '', '4.20', '5.70', 35, '6.60', '70.70', '1375.00', 29, 0, NULL),
(36, 'test17', '3/8', 'MS 441 C-M W', '', '', '4.20', '5.70', 35, '6.70', '70.70', '1410.00', 29, 0, NULL),
(37, 'test17', '3/8', 'MS 461', '', '', '4.40', '6.00', 35, '6.70', '76.50', '1445.00', 29, 0, NULL),
(38, 'test17', '3/8', 'MS 461 VW', '', '', '4.40', '6.00', 35, '6.80', '76.50', '1515.00', 29, 0, NULL),
(39, 'test17', '3/8', 'MS 661 C-M', '', '', '5.40', '7.30', 35, '7.40', '91.10', '1572.00', 29, 0, NULL),
(40, 'test17', '3/8', 'MS 661 C-M W', '', '', '5.40', '7.30', 35, '7.50', '91.10', '1642.00', 29, 0, NULL),
(41, 'test17', '0.404', 'MS 880', '', '', '6.40', '8.70', 35, '10.00', '121.60', '1849.00', 30, 0, NULL),
(42, 'test17', '1/4', 'MS 150 C-E. Carving', '', '', '1.00', '1.30', 35, '2.80', '23.60', '566.00', 1, 3, NULL),
(43, 'test17', '1/4', 'MS 193 C-E Carving', '', '', '1.30', '1.80', 35, '3.60', '30.10', '544.00', 31, 3, NULL),
(44, 'test17', '1/4', 'MS 201 C-M Carving', '', '', '1.80', '2.40', 35, '3.90', '35.20', '884.00', 31, 3, NULL),
(45, 'test17', '1/4', 'MSA 120 C-BQ. ohne Akku und Ladegerät', '', '', '0.00', '0.00', 35, '2.50', '0.00', '229.00', 32, 5, NULL),
(46, 'test17', '1/4', 'MSA 120 C-BQ. mit Akku AK 20 und Ladegerät AL 101', '', '', '0.00', '0.00', 35, '2.50', '0.00', '299.00', 32, 5, NULL),
(47, 'test17', '1/4', 'MSA 140 C-BQ. ohne Akku und Ladegerät', '', '', '0.00', '0.00', 35, '2.60', '0.00', '259.00', 32, 5, NULL),
(48, 'test17', '1/4', 'MSA 140 C-BQ. mit Akku AK 30 und Ladegerät AL 101', '', '', '0.00', '0.00', 35, '2.60', '0.00', '359.00', 32, 5, NULL),
(49, 'test17', '1/4', 'MSA 160 C-BQ. ohne Akku und ohne Ladegerät', '', '', '0.00', '0.00', 35, '3.10', '0.00', '359.00', 32, 5, NULL),
(50, 'test17', '1/4', 'MSA 160 C-BQ. mit Akku AP 200 und Ladegerät AL 101', '', '', '0.00', '0.00', 35, '3.10', '0.00', '569.00', 32, 5, NULL),
(51, 'test17', '1/4', 'MSA 160 T. ohne Akku und Ladegerät', '', '', '0.00', '0.00', 35, '2.30', '0.00', '407.00', 32, 5, NULL),
(52, 'test17', '1/4', 'MSA 200 C-BQ. ohne Akku und Ladegerät', '', '', '0.00', '0.00', 35, '3.30', '0.00', '419.00', 32, 5, NULL),
(53, 'test17', '1/4', 'MSA 200 C-BQ Carving. ohne Akku und Ladegerät', '', '', '0.00', '0.00', 35, '3.30', '0.00', '454.00', 32, 5, NULL),
(54, 'test17', '3/8', 'MSE 141 C-Q', '', '', '1.40', '0.00', 35, '4.10', '0.00', '179.00', 33, 6, NULL),
(55, 'test17', '3/8', 'MSE 170 C-Q', '', '', '1.70', '0.00', 35, '4.20', '0.00', '239.00', 33, 6, NULL),
(56, 'test17', '3/8', 'MSE 170 C-BQ', '', '', '1.70', '0.00', 35, '4.30', '0.00', '274.00', 33, 6, NULL),
(57, 'test17', '3/8', 'MSE 190 C-Q', '', '', '1.90', '0.00', 35, '4.30', '0.00', '309.00', 33, 6, NULL),
(58, 'test17', '3/8', 'MSE 190 C-BQ', '', '', '1.90', '0.00', 35, '4.40', '0.00', '344.00', 33, 6, NULL),
(59, 'test17', '3/8', 'MSE 210 C-BQ', '', '', '2.10', '0.00', 35, '4.50', '0.00', '397.00', 33, 6, NULL),
(60, 'test17', '3/8', 'MSE 210 C-BQ mit Picco Duro 3', '', '', '2.10', '0.00', 35, '4.50', '0.00', '439.00', 33, 6, NULL),
(61, 'test17', '3/8', 'MSE 230 C-BQ', '', '', '2.30', '0.00', 35, '4.70', '0.00', '467.00', 33, 6, NULL),
(62, 'test17', '3/8', 'MSE 250 C-Q', '', '', '2.50', '0.00', 35, '5.70', '0.00', '689.00', 33, 6, NULL),
(63, 'test17', '.404', 'MS 880', 'Stärkste Serien-Motorsäge der Welt. Dekompressionsventil und STIHL ElastoStart sorgen für ein kraftsparendes Anwerfen der Motorsäge, HD2-Filter garantiert eine hohe Filterstandzeit, werkzeuglose Tankverschlüsse für einfaches und sicheres Befüllen mit Betriebsstoffen ', '', '6.40', '8.70', 75, '10.00', '121.60', '1899.00', 30, 3, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `zubehoer`
--

CREATE TABLE `zubehoer` (
  `ID` int(11) NOT NULL,
  `Bestellnummer` varchar(15) COLLATE latin1_german1_ci NOT NULL,
  `Name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `Beschreibung` text COLLATE latin1_german1_ci,
  `Preis` decimal(7,2) NOT NULL,
  `FK_Bild` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Daten für Tabelle `zubehoer`
--

INSERT INTO `zubehoer` (`ID`, `Bestellnummer`, `Name`, `Beschreibung`, `Preis`, `FK_Bild`) VALUES
(1, '5605 007 1000', 'Schärfeset 1/4"', 'Mehrteiliges, bewährt robustes Schärfset in robuster Tasche mit Gürtelschlaufe. Feilenhalter mit Rundfeile. Flachfeile zum Nachbearbeiten der Tiefenbegrenzer. Feillehre zur Kontrolle von Brust- und Schärfwinkel, Zahnlänge sowie Tiefenbegrenzerabstand. Auch zum Reinigen von Nut und Öleintrittsbohrung der Führungsschiene. Verschiedene Ausführungen für die Pflege von 3/8-PMN-Ketten, 1/4"- und 3/8"-PM-Ketten, .325-Ketten und .404-Ketten lieferbar. ', '20.20', 37),
(2, '5605 007 1027', 'Schärfeset 1/4" u. 3/8"', 'Mehrteiliges, bewährt robustes Schärfset in robuster Tasche mit Gürtelschlaufe. Feilenhalter mit Rundfeile. Flachfeile zum Nachbearbeiten der Tiefenbegrenzer. Feillehre zur Kontrolle von Brust- und Schärfwinkel, Zahnlänge sowie Tiefenbegrenzerabstand. Auch zum Reinigen von Nut und Öleintrittsbohrung der Führungsschiene. Verschiedene Ausführungen für die Pflege von 3/8-PMN-Ketten, 1/4"- und 3/8"-PM-Ketten, .325-Ketten und .404-Ketten lieferbar. ', '20.20', 37),
(3, '5605 007 1028', 'Schärfeset .325"', 'Mehrteiliges, bewährt robustes Schärfset in robuster Tasche mit Gürtelschlaufe. Feilenhalter mit Rundfeile. Flachfeile zum Nachbearbeiten der Tiefenbegrenzer. Feillehre zur Kontrolle von Brust- und Schärfwinkel, Zahnlänge sowie Tiefenbegrenzerabstand. Auch zum Reinigen von Nut und Öleintrittsbohrung der Führungsschiene. Verschiedene Ausführungen für die Pflege von 3/8-PMN-Ketten, 1/4"- und 3/8"-PM-Ketten, .325-Ketten und .404-Ketten lieferbar. ', '20.20', 37),
(4, '5605 007 1029', 'Schärfeset 3/8"', 'Mehrteiliges, bewährt robustes Schärfset in robuster Tasche mit Gürtelschlaufe. Feilenhalter mit Rundfeile. Flachfeile zum Nachbearbeiten der Tiefenbegrenzer. Feillehre zur Kontrolle von Brust- und Schärfwinkel, Zahnlänge sowie Tiefenbegrenzerabstand. Auch zum Reinigen von Nut und Öleintrittsbohrung der Führungsschiene. Verschiedene Ausführungen für die Pflege von 3/8-PMN-Ketten, 1/4"- und 3/8"-PM-Ketten, .325-Ketten und .404-Ketten lieferbar. ', '20.20', 37),
(5, '5605 007 1030', 'Schärfeset .404"', 'Mehrteiliges, bewährt robustes Schärfset in robuster Tasche mit Gürtelschlaufe. Feilenhalter mit Rundfeile. Flachfeile zum Nachbearbeiten der Tiefenbegrenzer. Feillehre zur Kontrolle von Brust- und Schärfwinkel, Zahnlänge sowie Tiefenbegrenzerabstand. Auch zum Reinigen von Nut und Öleintrittsbohrung der Führungsschiene. Verschiedene Ausführungen für die Pflege von 3/8-PMN-Ketten, 1/4"- und 3/8"-PM-Ketten, .325-Ketten und .404-Ketten lieferbar. ', '20.20', 37),
(6, '0000 893 4105', 'Prüflehren', 'Zum Ermitteln der Teilung von Kette und Kettenrad sowie der Treibglieddicke und der Nutbreite der Führungsschiene.', '5.50', 36),
(7, '5604 000 7501', 'Feilgerät FG 2', 'Präzisions-Handfeilgerät aus Metall. Zur Tischbefestigung, ohne Feilengriffe und Feile.', '141.00', 34),
(8, '5605 773 4400', 'Führungsschienenrichter', 'Werkzeug zum Entgraten der Führungsschiene. Ergonomisch gestaltete Kunststoffhalterung mit Flachfeile (100 x 22 mm) aus gehärtetem Werkzeugstahl.', '28.80', 35);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `zubehoer_bildablage`
--

CREATE TABLE `zubehoer_bildablage` (
  `Zubehoer_ID` int(11) NOT NULL,
  `Bildablage_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Fuehrungsschienen` (`FK_Fuehrungsschienen`),
  ADD KEY `FK_Ketten` (`FK_Ketten`),
  ADD KEY `FK_Kunde` (`FK_Kunde`),
  ADD KEY `FK_Rechnungsnummer` (`FK_Rechnungsnummer`),
  ADD KEY `FK_Zubehoer` (`FK_Zubehoer`),
  ADD KEY `FK_Saege` (`FK_Saege`);

--
-- Indizes für die Tabelle `bildablage`
--
ALTER TABLE `bildablage`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `einsatzzweck`
--
ALTER TABLE `einsatzzweck`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `fuehrungsschienen`
--
ALTER TABLE `fuehrungsschienen`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Bild` (`FK_Bild`);

--
-- Indizes für die Tabelle `ketten`
--
ALTER TABLE `ketten`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `produkte`
--
ALTER TABLE `produkte`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `rechnung`
--
ALTER TABLE `rechnung`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `saege`
--
ALTER TABLE `saege`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Bestellung` (`FK_Bestellung`),
  ADD KEY `FK_Bild` (`FK_Bild`),
  ADD KEY `FK_Einsatzzweck` (`FK_Einsatzzweck`);

--
-- Indizes für die Tabelle `zubehoer`
--
ALTER TABLE `zubehoer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_bild` (`FK_Bild`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `bildablage`
--
ALTER TABLE `bildablage`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT für Tabelle `einsatzzweck`
--
ALTER TABLE `einsatzzweck`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT für Tabelle `fuehrungsschienen`
--
ALTER TABLE `fuehrungsschienen`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT für Tabelle `ketten`
--
ALTER TABLE `ketten`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `produkte`
--
ALTER TABLE `produkte`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT für Tabelle `rechnung`
--
ALTER TABLE `rechnung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `saege`
--
ALTER TABLE `saege`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- AUTO_INCREMENT für Tabelle `zubehoer`
--
ALTER TABLE `zubehoer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
