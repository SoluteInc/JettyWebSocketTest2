JettyWebSocketTest2
===================

This repository illustrates an issue in Jetty 9.2.6 class loading when using web sockets.

To replicate the issue:

1) git clone https://github.com/SoluteInc/JettyWebSocketTest2.git
2) cd JettyWebSocketTest2
3) mvn install
4) cd test-war
5) mvn jetty:run
6) browse to http://localhost:8080/test/