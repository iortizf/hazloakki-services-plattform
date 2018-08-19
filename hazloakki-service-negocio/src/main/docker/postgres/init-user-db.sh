#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER admin PASSWORD 'admin';
    CREATE DATABASE hazloakki_negocio OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE hazloakki_negocio TO admin;
EOSQL