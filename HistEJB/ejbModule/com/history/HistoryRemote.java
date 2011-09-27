package com.history;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface HistoryRemote {
	void addLogin1FASuccess(String idPib);

	void addLogin1FANotSuccess(String idPib);

	void addLogin2FANotSuccess(String idPib);

	void addLogin2FASuccess(String idPib);

	List<HistoryData> getHistory(String idPib);
}