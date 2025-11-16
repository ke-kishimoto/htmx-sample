insert into users(name, email)
values
('Alice', 'Alice@example.com'),
('Bob', 'Bob@example.com'),
('Chris', 'Chris@example.com');

WITH RECURSIVE cnt AS (
    SELECT 1 AS n
    UNION ALL
    SELECT n + 1 FROM cnt WHERE n < 10000
)
INSERT INTO users (name, email)
SELECT
    CONCAT('User', n) AS name,
    CONCAT('user', n, '@example.com') AS email
FROM cnt;