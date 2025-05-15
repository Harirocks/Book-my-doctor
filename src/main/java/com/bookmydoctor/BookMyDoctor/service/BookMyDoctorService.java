package com.bookmydoctor.BookMyDoctor.service;

import java.util.List;

public interface BookMyDoctorService {
        String save(Object object);
        String update(int id,Object object);
        Object getById(int id);
        List<?> getAll();
        void deleteById(int id);
}
