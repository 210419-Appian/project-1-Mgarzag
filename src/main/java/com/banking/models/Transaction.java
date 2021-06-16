package com.banking.models;

import java.time.LocalTime;

public class Transaction {
	int accountId;
	LocalTime transactionDate;
	double amount;
	int transType;
	public Transaction () {}
	public Transaction(int accountId, LocalTime transactionDate, double amount, int transType) {
		super();
		this.accountId = accountId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transType = transType;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public LocalTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransType() {
		return transType;
	}
	public void setTransType(int transType) {
		this.transType = transType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transType;
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (transType != other.transType)
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [Account#" + accountId + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transType=" + transType + "]";
	}
	
	
}
