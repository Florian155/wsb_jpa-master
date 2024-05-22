insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'Kolejowa 3', '13', 'Kraków', '62-030'),
            (2, 'Nowaka 4', null, 'Warszawa', '32-030'),
            (3, 'Łowicka 6', '23', 'Wrocław', '42-030'),
            (4, 'Torowa 4', '12', 'Gdańsk', '82-030');


insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values
    (1, 'Jan', 'Kowalski', '123456789', 'piotr.wisniewski@example.com', 'DOC123', 'CARDIOLOGY'),
    (2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'DOC456', 'DERMATOLOGY'),
    (3, 'Piotr', 'Wiśniewski', '555888999', 'krystyna.wisniewski@example.com', 'DOC789', 'NEUROLOGY'),
    (4, 'Magdalena', 'Zielińska', '111222333', 'andrzej.wisniewski@example.com', 'DOC101112', 'PEDIATRICS'),
    (5, 'Krzysztof', 'Lewandowski', '123442321', 'krzysztof.lewandowski@example.com', 'DOC131415', 'ORTHOPEDICS');

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance)
            values
        (1, 'Adam', 'Nowak', '123456789', 'adam.wisniewski@example.com', 'PAT001', '1990-05-15', TRUE),
        (2, 'Ewa', 'Kowalska', '987654321', 'ewa.kowalska@example.com', 'PAT002', '1985-08-20', FALSE),
        (3, 'Michał', 'Wiśniewski', '555888999', 'michal.wisniewski@example.com', 'PAT003', '1978-11-10',TRUE),
        (4, 'Anna', 'Zielińska', '111222333', 'anna.wisniewski@example.com', 'PAT004', '2000-03-25', FALSE );

insert into visit (id, time, doctor_id, patient_id)
values
    (1, '2024-05-01 10:00:00', 1, 1),
    (2, '2024-05-05 14:30:00', 2, 1),
    (3, '2024-05-10 11:15:00', 3, 2),
    (4, '2024-05-15 09:45:00', 4, 1),
    (5, '2024-05-20 13:00:00', 5, 3),
    (6, '2024-05-25 16:20:00', 3, 1),
    (7, '2024-05-30 08:30:00', 4, 4),
    (8, '2024-06-03 12:45:00', 5, 4);