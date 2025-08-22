# Write your MySQL query statement below
select der.name from
(select b.name as name,count(b.id) as cnt from Employee a join Employee b on a.managerId=b.id group by b.id) as der where der.cnt>=5;