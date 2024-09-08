SELECT
  b.author_id
  , b.author_name
  , c.category
  , SUM(a.sales * c.price) TOTAL_SALES
FROM(
    SELECT 
      bs.book_id
      , SUM(bs.sales) sales
    FROM book_sales bs
    WHERE TO_CHAR(bs.sales_date, 'YYYYMM') = '202201'
    GROUP BY bs.book_id
)a,
author b, book c
WHERE 1=1
  AND a.book_id = c.book_id
  AND b.author_id = c.author_id
GROUP BY b.author_id, b.author_name, c.category
ORDER BY b.author_id, c.category desc