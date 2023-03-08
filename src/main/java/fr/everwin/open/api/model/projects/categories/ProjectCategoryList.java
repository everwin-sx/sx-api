package fr.everwin.open.api.model.projects.categories;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.everwin.open.api.model.core.BasicList;

import java.util.List;


public class ProjectCategoryList extends BasicList<ProjectCategory> {

    private final static String METHOD = "query";

    //    @JsonProperty("projectcategory")
    @JsonProperty("projectcategory")
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
