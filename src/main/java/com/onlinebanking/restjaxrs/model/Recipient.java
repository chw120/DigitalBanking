package com.onlinebanking.restjaxrs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "recipients")
public class Recipient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ruid;
	@Column(name = "recipient_name")
	private String recipientName;
    @Column(name = "recipient_email", nullable = false, unique = true)
	private String recipientEmail;
	private String recipientPhone;
    @Column(name = "account_number", nullable = false, unique = true)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	
}
