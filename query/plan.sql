SELECT Plan_ID
    , tbl_Plan.Member_ID
    , Member_Name
    , IFNULL(Member_Picture,'') AS Member_Picture
    , IFNULL((SELECT Memo_Picture_Name FROM tbl_Memo_Picture WHERE tbl_Memo_Picture.Plan_Detail_ID IN (
                SELECT Plan_Detail_ID FROM tbl_Plan_Detail WHERE tbl_Plan_Detail.Plan_ID = tbl_Plan.Plan_ID) LIMIT 1) ,'') AS Memo_Picture_Name
    , Plan_Title
    , Plan_StartDate
    , Plan_EndDate
    , Plan_EndChk
    , Plan_Like_Cnt
    ,tbl_Plan.Created
    , tbl_Plan.Updated
FROM tbl_Plan JOIN tbl_Member ON tbl_Plan.Member_ID=tbl_Member.Member_ID


