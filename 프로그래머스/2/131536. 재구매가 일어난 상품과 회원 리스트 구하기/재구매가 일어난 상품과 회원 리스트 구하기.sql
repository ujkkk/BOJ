-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
Group By USER_ID, PRODUCT_ID
Having count(PRODUCT_ID)>1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;