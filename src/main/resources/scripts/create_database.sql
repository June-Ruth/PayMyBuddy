CREATE DATABASE pay_my_buddy CHARACTER SET utf8;

USE pmb;

CREATE TABLE bank_account (
    rib BIGINT UNSIGNED NOT NULL,
    bank VARCHAR(40) NOT NULL,
    iban VARCHAR(40) NOT NULL,
    bic VARCHAR(15) NOT NULL,
    PRIMARY KEY (rib)
) ENGINE = InnoDB;

CREATE TABLE person (
    person_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    bank_account_rib BIGINT UNSIGNED,
    PRIMARY KEY (person_id)
) ENGINE = InnoDB;

CREATE TABLE user_account (
    user_account_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_person_id BIGINT UNSIGNED NOT NULL,
    balance DECIMAL(6,2) UNSIGNED NOT NULL,
    PRIMARY KEY (user_account_id)
) ENGINE = InnoDB;

CREATE TABLE transaction (
    transaction_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    sender_user_account_id BIGINT UNSIGNED NOT NULL,
    receiver_user_account_id BIGINT UNSIGNED NOT NULL,
    description VARCHAR(60) NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(6,2) UNSIGNED NOT NULL,
    fee DECIMAL(4,2) UNSIGNED NOT NULL,
    transaction_type VARCHAR(40) NOT NULL,
    PRIMARY KEY (transaction_id)
) ENGINE = InnoDB;

CREATE TABLE network (
    network_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_account_id BIGINT UNSIGNED NOT NULL,
    connection_account_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (network_id)
) ENGINE = InnoDB;

ALTER TABLE person
    ADD CONSTRAINT fk_bank_account_rib
        FOREIGN KEY (bank_account_rib)
            REFERENCES bank_account(rib)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD INDEX ind_name (first_name, last_name);

ALTER TABLE user_account
    ADD CONSTRAINT fk_user_person_id
        FOREIGN KEY (user_account_id)
            REFERENCES person(person_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE transaction
    ADD CONSTRAINT fk_sender
        FOREIGN KEY (sender_user_account_id)
            REFERENCES user_account(user_account_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_receiver
        FOREIGN KEY(receiver_user_account_id)
            REFERENCES user_account(user_account_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD INDEX ind_date (transaction_date),
    ADD INDEX ind_sender (sender_user_account_id),
    ADD INDEX ind_receiver (receiver_user_account_id);

ALTER TABLE network
    ADD CONSTRAINT fk_user
        FOREIGN KEY (user_account_id)
            REFERENCES user_account(user_account_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_connection
        FOREIGN KEY (connection_account_id)
            REFERENCES user_account(user_account_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;