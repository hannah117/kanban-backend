CREATE TABLE task (
    id UUID NOT NULL,
    title TEXT,
    description TEXT,
    statusId UUID
);

CREATE TABLE ref_status (
    id UUID NOT NULL,
    name TEXT
);

