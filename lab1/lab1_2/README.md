# Lab 1.2 Notes

## pom.xml file

The **pom.xml** file is the core of a project's configuration in Maven.

The minimum requirement for a POM are the following:

* **project** root
* **modelVersion** - should be set to 4.0.0
* **groupId** - the id of the project's group.
* **artifactId** - the id of the artifact (project)
* **version** - the version of the artifact under the specified group

Other POM elements are;:

* dependencies
* developers and contributors
* plugin lists (including reports)
* plugin executions with matching ids
* plugin configuration
* resources

## Building the project
> mvn package

## Running the project
> mvn exec:java -Dexec.mainClass="pt.mankings.ies.WeatherStarter" -Dexec.args="[city id]" -Dexec.cleanupDaemonThreads=false

If the city id you provide is non-existing, the program will provide all available id's for you to choose one.
