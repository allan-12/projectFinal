package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.connection.DatabaseConfig;
import com.example.progexamnfinal.model.Club;
import com.example.progexamnfinal.model.Membre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class MembreRepositoryImpl implements MembreRepository{

    private Connection connection;

    @Override
    public void insert(Membre membre) {
        String sql = "INSERT INTO Membre (Membership_date, Role, Club_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(membre.getMembershipDate()));
            statement.setString(2, membre.getRole());
            statement.setInt(3, membre.getClub().getClubId());

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Insertion réussie : " + insert);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Membre membre) {
        String sql = "UPDATE Membre SET Membership_date = ?, Role = ?, Club_id = ? WHERE Membre_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(membre.getMembershipDate()));
            statement.setString(2, membre.getRole());
            statement.setInt(3, membre.getClub().getClubId());
            statement.setInt(4, id);

            int update = statement.executeUpdate();
            if (update > 0) {
                System.out.println("Mise à jour réussie : " + update);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Membre WHERE Membre_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int delete = statement.executeUpdate();
            if (delete > 0) {
                System.out.println("Suppression réussie : " + delete);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Membre findById(int id) {
        Membre membre = null;
        String sql = "SELECT * FROM Membre WHERE Membre_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                membre = new Membre(
                        resultSet.getInt("Membre_id"),
                        resultSet.getDate("Membership_date").toLocalDate(),
                        resultSet.getString("Role"),
                        new Club(resultSet.getInt("Club_id"), "", "", null)
                );
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return membre;
    }

    @Override
    public List<Membre> findAll() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT Membre_id, Membership_date, Role, Club_id FROM Membre";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Membre membre = new Membre(
                        resultSet.getInt("Membre_id"),
                        resultSet.getDate("Membership_date").toLocalDate(),
                        resultSet.getString("Role"),
                        new Club(resultSet.getInt("Club_id"), "", "", null)
                );
                membres.add(membre);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return membres;
    }
}
