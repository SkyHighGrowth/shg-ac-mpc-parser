package com.shg.bmapi.models.jobmanager;



public class DseObjectDto extends BaseDseObjectDto {
    private static final long serialVersionUID = 1L;
    private Integer l10nLocaleId;
    private AssignmentDto assignment;
    private Integer currentStepTemplateId;

    public DseObjectDto() {
    }

    public Integer getL10nLocaleId() {
        return this.l10nLocaleId;
    }

    public void setL10nLocaleId(Integer l10nLocaleId) {
        this.l10nLocaleId = l10nLocaleId;
    }

    public Integer getCurrentStepTemplateId() {
        return this.currentStepTemplateId;
    }

    public void setCurrentStepTemplateId(Integer currentStepTemplateId) {
        this.currentStepTemplateId = currentStepTemplateId;
    }

    public AssignmentDto getAssignment() {
        return this.assignment;
    }

    public void setAssignment(AssignmentDto assignment) {
        this.assignment = assignment;
    }
}
