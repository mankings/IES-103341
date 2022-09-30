# LAB01 NOTES
nmec: 103341    

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

## Review Questions

**A)** Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.

The defulat lifecycle comprises of the following phases:
* **validate** - validate the project is correct and all necessary information is available
* **compile** - compile the source code of the project
* **test** - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* **package** - take the compiled code and package it in its distributable format, such as a JAR.
* **verify** - run any checks on results of integration tests to ensure quality criteria are met
* **install** - install the package into the local repository, for use as a dependency in other projects locally
* **deploy** - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects

**B)** Maven is a build tool; is it appropriate to run your project to?

**C)** What would be a likely sequence of Git commands required to contribute with a new feature to a given project? (i.e., get a fresh copy, develop some increment, post back the added functionality)

To push some new features to the remote repository, one can:
```
$ git add .             # marks all changes in this root to be commited
$ git commit -m [msg]   # create the commit in the local repo
$ git push              # pushes the changes to the remote repo
```

**D)** There are strong opinions on how to write Git commit messages... Find some best practices online and give your own informed recommendations on how to write good commit messages (in a team project).

Well written commit messages are used in many ways, including:
* help a future reader understand *what* changed and *why* it changed;
* assist in undoing specific changes
* to prepare change notes or bump versions for a release

That said, git commit messages should be short, use imperative mood for easier reading comprehension, have a title and a concise body that explains why the change was made.

**E)** Docker automatically prepares the required volume space as you start a container. Why is it important that you take an extra step configuring the volumes for a (production) database?

By default, when a container is deleted, it's data and volumes are deletes as well. When dealing with databases, data permanence is a must, so it's important that we take that extra step configuring the volumes so we can make sure that upon container deletion, the data persists.