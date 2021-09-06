DROP TABLE IF EXISTS places;

CREATE TABLE places
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(80)   NOT NULL,
    latitude  DECIMAL(8, 6) NOT NULL,
    longitude DECIMAL(9, 6) NOT NULL,
    category  ENUM ('COFFEE_SHOP','RESTAURANT','THEATRE', 'PIZZA_RESTAURANT'),
    grid_id   UUID          NOT NULL
);
