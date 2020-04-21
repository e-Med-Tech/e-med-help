package com.example.e_med_help.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByUId", query = "SELECT u FROM User u WHERE u.uId = :uId"),
        @NamedQuery(name = "User.findByUName", query = "SELECT u FROM User u WHERE u.uName = :uName"),
        @NamedQuery(name = "User.findByUSurname", query = "SELECT u FROM User u WHERE u.uSurname = :uSurname"),
        @NamedQuery(name = "User.findByULoginname", query = "SELECT u FROM User u WHERE u.uLoginname = :uLoginname"),
        @NamedQuery(name = "User.findByUPassword", query = "SELECT u FROM User u WHERE u.uPassword = :uPassword")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "U_ID")
    private Integer uId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "U_NAME")
    private String uName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "U_SURNAME")
    private String uSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "U_LOGINNAME")
    private String uLoginname;
    @Size(max = 60)
    @Column(name = "U_PASSWORD")
    private String uPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fUId")
    private Collection<MedFile> medFileCollection;
    @JoinColumn(name = "U_ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false)
    private Role uRoleId;

    public User() {
    }

    public User(Integer uId) {
        this.uId = uId;
    }

    public User(Integer uId, String uName, String uSurname, String uLoginname) {
        this.uId = uId;
        this.uName = uName;
        this.uSurname = uSurname;
        this.uLoginname = uLoginname;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUSurname() {
        return uSurname;
    }

    public void setUSurname(String uSurname) {
        this.uSurname = uSurname;
    }

    public String getULoginname() {
        return uLoginname;
    }

    public void setULoginname(String uLoginname) {
        this.uLoginname = uLoginname;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @XmlTransient
    public Collection<MedFile> getMedFileCollection() {
        return medFileCollection;
    }

    public void setMedFileCollection(Collection<MedFile> medFileCollection) {
        this.medFileCollection = medFileCollection;
    }

    public Role getURoleId() {
        return uRoleId;
    }

    public void setURoleId(Role uRoleId) {
        this.uRoleId = uRoleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return (this.uId != null || other.uId == null) && (this.uId == null || this.uId.equals(other.uId));
    }

    @Override
    public String toString() {
        return "com.project.eMedHelp.models.User[ uId=" + uId + " ]";
    }

}
