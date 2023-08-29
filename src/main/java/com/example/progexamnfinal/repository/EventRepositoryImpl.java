package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Club;
import com.example.progexamnfinal.model.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class EventRepositoryImpl implements EventRepository {
    private Connection connection;
    @Override
    public void insert(Event event) {
        String sql = "INSERT INTO Event (event_name, event_description, start_date_time, end_date_time, club_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(event.getStartDateTime()));
            statement.setTimestamp(4, java.sql.Timestamp.valueOf(event.getEndDateTime()));
            statement.setInt(5, event.getClubId().getClubId());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Event event) {
        String sql = "UPDATE Event SET Event_name = ?, Event_description = ?, Start_date_time = ?, End_date_time = ?, Club_id = ? WHERE Event_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setTimestamp(3, Timestamp.valueOf(event.getStartDateTime()));
            statement.setTimestamp(4, Timestamp.valueOf(event.getEndDateTime()));
            statement.setInt(5, event.getClubId().getClubId());
            statement.setInt(6, event.getEventId());
            statement.executeUpdate();
        }
        catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Event WHERE Event_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Event findById(int id) {
        Event event = null;
        String sql = "SELECT * FROM Event WHERE Event_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                event = new Event(resultSet.getInt("Event_id"),
                        resultSet.getString("Event_name"),
                        resultSet.getString("Event_description"),
                        resultSet.getTimestamp("Start_date_time").toLocalDateTime(),
                        resultSet.getTimestamp("End_date_time").toLocalDateTime(),
                        new Club(resultSet.getInt("Club_id"), "", "", null)
                );
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return event;
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT Event_id, Event_name, Event_description, Start_date_time, End_date_time, Club_id FROM Event";

        try (PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Event event = new Event(
                    resultSet.getInt("Event_id"),
                    resultSet.getString("Event_name"),
                    resultSet.getString("Event_description"),
                    resultSet.getTimestamp("Start_date_time").toLocalDateTime(),
                    resultSet.getTimestamp("End_date_time").toLocalDateTime(),
                    new Club(
                            resultSet.getInt("Club_id"),
                            "",
                            "",
                            null
                    )
                );
                events.add(event);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return events;
    }
}
