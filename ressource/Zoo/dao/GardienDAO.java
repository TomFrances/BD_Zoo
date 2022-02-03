package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

import modele.Cage;
import modele.Gardien;
import modele.Specialite;

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
		Gardien gardien = null;

		/* TO DO */
		try {
			ResultSet result = this.conn.createStatement().executeQuery("select * from LesGardiens where ");
			while (resultAnimaux.next()) {

				Animal animal = new Animal();

				animal.setNomA(resultAnimaux.getString("nomA"));
				animal.setSexe(resultAnimaux.getString("sexe"));
				animal.setType(resultAnimaux.getString("type_an"));
				animal.setFonctionCage(resultAnimaux.getString("fonction_cage"));
				animal.setPays(resultAnimaux.getString("pays"));
				animal.setAnNais(resultAnimaux.getInt("anNais"));

				int noCage = resultAnimaux.getInt("noCage");

				ResultSet resultCage = this.conn.createStatement().executeQuery(String.format("select * from LesCages where noCage = %d", noCage));
				Cage cage = new Cage(noCage);
				resultCage.next();
				cage.setFonction(resultCage.getString("fonction"));
				cage.setNoAlle(resultCage.getLong("noAllee"));

				animal.setLaCage(cage);

				ResultSet resultMaladies = this.conn.createStatement()
						.executeQuery(String.format("select * from LesMaladies where nomA = '%s'", animal.getNomA()));

				Set<String> maladies = new HashSet<>();
				while(resultMaladies.next()) {
					maladies.add(resultMaladies.getString("nomM"));
				} 

				animal.setMaladies(maladies);

				animaux.add(animal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gardien;
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
