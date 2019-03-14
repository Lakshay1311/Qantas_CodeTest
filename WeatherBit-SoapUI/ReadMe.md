Steps to Run the project:

​ a) Install SOAP UI Open source 5.5 version

 b) Go to Import Projects and import the XML contained in the folder WeatherBit-SOAPUI.

c) ***Running indivual tests:***

Go to the test suite "Current Weather_TestSuite" and run the test cases one by one. Just double click on the test case name to run it.

For example, to run AC_CurrentWeather_Lat_Lon, just double click on it. You can see the REQUEST-RESPONSE when you double click on the 'Request' Test step.

Note: The bugs found have been named desciptively named and explained through the test steps. 

**Bug 1:** Country field should be mandatory:  Since we can have the same postcode for multiple countries, the country parameter should be made mandatory to avoid unexpected response. For example for postCode 2150, the response is different for country AU and US. If we don't enter the country name, weather information for country AU is retreived. 

**Bug 2:** If the post code is not entered, the error message received should be "Mandatory parameter missing" or similar instead of "Invalid Parameter supplied" to make the error handling more meaningful. 

-------------------------------OR--------------------------------------

c) ***Running the project through maven and generating report:***

Just download the project and run the following commands on the terminal at the location where you save the pom.xml file.

Prerequisite: Java and Maven should be pre-installed. 

 mvn clean test  -DEnvironment=UAT
mvn surefire-report:report site -DgenerateReports=false
```
