package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVariableTypeDto implements Serializable {
    private static final long serialVersionUID = -5751400135714872684L;
    private Integer id;

    private Integer metaTypeId;
    private String metaTypeName;
    private String uniqueName;
    private String displayName;
    private String technicalName;

    private Collection<ComfortGridColumnRestDto> columns;


}
