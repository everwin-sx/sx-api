package fr.everwin.open.api.model.projects.categories;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.util.JsonListDatalink;
import fr.everwin.open.api.util.JsonListDatalinkKey;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectCategory extends BasicObject {

    private Short type;
    private String label;
    @JsonDeserialize(contentUsing = JsonListDatalink.Deserializer.class)
    @JsonSerialize(contentUsing = JsonListDatalink.Serializer.class)
    @JsonListDatalinkKey(key = "entities")
    private List<DataLink> entities;
    private Short archived;

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DataLink> getEntities() {
        return entities;
    }

    public void setEntities(List<DataLink> entities) {
        this.entities = entities;
    }

    public Short getArchived() {
        return archived;
    }

    public void setArchived(Short archived) {
        this.archived = archived;
    }
}
