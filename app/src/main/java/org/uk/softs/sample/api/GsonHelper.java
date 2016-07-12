package org.uk.softs.sample.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonHelper {

    private GsonHelper() {
    }

    public static Gson getGson() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .registerTypeAdapter(Date.class, new GsonDateSerializer())
//                .registerTypeAdapter(ChannelPostEmbeddedContent.class, new GsonPostEmbeddedContentSerializer()) // FIXME This is because, this object returns as a string or object from server
                .create();

        return gson;
    }
}
