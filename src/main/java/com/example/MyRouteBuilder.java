package com.example;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("file:src/data?noop=true")
                .choice()

                .when(xpath("/Order/CustomerID = 'GREAL'"))
                .log("GREAL message")
                .to("file:target/messages/GREAL")

                .when(xpath("/Order/CustomerID = 'HUNGC'"))
                .log("HUNGC message")
                .to("file:target/messages/HUNGC")

                .when(xpath("/Order/CustomerID = 'LAZYK'"))
                .log("LAZYK message")
                .to("file:target/messages/LAZYK")

                .when(xpath("/Order/CustomerID = 'LETSS'"))
                .log("LETSS message")
                .to("file:target/messages/LETSS")

                .otherwise()
                .log("Other message")
                .to("file:target/messages/other");
    }

}
