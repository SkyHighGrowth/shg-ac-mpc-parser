package com.shg.bmapi.models.jobmanager;



public class DseUserGroupDto extends DseUserGroupLightDto {
    private UserDto defaultAssignee;
    private Boolean predefined;

    public DseUserGroupDto() {
    }

    public UserDto getDefaultAssignee() {
        return this.defaultAssignee;
    }

    public void setDefaultAssignee(UserDto defaultAssignee) {
        this.defaultAssignee = defaultAssignee;
    }

    public Boolean isPredefined() {
        return this.predefined;
    }

    public void setPredefined(Boolean predefined) {
        this.predefined = predefined;
    }
}
