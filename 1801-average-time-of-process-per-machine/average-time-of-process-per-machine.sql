# Write your MySQL query statement below
SELECT
    m.machine_id,
    ROUND(AVG(t.timestamp - m.timestamp), 3) AS processing_time
FROM Activity m
JOIN Activity t
    ON m.machine_id = t.machine_id
    AND m.process_id = t.process_id
WHERE m.activity_type = 'start'
AND t.activity_type = 'end'
GROUP BY m.machine_id;