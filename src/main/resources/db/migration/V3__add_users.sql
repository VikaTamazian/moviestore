INSERT INTO users
VALUES (1, 'admin', 'admin@admin.com', '$2a$12$wLG2P0DSWc.4QB9IlBBAXuVkeUAZXeh90lM6987QCKT9bHkjRnLcK'),
       (2, 'user', 'user@user.com', '$2a$12$2P29pruCqwBgPIRapHzf8uei3rqAHiJ1ZbNK4tfTRhWxDUGG4WHEy');

INSERT INTO roles
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO user_roles
VALUES (1, 1),
       (2, 2);