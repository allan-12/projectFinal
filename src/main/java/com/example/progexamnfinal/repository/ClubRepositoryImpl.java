package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Club;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class ClubRepositoryImpl implements ClubRepository {
    private Connection connection;

    @Override
    public void insert(Club club) {
        String sql = "INSERT INTO Club (Club_id, Club_name, Club_description, Creation_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, club.getClubId());
            statement.setString(2, club.getClubName());
            statement.setString(3, club.getClubDescription());
            statement.setDate(4, Date.valueOf(club.getCreationDate()));

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("insertion reussie :" + insert);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void update(int id , Club club) {
        String sql = "UPDATE Club SET Club_name = ?, Club_description = ?, Creation_date = ? WHERE Club_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, club.getClubName());
            statement.setString(2, club.getClubDescription());
            statement.setDate(3, Date.valueOf(club.getCreationDate()));
            statement.setInt(4, club.getClubId());
            int update  = statement.executeUpdate();
            if (update >0){
                System.out.println("Mise a jour reussie :" +update);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Club WHERE Club_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int delete = statement.executeUpdate();
            if (delete >0){
                System.out.println("Suppression reussie :" +delete);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Club findById(int id) {
        Club club = null;
        String sql = "SELECT * FROM Club WHERE Club_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                club = new Club(
                        resultSet.getInt("Club_id"),
                        resultSet.getString("Club_name"),
                        resultSet.getString("Club_description"),
                        resultSet.getDate("Creation_date").toLocalDate()
                );
            }
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return club;
    }

    @Override
    public List<Club> findAll() {
        List<Club> clubs = new ArrayList<>();
        String sql = "SELECT Club_id, Club_name, Club_description, Creation_date FROM Club";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Club club = new Club(
                        resultSet.getInt("Club_id"),
                        resultSet.getString("Club_name"),
                        resultSet.getString("Club_description"),
                        resultSet.getDate("Creation_date").toLocalDate()
                );
                clubs.add(club);
            }
        }catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return clubs;
    }
}
