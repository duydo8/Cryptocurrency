package com.globalsoftwaresupport.cryptocurrency;

import java.security.PublicKey;

public class TransactionOutput {

	// identifier of the transaction output (SHA-256)
	private String id;
	// transaction id (so the transaction it was created in)
	private String transactionId;
	// the new owner of the coin 
	private PublicKey receiver;
	// amount of coins
	private double amount;

	public TransactionOutput(PublicKey receiver, double amount, String transactionId) {
		this.receiver = receiver;
		this.amount = amount;
		this.transactionId = transactionId;
		generateId();
	}

	private void generateId() {
		this.id = CryptographyHelper.generateHash(receiver.toString() + Double.toString(amount) +
				transactionId);
	}

	public boolean isMine(PublicKey publicKey) {
		return publicKey == receiver;
	}

	public String getId() {
		return id;
	}

	public String getParentTransactionId() {
		return transactionId;
	}

	public void setParentTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PublicKey getReceiver() {
		return receiver;
	}

	public void setReceiver(PublicKey receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}