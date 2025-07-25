/*
 * Copyright 2025 Jiaqi Liu. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.qubitpi.fiore.web.endpoints

import org.qubitpi.fiore.JettyServerFactory
import org.qubitpi.fiore.application.ResourceConfig

import org.eclipse.jetty.server.Server

import io.restassured.RestAssured
import spock.lang.Specification

class HealthcheckServletITSpec extends Specification {

    static final int PORT = 8080

    def setupSpec() {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = PORT
        RestAssured.basePath = "/v1"
    }

    def "Healthchecking endpoints returns 200"() {
        setup:
        Server server = JettyServerFactory.newInstance(PORT, "/v1/*", new ResourceConfig())
        server.start()

        expect:
        RestAssured.given()
                .when()
                .get("/healthcheck")
                .then()
                .statusCode(200)

        cleanup:
        server.stop()
    }
}
