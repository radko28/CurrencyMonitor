# CurrencyMonitor

<b>Pull sources </b>
<br>git clone https://github.com/radko28/CurrencyMonitor.git <your_directory_to_create>

<b>Generate *.war file</b>
<br>mvn install

<b>Deploy application</b>
<br>Copy file from ./target/CurrencyMonitor-1.0.war to deployment directory of web or application server.
<br>I've tested on Tomcat7 and JBoss7.1.
<br>Deployment directory for Tomcat is Tomcat/webapps
<br>Deployment directory for JBoss is JBoss/standalone/deployments

<b>Run application</b>
<br>In Tomcat runs script Tomcat/bin/startup or simplier you can run it with command 
<br>java -jar target/dependency/webapp-runner.jar target/*.war.
<br>In JBoss runs script JBoss/bin/standalone
