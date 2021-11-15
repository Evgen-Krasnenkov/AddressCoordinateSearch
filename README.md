

# Address Coordinate Search 

This project is about a 3rd party API use to retrieve addresses and coordinates of them.

## Technologies 
- Java 11
- Spring Boot
- H2 DB
- Spring Security
- REST API
- Maven
- HttpClient
- Lombok
- Docker


##Features
- Getting address by coordinates (latitude & longitude)
- Getting all the addresses by coordinates stored in DB
- Storing coordinates in H2 DB
- Authentication for result endpoints
- Caching retrieved coordinates and addresses
- Application is dockerized




REST API:
It consists of a controller with 2 end points:

/addresses - it excepts GET HTTP requests and then return all the addresses 
           by coordinates which have been calculated and stored in DB previously.

Example of a JSON response:
```json
{
"address": {
  "house_number": "238",
  "road": "Davisville Avenue",
  "neighbourhood": "Davisville",
  "quarter": "Don Valley West",
  "city": "Old Toronto",
  "state_district": "Golden Horseshoe",
  "state": "Ontario",
  "postcode": "M4S 2L8",
  "country": "Canada",
  "country_code": "ca"
}
```

/coordinates - it excepts POST HTTP requests with four parameters: country, city, street and houseNumber. 
              All those parameters should NOT be null.
              As a result you get latitude and longitude of that address in JSON format.
Example:

POST Request:
```JSON
{"country":"Canada","city":"Toronto","street":"Dundas","houseNumber":1}
{
"latitude": "43.656202",
"longitude": "-79.3804418"
}
```
Layers of the APP:
- JPARepository for DAO layer.
- Service with mapping and 3rd Party API use
- Controller for HTTP requests

To get authorized please use ADMIN and 1234.
Also cache is enabled for all the end-points inputs
and this project is available on DockerHub - jackredd/search-address-coordinate.

Best regards, Evgen.



