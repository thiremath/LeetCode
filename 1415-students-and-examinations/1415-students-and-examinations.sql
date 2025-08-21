# Write your MySQL query statement below
-- select * from Students s join Subjects sb left join Examinations e on s.student_id=e.student_id and sb.subject_name = e.subject_name group by s.student_id,sb.subject_name;

select s.student_id,s.student_name,sb.subject_name,IFNULL(e.attended_exams,0) as attended_exams from Students s join Subjects sb left join(select student_id,subject_name,count(student_id) as attended_exams from Examinations group by student_id,subject_name) e on s.student_id=e.student_id and sb.subject_name=e.subject_name order by student_id,subject_name;


-- select s.student_id,s.student_name,sb.subject_name,IFNULL(e.attended_exams,0) as attended_exams from (select student_id,subject_name,count(student_id) as attended_exams from Examinations group by student_id,subject_name) e right join Students s join Subjects sb on s.student_id=e.student_id and sb.subject_name=e.subject_name;


-- select * from Students s join Subjects;