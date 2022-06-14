Feature: 
Scenario: 
Given open "chrome" browser
When launch "https://www.gmail.com"
When do login using "abinash7991004472@gmail.com" and "7991004472"
Then compose is displayed
When click on compose and fill fields and send mail and check response
|to|sub|body|attachment|
|dj.avinash55@gmail.com|wish|hi|D://avi.jpg|
When do logout
Then login page should be resdisplayed
When close site

