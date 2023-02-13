package org.example;

import javax.sql.DataSource;
import java.sql.*;

public class PooledJDBCTicketRepository implements TicketRepository<Ticket> {
    private static PooledJDBCTicketRepository repository;
    private final DataSource source;

    private PooledJDBCTicketRepository(DataSource source) {
        this.source = source;
    }

    public static PooledJDBCTicketRepository getInstance() {
        if (repository == null) {
            repository = new PooledJDBCTicketRepository(ConfigDataSource.getDataSourceInstance());
        }
        return repository;
    }

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return source.getConnection();
    }

    @Override
    public String save(Ticket ticket) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = source.getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO tickets  values (?, ?, ?)");
            preparedStatement.setString(1, ticket.getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(ticket.getRegisteredDate()));
            preparedStatement.setInt(3, (ticket.isActive() ? 1 : 0));
            preparedStatement.execute();

            return ticket.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();

                if (connection != null) connection.close();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return "No such ticket!";
    }

    @Override
    public int countByActiveIsTrue() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = source.getConnection();

            statement = connection.prepareStatement("select count(id) as c from tickets where active = 1");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("c");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();

                if (connection != null) connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public void consume(String itemID) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = source.getConnection();

            statement = connection.prepareStatement("update tickets set active = 0 where id = ?");
            statement.setString(1, itemID);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();

                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
