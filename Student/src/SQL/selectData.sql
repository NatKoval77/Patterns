SELECT * FROM student WHERE phone IS NOT NULL;
SELECT * FROM student WHERE tg IS NOT NULL AND git IS NOT NULL AND email IS NOT NULL AND phone IS NOT NULL;
SELECT * FROM student WHERE (tg IS NULL)::int + (email IS NULL)::int + (phone IS NULL)::int <= 1;