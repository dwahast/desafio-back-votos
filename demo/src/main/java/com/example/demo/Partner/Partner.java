package com.example.demo.Partner;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Partner {
    @Id
    @SequenceGenerator(
            name = "partner_sequence",
            sequenceName = "partner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "partner_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Transient
    private String fullName;
    private Long docId;

    public Partner() {
    }

    public Partner(String firstName, String lastName, Long docId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.docId = docId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Long getDocId() {
        return docId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partner partner = (Partner) o;
        return id.equals(partner.id) && firstName.equals(partner.firstName) && lastName.equals(partner.lastName) && Objects.equals(fullName, partner.fullName) && docId.equals(partner.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fullName, docId);
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", docId=" + docId +
                '}';
    }
}
