# Insert default values for testing

# Insert existing security roles
INSERT INTO pay_my_buddy.role_profile(role_id, role_name) VALUES (01, 'USER');
INSERT INTO pay_my_buddy.role_profile(role_id, role_name) VALUES (02, 'ADMIN');

# Insert default bank accounts
INSERT INTO pay_my_buddy.bank_account(bank_account_id, rib, bank, iban, bic) VALUES (01, '12345123450123456789001', 'Crédit Agricole', 'FR01 1234 1234 1234 1234 1234 123', 'ABCDEFGH123');
INSERT INTO pay_my_buddy.bank_account(bank_account_id, rib, bank, iban, bic) VALUES (02, '12345123450123456789002', 'BNP Paribas', 'FR02 1234 1234 1234 1234 1234 123', 'ABCDEFGH456');
INSERT INTO pay_my_buddy.bank_account(bank_account_id, rib, bank, iban, bic) VALUES (03, '12345123450123456789003', 'La Banque Postale', 'FR03 1234 1234 1234 1234 1234 123', 'ABCDEFGH789');
INSERT INTO pay_my_buddy.bank_account(bank_account_id, rib, bank, iban, bic) VALUES (04, '12345123450123456789004', 'LCL', 'FR04 1234 1234 1234 1234 1234 123', 'ABCDEFGH987');

# Insert default user accounts
INSERT INTO pay_my_buddy.user_account(user_id, first_name, last_name, email, password, bank_account_id, balance) VALUES (01, 'FirstName01', 'LastName01', 'email01@test.com', '$2y$10$SF7o4.2Ox0ufI1HlK/odeOx1xBFg1Wrq/2jJGM4NKk/duByaEHNvS', 01, 1000);
INSERT INTO pay_my_buddy.user_account(user_id, first_name, last_name, email, password, bank_account_id, balance) VALUES (02, 'FirstName02', 'LastName02', 'email02@test.com', '$2y$10$mwwpf20mt6JyO4ISBareKOjgUg6S9.aw4y6j4vkZEgsdMNaVOdnVq', 02, 1000);
INSERT INTO pay_my_buddy.user_account(user_id, first_name, last_name, email, password, bank_account_id, balance) VALUES (03, 'FirstName03', 'LastName03', 'email03@test.com', '$2y$10$IPJ4TXsXKuv4Zwlx3gAwLutZ8bxoG.wPZ1Nu1md6bZM0y5V4ymPYi', 03, 1000);
INSERT INTO pay_my_buddy.user_account(user_id, first_name, last_name, email, password, bank_account_id, balance) VALUES (04, 'FirstName04', 'LastName04', 'email04@test.com', '$2y$10$RoWfxgQQotQAhlnCz6oqWeAhpKo97VaBy5ZoHOZDkNVCtQAJzWn0u', 04, 1000);

# Insert default transfers
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (01, 01, 02, 'description 01', '2021-01-01', 100, 0.5, 'TRANSFER_BETWEEN_USER');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (02, 01, 01, 'description 02', '2021-01-02', 100, 0, 'TRANSFER_WITH_BANK');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (03, 02, 04, 'description 03', '2021-01-03', 100, 0.5, 'TRANSFER_BETWEEN_USER');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (04, 03, 01, 'description 04', '2021-01-04', 100, 0.5, 'TRANSFER_BETWEEN_USER');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (05, 04, 03, 'description 05', '2021-01-05', 100, 0.5, 'TRANSFER_BETWEEN_USER');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (06, 03, 03, 'description 06', '2021-01-06', 100, 0, 'TRANSFER_WITH_BANK');
INSERT INTO pay_my_buddy.transfer(transfer_id, sender_user_id, receiver_user_id, description, transfer_date, amount, fee, transfer_type) VALUES (07, 04, 04, 'description 07', '2021-01-07', 100, 0, 'TRANSFER_WITH_BANK');

# Insert transfer log
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (01, 01, 02);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (02, 01, 01);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (03, 02, 04);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (04, 03, 01);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (05, 04, 03);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (06, 03, 03);
INSERT INTO pay_my_buddy.transfer_log(transfer_id, sender_user_id, receiver_user_id) VALUES (07, 04, 04);

# Insert connection
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (01, 02);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (01, 03);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (01, 04);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (02, 04);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (03, 01);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (03, 04);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (04, 02);
INSERT INTO pay_my_buddy.connection(user_id, connection_id) VALUES (04, 03);

# Insert user roles
INSERT INTO pay_my_buddy.user_role(user_id, role_id) VALUES (01, 01);
INSERT INTO pay_my_buddy.user_role(user_id, role_id) VALUES (01, 02);
INSERT INTO pay_my_buddy.user_role(user_id, role_id) VALUES (02, 01);
INSERT INTO pay_my_buddy.user_role(user_id, role_id) VALUES (03, 01);
INSERT INTO pay_my_buddy.user_role(user_id, role_id) VALUES (04, 01);

# Insert privilege and correct roles
