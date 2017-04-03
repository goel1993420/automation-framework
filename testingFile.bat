set projectLocation=C:\Users\gs-1461\workspace\WebDriver_Selenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause