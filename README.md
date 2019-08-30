### Heroku link: https://cursor-rest-api-hw.herokuapp.com 

#### Main commands:
**Important:** If you simpy go to https://cursor-rest-api-hw.herokuapp.com - it will lead to 404. You need to work with commands below.
- **/{id}** - returns the book of author with mentioned id. Example: https://cursor-rest-api-hw.herokuapp.com/1
- **/{genre}** - returns the book of author with mentioned genre. Example: https://cursor-rest-api-hw.herokuapp.com/Education
- **/author/add** - Allows you to add new Author to the database. You should add First Name, Last Name and ID as a request body in Postman to add new author.
- **/book/add** - Allows you to add new Book to the database. You should add ID, Title, Genre, Description and Rating as a request body in Postman to add new book.
- **/book/{id}** - Deletes book by given ID. Example: https://cursor-rest-api-hw.herokuapp.com/book/1
- **/author/{id}** - Deletes author by given ID Example: https://cursor-rest-api-hw.herokuapp.com/author/1
- **/book/add/author** - Allows you to add new Book to the database. You should add ID, ID of the Author, Title, Genre, Description and Rating as a request body in Postman to add new book.
