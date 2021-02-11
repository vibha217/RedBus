                            --------------------------Red Bus Project---------------------------------


### PURPOSE:To automate the given website - url(https://www.redbus.in/) and check the functionality of the
            given website.

##Tools:
--

*Eclipse JAVA
*Web Driver - Chrome,gecko,ie
*Selenium Server
*Apache POI
*Apache Maven
*TestNG
*Jenkins
*Log4j
*other open source tools

##Note :  - in property file you have an option to run the test cases in headless mode.
	      - you can chage browser from property file(following browsers Chrome, FF )

###STRUCTURE
--

##src/main/java
     ##com.base - in this package,it consists of base class in which some method has been created so that it can
                   be used in different class.Driver class consist of initialisation of driver and extent report.
                   it also consists of Screenshot,when the test will bw failed it wil automatically capture the screenshot.
                   
     ##com.Pages - In these package,locators has been defined of different pages that perform some functionality
                   by using base class.   
                   
###src/test/java
      ##com.tests - these package executes the test cases.
      ##com.utils - this package is used to read the data from the excel sheet
      
 #Resources
 ---
 
 this folder consists of properties file  and logger file that has been used by test file.
 this folder consist of excel sheet also.    
TestDataRedBus.xlsx - (User has the ability to selective run the test cases by
                    marking yes in the "Execution Required" field in excel.)                 
                             
                   
                   
                   
           
		