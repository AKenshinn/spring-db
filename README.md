Spring DB
=========
The example project using Spring, Hibernate, MySQL, Maven and JUnit.

### Configuration for running ###
Change to use your **username** and **password** of database configuration in
 1. **pom.xml**
 2. src/main/resources/**hibernate.properties**
 3. src/main/resources/**hibernate.cfg.xml**

### Running ###
1. Create database using name **spring_db**.
2. Install this project using this command below :

	~~~
	mvn clean install
	~~~

3. Create schema and initial data using command below :

	~~~
	mvn hibernate4:export sql:execute
	~~~
