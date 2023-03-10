/**
 *
 */
package fr.everwin.open.api.model.salesactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.everwin.open.api.model.core.BasicObject;
import fr.everwin.open.api.model.core.DataLink;
import fr.everwin.open.api.model.core.SpecificData;
import fr.everwin.open.api.util.JsonDateDeserializer;
import fr.everwin.open.api.util.JsonTimeDeserializer;

import java.util.Date;
import java.util.List;

/**
 * Sales action class
 *
 * @author everwin-team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAction extends BasicObject {

    private Short type;
    private String description;
    private DataLink mainPlayer;
    private List<DataLink> secondaryPlayers;
    private DataLink company;
    private DataLink mainContact;
    private List<DataLink> secondaryContacts;
    private DataLink opportunity;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date startDate;
    private String place;
    @JsonDeserialize(using = JsonTimeDeserializer.class)
    private Date duration;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date endDate;
    private Short priority;
    private DataLink marketingOperation;
    private Short status;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date completionDate;
    private Short answer;
    private DataLink salesStep;
    private DataLink introducedCollaborator;
    private Short isPrivate;
    private List<DataLink> equipments;
    private DataLink marketingCampaign;
    private DataLink lead;
    private String updatedBy;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updatedOnTime;
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createdOnTime;
    private List<SpecificData> extraData;

    /**
     *
     */
    public SalesAction() {
        // Constructor empty
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataLink getMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(DataLink mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public List<DataLink> getSecondaryPlayers() {
        return secondaryPlayers;
    }

    public void setSecondaryPlayers(List<DataLink> secondaryPlayers) {
        this.secondaryPlayers = secondaryPlayers;
    }

    public DataLink getCompany() {
        return company;
    }

    public void setCompany(DataLink company) {
        this.company = company;
    }

    public DataLink getMainContact() {
        return mainContact;
    }

    public void setMainContact(DataLink mainContact) {
        this.mainContact = mainContact;
    }

    public List<DataLink> getSecondaryContacts() {
        return secondaryContacts;
    }

    public void setSecondaryContacts(List<DataLink> secondaryContacts) {
        this.secondaryContacts = secondaryContacts;
    }

    public DataLink getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(DataLink opportunity) {
        this.opportunity = opportunity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public DataLink getMarketingOperation() {
        return marketingOperation;
    }

    public void setMarketingOperation(DataLink marketingOperation) {
        this.marketingOperation = marketingOperation;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getAnswer() {
        return answer;
    }

    public void setAnswer(Short answer) {
        this.answer = answer;
    }

    public DataLink getSalesStep() {
        return salesStep;
    }

    public void setSalesStep(DataLink salesStep) {
        this.salesStep = salesStep;
    }

    public DataLink getIntroducedCollaborator() {
        return introducedCollaborator;
    }

    public void setIntroducedCollaborator(DataLink introducedCollaborator) {
        this.introducedCollaborator = introducedCollaborator;
    }

    public Short getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Short isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<DataLink> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<DataLink> equipments) {
        this.equipments = equipments;
    }

    public DataLink getMarketingCampaign() {
        return marketingCampaign;
    }

    public void setMarketingCampaign(DataLink marketingCampaign) {
        this.marketingCampaign = marketingCampaign;
    }

    public DataLink getLead() {
        return lead;
    }

    public void setLead(DataLink lead) {
        this.lead = lead;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public List<SpecificData> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<SpecificData> extraData) {
        this.extraData = extraData;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
