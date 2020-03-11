# MaltemProject
# Movies_Project_back_end
The application was designed in two parts :

# Part 1 : back end
the back end part was developped in Java using spring boot.

The back end part of the application is created to respond to multiple http requests.

in this part we consider 4  major packages:

Entity: this package is for persistence layer, in our case we only have one class which is Movie.java

DAF : this package is for direct interaction with the data (which in our case is nothing but a json file)

RestWebService : to respond to http requests

Util : this package contains the methods read and write the json file 

running the back end application :
please make sure to run the back end part first. to do so you'll have to run class MoviesApplication.java (embeeded tomecat will be launched on port 8080)

# part 2 : front end
this part is developped using Angular 8 + bootstrap 3

we have 4 major web components :

Movie : for displaying the list of movies, and performing the different type of search

new-movie : to add a new movie to the list of movies

edit-movie: to update an existing movie

home : is for home web page

running the front end application :
run the angular Cli server on port 4200 and enjoy browsing
