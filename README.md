case study to learn stuff

find the screenshots of working app in the 'screenshots' folder

not all the back-end services have been connected with the front-end 

front to back connected services are:
1. stockmarket-service: a combination of company, sector, stockexchange, ipo services
2. the user-service aka the JWT authentication service
further, the authentication is done by user-service, and authorization by Zuul gateway 

more importantly all above services run with proper zuul, eureka, admin and config servers, so all the front-end requests go to Zuul, which then checks the authorization and serves the response from respective backend rest-APIs
