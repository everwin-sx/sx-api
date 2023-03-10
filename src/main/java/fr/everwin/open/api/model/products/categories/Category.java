package fr.everwin.open.api.model.products.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;

import java.util.List;

/**
 * Product category class
 *
 * @author everwin-team
 */


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BasicObject {

    private String label;
    private List<DataLink> rowTypes;
    private Short isArchived;
    private List<SpecificData> extraData;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DataLink> getRowTypes() {
        return rowTypes;
    }

    public void setRowTypes(List<DataLink> rowTypes) {
        this.rowTypes = rowTypes;
    }

    public Short getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Short isArchived) {
        this.isArchived = isArchived;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }
}
