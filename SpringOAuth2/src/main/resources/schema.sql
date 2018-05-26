DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id               VARCHAR(256) PRIMARY KEY,
  resource_ids            VARCHAR(256),
  client_secret           VARCHAR(256),
  scope                   VARCHAR(256),
  authorized_grant_types  VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities             VARCHAR(256),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(256)
);

INSERT INTO oauth_client_details (client_id,
                                  resource_ids,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity)
VALUES
  ('oauth2-client', 'resource-server-rest-api', '$2a$10$aCHqJj1oaTyljs686vZLcuHNSBgoAhr2DPHYjA5XYzAyKTZ7yTxIa', 'read',
   'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id          VARCHAR(255),
  token             BYTEA,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id          VARCHAR(255),
  token             BYTEA,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BYTEA,
  refresh_token     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id       VARCHAR(255),
  token          BYTEA,
  authentication BYTEA
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code           VARCHAR(255),
  authentication BYTEA
);

CREATE TABLE IF NOT EXISTS oauth_approvals (
  userId         VARCHAR(255),
  clientId       VARCHAR(255),
  scope          VARCHAR(255),
  status         VARCHAR(10),
  expiresAt      TIMESTAMP,
  lastModifiedAt TIMESTAMP
);