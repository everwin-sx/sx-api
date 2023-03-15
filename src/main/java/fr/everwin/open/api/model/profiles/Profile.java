package fr.everwin.open.api.model.profiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;


/**
 * Profile class
 *
 * @author everwin-team
 */


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile extends BasicObject {

    private String code;
    private DataLink entity;
    private DataLink financialEntity;
    private DataLink workMode;
    private Short isArchived;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataLink getEntity() {
        return entity;
    }

    public void setEntity(DataLink entity) {
        this.entity = entity;
    }

    public DataLink getFinancialEntity() {
        return financialEntity;
    }

    public void setFinancialEntity(DataLink financialEntity) {
        this.financialEntity = financialEntity;
    }

    public DataLink getWorkMode() {
        return workMode;
    }

    public void setWorkMode(DataLink workMode) {
        this.workMode = workMode;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }
}
