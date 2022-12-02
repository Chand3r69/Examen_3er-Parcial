package com.chander.dao;

import com.chander.util.conectorBD;
import com.chander.model.Coche;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CochesDao {

    private Connection connection;
    public CochesDao() {
        connection = conectorBD.getConnection();
    }

    public void addCoches(Coche coche) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO coches (matricula, modelo, color, precio, marca, nif) VALUES (?, ?, ?, ?, ?, ?)"

            );
            preparedStatement.setString(1, coche.getMatricula());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3, coche.getModelo());
            preparedStatement.setString(4, coche.getColor());
            preparedStatement.setDouble(5, coche.getPrecio());
            preparedStatement.setString(6, coche.getNif());
            preparedStatement.executeUpdate();

            System.out.println(coche + " creado");

        } catch (SQLException e) {
            System.out.println("Error al crear el coche: " + e.getMessage());
        }
    }

            public void updateCoche(Coche coche){
                try {

                    PreparedStatement preparedStatement= connection.prepareStatement(
                            "UPDATE coches SET matricula=?, marca=?, modelo=?, color=?, precio=?, nif=? WHERE matricula=?"

                    );
                    preparedStatement.setString(1,coche.getMatricula());
                    preparedStatement.setString(2,coche.getMarca());
                    preparedStatement.setString(3,coche.getModelo());
                    preparedStatement.setString(4,coche.getColor());
                    preparedStatement.setDouble(5,coche.getPrecio());
                    preparedStatement.setString(6,coche.getNif());

                    preparedStatement.setString(7,coche.getMatricula());
                    preparedStatement.executeUpdate();

                    System.out.println(coche + "editado");

                } catch (SQLException e) {
                    System.out.println("Error al editar el coche: " + e.getMessage());
                }
            }

            public void deleteCoche(String matricula){
                try {


                    PreparedStatement preparedStatement= connection.prepareStatement(
                            "DELETE FROM coches WHERE matricula=?"

                    );
                    preparedStatement.setString(1,matricula);
                    preparedStatement.executeUpdate();


                    System.out.println(matricula + "eliminado");

                } catch (SQLException e) {
                    System.out.println("Error al eliminar la matricula: " + e.getMessage());
                }
            }

            public List<Coche> getALLCoches() {
                List<Coche> coches = new ArrayList<Coche>();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM coches");
                    while (resultSet.next()) {
                        Coche coche = new Coche();
                        coche.setMatricula(resultSet.getString("matricula"));
                        coche.setMarca(resultSet.getString("marca"));
                        coche.setModelo(resultSet.getString("modelo"));
                        coche.setColor(resultSet.getString("color"));
                        coche.setPrecio(resultSet.getDouble("precio"));
                        coche.setNif(resultSet.getString("nif"));

                        coches.add(coche);

                    }

                } catch (SQLException e) {
                    System.out.println("Error al listar los coches: " + e.getMessage());
                }

                return coches;

        }

    }


