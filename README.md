### Streaming Data Factory

`Spring` application that emulates a streaming data source through a 
continuous generation of random test data.

The application regularly generates a random `Java` bean 
(enriched by some special annotations) which is then serialized 
as a `json` or `xml` string and then sent to an external `REST` service
for further processing and storage. For each generated sample, 
the application also inserts a logging record in a table of a `PostgreSQL` database. 

Main modules
* `application` which defines the Spring application
* `data-model` that defines both structure of each generated bean 
and functions to be used for random data generation 