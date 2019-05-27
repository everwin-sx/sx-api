/**
 * $(list_comment)
 * @author everwin-team
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "$(list_xmlroot) ")
public class $(list_class) extends com.everwin.open.api.model.core.BasicList {

	@XmlElement(name = "$(object_xml)")
	@XmlElementWrapper(name = "$(object_xmlwrapper) ")
	private List<$(object_class)> items;

	public $(list_class)() {

	}

	public List<$(object_class)> getItems() {
		return items;
	}

	public void setItems(List<$(object_class)> items) {
		this.items = items;
	}


}
