select to_char(a.sales_date, 'YYYY')
, to_number(to_char(a.sales_date, 'MM'))
, b.gender
, count(distinct(a.user_id))
from ONLINE_SALE a, USER_INFO b
where a.user_id = b.user_id
and b.gender is not null
group by to_char(a.sales_date, 'YYYY'), to_number(to_char(a.sales_date, 'MM')), b.gender
order by 1,2,3