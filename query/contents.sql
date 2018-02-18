SELECT tbl_Contents.Contents_ID
    , tbl_Contents.Category_ID
    , Category_Value_kor
    , Contents_Title
    , Contents_Keyword
    , Contents_Location
    , Contents_Country
    , Contents_City
    , Contents_Rating
    , Contents_View_Cnt
    , Contents_Review_Cnt
    , Contents_Scrap_Cnt
    , Contents_Thumbnail
    , IFNULL(Contents_Contents,'') AS Contents_Contents
    , IFNULL(Contents_Time,'') AS Contents_Time
    , IFNULL(Contents_Tel,'') AS Contents_Tel
    , IFNULL(Contents_Lat,0) AS Contents_Lat
    , IFNULL(Contents_Long,0) AS Contents_Long
    , tbl_Contents.Created
    , tbl_Contents.Updated
FROM tbl_Contents
    JOIN tbl_Category ON tbl_Contents.Category_ID = tbl_Category.Category_ID
    JOIN tbl_Contents_Detail ON tbl_Contents.Contents_ID = tbl_Contents_Detail.Contents_ID
WHERE Contents_ID > :sql_last_value || tbl_Contents.Updated < current_timestamp()
