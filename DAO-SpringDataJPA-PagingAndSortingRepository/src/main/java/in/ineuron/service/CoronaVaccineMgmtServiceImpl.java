package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		System.out.println("Proxy class implementation name is :: " + repo.getClass().getName());
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities = repo.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int PageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, PageSize, asc ? Direction.ASC : Direction.DESC, properties);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		
		//total record count
		long count = repo.count(); //total 7
		
		//deciding page count
		long pagesCount = count / pageSize; //pagesCount = 7/3 = 2
		pagesCount = count % pageSize == 0 ? pagesCount : ++pagesCount; //pagesCOunt = 3
		
		for(int i=0; i<pagesCount; i++) {
			//loop running from 0,1,2
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-----------" + (i+1) + " of :: " + page.getTotalPages());
		}
		
	}

	
	
}
