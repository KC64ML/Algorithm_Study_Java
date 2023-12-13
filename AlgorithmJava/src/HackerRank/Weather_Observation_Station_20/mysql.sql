SELECT ROUND(AVG(LAT_N), 4)
FROM (SELECT ROW_NUMBER() OVER (ORDER BY LAT_N) row_num, COUNT(*) OVER() n, LAT_N
      FROM STATION) t
WHERE CASE
          WHEN MOD(n, 2) = 1 THEN row_num = (n + 1) / 2
          ELSE row_num IN (n / 2, n / 2 + 1)
          END