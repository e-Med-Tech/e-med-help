package com.example.e_med_help.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user_medical_history")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserMedicalHistory.findAll", query = "SELECT u FROM MedFile u"),
        @NamedQuery(name = "UserMedicalHistory.findByFId", query = "SELECT u FROM MedFile u WHERE u.fId = :fId"),
        @NamedQuery(name = "UserMedicalHistory.findByFUName", query = "SELECT u FROM MedFile u WHERE u.fUName = :fUName"),
        @NamedQuery(name = "UserMedicalHistory.findByFUSurname", query = "SELECT u FROM MedFile u WHERE u.fUSurname = :fUSurname")})
public class MedFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "F_ID")
    private Integer fId;
    @Size(max = 45)
    @Column(name = "F_U_NAME")
    private String fUName;
    @Size(max = 45)
    @Column(name = "F_U_SURNAME")
    private String fUSurname;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "F_DATA")
    private byte[] fData;
    @JoinColumn(name = "F_U_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private User fUId;

    public MedFile() {
    }

    public MedFile(Integer fId) {
        this.fId = fId;
    }

    public MedFile(Integer fId, byte[] fData) {
        this.fId = fId;
        this.fData = fData;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFUName() {
        return fUName;
    }

    public void setFUName(String fUName) {
        this.fUName = fUName;
    }

    public String getFUSurname() {
        return fUSurname;
    }

    public void setFUSurname(String fUSurname) {
        this.fUSurname = fUSurname;
    }

    public byte[] getFData() {
        return fData;
    }

    public void setFData(byte[] fData) {
        this.fData = fData;
    }

    public User getFUId() {
        return fUId;
    }

    public void setFUId(User fUId) {
        this.fUId = fUId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fId != null ? fId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedFile)) {
            return false;
        }
        MedFile other = (MedFile) object;
        return (this.fId != null || other.fId == null) && (this.fId == null || this.fId.equals(other.fId));
    }

    @Override
    public String toString() {
        return "com.project.eMedHelp.models.MedFile[ fId=" + fId + " ]";
    }

}
