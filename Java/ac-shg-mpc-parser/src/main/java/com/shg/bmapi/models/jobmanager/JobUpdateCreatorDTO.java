package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobUpdateCreatorDTO {
    private Integer dseObjectId;
    private Integer l10LocaleId;
    private String comment;
    private Integer stepNumber;
    private Integer userGroupIds;
    private Integer assigneeIds;
}
