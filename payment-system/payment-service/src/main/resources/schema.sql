DROP TABLE IF EXISTS credit_card_information;

CREATE TABLE credit_card_information
(
    id          VARCHAR(36) PRIMARY KEY,
    user_id     VARCHAR(80)              NOT NULL,
    card_number VARCHAR(80)              NOT NULL,
    card_name   VARCHAR(80)              NOT NULL,
    cvv_number  VARCHAR(3)               NOT NULL,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL
);
