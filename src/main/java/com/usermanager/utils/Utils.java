package com.usermanager.utils;

import com.usermanager.simulated.jpa.Alternative;
import com.usermanager.simulated.jpa.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class Utils {



    public List<Long> extrairIds(List<Object> objects){
        List<Long> ids = new ArrayList<>();

        if (!objects.isEmpty()){
            if (objects.get(0) instanceof Question){
                for (Object question : objects){
                    ids.add(((Question) question).getId());
                }
            } else if (objects.get(0) instanceof Alternative) {
                for (Object question : objects){
                    ids.add(((Alternative) question).getId());
                }
            }
        }

        return ids;
    }

}
