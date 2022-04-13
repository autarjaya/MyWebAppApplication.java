package com.mycompany.Anamnese;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class AnamneseService {
    @Autowired
    private AnamneseRepository repo4;

    public List<Anamnese> listall(){
        return (List<Anamnese>) repo4.findAll();
    }

    public void save(Anamnese anamnese  ){
        repo4.save(anamnese);
    }

    public Anamnese get(Integer id) throws AnamneseNotFoundException{
        Optional<Anamnese> result=repo4.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new AnamneseNotFoundException("Could not find any details with ID"+id);
    }
    public void delete(Integer id) throws AnamneseNotFoundException{
        Long count=repo4.countById(id);
        if(count== null || count==0){
            throw new AnamneseNotFoundException("Could not find any details with ID"+id);

        }
        repo4.deleteById(id);
    }
    // er moet nog delete method komen
}

