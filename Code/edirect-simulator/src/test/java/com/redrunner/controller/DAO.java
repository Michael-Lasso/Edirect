package com.redrunner.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import online.edirect.geocoordinates.Coordinates;
import online.edirect.utils.Constants;

public class DAO {

	public void create(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();

			String sql = "CREATE SEQUENCE coordinate_id_seq START WITH 1 INCREMENT BY 1;"
					+ "ALTER TABLE location ADD COLUMN id numeric DEFAULT nextval('coordinate_id_seq');"
					+ "ALTER SEQUENCE coordinate_id_seq OWNED BY location.id;";
			String sql1 = "CREATE TABLE LOCATION (ID numeric, STREET_NAME VARCHAR(100), LATITUDE VARCHAR(100), "
					+ " LONGITUDE VARCHAR(100),  TIMESTAMP VARCHAR(100))";
			String sql2 = "DROP TABLE LOCATION ";

			// stmt.executeUpdate(sql2);
			// stmt.executeUpdate(sql1);
			// stmt.executeUpdate("drop table account;");
			stmt.executeUpdate(
					"CREATE TABLE bookmark (id INT AUTO_INCREMENT primary key NOT NULL, uri VARCHAR(20), description VARCHAR(25))");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void delete(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();

			String sql1 = "delete from street_intersection";

			stmt.executeUpdate(sql1);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Constants.URL + Constants.DBNAME, Constants.USERNAME,
					Constants.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void insertRecord(Coordinates coords) {
		String insertTableSQL = "INSERT INTO LOCATION (STREET_NAME, LATITUDE,  LONGITUDE,  TIMESTAMP) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			Connection conn = getConnection();
			preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, coords.getName());
			preparedStatement.setString(2, coords.getLatitude());
			preparedStatement.setString(3, coords.getLongitude());
			preparedStatement.setString(4, coords.getTimeStamp());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Coordinates> select() {
		Connection conn = null;
		Statement stmt = null;
		List<Coordinates> list = null;
		try {

			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "SELECT * FROM red_runner";

			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("STREET_NAME");
				String lat = rs.getString("LATITUDE");
				String lon = rs.getString("LONGITUDE");
				Long id = rs.getLong("red_runner_id");
				// String time = rs.getString("TIMESTAMP");
				System.out.println(id);
				Coordinates coord = new Coordinates(lat, lon, name, null);
				list.add(coord);
				// Display values

			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return list;
	}// end main

//	public static void main(String[] args) {
//		DAO dao = new DAO();
//		Connection conn = getConnection();
////		 dao.create(conn);
//		 dao.delete(conn);
////		List<Coordinates> list = dao.select();
////		list.forEach(a -> System.out.println(a));
//	}

}
