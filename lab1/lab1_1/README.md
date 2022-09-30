# Lab 1.1 Notes

## Creating first Java Maven Project
> mvn archetype:generate -DgroupId=pt.mankings.app -DartifactId=test-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

**archetype** - modelo genrénico de uma componente importante num sistema.

**groupId** - identificador único de cada projeto, este deve seguir as "Java's package name rules", i.e., o mesmo começa pelo domain name revertido.

**artifactId** - nome do jar sem versão.

## Maven Goals

Os projetos Maven são compostos por "build phases", cada uma destas fases representando um passo no ciclo, estas fases também são denominadas de **goals**.

Cada uma das "build phases" também é dividida em goals, i.e., tarefas a serem cumpridas.

Os principais "maven goals" são os seguintes:
* **validate** - validate the project is correct and all necessary information is available
* **compile** - compile the source code of the project
* **test** - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* **package** - take the compiled code and package it in its distributable format, such as a JAR.
* **verify** - run any checks on results of integration tests to ensure quality criteria are met
* **install** - install the package into the local repository, for use as a dependency in other projects locally
* **deploy** - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects