# ClashTrack test automation
## Prerequisites
##### For running UI tests:
Setup ClashTrack on https://www.clashtrack.com/en/war-weight using **google account.**
##### For running API tests:
Create authorization token on https://developer.clashofclans.com/
## Execution
####UI tests:
_(Running from **clashtrack-at-ui** dir)_
```
mvn clean test -Denv=prod -Dclashtrack.ui.user.login=...@gmail.com -Dclashtrack.ui.user.password=... -Dclashtrack.ui.user.name.=...
```
For running UI tests without setup user (limited cases):
```
mvn clean test -Denv=prod -DsuiteXmlFile=testng-no-sign-in.xml
```
#### API tests:
_(Running from **clashtrack-at-api** dir)_
```
mvn clean test -Denv=prod -Dclash.api.authorization.token=...
```
## Reporting
Extent report will be generated automaticaly in {user.dir}/target/test_report/ExtentReports-Version3-Test-Automaton-Report.html
