#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL

    CREATE USER admin PASSWORD 'admin';

    CREATE DATABASE hazloakki_cuenta OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_cuenta TO admin;

    CREATE DATABASE hazloakki_negocio OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_negocio TO admin;

    CREATE DATABASE hazloakki_catalogos OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_catalogos TO admin;

    CREATE DATABASE hazloakki_ofertas OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_ofertas TO admin;

    CREATE DATABASE hazloakki_analitica OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_analitica TO admin;
EOSQL