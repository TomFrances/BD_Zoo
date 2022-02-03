package modele;

public class Specialite {
  private String fonction_cage;

   public Specialite() {
    }

   public Specialite(String n) {
        this.fonction_cage = n;
    }

  public String getFonctionCage() {
    return fonction_cage;
  }  

  public void setFonctionCage(String n) {
    fonction_cage = n;
  }

}