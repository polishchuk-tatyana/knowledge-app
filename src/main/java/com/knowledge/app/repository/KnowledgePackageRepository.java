package com.knowledge.app.repository;

import com.knowledge.app.config.DatabaseConfiguration;
import com.knowledge.app.domain.KnowledgePackage;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class KnowledgePackageRepository {

    Connection connection = DatabaseConfiguration.getConnection();

    public void save(KnowledgePackage knowledgePackage){
        try {
            String sqlRequest = "insert into KnowledgePackage values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, knowledgePackage.getId());
            preparedStatement.setString(2, knowledgePackage.getTitle());
            preparedStatement.setString(3, knowledgePackage.getDescription());
            preparedStatement.setDate(4, java.sql.Date.valueOf(knowledgePackage.getCreatingDate()));
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int knowledgePackageId){
        try {
            String sqlRequest = "delete from KnowledgePackage where id="+knowledgePackageId;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<KnowledgePackage> findAll() {
        List<KnowledgePackage> knowledgePackages = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sqlRequest = "select * from KnowledgePackage";
            ResultSet findAllKnowledgePackageResult = statement.executeQuery(sqlRequest);

            while(findAllKnowledgePackageResult.next()){
                KnowledgePackage knowledgePackage = new KnowledgePackage();

                knowledgePackage.setId(findAllKnowledgePackageResult.getInt("id"));
                knowledgePackage.setTitle(findAllKnowledgePackageResult.getString("title"));
                knowledgePackage.setDescription(findAllKnowledgePackageResult.getString("description"));
                knowledgePackage.setCreatingDate(findAllKnowledgePackageResult.getDate("creatingDate").toLocalDate());

                knowledgePackages.add(knowledgePackage);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return knowledgePackages;
    }

    public List<KnowledgePackage> findAllByKnowledgePackageSetId(int knowledgePackageSetId) {
        List<KnowledgePackage> knowledgePackagesInSet = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sqlRequest = "select id, title,description from knowledgepackage\n" +
                    "join k_pacset k on knowledgepackage.id = k.knowledgePackageId\n" +
                    "where k.knowledgePackageSetId = " + knowledgePackageSetId;
            ResultSet resultSet = statement.executeQuery(sqlRequest);

            while(resultSet.next()){
                KnowledgePackage knowledgePackageOfSet = new KnowledgePackage();

                knowledgePackageOfSet.setId(resultSet.getInt("id"));
                knowledgePackageOfSet.setTitle(resultSet.getString("title"));
                knowledgePackageOfSet.setDescription(resultSet.getString("description"));

                knowledgePackagesInSet.add(knowledgePackageOfSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return knowledgePackagesInSet;
    }

    public int getLastKnowledgePackageId(){
        int knowledgePackageId = 0;
        try{
            Statement statement = connection.createStatement();
            String sqlRequest = "select id from knowledgepackage order by id desc limit 1";
            ResultSet resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()) {
                knowledgePackageId = resultSet.getInt("id");
            }

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return knowledgePackageId;
    }
}