package com.onlinebanking.restjaxrs.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tuid;
	private Date date;
	private String notes;
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private TransactionType transactionType;
	private String status;
	private BigDecimal amount;
	@Column(name = "available_balance")
	private BigDecimal availableBalance;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public Long getTuid() {
		return tuid;
	}

	public void setTuid(Long tuid) {
		this.tuid = tuid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

}
