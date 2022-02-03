package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

import modele.Cage;
import modele.Animal;

public class AnimalDAO extends DAO<Animal> {

	public AnimalDAO(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public boolean create(Animal obj) throws SQLException {

		/* TO DO */
		try {
			String sql = "insert into LesAnimaux values (?,?,?,?,?,?,?,?)";
			PreparedStatement query = this.conn.prepareStatement(sql);
			query.setString(1, obj.getNomA());
			query.setString(2, obj.getSexe());
			query.setString(3, obj.getType());
			query.setString(4, obj.getFonctionCage());
			query.setString(5, obj.getPays());
			query.setInt(6, obj.getAnNais());
			query.setInt(7, obj.getLaCage().getNoCage());
			query.setInt(8, obj.getMaladies().size());

			//exécution
			query.executeQuery();

			sql = "insert into LesMaladies values (?,?)";
			query = this.conn.prepareStatement(sql);
			query.setString(1, obj.getNomA());

			System.out.println(String.format("Nombre de maladies de l'animal %s : %d", obj.getNomA(), obj.getMaladies().size()));
			for(String maladie : obj.getMaladies()){
				query.setString(2, maladie);
				query.executeQuery();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Animal read(Object obj) throws SQLException {
		return null;
	}

	@Override
	public Set<Animal> readAll() throws SQLException {
		Set<Animal> animaux = new HashSet<>();

		/* TO DO */
		try {
			ResultSet resultAnimaux = this.conn.createStatement().executeQuery("select * from LesAnimaux");
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
		return animaux;
	}

	@Override
	public boolean update(Animal animal) throws SQLException {
		return false;
	}

	@Override
	public boolean delete(Animal obj) throws SQLException {
		return false;
	}

}
