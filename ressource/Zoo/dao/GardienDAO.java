package dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Set;

import modele.Cage;
import modele.Gardien;

public class GardienDAO extends DAO<Gardien> {

	public GardienDAO(Connection conn) throws SQLException{
		super(conn);
	}


	@Override
	public boolean create(Gardien obj)throws SQLException {
		return false;
	}

	@Override
	public Gardien read(Object obj) throws SQLException{
		return null;
	}

	@Override
	public Set<Gardien> readAll() throws SQLException {
		return null;
	}

	@Override
	public boolean update(Gardien gardien) throws SQLException{
		return false;
	}

	public boolean AddCage(Gardien gardien, Cage cage) throws SQLException{

		/* TO DO */

		return false;
	}


	@Override
	public boolean delete(Gardien obj) throws SQLException{
		return false;
	}

}
