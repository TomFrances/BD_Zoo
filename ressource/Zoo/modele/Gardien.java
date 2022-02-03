package modele;

import java.util.HashSet;
import java.util.Set;

import modele.Cage;
import modele.Specialite;

public class Gardien {
   private String nomE ;
   private Set<Cage> lstCage;
   private Set<String> lstSpecialites;

  public Gardien() {
  }

  public Gardien(String n) {
    this.nomE = n;
  }

  public String getNomE() {
    return nomE;
  }
  
  public void setNomE(String n) {
    nomE = n;
  }
 
   public Set<Cage> getCages() {
    return lstCage;
  }
  
  public void setCages(Set<Cage> l) {
    lstCage = l;
  }
  
   public Set<String> getSpecialites() {
    return lstSpecialites;
  }
  
  public void setSpecialites(Set<String> l) {
    lstSpecialites = l;
  }

}
