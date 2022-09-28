# LAB01 NOTES

## 1st app created with:
> mvn archetype:generate -DgroupId=pt.mankings.app -DartifactId=test-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

**groupId** uniquely identifies your project across all projects

**artifactId** is the name of the jar without version


### pom.xml file
is the core of a project's configuration in Maven.


### Building the project
> mvn package

## Weather Forecast Project
Using IPMA's weather forecast API. Use example:
> curl http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json | json_pp

project created with:
> mvn archetype:generate -DgroupId=pt.mankings.ies -DartifactId=weather-forecast -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

### Costumizing pom.xml
Added to **pom.xml**:
```
    <organization>
        <name>DETI</name>
        <url>https://www.ua.pt/deti</url>
    </organization>

    <developers>
        <developer>
            <id>mankings</id>
            <name>João Miguel Almeida Matos</name>
            <email>miguelamatos@ua.pt</email>
        </developer>
    </developers>
```

### Declaring dependencies
Added to **pom.xml** dependencies:
```
    <dependency>
        <groupId>com.squareup.retrofit2</groupId>
        <artifactId>retrofit</artifactId>
        <version>2.9.0</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.9.1</version>
    </dependency>
```

### Running the project
> mvn exec:java -Dexec.mainClass="pt.mankings.ies.WeatherStarter" -Dexec.args="[city id]" -Dexec.cleanupDaemonThreads=false

if you city id is non-existing, the program will provide all available id's for you to choose one.