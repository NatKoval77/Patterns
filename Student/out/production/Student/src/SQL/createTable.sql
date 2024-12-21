CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    surname VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100) NOT NULL,
    tg VARCHAR(100),
    git VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(11),
    CHECK (tg IS NOT NULL OR email  IS NOT NULL OR phone IS NOT NULL)
);