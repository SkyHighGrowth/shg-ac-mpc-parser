package com.shg.bmapi.models.jobmanager;




import java.io.Serializable;
import java.util.List;

public class AssignmentDto implements Serializable {
    private List<UserDto> assignees;
    private DseUserGroupDto group;

    public AssignmentDto() {
    }

    public List<UserDto> getAssignees() {
        return this.assignees;
    }

    public void setAssignees(List<UserDto> assignees) {
        this.assignees = assignees;
    }

    public DseUserGroupDto getGroup() {
        return this.group;
    }

    public void setGroup(DseUserGroupDto group) {
        this.group = group;
    }
}
