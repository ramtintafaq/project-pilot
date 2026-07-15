CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,

                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,

                       email VARCHAR(255) NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,

                       status VARCHAR(30) NOT NULL DEFAULT 'PENDING_VERIFICATION',

                       created_at TIMESTAMP(6) NOT NULL,
                       updated_at TIMESTAMP(6) NOT NULL,

                       deleted_at TIMESTAMP(6) NULL,
                       deleted_by BIGINT NULL,

                       CONSTRAINT pk_users
                           PRIMARY KEY (id),

                       CONSTRAINT uk_users_email
                           UNIQUE (email),

                       CONSTRAINT chk_users_status
                           CHECK (
                               status IN (
                                          'PENDING_VERIFICATION',
                                          'ACTIVE',
                                          'SUSPENDED',
                                          'DISABLED',
                                          'DELETED'
                                   )
                               ),

                       CONSTRAINT fk_users_deleted_by
                           FOREIGN KEY (deleted_by)
                               REFERENCES users(id)
);