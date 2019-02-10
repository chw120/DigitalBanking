# DigitalBanking

APIs:
GET /api/v1/transfer/info
get all user info 
return all users' UserId, Email, AccountNumber and AccountBalance.

POST /api/v1/transfer/onetime
transfer money from user to his/her recipient
header: content-type: application/json
body: {"userEmail":"user's email","recipientEmail":"recipient's email","amount":money,"userAccountNo":"user's account number","recipientAccountNo":"recipient's account number"}'


Example:
curl localhost:8080/api/v1/transfer/info
 Welcome!
1 helen@gm.com 122100 9999.99
2 cy@gm.com 080600 100.00

curl -X POST   http://localhost:8080/api/v1/transfer/onetime   -H 'content-type: application/json'   -d ' {"userEmail":"helen@gm.com","recipientEmail":"cy@gm.com","amount":99.99,"userAccountNo":"122100","recipientAccountNo":"080600"}'
Transfer successfully.

curl localhost:8080/api/v1/transfer/info
 Welcome!
1 helen@gm.com 122100 9900.00
2 cy@gm.com 080600 199.99
