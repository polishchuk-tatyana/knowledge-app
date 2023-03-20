package com.knowledge.app.repository;

import com.knowledge.app.config.DatabaseConfiguration;
import com.knowledge.app.domain.KnowledgePackageSet;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class KnowledgePackageSetRepository {

    Connection connection = DatabaseConfiguration.getConnection();

    public void save(KnowledgePackageSet knowledgePackageSet){
        try {
            String sqlRequest = "insert into KnowledgePackageSet values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, knowledgePackageSet.getId());
            preparedStatement.setString(2, knowledgePackageSet.getTitle());
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int knowledgePackageSetId){
        try {
            String sqlRequest = "delete from KnowledgePackageSet where id="+knowledgePackageSetId;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<KnowledgePackageSet> findAll() {
        List<KnowledgePackageSet> knowledgePackageSets = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sqlRequest = "select * from KnowledgePackageSet";
            ResultSet findAllKnowledgePackageSetResult = statement.executeQuery(sqlRequest);

            while(findAllKnowledgePackageSetResult.next()){
                KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();

                knowledgePackageSet.setId(findAllKnowledgePackageSetResult.getInt("id"));
                knowledgePackageSet.setTitle(findAllKnowledgePackageSetResult.getString("title"));

                knowledgePackageSets.add(knowledgePackageSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return knowledgePackageSets;
    }
}