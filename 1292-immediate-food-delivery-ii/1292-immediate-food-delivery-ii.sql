# Write your MySQL query statement below

select Round(count(distinct a.customer_id)*100/count(distinct c.customer_id),2) as immediate_percentage from delivery c  join Delivery a left join Delivery b on a.customer_id=b.customer_id and a.order_date > b.order_date where a.order_date = a.customer_pref_delivery_date and b.customer_pref_delivery_date is null;