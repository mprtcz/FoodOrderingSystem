# FoodOrderingSystem

A design of a java application for a restaurant ordering system. The application uses command line interface only, which asks a user to pick optional order components from available main courses, desserts and drinks.

The application can be extended by adding new items for three cuisines (Italian, Polish and Mexican) to classes in availableitems package, as well as by adding new cuisines to CuisineOptions enum in Cuisine interface. 

At the end of an order, application displays all ordered items and a total price for them.

The application's sample output:

![sampleOutput](https://sc-cdn.scaleengine.net/i/b9af1b07be5b51cdb7adab0a50b5c2995.png)


To generate a jar file of this project using maven:
  1. after cloning the project, open terminal in the project's main directory and type:

  `mvn package`
  
  2. Next go to generated `target` directory:
  
  `cd target`
  
  3. To run generated jar file enter:
  
  `java -jar FoodOrderingSystem-jar-with-dependencies.jar`
