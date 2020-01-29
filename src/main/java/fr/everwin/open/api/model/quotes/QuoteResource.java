package fr.everwin.open.api.model.quotes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.everwin.open.api.model.core.DataLink;

/**
 * Quote resource class
 * @author everwin-team
 */
@XmlRootElement(name = "quoteResource")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuoteResource {

	@XmlElement
	protected DataLink employee;

	@XmlElement
	protected DataLink equipment;

	@XmlElement
	protected DataLink profil;

	@XmlElement
	protected DataLink equipmentFamily;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof QuoteResource) {
			QuoteResource quoteResoure = (QuoteResource)obj;
			return (employee == null && quoteResoure.employee == null || employee.getId().equals(quoteResoure.employee.getId())) &&
					(equipment == null && quoteResoure.equipment == null || equipment.getId().equals(quoteResoure.equipment.getId())) &&
					(profil == null && quoteResoure.profil == null || profil.getId().equals(quoteResoure.profil.getId())) &&
					(equipmentFamily == null && quoteResoure.equipmentFamily == null || equipmentFamily.getId().equals(quoteResoure.equipmentFamily.getId()));
		} else {
			return false;
		}
	}

	public DataLink getEmployee() {
		return employee;
	}

	public void setEmployee(DataLink employee) {
		this.employee = employee;
	}

	public DataLink getEquipment() {
		return equipment;
	}

	public void setEquipment(DataLink equipment) {
		this.equipment = equipment;
	}

	public DataLink getProfil() {
		return profil;
	}

	public void setProfil(DataLink profil) {
		this.profil = profil;
	}

	public DataLink getEquipmentFamily() {
		return equipmentFamily;
	}

	public void setEquipmentFamily(DataLink equipmentFamily) {
		this.equipmentFamily = equipmentFamily;
	}
}
