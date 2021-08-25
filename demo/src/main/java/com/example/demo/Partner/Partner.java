package com.example.demo.Partner;

import javax.persistence.*;

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
}
