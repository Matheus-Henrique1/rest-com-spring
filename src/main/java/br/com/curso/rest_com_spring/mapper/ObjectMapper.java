package br.com.curso.rest_com_spring.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        origin.forEach(o -> {
            destinationObjects.add(mapper.map(o, destination));
        });
        return destinationObjects;
    }

}
