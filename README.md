# IoT Lab project
Build a Java based web-microservices API for Car Tracker Sensor.


## API endpoints:

#### Insert or update vehicles details in database.
PUT: http://localhost:8080/vehicles

#### Insert new car sensor readings in database.
Post: http://localhost:8080/readings

#### Get details of all the vehicle.
Get: http://localhost:8080/getVehiclesDetails

#### Get HIGH alerts within last 2 hours for all vehicle
Get: http://localhost:8080/getHighAlerts

#### Get a vehicle's all historical alerts.
Get: http://localhost:8080/vehicleHistoricalAlerts/{vin}
     param: vin is unique identifier of vehicle

## Setting up project
- Create the schema in Mysql with name 'carsensorsdb' to store tables.
- Run the project on tomcat server, apis are configured to run on port 8080.
