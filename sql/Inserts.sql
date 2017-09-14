INSERT INTO Bildablage (ID, Pfad) VALUES (0, '/pics/motorsaegen/ms150ce.png');

INSERT INTO Einsatzzweck (ID, Name) VALUES (0, 'Forst');
INSERT INTO Einsatzzweck (ID, Name) VALUES (SELECT ID FROM einsatzzweck ORDER BY id+1 FROM Einsatzzweck), 'Privat');
INSERT INTO Einsatzzweck (ID, Name) VALUES ((SELECT MAX(ID)+1 FROM Einsatzzweck), 'LandwirtschaftGaLa');
INSERT INTO Einsatzzweck (ID, Name) VALUES ((SELECT MAX(ID)+1 FROM Einsatzzweck), 'Spezial');
INSERT INTO Einsatzzweck (ID, Name) VALUES ((SELECT MAX(ID)+1 FROM Einsatzzweck), 'Carving');
INSERT INTO Einsatzzweck (ID, Name) VALUES ((SELECT MAX(ID)+1 FROM Einsatzzweck), 'Akku');
INSERT INTO Einsatzzweck (ID, Name) VALUES ((SELECT MAX(ID)+1 FROM Einsatzzweck), 'Elektro');
INSERT INTO Einsatzzweck (Name, FK_Bild) VALUES ('Ketten- und Schienenberater', 27);
INSERT INTO Einsatzzweck (Name, FK_Bild) VALUES ('Schneidgarnituren und Zubehör', 24);


INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 150 C-E ','1/4',23.60,1.00,1.30,35,2.80,519.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 170','3/8',30.10,1.20,1.60,35,4.10,239.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 171','3/8',31.80,1.30,1.80,35,4.30,279.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 180 ','3/8',31.80,1.40,1.90,35,4.10,279.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 180 C-BE','3/8',31.80,1.40,1.90,35,4.50,349.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 181','3/8',31.80,1.50,2.00,35,4.30,349.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 181 C-BE','3/8',31.80,1.50,2.00,35,4.60,419.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 193 C-E','3/8',30.10,1.30,1.80,35,3.60,509.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 211','3/8',35.20,1.70,2.30,35,4.30,399.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 211 C-BE','3/8',35.20,1.70,2.30,35,4.60,469.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 211 mit Picco Duro 3','3/8',35.20,1.70,2.30,35,4.30,441.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 231','3/8',42.60,2.00,2.70,35,4.80,479.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 231 C-BE','3/8',42.60,2.00,2.70,35,5.10,549.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 231 C-BE mit Picco Duro 3','3/8',42.60,2.00,2.70,35,5.10,591.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 251',0.325,45.60,2.20,3.00,35,4.80,549.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (1,'MS 251 C-BEQ',0.325,45.60,2.20,3.00,35,5.20,654.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 271','3/8',50.20,2.60,3.60,35,5.60,599.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 271 C-BE','3/8',50.20,2.60,3.60,35,6.20,669.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 291','3/8',55.50,2.80,3.80,35,5.60,679.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 291 C-BE','3/8',55.50,2.80,3.80,35,6.20,749.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 311','3/8',59.00,3.10,4.20,35,6.20,789.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (2,'MS 391','3/8',64.10,3.30,4.50,35,6.20,869.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 201 C-M','3/8',35.20,1.80,2.40,35,3.90,849.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 241 C-BEM','3/8',42.60,2.30,3.10,35,4.90,889.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 241 C-M','3/8',42.60,2.30,3.10,35,4.50,819.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 241 C-M VW','3/8',42.60,2.30,3.10,35,4.80,889.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 261 C-M',.325,50.20,3.00,4.10,35,4.90,959.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 261 C-M mit Rapid Duro 3',.325,50.20,3.00,4.10,35,4.90,989.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 261 C-MQ',.325,50.20,3.00,4.10,35,5.00,994.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 261 C-BM',.325,50.20,3.00,4.10,35,5.10,994.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 261 C-M VW','3/8',50.20,3.00,4.10,35,5.10,1029.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 362 C-M','3/8',59.00,3.50,4.80,35,5.60,1177.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 362 C-M mit Rapid Duro 3','3/8',59.00,3.50,4.80,35,5.60,1229.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 362 C-M VW','3/8',59.00,3.50,4.80,35,5.80,1247.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 441 C-M','3/8',70.70,4.20,5.70,35,6.60,1375.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 441 C-M W','3/8',70.70,4.20,5.70,35,6.70,1410.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 461','3/8',76.50,4.40,6.00,35,6.70,1445.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 461 VW','3/8',76.50,4.40,6.00,35,6.80,1515.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 661 C-M','3/8',91.10,5.40,7.30,35,7.40,1572.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 661 C-M W','3/8',91.10,5.40,7.30,35,7.50,1642.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (0,'MS 880',.404,121.60,6.40,8.70,35,10.00,1849.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (4,'MS 150 C-E. Carving','1/4',23.60,1.00,1.30,35,2.80,566.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (4,'MS 193 C-E Carving','1/4',30.10,1.30,1.80,35,3.60,544.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (4,'MS 201 C-M Carving','1/4',35.20,1.80,2.40,35,3.90,884.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 120 C-BQ. ohne Akku und Ladegerät','1/4',0.00,0.00,0.00,35,2.50,229.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 120 C-BQ. mit Akku AK 20 und Ladegerät AL 101','1/4',0.00,0.00,0.00,35,2.50,299.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 140 C-BQ. ohne Akku und Ladegerät','1/4',0.00,0.00,0.00,35,2.60,259.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 140 C-BQ. mit Akku AK 30 und Ladegerät AL 101','1/4',0.00,0.00,0.00,35,2.60,359.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 160 C-BQ. ohne Akku und ohne Ladegerät','1/4',0.00,0.00,0.00,35,3.10,359.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 160 C-BQ. mit Akku AP 200 und Ladegerät AL 101','1/4',0.00,0.00,0.00,35,3.10,569.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 160 T. ohne Akku und Ladegerät','1/4',0.00,0.00,0.00,35,2.30,407.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 200 C-BQ. ohne Akku und Ladegerät','1/4',0.00,0.00,0.00,35,3.30,419.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (5,'MSA 200 C-BQ Carving. ohne Akku und Ladegerät','1/4',0.00,0.00,0.00,35,3.30,454.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 141 C-Q','3/8',0.00,1.40,0.00,35,4.10,179.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 170 C-Q','3/8',0.00,1.70,0.00,35,4.20,239.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 170 C-BQ','3/8',0.00,1.70,0.00,35,4.30,274.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 190 C-Q','3/8',0.00,1.90,0.00,35,4.30,309.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 190 C-BQ','3/8',0.00,1.90,0.00,35,4.40,344.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 210 C-BQ','3/8',0.00,2.10,0.00,35,4.50,397.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 210 C-BQ mit Picco Duro 3','3/8',0.00,2.10,0.00,35,4.50,439.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 230 C-BQ','3/8',0.00,2.30,0.00,35,4.70,467.00, 'test17', '', '');
INSERT INTO Saege (FK_Einsatzzweck, Name, Kettenteilung, Hubraum, KW, PS, Schienenlaenge, Gewicht, Preis, Bestellnummer, Beschreibung, Besonderheiten) VALUES (6,'MSE 250 C-Q','3/8',0.00,2.50,0.00,35,5.70,689.00, 'test17', '', '');

INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 7405', 67.00,9,30,'MS 180/211/231','Rollomatic E Light');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 4805', 55.00,9,30,'MS 180/211/231','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 7409', 73.00,9,35,'MS 180/211/231','Rollomatic E Light');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 7413', 79.00,9,40,'MS 180/211/231','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 4809',61.00,9,35,'MS 180/211/231','Rollomatic E Light');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3005 000 4813',67.00,9,40,'MS 180/211/231','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3003 000 5306',57.00,11,32,'MS 271','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3003 000 6811',66.00,11,37,'MS 271','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3003 000 5307',57.00,11,32,'MS 261','Rollomatic E');
INSERT INTO Fuehrungsschienen (Bestellnummer, Preis, AnzahlZaehneUmlenkung, Laenge, Beschreibung, Name) VALUES ('3003 000 6812',66.00,11,37,'MS 261','Duromatic E');


INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3617','Picco Super (PS)','MS 261',40,'3/8','1.3',60,24.60);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3686','Rapid Micro (RM)','MS 261',32,'.0325','1.6',56,24.20);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3686','Rapid Micro (RM)','MS 261',37,'.0325','1.6',62,27.00);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3686','Rapid Micro (RM)','MS 261',40,'.0325','1.6',67,29.10 );
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3689','Rapid Micro 3 (RM3)','MS 261',32,'.0325','1.6',56,24.20);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3689','Rapid Micro 3 (RM3)','MS 261',37,'.0325','1.6',62,27.00);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3689','Rapid Micro 3 (RM3)','MS 261',40,'.0325','1.6',67,29.10);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3639','Rapid Super (RS)','MS 261',32,'.0325','1.6',56,24.20);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3639','Rapid Super (RS)','MS 261',37,'.0325','1.6',62,27.00);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3639','Rapid Super (RS)','MS 261',40,'.0325','1.6',67,29.10);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3636','Picco Micro 3 (PM3)','MS 180/211/231',30,'3/8','1.3',44,18.10);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3636','Picco Micro 3 (PM3)','MS 180/211/231',35,'3/8','1.3',50,20.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3612','Picco Duro 3 (PD3)','MS 180/211/231',30,'3/8','1.3',44,18.10);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3636','Picco Micro 3 (PM3)','MS 180/211/231',40,'3/8','1.3',55,22.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3612','Picco Duro 3 (PD3)','MS 180/211/231',35,'3/8','1.3',50,20.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3612','Picco Duro 3 (PD3)','MS 180/211/231',40,'3/8','1.3',55,22.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3617','Picco Super (PS)','MS 180/211/231',30,'3/8','1.3',44,18.10);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3617','Picco Super (PS)','MS 180/211/231',35,'3/8','1.3',50,20.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3617','Picco Super (PS)','MS 180/211/231',40,'3/8','1.3',55,22.50);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3616','Picco Super 3 (PS3)','MS 180/211/231',30,'3/8','1.3',44,44.80);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3616','Picco Super 3 (PS3)','MS 180/211/231',35,'3/8','1.3',50,50.90);
INSERT INTO Ketten (TeileBestellnummer,Name,Beschreibung,Laenge,Teilung,Treibglieddicke,Treibgliedanzahl,Preis)
VALUES ('3616','Picco Super 3 (PS3)','MS 180/211/231',40,'3/8','1.3',55,55.80);




INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Schärfeset 1/4"','5605 007 1000','Bestehend aus Feilenhalter mit Rundfeile, Flachfeile und Feillehre in robuster Tasche.',20.20);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Schärfeset 1/4" u. 3/8"','5605 007 1027','Bestehend aus Feilenhalter mit Rundfeile, Flachfeile und Feillehre in robuster Tasche.',20.20);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Schärfeset .325"', '5605 007 1028','Bestehend aus Feilenhalter mit Rundfeile, Flachfeile und Feillehre in robuster Tasche.',20.20);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Schärfeset 3/8"', '5605 007 1029','Bestehend aus Feilenhalter mit Rundfeile, Flachfeile und Feillehre in robuster Tasche.',20.20);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Schärfeset .404"', '5605 007 1030','Bestehend aus Feilenhalter mit Rundfeile, Flachfeile und Feillehre in robuster Tasche.',20.20);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Prüflehren', '0000 893 4105', 'Zum Ermitteln der Teilung von Kette und Kettenrad sowie der Treibglieddicke und der Nutbreite der Führungsschiene.',5.50);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Feilgerät FG 2', '5604 000 7501', 'Präzisions-Handfeilgerät aus Metall. Zur Tischbefestigung, ohne Feilengriffe und Feile.',141.00);
INSERT INTO Zubehoer (Name, Bestellnummer, Beschreibung,Preis)
VALUES ('Führungsschienenrichter', '5605 773 4400', 'Werkzeug zum Entgraten der Führungsschiene. Ergonomisch gestaltete Kunststoffhalterung mit Flachfeile (100 x 22 mm) aus gehärtetem Werkzeugstahl.',28.80);


INSERT INTO Bildablage (Pfad) VALUES ('/produkte/STIHL Akku Geräte.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Motorsägen und Kettensägen.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/KombiSysteme und MultiSystem.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Motorsensen und Freischneider.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Heckenscheren und Heckenschneider.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Reinigungsgeräte.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Sprüh- und Spritzgeräte.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Erdbohrgeräte und Bohrwerkzeuge.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Gesteinschneider und Trennschleifer.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Zubehör und Betriebsstoffe.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/Persönliche Schutzausstattung.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/produkte/STIHL Markenshop.jpg');

INSERT INTO Produkte (Name, FK_Bild) VALUES ('STIHL Akku Geräte', 8);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Motorsägen und Kettensägen', 9);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('KombiSysteme und MultiSystem', 10);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Motorsensen und Freischneider', 11);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Heckenscheren und Heckenschneider', 12);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Reinigungsgeräte', 13);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Sprüh- und Spritzgeräte', 14);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Erdbohrgeräte und Bohrwerkzeuge', 15);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Gesteinschneider und Trennschleifer', 16);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Zubehör und Betriebsstoffe', 17);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('Persönliche Schutzausstattung', 18);
INSERT INTO Produkte (Name, FK_Bild) VALUES ('STIHL Markenshop', 19);






INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Privat.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Forst.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/LandwirtschaftGaLa.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Spezial.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Schneidgarnituren und Zubehör.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Akku.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Elektro.jpg');
INSERT INTO Bildablage (Pfad) VALUES ('/MotorsägenKettensägen/Ketten- und Schienenberater.jpg');


























