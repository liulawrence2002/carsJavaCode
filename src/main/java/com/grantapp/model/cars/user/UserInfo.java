package com.grantapp.model.cars.user;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.grantapp.model.cars.lookup.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserInfo", schema = "cars")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", foreignKey = @ForeignKey(name = "FK_UserInfo_ProUser"), nullable = false)
    private ProUser user;

    @Column(name = "MilitaryRankId")
    private Integer militaryRankId;

    @Column(name = "MilitaryStatusTypeId")
    private Integer militaryStatusTypeId;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "MiddleName", length = 50)
    private String middleName;

    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @Column(name = "NickName", length = 50)
    private String nickName;

    @Column(name = "VendorId")
    private Integer vendorId;

    @Column(name = "VendorName", length = 100)
    private String vendorName;

    @Column(name = "Institution", length = 100)
    private String institution;

    @Column(name = "Department", length = 100)
    private String department;

    @Column(name = "Position", length = 100)
    private String position;

    @Column(name = "BadgeName", length = 100)
    private String badgeName;

    @Column(name = "PrefixId")
    private Integer prefixId;

    @Column(name = "SuffixText", length = 50)
    private String suffixText;

    @Column(name = "GenderId")
    private Integer genderId;

    @Column(name = "EthnicityId")
    private Integer ethnicityId;

    @Column(name = "EthnicityARSId")
    private Integer ethnicityARSId;

    @Column(name = "AcademicRankId")
    private Integer academicRankId;

    @Column(name = "Expertise", length = 500)
    private String expertise;

    @Column(name = "DegreeNotApplicable", nullable = false)
    private boolean degreeNotApplicable;

    @Column(name = "ProfessionalAffiliationId")
    private Integer professionalAffiliationId;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "last_updated_by")
    private Integer lastUpdatedBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "DeletedFlag", nullable = false)
    private boolean deletedFlag;

    @Column(name = "DeletedBy")
    private Integer deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    @ManyToOne
    @JoinColumn(name = "TenantId", foreignKey = @ForeignKey(name = "FK_UserInfo_Tenant"), nullable = false)
    private Tenant tenant;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProUser getUser() {
        return user;
    }

    public void setUser(ProUser user) {
        this.user = user;
    }

    public Integer getMilitaryRankId() {
        return militaryRankId;
    }

    public void setMilitaryRankId(Integer militaryRankId) {
        this.militaryRankId = militaryRankId;
    }

    public Integer getMilitaryStatusTypeId() {
        return militaryStatusTypeId;
    }

    public void setMilitaryStatusTypeId(Integer militaryStatusTypeId) {
        this.militaryStatusTypeId = militaryStatusTypeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public Integer getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(Integer prefixId) {
        this.prefixId = prefixId;
    }

    public String getSuffixText() {
        return suffixText;
    }

    public void setSuffixText(String suffixText) {
        this.suffixText = suffixText;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Integer ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public Integer getEthnicityARSId() {
        return ethnicityARSId;
    }

    public void setEthnicityARSId(Integer ethnicityARSId) {
        this.ethnicityARSId = ethnicityARSId;
    }

    public Integer getAcademicRankId() {
        return academicRankId;
    }

    public void setAcademicRankId(Integer academicRankId) {
        this.academicRankId = academicRankId;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public boolean isDegreeNotApplicable() {
        return degreeNotApplicable;
    }

    public void setDegreeNotApplicable(boolean degreeNotApplicable) {
        this.degreeNotApplicable = degreeNotApplicable;
    }

    public Integer getProfessionalAffiliationId() {
        return professionalAffiliationId;
    }

    public void setProfessionalAffiliationId(Integer professionalAffiliationId) {
        this.professionalAffiliationId = professionalAffiliationId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return dateCreated;
    }

    public void setCreatedDate(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}