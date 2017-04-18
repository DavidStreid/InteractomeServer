# build project
mvn package
# Copy servlet .xmls to WEB-INF for .war packaging
cp src/WEB-INF/*.xml /Users/Bike_Thoughts/code/InteractomeProject/target/Interactome/WEB-INF 
cd target/Interactome
# Package .war
jar -cvf Interactome.war WEB-INF 
cd ..
# Copy .war to tomcat
rm /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps/Interactome.war
cp Interactome.war /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps
# cd /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps
# jar -xf Interactome.war
