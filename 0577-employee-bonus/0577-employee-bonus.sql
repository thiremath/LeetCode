# Write your MySQL query statement below
select e1.name,e2.bonus from Employee e1
left join Bonus e2 on e1.empId=e2.empId
where bonus<1000 or bonus is null;