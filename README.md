Weather service
==================

**TODO**
implement the landing page 


**To test the service**

This is a service that provides weather information from a city
for Example London
/public/weather/London

it will return:
```
{
    "city": "London",
    "tempC": "9.44",
    "tempF": "48.99",
    "description": "few clouds",
    "today": "05-22-19 20:56:19",
    "sunrise": "05-22-19 22:58:32",
    "sunset": "05-23-19 14:56:15"
}
```

or Hong Kong 
/public/weather/Hong Kong

It will return
```
{
    "city": "Hong Kong",
    "tempC": "27.42",
    "tempF": "81.36",
    "description": "light intensity shower rain",
    "today": "05-22-19 21:05:16",
    "sunrise": "05-22-19 16:41:09",
    "sunset": "05-23-19 05:59:16"
}
```

in your local you have to use http://localhost:8080/public/weather/Hong Kong to call the service changing the City, this city is an String

To compile and run the unit test you have to use ```mvn clean package```
to run the service in local you can use spring boot with the instruction mvn ```spring-boot:run``` in console




