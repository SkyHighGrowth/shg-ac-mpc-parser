package com.shg.bmapi.models.jobmanager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataSheetSectionLightDto implements Serializable {
    private List<DataSheetAreaLightDto> areas = new ArrayList();

    public DataSheetSectionLightDto() {
    }

    public List<DataSheetAreaLightDto> getAreas() {
        return this.areas;
    }

    public void setAreas(List<DataSheetAreaLightDto> areas) {
        this.areas = areas;
    }
}

