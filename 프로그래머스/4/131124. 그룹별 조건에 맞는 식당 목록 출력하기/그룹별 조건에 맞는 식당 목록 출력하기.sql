select M.MEMBER_NAME, R.REVIEW_TEXT,
DATE_FORMAT(R.REVIEW_DATE , "%Y-%m-%d") as REVIEW_DATE
from REST_REVIEW R
inner join MEMBER_PROFILE M on R.MEMBER_ID = M.MEMBER_ID
WHERE R.MEMBER_ID = (select MEMBER_ID from REST_REVIEW R
                    GROUP BY MEMBER_ID
                    ORDER BY COUNT(*) DESC
                    LIMIT 1)
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT
                    