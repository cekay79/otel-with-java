package com.riferrei.otel.java;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloAppController {

    private static final Logger log =
        LoggerFactory.getLogger(HelloAppController.class);

    static final Counter counter = Metrics.counter("test.counter");

    @RequestMapping(method= RequestMethod.GET, value="/hello")
    public Response Car() {
        Response response = buildResponse();
        if (response.isValid()) {
            log.info("The response is valid.");
        }
        counter.increment();
        return response;
    }

    private Response buildResponse() {
        return new Response("Hello World");
    }

    private class Response {

        private String message;

        public Response(String message) {
            setMessage(message);
        }

        @SuppressWarnings("unused")
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isValid() {
            return true;
        }

    }

}
