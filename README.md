# ClashTrack test automation

## Prerequisites
Setup ClashTrack on https://www.clashtrack.com/en/war-weight using **google account.**

## Execution
For running UI tests:
```
mvn clean test -Denv=prod -Dclashtrack.ui.user.login=...@gmail.com -Dclashtrack.ui.user.password=... -Dclashtrack.ui.user.name.=...
```
For running UI tests without setup user (limited cases):
```
mvn clean test -Denv=prod -DsuiteXmlFile=testng-no-sign-in.xml
```
