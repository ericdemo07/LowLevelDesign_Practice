DROP TABLE IF EXISTS places;

CREATE TABLE trips
(
    id                     UUID PRIMARY KEY,
    driverId               UUID                          NOT NULL,
    passengerId            UUID                          NOT NULL,
    scheduledStartTime     TIMESTAMP WITH TIME ZONE      NOT NULL,
    scheduledEndTime       TIMESTAMP WITH TIME ZONE      NOT NULL,
    actualStartTime        TIMESTAMP WITH TIME ZONE,
    actualEndTime          TIMESTAMP WITH TIME ZONE,
    expectedStartLatitude  DECIMAL(8, 6)                 NOT NULL,
    expectedStartLongitude DECIMAL(9, 6)                 NOT NULL,
    actualStartLatitude    DECIMAL(8, 6),
    actualStartLongitude   DECIMAL(9, 6),
    expectedEndLatitude    DECIMAL(8, 6)                 NOT NULL,
    expectedEndLongitude   DECIMAL(9, 6)                 NOT NULL,
    actualEndLatitude      DECIMAL(8, 6),
    actualEndLongitude     DECIMAL(9, 6),
    status                 ENUM ('IN_PROGRESS', 'OTHER') NOT NULL,
    estimatedPrice         DECIMAL(4, 2)                 NOT NULL,
    actualPrice            DECIMAL(4, 2)
);

CREATE TABLE trips_history
(
    id                     UUID PRIMARY KEY,
    driverId               UUID                        NOT NULL,
    passengerId            UUID                        NOT NULL,
    scheduledStartTime     TIMESTAMP WITH TIME ZONE    NOT NULL,
    scheduledEndTime       TIMESTAMP WITH TIME ZONE    NOT NULL,
    actualStartTime        TIMESTAMP WITH TIME ZONE    NOT NULL,
    actualEndTime          TIMESTAMP WITH TIME ZONE    NOT NULL,
    expectedStartLatitude  DECIMAL(8, 6)               NOT NULL,
    expectedStartLongitude DECIMAL(9, 6)               NOT NULL,
    actualStartLatitude    DECIMAL(8, 6)               NOT NULL,
    actualStartLongitude   DECIMAL(9, 6)               NOT NULL,
    expectedEndLatitude    DECIMAL(8, 6)               NOT NULL,
    expectedEndLongitude   DECIMAL(9, 6)               NOT NULL,
    actualEndLatitude      DECIMAL(8, 6)               NOT NULL,
    actualEndLongitude     DECIMAL(9, 6)               NOT NULL,
    status                 ENUM ('COMPLETED', 'OTHER') NOT NULL,
    estimatedPrice         DECIMAL(4, 2)               NOT NULL,
    actualPrice            DECIMAL(4, 2)               NOT NULL
);
