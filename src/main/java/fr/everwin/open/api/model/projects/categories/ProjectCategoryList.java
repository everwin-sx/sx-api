package fr.everwin.open.api.model.projects.categories;

import fr.everwin.open.api.model.core.BasicList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projectcategorylist")

public class ProjectCategoryList extends BasicList<ProjectCategory> {

    private final static String METHOD = "query";

    @XmlElement(name = "projectcategory")
    @XmlElementWrapper(name = "projectcategory")
    private List<ProjectCategory> items;

    @Override
    public List<ProjectCategory> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProjectCategory> items) {
        this.items = items;
    }
}
