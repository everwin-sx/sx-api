package fr.everwin.open.api.model.projects.categories;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import fr.everwin.open.api.model.core.BasicList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projectcategorylist")

public class ProjectCategoryList extends BasicList<ProjectCategory> {

    private final static String METHOD = "query";

    @XmlElement(name = "projectcategory")
    @XmlElementWrapper(name = "projectcategory")
    private List<ProjectCategory> items;

    @XmlElement(name = "selflink")
    protected String href;

    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    protected List<Link> links;

    @Override
    public List<ProjectCategory> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProjectCategory> items) {
        this.items = items;
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public List<Link> getLinks() {
        return links;
    }

    @Override
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
