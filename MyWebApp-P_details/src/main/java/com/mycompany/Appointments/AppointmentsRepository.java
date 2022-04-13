package com.mycompany.Appointments;

import com.mycompany.Anamnese.*;
import org.springframework.data.repository.*;

public interface AppointmentsRepository extends CrudRepository<Appointments,Integer> {
    public Long countById(Integer id);
}

