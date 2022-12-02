package com.chander.dao;

import com.chander.util.conectorBD;
import com.chander.model.Revision;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {

    private Connection connection;
    public RevisionDao(){
        connection = conectorBD.getConnection();

    }

    public void addRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO revison (codigo, aceite, frenos, filtro, matricula) VALUES (?, ?, ?, ?, ?) "
            );
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getAceite());
            preparedStatement.setString(3,revision.getFiltro());
            preparedStatement.setString(4,revision.getFrenos());
            preparedStatement.setString(5,revision.getMatricula());
            preparedStatement.executeUpdate();

            System.out.println( revision + " creada.");

        } catch ( SQLException e){
            System.out.println( "Error al crear una revision: " + e.getMessage());
        }

    }


    public void updateRevision(Revision revision){
        try {


            PreparedStatement preparedStatement= connection.prepareStatement(
                    "UPDATE revision SET codigo=?, aceite=?, frenos=?, filtro=?, matricula=? WHERE codigo=?"

            );
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getAceite());
            preparedStatement.setString(3,revision.getFiltro());
            preparedStatement.setString(4,revision.getFrenos());
            preparedStatement.setString(5,revision.getMatricula());

            preparedStatement.setString(6,revision.getCodigo());
            preparedStatement.executeUpdate();

            System.out.println(revision + " editar");

        } catch (SQLException e) {
            System.out.println(" Error al editar revision: " + e.getMessage());
        }

    }

    public void deleteRevision(String codigo){
        try {


            PreparedStatement preparedStatement= connection.prepareStatement(
                    "DELETE FROM revision WHERE codigo=?"

            );
            preparedStatement.setString(1,codigo);
            preparedStatement.executeUpdate();


            System.out.println(codigo + " eliminado");

        } catch (SQLException e) {
            System.out.println(" Error al editar la reivsion: " + e.getMessage());
        }

    }

    public List<Revision> getALLRevision(){

        List<Revision> Revisions = new ArrayList<Revision>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM revision");
            while (resultSet.next()) {
                Revision revision = new Revision();
                revision.setCodigo(resultSet.getString("codigo"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setFrenos(resultSet.getString("frenos"));
                revision.setMatricula(resultSet.getString("matricula"));

                Revisions.add(revision);


            }

        } catch (SQLException e) {
            System.out.println("Error al listar las revisiones : " + e.getMessage());
        }

        return Revisions;


            }










}
