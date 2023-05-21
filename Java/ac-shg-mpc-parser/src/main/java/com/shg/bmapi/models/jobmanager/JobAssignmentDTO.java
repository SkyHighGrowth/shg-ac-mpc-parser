package com.shg.bmapi.models.jobmanager;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shg.bmapi.models.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobAssignmentDTO {

    private List<UserDTO> assignees = new ArrayList<>();

    public JobAssignmentDTO() {

    }

    public JobAssignmentDTO(final List<UserDTO> assignees) {
        this.assignees = assignees;
    }

    public List<UserDTO> getAssignees() {
        return this.assignees;
    }

    public JobAssignmentDTO setAssignees(final List<UserDTO> assignees) {
        this.assignees = assignees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobAssignmentDTO)) {
            return false;
        }
        JobAssignmentDTO jobAssignmentTO = (JobAssignmentDTO) o;
        return Objects.equals(assignees, jobAssignmentTO.assignees);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(assignees);
    }

    @Override
    public String toString() {
        return "{" +
                " assignees='" + getAssignees() + "'" +
                "}";
    }

}
