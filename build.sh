# build project
mvn clean install
# Copy servlet .xmls to WEB-INF for .war packaging
cp src/main/webapp/WEB-INF/*.xml /target/Interactome/WEB-INF 
rm target/Interactome.war
cd target
# Package .war
jar -cvf Interactome.war Interactome/WEB-INF Interactome/META-INF
rm -rf Interactome
rm -rf {path/to/tomcat}/webapps/Interactome
rm {path/to/tomcat}/webapps/Interactome.war
# Copy .war to tomcat
cp Interactome.war {path/to/tomcat}/webapps
cd {path/to/tomcat}/webapps
# explode .war
jar -xvf Interactome.war
# META-INF gets generated...
rm -rf META-INF
