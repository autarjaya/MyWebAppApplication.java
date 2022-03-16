package com.mycompany.P_details;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class P_detailsService {
    @Autowired
    private P_detailsRepository repo2;

    public List<P_details> listall(){
        return (List<P_details>) repo2.findAll();
    }

    public void save(P_details p_details){
        repo2.save(p_details);
    }

    public P_details get(Integer id) throws P_detailsNotFoundException{
        Optional<P_details> result=repo2.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new P_detailsNotFoundException("Could not find any details with ID"+id);
    }
    public void delete(Integer id) throws P_detailsNotFoundException{
        Long count=repo2.countById(id);
        if(count== null || count==0){
            throw new P_detailsNotFoundException("Could not find any details with ID"+id);

        }
        repo2.deleteById(id);
    }
    // er moet nog delete method komen
}
