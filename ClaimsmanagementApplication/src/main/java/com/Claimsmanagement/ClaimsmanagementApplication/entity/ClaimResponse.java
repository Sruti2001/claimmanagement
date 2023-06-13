package com.Claimsmanagement.ClaimsmanagementApplication.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="claimresponse")
public class ClaimResponse {
		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
		
		@Column(name="ResponseDate")
		private Date responseDate;
		@Column(name="ResponseDetails",length=500)
		private String responseDetails;
		@Column(name="ClaimId",length=10)
		private int claimId;
		
		public ClaimResponse() {
			super();
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getResponseDate() {
			return responseDate;
		}

		public void setResponseDate(Date responseDate) {
			this.responseDate = responseDate;
		}

		public String getResponseDetails() {
			return responseDetails;
		}

		public void setResponseDetails(String responseDetails) {
			this.responseDetails = responseDetails;
		}

		public int getClaimId() {
			return claimId;
		}

		public void setClaimId(int claimId) {
			this.claimId = claimId;
		}
}
