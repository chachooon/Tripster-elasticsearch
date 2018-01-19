SELECT Member_ID, Member_Email, Member_Name, Member_Sex, Member_Birthday, Member_Picture, Created, Updated FROM tbl_Member WHERE Member_ID > :sql_last_value
