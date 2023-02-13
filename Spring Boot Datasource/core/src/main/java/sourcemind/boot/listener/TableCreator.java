package sourcemind.boot.listener;

import com.sourcemind.data.JDBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class TableCreator {
    private final static Logger LOGGER = LoggerFactory.getLogger(TableCreator.class);

    private final Connection connection;

    public TableCreator(final JDBConnection connection) {
        this.connection = connection.getConnection();
    }

    public void createTable() {
        String query = "create table if not exists users (id bigserial, username varchar(255));";
        LOGGER.info("Executing query - {}", query);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
