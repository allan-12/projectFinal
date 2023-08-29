package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Event_Participation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class EventParticipationRepositoryImpl implements EventParticipationRepository {
    private final Connection connection;

    @Override
    public void insert(Event_Participation eventParticipation) {
        String sql = "INSERT INTO Event_Participation (Participation_date, Event_id, Student_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(eventParticipation.getParticipationDate()));
            statement.setInt(2, eventParticipation.getEventId());
            statement.setInt(3, eventParticipation.getStudentId());

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Insertion réussie : " + insert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Event_Participation eventParticipation) {

    }

    @Override
    public void update(Event_Participation eventParticipation) {
        String sql = "UPDATE Event_Participation SET Participation_date = ?, Event_id = ?, Student_id = ? WHERE Participation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(eventParticipation.getParticipationDate()));
            statement.setInt(2, eventParticipation.getEventId());
            statement.setInt(3, eventParticipation.getStudentId());
            statement.setInt(4, eventParticipation.getParticipationId());

            int update = statement.executeUpdate();
            if (update > 0) {
                System.out.println("Mise à jour réussie : " + update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int participationId) {
        String sql = "DELETE FROM Event_Participation WHERE Participation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, participationId);
            int delete = statement.executeUpdate();
            if (delete > 0) {
                System.out.println("Suppression réussie : " + delete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event_Participation findById(int participationId) {
        Event_Participation eventParticipation = null;
        String sql = "SELECT * FROM Event_Participation WHERE Participation_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, participationId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                eventParticipation = new Event_Participation(
                        resultSet.getInt("Participation_id"),
                        resultSet.getDate("Participation_date").toLocalDate(),
                        resultSet.getInt("Event_id"),
                        resultSet.getInt("Student_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventParticipation;
    }

    @Override
    public List<Event_Participation> findAll() {
        List<Event_Participation> eventParticipations = new ArrayList<>();
        String sql = "SELECT * FROM Event_Participation";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Event_Participation eventParticipation = new Event_Participation(
                        resultSet.getInt("Participation_id"),
                        resultSet.getDate("Participation_date").toLocalDate(),
                        resultSet.getInt("Event_id"),
                        resultSet.getInt("Student_id")
                );
                eventParticipations.add(eventParticipation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventParticipations;
    }


}
