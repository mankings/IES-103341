# Lab 3.3 Notes
## Quote Application
## Structure

* *Controller*
    * *Controller*
* *Service*
    * *Serv*
* *Repositories*
    * *MovieRepository*
    * *QuoteRepository*
* *Entities*
    * *Movie*
    * *Quote*
    * *NewQuote*

The controller handles HTTP requests, calling the service layer to handle the persistence logic. Data is stored in the repositories, using both the *Movie* and the *Quote* class.  
The *NewQuote* class is an auxiliary class for the persistence logic. No data is stored in that form.

## API calls
* **/movies** (GET) - get all movies
* **/movie/{id}** (GET) - get a specific movie, given by id
* **/addmovie** (POST) - insert a new movie
* **/updatemovie/{id}** (PUT) - update a movie
* **/deletemovie/{id}** (DELETE) - delete a movie

* **/quotes** (GET) - get all quotes
* **/quote/{id}** (GET) - get a specific quote, given by id
* **/addquote** (POST) - insert a new quote
* **/updatequote/{id}** (PUT) - update a quote
* **/deletequote/{id}** (DELETE) - delete a quote