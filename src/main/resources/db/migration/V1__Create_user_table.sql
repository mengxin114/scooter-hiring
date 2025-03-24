CREATE TABLE user (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_name VARCHAR(255) NOT NULL,
    mobile VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL,
    last_login_date TIMESTAMP,
    login_count INTEGER
);