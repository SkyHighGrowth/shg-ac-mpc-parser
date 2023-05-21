package com.shg.bmapi.models.jobmanager;




import com.shg.bmapi.models.UserDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseDseObjectDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer instanceId;
    private Integer workflowObjectId;
    private String name;
    private String extendedName;
    private String state;
    private Integer ordinalNumber;
    private Integer typeId;
    private String createdBy;
    private UserDTO creator;
    private Integer parentId;
    private Integer workflowTypeId;
    private Map<String, DseObjectValueDto> values = new HashMap();

    public BaseDseObjectDto() {
    }

    public Map<String, DseObjectValueDto> getValues() {
        return this.values;
    }

    public void setValues(Map<String, DseObjectValueDto> values) {
        this.values = values;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Integer getWorkflowObjectId() {
        return this.workflowObjectId;
    }

    public void setWorkflowObjectId(Integer workflowObjectId) {
        this.workflowObjectId = workflowObjectId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtendedName() {
        return this.extendedName;
    }

    public void setExtendedName(String extendedName) {
        this.extendedName = extendedName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrdinalNumber() {
        return this.ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public UserDTO getCreator() {
        return this.creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public Integer getWorkflowTypeId() {
        return this.workflowTypeId;
    }

    public void setWorkflowTypeId(Integer workflowTypeId) {
        this.workflowTypeId = workflowTypeId;
    }
}
