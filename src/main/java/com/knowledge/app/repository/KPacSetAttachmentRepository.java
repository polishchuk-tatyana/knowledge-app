package com.knowledge.app.repository;

import com.knowledge.app.config.DatabaseConfiguration;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class KPacSetAttachmentRepository {

    Connection connection = DatabaseConfiguration.getConnection();

    public void attach(int knowledgePackage, int knowledgePackageSet){
        try {
            String sqlRequest = "insert into k_pacset values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, knowledgePackage);
            preparedStatement.setInt(2, knowledgePackageSet);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteKnowledgePackage(int knowledgePackageId){
        try {
            String sqlRequest = "delete from k_pacset where knowledgePackageId="+knowledgePackageId;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteKnowledgePackageSet(int knowledgePackageSetId){
        try {
            String sqlRequest = "delete from k_pacset where knowledgePackageSetId="+knowledgePackageSetId;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean findAttachedKnowledgePackageSet(int id){
        boolean existKnowledgePackageSet = true;
        try {
            Statement statement = connection.createStatement();
            String sqlRequest = "select knowledgePackageSetId from k_pacset where knowledgePackageSetId=" + id;
            ResultSet ids = statement.executeQuery(sqlRequest);
            if(!ids.next()) existKnowledgePackageSet = false;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return existKnowledgePackageSet;
    }
}