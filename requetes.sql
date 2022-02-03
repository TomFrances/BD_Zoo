-- Q1 --
SELECT DISTINCT noCage AS numeroCage_Q1
FROM LesAnimaux
WHERE type_an='lion' OR type_an='leopard';


-- Q2 --
SELECT DISTINCT nomE
FROM LesGardiens NATURAL JOIN LesAnimaux
WHERE type_an='leopard';


-- Q3 V1 --
SELECT DISTINCT nomE
FROM LesGardiens G JOIN LesAnimaux A1 USING (noCage) 
WHERE type_an='leopard' 
AND nomE IN (   SELECT nomE 
                FROM LesGardiens G JOIN LesAnimaux A1 USING (noCage) 
                WHERE type_an='lion' );
-- Q3 V2 --
SELECT nomE
FROM LesGardiens JOIN LesAnimaux USING (noCage)
WHERE type_an='leopard'
INTERSECT
SELECT nomE
FROM LesGardiens JOIN LesAnimaux USING (noCage)
WHERE type_an='lion';



-- Q4 --
SELECT DISTINCT nomE
FROM LesMaladies JOIN LesAnimaux USING (nomA)
                 JOIN LesGardiens USING (noCage);


-- Q5 --
SELECT DISTINCT nomE
FROM LesResponsables JOIN LesCages USING (noAllee)
                     JOIN LesAnimaux USING (noCage)
                     JOIN LesMaladies USING (nomA);


-- Q6 --
SELECT DISTINCT nomE
FROM LesGardiens
WHERE nomE NOT IN ( SELECT nomE
                    FROM LesGardiens NATURAL JOIN LesAnimaux
                    WHERE type_an='leopard' );


-- Q7 --
SELECT COUNT(DISTINCT nomA) AS NbAnimauxMalade
FROM LesMaladies;


-- Q8 --
SELECT nomM, COUNT(nomA) AS NbAnimauxMaladeParMaladie
FROM LesMaladies
GROUP BY nomM;


-- Q9 --
SELECT nomA
FROM LesMaladies
GROUP BY nomA
HAVING COUNT(nomM) >= 2;


-- Q10 --
SELECT nomE
FROM LesGardiens NATURAL JOIN LesCages
WHERE fonction='fauve'
GROUP BY nomE
HAVING COUNT(noCage) >= 2;


-- Q11 -- on suppose que LesResponsables[noAllee] = LesCages[noAllee], i.e. toutes les allées ont un responsable
SELECT nomE
FROM LesResponsables NATURAL JOIN LesCages
GROUP BY nomE, noAllee
HAVING COUNT(noCage) = (SELECT MAX(COUNT(noCage))
                        FROM LesCages
                        GROUP BY noAllee);


-- Q12 --
SELECT nomE
FROM LesGardiens NATURAL JOIN LesAnimaux
WHERE type_an='leopard'
GROUP BY nomE
HAVING COUNT(DISTINCT noCage) = (   SELECT COUNT(DISTINCT noCage)
                                    FROM LesAnimaux
                                    WHERE type_an='leopard');


-- Q13 --
SELECT nomE, NVL(COUNT(nomA), 0) AS NbLeopardsGardes
FROM LesGardiens G LEFT JOIN LESANIMAUX A ON (A.noCage=G.noCage AND type_an='leopard')
GROUP BY nomE;

-- Q14 --
SELECT nomE, nvl(COUNT(DISTINCT A.noCage), 0) AS NbCagesLeopardsGardees
FROM LesGardiens G LEFT JOIN LesAnimaux A ON (A.noCage=G.noCage AND A.type_an='leopard')
GROUP BY nomE;

