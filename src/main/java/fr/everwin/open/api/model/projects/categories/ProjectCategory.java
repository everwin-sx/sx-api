package fr.everwin.open.api.model.projects.categories;
// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlElementWrapper;
// import javax.xml.bind.annotation.XmlElements;
// import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectCategory extends BasicObject {


    private Short type;


    private String label;

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
