-- todo_schema

-- !Ups
CREATE TABLE public.todo
(
    id         SERIAL  NOT NULL,
    name       TEXT    NOT NULL,
    isComplete boolean NOT NULL,
    PRIMARY KEY (id)
);

-- !Downs
DROP TABLE public.todo CASCADE;
