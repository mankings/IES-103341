# Lab 1.3 Notes

## Some useful docker commands:
Check docker version
```
$ docker --version
```

Test Docker installation
```
$ docker run hello-world
```

List the Docker images on computer
```
$ docker image ls
```

List the existing Docker containers
```
$ docker ps --all
```

## Dockerfile
A **Dockerfile** describes how to assemble a private filesystem for a container, and can also contain some metadata describing how to run a container based on this image.

## Building your own images
Having come source code and a Dockerfile, one can build it's own image, and make sure the containers launched from it work as expected.

Being in the directory with the Dockerfile:
```
$ docker build -t postgresbasic .
```

This creates our own costum PostgreSQL image, using our Dockerfile.

## Running your own images
```
$ docker run --name pg-docker -d -p 5432:5432 -e PGDATA=/tmp -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgresbasic
```

There are a couple of flags in the command above:
* **-p** or **--publis** asks Docker to forward traffic incoming on the host’s port 5432 to the container’s port 5432. Containers have their own private set of ports, so if you want to reach one from the network, you have to forward traffic to it in this way. Otherwise, firewall rules will prevent all network traffic from reaching your container, as a default security posture.
* **-d** or **--detach** asks Docker to run this container in the background.
* **--name** specifies a name with which you can refer to your container in subsequent commands, in this case postgresbasic.

While running, you can visit your application in a browser at localhost:5432.

Since this is a PostgreSQL instance, you can also connect to it with pqsl, with:
```
psql -h localhost
```

To delete your container:
```
$ docker rm --force postgresbasic
```

The **--force** option stops a running container, so it can be removed. If you stop the container running with *$ docker stop postgresbasic* first, then you do not need to use **--force** to remove it.

## Docker Compose
Docker Compose is a tool that was developed to help define and share multi-container applications. With Compose, we can create a YAML file to define the services and with a single command, can spin everything up or tear it all down.

Full tutorial: https://docs.docker.com/compose/gettingstarted/

Start docker-compose:
```
$ docker-compose up
```

Stop docker-compose:
```
$ docker-compose stop
```