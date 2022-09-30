# Lab 1.1 Notes

## Creating first Java Maven Project
```
$ mvn archetype:generate -DgroupId=pt.mankings.app -DartifactId=test-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

**archetype** - modelo genrénico de uma componente importante num sistema.

**groupId** - identificador único de cada projeto, este deve seguir as "Java's package name rules", i.e., o mesmo começa pelo domain name revertido.

**artifactId** - nome do jar sem versão.

## Maven Goals

Os projetos Maven são compostos por "build phases", cada uma destas fases representando um passo no ciclo, estas fases também são denominadas de **goals**.

Cada uma das "build phases" também é dividida em goals, i.e., tarefas a serem cumpridas.