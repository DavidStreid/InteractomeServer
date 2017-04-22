# build project
mvn package
# Copy servlet .xmls to WEB-INF for .war packaging
cp src/WEB-INF/*.xml target/Interactome/WEB-INF 
cd target/Interactome 
# Package .war
jar -cvf Interactome.war WEB-INF .ebextensions
cd ..
# Copy .war to tomcat
rm /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps/Interactome.war
cp Interactome.war /Users/Bike_Thoughts/code/apache-tomcat-8.5.13/webapps
