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