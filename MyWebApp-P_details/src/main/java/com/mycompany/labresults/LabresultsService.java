package com.mycompany.labresults;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabresultsService {
    @Autowired
    private LabresultsRepository repo3;

    public List<Labresults> listall(){
        return (List<Labresults>) repo3.findAll();
    }

    public void save(Labresults labresults ){
        repo3.save(labresults);
    }

    public Labresults get(Integer id) throws LabresultsNotFoundException, LabresultsNotFoundException {
        Optional<Labresults> result=repo3.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new LabresultsNotFoundException("Could not find any details with ID"+id);
    }
    public void delete(Integer id) throws LabresultsNotFoundException{
        Long count=repo3.countById(id);
        if(count== null || count==0){
            throw new LabresultsNotFoundException("Could not find any details with ID"+id);

        }
        repo3.deleteById(id);
    }
    // er moet nog delete method komen
}

