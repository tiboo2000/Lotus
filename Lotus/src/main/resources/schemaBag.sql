CREATE TABLE bag (
        id SERIAL PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        bagcontent VARCHAR(10000) NOT NULL
);