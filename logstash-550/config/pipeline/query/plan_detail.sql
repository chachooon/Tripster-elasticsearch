SELECT  A.Plan_ID, Plan_Detail_ID,
		Plan_Detail_StartTime, Plan_Detail_EndTime, Plan_Detail_Date,
		Plan_StartDate, Plan_EndDate,   
        B.Created, B.Updated 
FROM tbl_Plan A 
JOIN tbl_Plan_Detail B ON A.Plan_ID=B.Plan_ID 
JOIN tbl_Contents C ON B.Contents_ID=C.Contents_ID 
WHERE Plan_ID > :sql_last_value || tbl_Plan.Updated < current_timestamp();