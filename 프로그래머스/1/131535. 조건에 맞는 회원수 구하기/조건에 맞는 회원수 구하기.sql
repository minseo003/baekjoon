select count(*) as USERS from USER_INFO U
where U.AGE between 20 and 29 
AND U.JOINED LIKE "2021-%" ; 