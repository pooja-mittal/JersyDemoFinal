package com.resource;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;


public class RestApplication extends ResourceConfig {
    public RestApplication() {
        register(MoxyJsonFeature.class);

    }
} 