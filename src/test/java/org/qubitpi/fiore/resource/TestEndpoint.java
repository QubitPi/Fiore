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
package org.qubitpi.fiore.resource;

import org.qubitpi.fiore.JettyServerFactory;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

/**
 * A JAX-RS resource class used for testing {@link JettyServerFactory}.
 *
 * see {@link JettyServerFactory#newInstance(int, String, ResourceConfig)} for why we
 * need to prefix @Path with "/v1"
 */
@Singleton
@Immutable
@ThreadSafe
@Path("/v1/example")
public class TestEndpoint {

    /**
     * A sanity check endpoint that simply returns a 200 response.
     *
     * @return a simple success response
     */
    @GET
    @Path("/test")
    public Response test() {
        return Response
                .status(Response.Status.OK)
                .entity("SUCCESS")
                .build();
    }
}
