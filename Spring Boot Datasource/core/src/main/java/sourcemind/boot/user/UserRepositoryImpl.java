package sourcemind.boot.user;

import com.sourcemind.data.JDBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Connection connection;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    public UserRepositoryImpl(final JDBConnection connection) {
        this.connection = connection.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }


    @Override
    public void save(User user) {
        String query = "insert into users (username) values (?) returning id";
        LOGGER.info("Trying to insert user - {}", user);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getLong("id"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("User is successfully inserted new id is {}", user.getId());
    }
}
