SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(AMOUNT*PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT P
INNER JOIN FOOD_ORDER O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE LIKE "2022-05%"
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID ASC;