# Backend API using Spring Data and Spring Rest
This is a demonstration of what I've learned using Spring. It's a complete backend using Spring boot and deployed to a PaaS such as Heroku or Pivotal Cloud Foundry.
## Requesting from the backend
This API recognizes JSON queries. They can be easily made through a query runner such as Postman.

###Before you try queries
You need a bearer token that is a JWT (JSON Web Token). You get one by POSTing to localhost:8080/users/signin with a login credential. Try this: {"username":"NoopDog","password":"admin"}

You should get something back that looks like this:
```
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJtYW5hZ2VyIiwic3ViIjoiMTciLCJpc3MiOiJab290cm9wb2xpcyIsImV4cCI6MTUzMjA5MTMzNH0.v3EvRYzF5jR4VECHzxuNUWMytK_Sx8eSuEe6xvh3eOt6HBn3ZTszRy2zfns43lSwXVVWFO4Gghvm3NK6MNufng
```

### Now, Endpoints!

For example, to see what animals there are at our fictional Zoo, do a get request on localhost:8080/Animal/ to yield this result:

```json
[
    {
        "animalId": 1,
        "animalName": "American Alligator",
        "scientificName": "Alligator Mississippiensis",
        "funFact": "The eyes and snout are positioned on the top of the head, enabling the American alligator to breathe and watch for prey, while the rest of the body is submerged.",
        "summary": "Domestic American alligators range from long and slender to short and robust, possibly due to variations in factors such as growth rate, diet, and climate. American alligators have broad snouts, especially in captive individuals.",
        "numOfAnimal": 9,
        "tracking": 0,
        "notes": null,
        "food": []
    },
    {
        "animalId": 2,
        "animalName": "American Bison",
        "scientificName": "Bison Bison",
        "funFact": "Bison are known to consume snow (or drink water) on a daily basis.",
        "summary": "The American bison or simply bison, also commonly known as the American buffalo or simply buffalo, is a North American species of bison that once roamed the grasslands of North America in massive herds. They became nearly extinct by a combination of commercial hunting and slaughter in the 19th century and introduction of bovine diseases from domestic cattle, and have made a recent resurgence largely restricted to a few national parks and reserves.",
        "numOfAnimal": 6,
        "tracking": 0,
        "notes": null,
        "food": []
    },
    {
        "animalId": 3,
        "animalName": "Asian Elephant",
        "scientificName": "Elephas Maximus",
        "funFact": "Their trunks can carry about 4 liters of water.",
        "summary": "Asian elephants are the largest living land animals in Asia. The largest Asian elephant ever recorded was from the Garo Hills of Assam, India; it weighed 7.7 tons, stood 11.3 ft tall at the shoulder and was 26.4 ft long from head to tail. The distinctive trunk is an elongation of the nose and upper lip combined; the nostrils are at its tip, which has a one finger-like process. The trunk contains as many as 60,000 muscles, which consist of longitudinal and radiating sets.",
        "numOfAnimal": 4,
        "tracking": 0,
        "notes": null,
        "food": []
    }
    ]
```

Maybe you want to find out what food the park has for the animals:

localhost:8080/Food/

```json
[
    {
        "foodId": 32,
        "foodName": "Bamboo",
        "amount": 400,
        "nextDelivery": "11/27/2018",
        "notes": "For the Pandas only"
    },
    {
        "foodId": 33,
        "foodName": "Beef",
        "amount": 600,
        "nextDelivery": "08/23/2018",
        "notes": "Need to order less now"
    },
    {
        "foodId": 34,
        "foodName": "Eggs",
        "amount": 300,
        "nextDelivery": "06/11/2018",
        "notes": null
    }
    ]
```
## But I don't want to run this on my machine right now!

Now problem; I have it hosted! 🙃
The hosted backend isn't always up. The first request may take several seconds as Heroku is spinning up the instance.

https://zootropolis.herokuapp.com/{endpoint}/

where {endpoint} can be:
* Food (GET/POST)
* Animal (GET)
* Events (GET/POST)
* Location (POST)
* users/info (POST) *Try {"employeeId":17} in the body*
* users/signin (POST) *Necessary for most queries as a Bearer Token*

Happy Postmanning!
