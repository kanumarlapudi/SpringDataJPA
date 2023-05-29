package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;

public interface ICoronaVaccineMgmtService {

	public List<ResultView> searchVaccineBystartPrice(Double price);
	
}
