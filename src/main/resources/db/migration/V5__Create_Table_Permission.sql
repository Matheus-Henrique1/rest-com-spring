﻿CREATE TABLE IF NOT EXISTS permission (
    id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE),
    description varchar(255) DEFAULT NULL,
    PRIMARY KEY(id)
)