-- Insert do doktorów
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Jan', 'Kowalski', '+48 123 456 789', 'jan.kowalski@example.com', '123456', 'SURGEON');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (2, 'Anna', 'Nowak', '+48 987 654 321', 'anna.nowak@example.com', '654321', 'DERMATOLOGIST');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (3, 'Piotr', 'Wiśniewski', '+48 321 654 987', 'piotr.wisniewski@example.com', '987654', 'GP');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (4, 'Katarzyna', 'Zielińska', '+48 789 456 123', 'katarzyna.zielinska@example.com', '123456', 'OCULIST');

-- Insert do pacjentów
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, sex, pesel)
VALUES (1, 'Zuzanna', 'Szymańska', '+48 432 109 876', 'zuzanna.szymanska@example.com', '1234567890', '2000-01-01','FEMALE',00010123122);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, sex, pesel)
VALUES (2, 'Bartosz', 'Kamiński', '+48 654 987 321', 'bartosz.kaminski@example.com', '9876543210', '1985-05-15','MALE',85051509832);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, sex, pesel)
VALUES (3, 'Magdalena', 'Nowakowska', '+48 210 543 789', 'magdalena.nowakowska@example.com', '6543219870', '1970-12-31','OTHER',70123107654);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, sex, pesel)
VALUES (4, 'Mateusz', 'Wojciechowski', '+48 876 321 098', 'mateusz.wojciechowski@example.com', '3210987654', '1995-07-10','MALE',95071039432);

--Inserty do adresów
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (1, ' ul. Nowa 123', '', 'Warszawa', '00-100', 1);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (2, ' Aleja Wiśniowa 45', ' lok. 3', 'Kraków', '30-001', 2);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (3, ' ul. Polna 21', '', 'Gdańsk', '80-100', 3);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (4, ' ul. Leśna 7/8', '', 'Poznań', '61-777', 4);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (5, ' ul. Nowa 123', '', 'Warszawa', '00-100', 1);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (6, ' Aleja Wiśniowa 45', ' lok. 3', 'Kraków', '30-001', 2);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (7, ' ul. Polna 21', '', 'Gdańsk', '80-100', 3);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (8, ' ul. Leśna 7/8', '', 'Poznań', '61-777', 4);

-- Inserty do tabeli visit
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (1, 'Przegląd ogólny', '2024-05-03 10:00:00', 1, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (2, 'Konsultacja dermatologiczna', '2024-05-03 11:30:00', 2, 2);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (3, 'Zabieg chirurgiczny', '2024-05-03 14:00:00', 3, 3);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (4, 'Badanie laryngologiczne', '2024-05-03 15:30:00', 4, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (5, 'Kontrolna wizyta stomatologiczna', '2024-05-03 16:00:00', 1, 4);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (6, 'Pobranie krwi', '2023-07-24 12:02', 3, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (7, 'Badanie kontrolne', '2024-06-26 10:32', 1, 3);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (8, 'Szczepienie', '2024-12-15 15:54', 2, 4);

-- Inserty do medical treatment
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Badanie USG jamy brzusznej', 'USG', 1);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (2, 'EKG serca', 'EKG', 2);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (3, 'Zdjęcie RTG klatki piersiowej', 'RTG', 3);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (4, 'Kontrolne badanie USG', 'USG', 5);