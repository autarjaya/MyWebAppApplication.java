package com.mycompany.Appointments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {
    @Autowired
    private AppointmentsRepository repo5;

    public List<Appointments> listall(){
        return (List<Appointments>) repo5.findAll();
    }
    public void save(Appointments appointments){
        repo5.save(appointments);
    }
    public Appointments get(Integer id) throws AppointmentsNotFoundException{
        Optional<Appointments> result=repo5.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new AppointmentsNotFoundException("Could not find any appointments with ID"+id);
    }
    public void delete(Integer id) throws AppointmentsNotFoundException{
        Long count=repo5.countById(id);
        if(count==null || count==0){
            throw new AppointmentsNotFoundException("Could not find any appointments with ID"+id);

        }
        repo5.deleteById(id);
    }
}