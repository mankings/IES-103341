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

## .gitignore file
Used to specify which files or file extensions Git should ignore when commiting to the common repository.

Example at use: adding "*.pdf" to the file makes it so that all pdf files are ignored, which is helpful since the documents with the info about the assignment are .pdf files, and we don't want those on the repository.

## Saving files in shared repo
```
    $ cd project_folder                                         # move to the root of the working folder to be imported
    $ git init                                                  # initialize a local git repo in this folder
    $ git remote add origin <REMOTE_URL>                        # must adapt the url for your repo
    $ git add .                                                 # mark all existing changes in this root to be commited
    $ git commit -m "Initial project setup for exercise 1_3"    # create the commit snapshot locally
    $ git push -u origin main                                   # uploads the local commit to the shared repo
```