package org.hippoproject.framework.marvin.foundation.message;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 */
public class JsonMessageSerializer implements IMessageSerializer {

    private ObjectMapper objectMapper;

    public JsonMessageSerializer() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES , true);
        this.objectMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES , false);
    }

    @Override
    public byte[] serialize(Object message) throws IOException {
        return this.objectMapper.writeValueAsBytes(message);
    }

    @Override
    public <T> T deserialize(byte[] messageBytes, Class<T> messageType) throws IOException {
        return this.objectMapper.readValue(messageBytes, messageType);
    }
}
