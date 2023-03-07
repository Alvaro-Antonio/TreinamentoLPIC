package com.usermanager.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.usermanager.simulated.jpa.Alternative;
import com.usermanager.simulated.jpa.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)

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
