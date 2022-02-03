package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import modele.Cage;
import modele.Gardien;


public class CageDAO extends DAO<Cage> {

	public CageDAO(Connection conn){
		super(conn);
	}
	
	
	@Override
	public boolean create(Cage obj) throws SQLException{
		return false;
	}
	
	@Override
	public Cage read(Object obj) throws SQLException {
		return null;
	}
	
	public Set<Cage> readByFonction(String fonction) throws SQLException {
		Set<Cage> cages = new HashSet<>();
        /* TO DO */
		try {
			ResultSet resultCages = this.conn.createStatement()
			.executeQuery(String.format("select * from LesCages where fonction = '%s'", fonction));
			while (resultCages.next()) {
				Cage cage = new Cage();
				cage.setFonction(resultCages.getString("fonction"));
				cage.setNoAlle(resultCages.getLong("noAllee"));
				cage.setNoCage(resultCages.getInt("noCage"));
				cages.add(cage);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cages;
	}

	public Set<Cage> readByGardien(Gardien g) throws SQLException {
		Set<Cage> cages = new HashSet<>();

                /* TO DO */

		return cages;
	}
	
	@Override
	public Set<Cage> readAll() throws SQLException {
		return null;
	}

	@Override
	public boolean update(Cage cage) throws SQLException{
		return false;
	}

	@Override
	public boolean delete(Cage obj) throws SQLException {
		return false;
	}



}
