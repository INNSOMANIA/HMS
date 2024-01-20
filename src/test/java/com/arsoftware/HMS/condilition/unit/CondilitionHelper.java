package com.arsoftware.HMS.condilition.unit;

import com.arsoftware.HMS.condilition.dto.CondilitionDTO;
import com.arsoftware.HMS.condilition.model.SeriousnessType;
import com.arsoftware.HMS.condilition.persistence.entity.Condilition;

import java.util.ArrayList;
import java.util.List;

public class CondilitionHelper {

    protected static Condilition getSampleCondilition() {
        Condilition condilition = new Condilition();
        condilition.getId();
        condilition.getInfo();
        condilition.getSeriousnessType();

        return condilition;
    }

    protected static List<Condilition> getSampleCondilitionList() {
        List<Condilition> condilitionList = new ArrayList<>();
        condilitionList.add(getSampleCondilition());
        condilitionList.add(getSampleCondilition());

        return condilitionList;
    }

    protected static CondilitionDTO getSampleCondilitionDTO() {
        return new CondilitionDTO(
                1l,
                "INFO",
                SeriousnessType.RED);
    }

    protected static List<CondilitionDTO> getSampleCondilitionDTOList() {
        List<CondilitionDTO> condilitionDTOList = new ArrayList<>();
        condilitionDTOList.add(new CondilitionDTO(
                1l,
                "INFO",
                SeriousnessType.RED));

        return condilitionDTOList;
    }
}
