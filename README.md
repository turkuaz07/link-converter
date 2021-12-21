# Link Converter App.

This is a microservice that provides some conversions like web url to deeplink or vice versa

## Technology Used

 * Java 11
 * Spring Boot (2.6.1)
 * Elasticsearch (7.13.2)
 * Springdoc-openapi (1.5.2)

## Run the System

## > On Your Local IDE
Simply open the Java class com.test.lc.LinkConverterApplication and run the main method from your IDE

But running like that assumes that you have a running elasticsearch instance available on http://localhost:9200.
So if there is no running elasticsearch instance, get one ready


## > On Docker

After locate to project folder run below command

```
docker-compose -f developmnet.yml up -d
```

After a successful compose you will find 2 running containers on docker

## Available APIs

* POST ``​/api​/conversion​/toDeeplink``
* POST ``​/api​/conversion​/toWebUrl``

You can find more details http://localhost:8080/swagger-ui.html (based on your host name and port info)
