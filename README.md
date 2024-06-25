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
mvn clean install
```

## Deployment

**IN ORDER FOR ANY PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

----------------------------------------
### First exercise
----------------------------------------

Write a program in which you create an URL object and print out each one of the data that return each of the 8 methods of the last section.

#### How to execute this program

if you want to use the programm **first** use

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

----------------------------------------
### Second exercise
----------------------------------------

Write a browser application that asks the user for a URL, reads data from that URL, and stores it in a file named resultado.html. Then, try to view this file in the browser.

#### How to execute this program

if you want to use the programm **first** use

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


----------------------------------------
### Third excersice
----------------------------------------

Write a server that receives a number and responds with the square of that number.

#### How to execute this program

if you want to use the programm **first** use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio3'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio3
```

This will launch the server, then start the client on another terminal with

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.SocketClient'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.SocketClient
```

#### Acceptance test

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/91ca2236-81e8-4831-9179-a02d74b11106)

In this screenshot we can see how both server and client are active and running

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/8e45ce5b-c69c-4e2b-a9db-8a30d9502331)

here we can see how the server delivers the operation made and the message recieved.

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/e9c3f2d1-7b9d-4613-918b-e1878e5cf193)

in the client side we can see how the input is delivered and the response corresponds to the Echo line.

----------------------------------------
### Fourth exercise
----------------------------------------

Write a server that receives a number and responds with the square of that number.

#### How to execute this program

if you want to use the programm **first** use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio4'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio4
```

This will launch the server, then start the client on another terminal with

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.SocketClient'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.SocketClient
```

#### Acceptance test

**is important to note that PI is delivered via terminal as the symbol ?**

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/250750a8-c36e-42c6-bfa8-c702974d92e4)

In this screenshot we can see how both server and client are active and running


![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/11efa5cc-553d-4dd1-b810-1bffb31ece86)


in the client side we can see how the input is delivered and the response corresponds to the Echo line.


![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/ec845544-835e-43fa-95d8-466c4a6c4eab)

And as seen in the image, the operation changes successfully.

----------------------------------------
### Fifth exercise
----------------------------------------

Write a web server that supports multiple sequential requests (not concurrent). The server must return all requested files, including HTML pages and images.

#### How to execute this program

if you want to use the programm **first** use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio5'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio5
```


To access you'll need to enter to [http://localhost:35000](http://localhost:35000)

#### Acceptance test


https://github.com/Parralol/Lab03ARSW/assets/110953563/7338b2ca-5142-48a0-8e65-ce6abdac55bd

in this video you can see how the server resolves every peticion


![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/875de2b0-299e-4ccd-a0c6-b3cb1afd6bdc)

Each resource is stored in the highlited folder.

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/63fabf6b-4c22-4730-b7fe-d85acf85952e)

As i couldn't record the whole screen, here's a screenshot of the terminal output.

----------------------------------------
### Sixth exercise
----------------------------------------

Using Datagrams, write a program that connects to a server that responds with the current time on the server. The program should update the time every 5 seconds based on the server's data. If a time is not received, it should maintain the time it had. For the test, the server will be turned off and after a few seconds, it will be turned back on. The client must continue working and update itself when the server is functioning again

#### How to execute this program

if you want to use the programm **first** use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Datagram.DatagramTimeServer'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Datagram.DatagramTimeServer
```

This will launch the server, then start the client on another terminal with

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio6'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.introduccion.Ejercicio6
```

#### Acceptance test

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/4d914357-983b-4282-a6f5-3f05b77fd5ef)

In this screenshot we can see how both server and client are active and running, the output is a bit off given that maven does not print every step it makes, however it works.

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/4b14f473-71c6-4649-90b4-4e9e1996621d)

As seen here, the terminal looks like is not working, however this screenshot was taken at the same time the cilent was working.

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/57acd11b-f430-4b9e-b196-9f6acd54ac0b)

When the numbers start repeating is when the servers get's shut down, so it outputs the last time it was given, behaving as intended.

----------------------------------------
### Seventh exercise
----------------------------------------

Using RMI, write an application that can connect to another application of the same type on a remote server to start a chat. The application should request an IP address and a port before connecting with the desired client. Likewise, it should request a port before starting to publish the object that receives remote calls on that port.

#### How to execute this program

if you want to use the programm **first** use

```
java -cp target/lab03-1.0-SNAPSHOT.jar edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7.ChatServer
```

This will launch the server, then start the client on another terminal with

```
java -cp target/lab03-1.0-SNAPSHOT.jar edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7.ChatClient
```
#### Acceptance test

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/9f0cfe97-8721-450c-88ed-b6edece8f49a)


In this screenshot we can see how the server starts, this allows us to know if the server started correctly

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/da729651-0f63-49c9-aa4d-af72120cef75)


Here we can see how the program allows us to connect from both terminals entering the IP and port

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/dfebcc1f-0d8a-462d-b555-6ece3bf3c738)

As seen here, the comunication is possible via both terminals.

![image](https://github.com/Parralol/Lab03ARSW/assets/110953563/47542f1b-38cd-4315-aead-f1827523df5f)

and serverside there's no input.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language
* [HTML 5](https://html.spec.whatwg.org/multipage/) - HiperText Markup Lenguaje
* [JavaScript](https://262.ecma-international.org/14.0/?_gl=1*1jesqaj*_ga*MTM5NDk2MzkzNS4xNzE5MDk5NzQ3*_ga_TDCK4DWEPP*MTcxOTA5OTc0Ni4xLjEuMTcxOTA5OTgwMC4wLjAuMA..) - Programming lenguage
* [Css](https://www.w3.org/Style/CSS/Overview.en.html) - stylesheet language

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)
