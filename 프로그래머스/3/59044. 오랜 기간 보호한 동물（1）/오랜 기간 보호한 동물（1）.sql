SELECT
I.NAME,
I.DATETIME

FROM ANIMAL_INS I LEFT JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID is NULL

ORDER BY I.DATETIME
limit 3;
