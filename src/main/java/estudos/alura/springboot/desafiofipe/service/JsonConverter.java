package estudos.alura.springboot.desafiofipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonConverter {

    private ObjectMapper mapper;

    public JsonConverter() {
        this.mapper = new ObjectMapper();
    }

    public <T> T convertToSingleObject(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }

    public <T> List<T> convertToListObject(String json, TypeReference<List<T>> typeReference) throws JsonProcessingException {
        return mapper.readValue(json, typeReference);
    }
}
