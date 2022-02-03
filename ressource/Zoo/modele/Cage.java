package modele;

import modele.Animal;
import modele.Gardien;

import java.util.Set;

public class Cage {
  private Integer noCage;
  private String fonction;
  private long noAlle;
  private Set<Animal> lstAnimals;
  private Set<Gardien> lstGardiens;
  
  public Cage() {
  }

  public Cage(Integer c) {
    noCage = c;
  }

  public Integer getNoCage() {
    return noCage;
  }

  public void setNoCage(Integer c) {
    noCage = c;
  }
  
  public String getFonction() {
    return fonction;
  }  

  public void setFonction(String f) {
    fonction = f;
  }

  public long getNoAlle() {
    return noAlle;
  }
 
  public void setNoAlle(long n) {
    noAlle = n;
  }
  
  public Set<Animal> getAnimals() {
	    return lstAnimals;
	  }
	  
  public void setAnimals(Set<Animal> l) {
	    lstAnimals = l;
	  }

  public Set<Gardien> getGardiens() {
	    return lstGardiens;
	  }
	  
public void setGardiens(Set<Gardien> l) {
	    lstGardiens = l;
	  }
}
