SELECT Plan_ID, tbl_Plan.Member_ID, Member_Name, IFNULL(Member_Picture,'') AS Member_Picture, IFNULL((SELECT Memo_Picture_Name FROM tbl_Memo_Picture WHERE tbl_Memo_Picture.Plan_Detail_ID IN (SELECT Plan_Detail_ID FROM tbl_Plan_Detail WHERE tbl_Plan_Detail.Plan_ID = tbl_Plan.Plan_ID) LIMIT 1),'') AS Memo_Picture_Name, Plan_Title, Plan_StartDate, Plan_EndDate, Plan_EndChk, Plan_Like_Cnt,tbl_Plan.Created, tbl_Plan.Updated FROM tbl_Plan JOIN tbl_Member ON tbl_Plan.Member_ID=tbl_Member.Member_ID




SELECT Plan_Detail.Plan_ID, Plan_Detail.Plan_Detail_ID
    , Contents_ID, Category_Value_kor, Contents_Title, Contents_Keyword
    , Plan_Detail_StartTime, Plan_Detail_EndTime, Plan_Detail_Date
    ,IFNULL(
        SELECT TOP 1 Memo_Picture_Name
        FROM tbl_Memo_Picture
        WHERE Plan_Detail.Plan_Detail_ID = tbl_Memo_Picture.Plan_Detail_ID,'') AS Memo_Picture_Name
    , Plan_Detail.Created, Plan_Detail.Updated
FROM (
    SELECT Plan_ID
        , Plan_Detail_ID
        , tbl_Plan_Detail.Contents_ID
        , Category_Value_kor
        , Contents_Title
        , Contents_Keyword
        , IFNULL(Plan_Detail_StartTime,'') AS Plan_Detail_StartTime
        , IFNULL(Plan_Detail_StartTime,'') AS Plan_Detail_StartTime
        , IFNULL(Plan_Detail_EndTime,'') AS Plan_Detail_EndTime
        , IFNULL(Plan_Detail_Date,'') AS Plan_Detail_Date
        , tbl_Plan_Detail.Created, tbl_Plan_Detail.Updated
    FROM tbl_Plan_Detail JOIN tbl_Contents ON tbl_Plan_Detail.Contents_ID = tbl_Contents.Contents_ID) AS Plan_Detail
WHERE Plan_Detail.Updated > :sql_last_value


SELECT Like_ID, Plan_ID, Member_ID FROM tbl_Like
SELECT Follow_ID, Member_ID FROM tbl_Follow

