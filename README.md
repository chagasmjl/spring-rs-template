# spring-rs-template

Spring project template for weblogic (12.X) server and Oracle database.

- <b>Generating weblogic war file: </b></p>
mvn install -P weblogic


- <b>Spring-boot local startup and deploy: </b></p>
mvn spring-boot:run -P springboot


- <b>Using Spring Tool Suite: </b></p>
mvn clean install -P springboot 


- <b>Weblogic deploy: </b></p>
java -cp C:/Oracle/Middleware/Oracle_Home/wlserver/server/lib/weblogic.jar weblogic.Deployer -adminurl t3://localhost:7003 -username weblogic -password weblogic123 -deploy -name spring-rs-template-0.0.1-SNAPSHOT -targets AdminServer -source target\spring-rs-template-0.0.1-SNAPSHOT.war


