# build project
mvn clean install
# Copy servlet .xmls to WEB-INF for .war packaging
cp src/WEB-INF/*.xml /Users/Bike_Thoughts/code/InteractomeProject/target/Interactome/WEB-INF 
rm target/Interactome.war
cd target
# Package .war
jar -cvf Interactome.war Interactome/WEB-INF 
rm -rf Interactome
rm -rf /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps/Interactome
rm /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps/Interactome.war
# Copy .war to tomcat
cp Interactome.war /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps
cd /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps
jar -xf Interactome.war
# META-INF gets generated...
rm -rf META-INF
