-- 코드를 입력하세요
SELECT CAR.CAR_ID, CAR.CAR_TYPE, ROUND(CAR.DAILY_FEE * 30 * (100 - PLAN.DISCOUNT_RATE) / 100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS CAR
         INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN ON CAR.CAR_TYPE = PLAN.CAR_TYPE
         INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HISTORY ON CAR.CAR_ID = HISTORY.CAR_ID
WHERE CAR.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE > '2022-11-01' AND START_DATE < '2022-12-01'
) AND PLAN.DURATION_TYPE = '30일 이상'
GROUP BY CAR.CAR_ID
HAVING CAR.CAR_TYPE IN ('세단', 'SUV') AND (FEE >= 500000 AND FEE <= 2000000)
ORDER BY FEE DESC, CAR.CAR_TYPE, CAR.CAR_ID DESC;