SELECT * FROM student WHERE phone IS NOT NULL;
SELECT * FROM student WHERE email IS NOT NULL;
SELECT * FROM student WHERE (tg IS NULL)::int + (email IS NULL)::int + (phone IS NULL)::int <= 1;