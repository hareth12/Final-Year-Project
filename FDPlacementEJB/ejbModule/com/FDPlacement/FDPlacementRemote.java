package com.FDPlacement;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FDPlacementRemote {
	public List<FDPlacementClass> getPlacementList(long accountNumber);

	public boolean makeFDPlacement(long accountNumber, Double amount, int days, String idPib);
}


