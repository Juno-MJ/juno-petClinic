package juno.springboot.junopetclinic.Services.Map;

import juno.springboot.junopetclinic.Model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void delete(T object){
        map.entrySet().removeIf(Entry -> Entry.equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    public Long getNextId(){
        Long id = null;
        try{
            id = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException nsee){
            id = 1L;
        }

        return id;
    }

}
