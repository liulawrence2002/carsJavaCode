package com.grantapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class GrantApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proposalId;

    @NotBlank(message = "Project title cannot be blank")
    @Size(max = 500, message = "Project title cannot exceed 500 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Project title must contain only letters and spaces")
    private String projectTitle;

    @NotBlank(message = "Project type cannot be blank")
    @Size(max = 20, message = "Project type cannot exceed 20 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Project type must contain only letters and spaces")
    private String projectType;

    private String contactInfo;
    private String name;
    private String address;

    @ManyToOne
    private Institution institution;

    private String abstractText;
    private String goals;
    private String objectives;

    @OneToMany(mappedBy = "grantApplication", cascade = CascadeType.ALL)
    private List<SupportDocument> supportDocuments;

    @OneToOne(cascade = CascadeType.ALL)
    private ProjectBudget projectBudget;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CarsUser user;
    @Transient
    private Long userId;

    private String status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    //public void setUserId(Long userId) { this.userId = userId; }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public List<SupportDocument> getSupportDocuments() {
        return supportDocuments;
    }

    public void setSupportDocuments(List<SupportDocument> supportDocuments) {
        this.supportDocuments = supportDocuments;
    }

    public ProjectBudget getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(ProjectBudget projectBudget) {
        this.projectBudget = projectBudget;
    }

    public CarsUser getUser() {
        return user;
    }

    public void setUser(CarsUser user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}