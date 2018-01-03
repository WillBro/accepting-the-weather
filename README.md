# Accepting Weather

BDD acceptance tests of Weather Acceptance React application with Spring, Cucumber and Selenium.

## Getting Started

Provided is a Maven plugin which will download WebDriver binaries and store these locally in the ```drivers``` folder.

With a view to feature breadth first the tests are currently relying on a Chrome WebDriver and Chrome being available.

### Prerequisites

You will need:

* Java 8
* Maven
* Chrome

## Running the tests

```
mvn test
```

## Built With

* [Spring](https://spring.io/) - Spring Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Cucumber](https://cucumber.io/) - BDD Testing
* [Selenium](www.seleniumhq.org) - Automated Web Driver

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/WillBro/accepting-the-weather/project/tags). 

## Authors

* **William Brown** - *Initial work* - [WillBro](https://github.com/WillBro)

## Notes and limitations

Given the 4 hours so far this is an imcomplete project with many of the features not yet covered. Largely, this was a result of wiring the Page Object Models first which could have been mocked to allow for the behaviours themselves to be covered first.

As I had been using Spring recently I setup a Maven POM with the required dependencies which using a framework such as Serenity would have enabled to writing of tests sooner.

If there was more time, naturally, this project would be dockerised to move the requirement of Java, Maven and any other dependencies to be packaged with the project. Approaching the problem again I would likely implement the Selenium Page Object Models last and stub/mock test scenarios.

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE - see the [LICENSE](LICENSE.md) file for details

## Acknowledgments

* [Eugenp](https://github.com/eugenp) of [Baeldung](www.baeldung.com) for his excellent Spring articles
