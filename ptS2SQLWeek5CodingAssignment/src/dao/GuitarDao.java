package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Guitar;

public class GuitarDao {

	private Connection connection;
	private final String GET_GUITARS_QUERY = "SELECT * FROM guitars";
	private final String CREATE_NEW_GUITAR_QUERY = "INSERT INTO guitars(make, model) VALUES(?, ?)";
	private final String UPDATE_GUITAR_BY_ID_QUERY = "UPDATE guitars SET make = ?, model = ? WHERE id = ?";
	private final String DELETE_GUITAR_BY_ID_QUERY = "DELETE FROM guitars WHERE id = ?";
	
	public GuitarDao() {
		connection = DBConnection.getConnection();	
	}
	
	public List<Guitar> getGuitars() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_GUITARS_QUERY).executeQuery();
		List<Guitar> guitars = new ArrayList<Guitar>();
		
		while (rs.next()) {
			guitars.add(populateGuitar(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return guitars;
	}
	
	public void createNewGuitar(String make, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_GUITAR_QUERY);
		ps.setString(1, make);
		ps.setString(2, model);
		ps.executeUpdate();
	}
	
	public void updateGuitar(int id, String make, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_GUITAR_BY_ID_QUERY);
		ps.setString(1, make);
		ps.setString(2, model);
		ps.setInt(3, id);
		ps.executeUpdate();
	}
	
	public void deleteGuitarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_GUITAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Guitar populateGuitar(int id, String make, String model) {
		return new Guitar(id, make, model);
	}	
}


