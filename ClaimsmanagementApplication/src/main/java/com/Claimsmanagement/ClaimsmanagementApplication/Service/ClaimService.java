package com.Claimsmanagement.ClaimsmanagementApplication.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.Claim;
import com.Claimsmanagement.ClaimsmanagementApplication.repository.ClaimRepository;

@Service
public class ClaimService {
	private ClaimRepository claimRepository;
	
	@Autowired
	public ClaimService(ClaimRepository claimRepository) {
		this.claimRepository=claimRepository;
	}
	
	//1.Endpoint2 implement 
	public void addNewClaim(Claim claimDTO) {
		
		claimRepository.save(claimDTO);
		System.out.println("Successfully saved");
	}


	//2.endpoint3 implement-get request for new claims for policy managers
	public List<Claim> getNewClaims() {
		List<Claim>newclaimfromdb= new ArrayList<>();
		List<Claim>newclaimtoreturn= new ArrayList<>();
		List<Claim>temp= new ArrayList<>();
		newclaimfromdb=(List<Claim>) claimRepository.findAll();
		for(int i=0;i<newclaimfromdb.size();i++) {
			if(newclaimfromdb.get(i).getClaimStatus()=="New") {
				temp=(List<Claim>)newclaimfromdb.get(i);
				newclaimtoreturn.addAll(temp);	
			}
		}
		System.out.println("size: ");
		System.out.println(newclaimtoreturn.size());
		if(newclaimtoreturn.size()==0) {
			return null;
		}else {
		return newclaimtoreturn;
		}
	}

	//3.Endpoint4 implement-get request for claim details for any claim request(s) by policy manager 
	public Claim getClaimsByClaimId(int id) {
		List<Claim>claims= new ArrayList<>();
		claims=(List<Claim>) claimRepository.findAll();
		for(int i=0;i<claims.size();i++) {
			if(id==claims.get(i).getId()) {
				return claims.get(i);
			}
		}
		return null;
	}


}
