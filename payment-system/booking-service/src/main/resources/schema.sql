DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings
(
    id         VARCHAR(36) PRIMARY KEY,
    item_id    VARCHAR(80)              NOT NULL,
    user_id    VARCHAR(80)              NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
