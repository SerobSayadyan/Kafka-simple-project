package org.example.consumer_service.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @SuppressWarnings("all")
    public static boolean createDatabaseIfNotExists() {
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            logger.debug("Checking and creating database if not exists...");

            final String DB_USERNAME = "postgres";
            final String DB_PASSWORD = "postgres";
            final String DB_HOST = "postgresSQL";
            final String DB_PORT = "5432";
            final String DB_NAME = "messages";

            // Connect to the PostgreSQL server (not to the target database)
            String url = String.format("jdbc:postgresql://%s:%s/postgres", DB_HOST, DB_PORT);
            connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);

            // Check if the database exists
            String checkDatabaseExistsQuery = "SELECT 1 FROM pg_database WHERE datname = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkDatabaseExistsQuery)) {
                checkStatement.setString(1, DB_NAME);
                resultSet = checkStatement.executeQuery();
                if (!resultSet.next()) {
                    // Create the database if it does not exist
                    String createDatabaseQuery = "CREATE DATABASE " + DB_NAME;
                    try (Statement createStatement = connection.createStatement()) {
                        createStatement.executeUpdate(createDatabaseQuery);
                        logger.debug("Database created: {}", DB_NAME);
                    }
                } else {
                    logger.debug("Database already exists: {}", DB_NAME);
                }
            }

            return true;

        } catch (SQLException e) {
            logger.error("Error creating database: {}", e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    logger.debug("Closed ResultSet.");
                }
                if (connection != null) {
                    connection.close();
                    logger.debug("Closed Connection.");
                }
            } catch (SQLException e) {
                logger.error("Error closing resources: {}", e.getMessage());
            }
        }
    }
}

