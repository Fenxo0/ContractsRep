package org.contract.api.util.jdbc;

import org.contract.api.model.Client;
import org.contract.api.model.Internet;
import org.contract.api.model.Mobile;
import org.contract.api.model.TV;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {

    //User database data
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";

    //Database connection
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/example";

    //SQL
    private final String INSERT_CLIENT  = "INSERT INTO CLIENT (SNP, SEX, PASSPORT_SERIES, PASSPORT_NUMBER, BIRTH_DATE, AGE) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private final String INSERT_MOBILE  = "INSERT INTO MOBILE (AMOUNT_INTERNET, AMOUNT_SMS, AMOUNT_CALL, START_DATE, END_DATE, CLIENT_ID) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private final String INSERT_INTERNET  = "INSERT INTO INTERNET (MAX_SPEED, START_DATE, END_DATE, CLIENT_ID) "
            + "VALUES (?, ?, ?, ?)";
    private final String INSERT_TV  = "INSERT INTO TV (PACKAGE_TV, START_DATE, END_DATE, CLIENT_ID) "
            + "VALUES (?, ?, ?, ?)";
    private final String CLIENT_SELECT = "SELECT * FROM CLIENT";
    private final String INTERNET_SELECT = "SELECT * FROM INTERNET";
    private final String MOBILE_SELECT = "SELECT * FROM MOBILE";
    private final String TV_SELECT = "SELECT * FROM TV";

    private Connection conn;
    private Statement stmt;

    public void insertClient(Client client){
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(INSERT_CLIENT);
            preparedStatement.setString(1, client.getSNP());
            preparedStatement.setString(2, client.getSex());
            preparedStatement.setInt(3, client.getSerPas());
            preparedStatement.setInt(4, client.getNumPas());
            preparedStatement.setDate(5, Date.valueOf(client.getBirthDate()));
            preparedStatement.setInt(6, client.getAge());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertMobile(Mobile mobile){
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(INSERT_MOBILE);
            preparedStatement.setString(1, mobile.getAmountInternet());
            preparedStatement.setInt(2, mobile.getAmountSMS());
            preparedStatement.setInt(3, mobile.getAmountCall());
            preparedStatement.setDate(4, Date.valueOf(mobile.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(mobile.getEndDate()));
            preparedStatement.setInt(6, mobile.getClient().getId());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertInternet(Internet internet){
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(INSERT_INTERNET);
            preparedStatement.setInt(1, internet.getMaxSpeed());
            preparedStatement.setDate(2, Date.valueOf(internet.getStartDate()));
            preparedStatement.setDate(3, Date.valueOf(internet.getEndDate()));
            preparedStatement.setInt(4, internet.getClient().getId());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertTV(TV tv){
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(INSERT_TV);
            preparedStatement.setString(1, tv.getPackageTV());
            preparedStatement.setDate(2, Date.valueOf(tv.getStartDate()));
            preparedStatement.setDate(3, Date.valueOf(tv.getEndDate()));
            preparedStatement.setInt(4, tv.getClient().getId());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Client> selectClients(){
        List<Client> clients = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(CLIENT_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Client client = new Client.Builder()
                        .setId(resultSet.getInt("ID"))
                        .setSNP(resultSet.getString("SNP"))
                        .setBirthDate((resultSet.getTimestamp("BIRTH_DATE")).toLocalDateTime().toLocalDate())
                        .setSex(resultSet.getString("SEX"))
                        .setNumPas(resultSet.getInt("PASSPORT_SERIES"))
                        .setSerPas(resultSet.getInt("PASSPORT_NUMBER"))
                        .build();
                clients.add(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Internet> selectInternets(){
        List<Internet> internets = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(INTERNET_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Internet internet = new Internet.Builder()
                        .setId(resultSet.getInt("ID"))
                        .setStartDate(resultSet.getTimestamp("START_DATE").toLocalDateTime().toLocalDate())
                        .setEndDate(resultSet.getTimestamp("END_DATE").toLocalDateTime().toLocalDate())
                        .build();
                internets.add(internet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return internets;
    }

    public List<Mobile> selectMobiles(){
        List<Mobile> mobiles = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(MOBILE_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Mobile mobile = new Mobile.Builder()
                        .setId(resultSet.getInt("ID"))
                        .setStartDate(resultSet.getTimestamp("START_DATE").toLocalDateTime().toLocalDate())
                        .setEndDate(resultSet.getTimestamp("END_DATE").toLocalDateTime().toLocalDate())
                        .setAmountInternet(resultSet.getString("AMOUNT_INTERNET"))
                        .setAmountCall(resultSet.getInt("AMOUNT_CALL"))
                        .setAmountSMS(resultSet.getInt("AMOUNT_SMS"))
                        .build();
                mobiles.add(mobile);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mobiles;
    }

    public List<TV> selectTVs(){
        List<TV> tvs = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement(TV_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TV tv = new TV.Builder()
                        .setId(resultSet.getInt("ID"))
                        .setStartDate(resultSet.getTimestamp("START_DATE").toLocalDateTime().toLocalDate())
                        .setEndDate(resultSet.getTimestamp("END_DATE").toLocalDateTime().toLocalDate())
                        .setPackageTV(resultSet.getString("PACKAGE_TV"))
                        .build();
                tvs.add(tv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tvs;
    }
}
