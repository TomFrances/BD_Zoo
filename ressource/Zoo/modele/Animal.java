package modele;

import java.util.Set;

import modele.Cage;

public class Animal {
  private Integer an_id;
  private String nomA;
  private String sexe;
  private String type;
  private String fonction_cage;
  private String pays;
  private int anNais;
  private Cage laCage;
  private Set<String> lstMaladies;

  public Animal() {
  }

  public Animal(Integer id) {
    an_id = id;
    ;
  }

  public Animal(String nomA, String sexe, String type, String fonction_cage, String pays, int anNais, Cage laCage, Set<String> lstMaladies) {
    this.nomA = nomA;
    this.sexe = sexe;
    this.type = type;
    this.fonction_cage = fonction_cage;
    this.pays = pays;
    this.anNais = anNais;
    this.laCage = laCage;
    this.lstMaladies = lstMaladies;
  }

  public long getAn_id() {
    return an_id;
  }

  public void setAn_id(Integer id) {
    an_id = id;
  }

  public String getNomA() {
    return nomA;
  }

  public void setNomA(String n) {
    nomA = n;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String s) {
    sexe = s;
  }

  public String getType() {
    return type;
  }

  public void setType(String t) {
    type = t;
  }

  public String getFonctionCage() {
    return fonction_cage;
  }

  public void setFonctionCage(String s) {
    fonction_cage = s;
  }

  public String getPays() {
    return pays;
  }

  public void setPays(String p) {
    pays = p;
  }

  public int getAnNais() {
    return anNais;
  }

  public void setAnNais(int a) {
    anNais = a;
  }

  public Cage getLaCage() {
    return laCage;
  }

  public void setLaCage(Cage C) {
    laCage = C;
  }

  public Set<String> getMaladies() {
    return lstMaladies;
  }

  public void setMaladies(Set<String> l) {
    lstMaladies = l;
  }

  @Override
  public String toString() {
    String s = String.format(
        "Nom : %s\nSexe : %s\nType : %s\nFonction cage : %s\nPays : %s\nAnnée naissance : %d\nCage : %d\nMaladies : ",
        nomA, sexe, type, fonction_cage, pays, anNais, laCage.getNoCage());
    for(String maladie : getMaladies()){
      s += maladie + " ; ";
    }
    return s+"\n";
  }

}
