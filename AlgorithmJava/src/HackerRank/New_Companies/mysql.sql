SELECT c.company_code, c.founder, COUNT(DISTINCT(l.lead_manager_code)),
       COUNT(DISTINCT(s.senior_manager_code)), COUNT(DISTINCT(m.manager_code)), COUNT(DISTINCT(e.employee_code))
from Employee as e
         INNER JOIN Company c ON e.company_code = c.company_code
         INNER JOIN Lead_Manager l ON e.lead_manager_code = l.lead_manager_code
         INNER JOIN Senior_Manager s ON s.senior_manager_code = e.senior_manager_code
         INNER JOIN Manager m ON m.manager_code = e.manager_code
GROUP BY c.company_code, c.founder
ORDER BY c.company_code;
