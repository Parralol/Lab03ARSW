# Lab-03 ARSW

This Laboratory is made to explain everything related to networking in java.

finished in 2024/06/12


## Project Structure

This proyect is divided into several diferent programs, each one will be explained in it's corresponding subject.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

First you need the following java version (command to see your current java version below)

```
java -version
```

![image](https://github.com/Parralol/Taller1ARSW/assets/110953563/6088e13f-2c49-4e5f-9eb3-c09642af5d65)

to see the maven version we are using we need to enter the following command, also this is the version of Maven this programm uses

```
mvn -version
```

![image](https://github.com/Parralol/Taller1ARSW/assets/110953563/0c2f20e7-a955-4aa5-bb92-a073488ba7e1)

### Installing

First clone this proyect into your own system, then 

```
mvn clean package
```

## Deployment

**IN ORDER FOR ANY PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

### First exercise

Write a program in which you create an URL object and print out each one of the data that return each of the 8 methods of the last section.

#### How to execute this program

if you want to use te programm before using the package command we use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.URLReader'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.URLReader
```

#### Acceptance test

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/ddcf8810-6b2d-437e-8ed1-535a6880ae69)

The exception given in the last line is because the path used does not work, it's only for demostrative purposes.


### Second exercise

Write a browser application that asks the user for a URL, reads data from that URL, and stores it in a file named resultado.html. Then, try to view this file in the browser.

#### How to execute this program

if you want to use te programm before using the package command we use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio2'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio2
```

#### Acceptance test

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/c9711a20-0db5-4ccd-b015-2f594112f04f)

This is the expected output to the program, the file is stored in:


![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/3cdae6fd-935e-4753-832f-0ca76e6c00bf)

and the file is correctly saved, being proof of this is:

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/e8c3ab78-5e0e-4d54-88c2-1266d85aa6fc)
(Snippet of the code)

and

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/b9edaa29-8c8a-409c-8609-d7e9eec2731b)




## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)
