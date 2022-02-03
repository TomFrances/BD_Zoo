drop table LesMaladies ;
drop table LesAnimaux ;
drop table LesResponsables ;
drop table LesGardiens ;
drop table LesEMployes ;
drop table LesCages ;

create table LesCages (
	noCage number(3),
	fonction varchar2(20),
	noAllee number(3),
	constraint pk_LesCages_noCage PRIMARY KEY (noCage),
	constraint ck_LesCages_noCage CHECK(noCage > 0 AND noCage < 1000),
	constraint ck_LesCages_noAllee CHECK(noAllee > 0 AND noAllee < 1000)
);

create table LesEmployes (
	nomE varchar2(20),
	adresse varchar2(20),
	constraint pk_LesEmployes_nomE PRIMARY KEY (nomE)
);

create table LesGardiens (
	noCage number(3),
	nomE varchar2(20),
	constraint pk_LesGardiens_noCage_nomE PRIMARY KEY (noCage, nomE),
	constraint fk_LesGardiens_nomE FOREIGN KEY (nomE) REFERENCES LesEmployes (nomE),
	constraint fk_LesGardiens_noCage FOREIGN KEY (noCage) REFERENCES LesCages (noCage),
	constraint ck_LesGardiens_noCage CHECK(noCage > 0 AND noCage < 1000)
);

create table LesResponsables (
	noAllee number(3),
	nomE varchar2(20),
	constraint pk_LesResp_noAllee_nomE PRIMARY KEY (noAllee, nomE),
	constraint fk_LesResp_nomE FOREIGN KEY (nomE) REFERENCES LesEmployes (nomE),
	constraint ck_LesResponsables_noAllee CHECK(noAllee > 0 AND noAllee < 1000)
);
		
create table LesAnimaux (
	nomA varchar2(20),
	sexe varchar2(13),
	type_an varchar2(15),
	fonction_cage varchar2(20),
	pays varchar2(20),
	anNais number(4),
	noCage number(3),
	constraint pk_LesAnimaux_nomA PRIMARY KEY (nomA),
	constraint fk_LesAnimaux_noCage FOREIGN KEY (noCage) REFERENCES LesCages (noCage),
	constraint ck_LesAnimaux_sexe CHECK (sexe IN ('femelle', 'male', 'hermaphrodite')),
	constraint ck_LesAnimaux_noCage CHECK (noCage > 0 AND noCage < 1000),
	constraint ck_LesAnimaux_annais CHECK (annais >= 2000)
);

create table LesMaladies (
	nomA varchar2(20),
	nomM varchar2(20),
	constraint pk_LesMaladies_nomA_nomM PRIMARY KEY (nomA, nomM),
	constraint fk_LesMaladies_nomA FOREIGN KEY (nomA) REFERENCES LesAnimaux (nomA)
);
