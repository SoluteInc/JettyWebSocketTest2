JettyWebSocketTest2
===================

This repository illustrates an issue in Jetty 9.2.6 class loading when using web sockets.

To replicate the issue:

1. git clone https://github.com/SoluteInc/JettyWebSocketTest2.git
2. cd JettyWebSocketTest2
3. mvn install
4. cd test-war
5. mvn jetty:run
6. browse to http://localhost:8080/test/
7. View the console to see the results.

Issue
===================
The issue is that the Thread.currentThread().getContextClassLoader() is different when code is called from an @onOpen method and an @onMessage method.  When in the onMessage, the context class loader will be a org.codehaus.plexus.classworlds.realm.ClassRealm instead of a org.eclipse.jetty.webapp.WebAppClassLoader.  As such, looking up resources on the classpath from within a Jar in the web app will fail.
