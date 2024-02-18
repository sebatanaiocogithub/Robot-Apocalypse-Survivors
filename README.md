# Robot-Apocalypse-Survivors
Robot Apocalypse Survivors
SurvivorApoco app
read.me

JDBC URL
jdbc:postgresql://localhost:5432/survivors 
IDE
Spring | Tools 
Download IntelliJ IDEA – The Leading Java and Kotlin IDE (jetbrains.com) 
Database
PostgreSQL
Language
Java
Query tool
Postman

API first (Survivors)
Endpoint	HTTP method	Status	Description
/survivors	GET	200	Get all the survivors
/survivors	POST	201	Create a new survivor.
/survivors/survivorId	GET	200	Get a survivor with a given survivorId.
/survivors/survivorId	PUT	200	Update a survivor details of the given survivorId.
/survivors/survivorId/location?latitude=00.001&longitude=00.001	PUT	200	Update a survivor last location(latitude, longitude) of the given survivorId.

API first (Report-contamination)
Endpoint	HTTP method	Status	Description
/api/infectedPercentage	GET	200	Percentage of infected and non-infected survivors.
/survivors/infected	GET	200	List of infected survivors
/survivors/nonInfected	GET	200	List of non-infected survivors
/api/survivors/{survivorId}/
report-contamination	PUT	200	Update/report contamination by survivor Id

API first (Robots)
Endpoint	HTTP method	Status	Description
/robots	GET	200	List of robots
/robots/land	GET	200	List of by category {land} robots
/robots/flying	GET	200	List of by category {flying} robots
/robots/{model}	GET	200	Get robot by model
/robots/{serialNumber}	GET	200	Get robot by serial Number


