package org.maruhan.service;

import java.util.List;

import org.maruhan.domain.RouteVO;
import org.maruhan.persistence.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteService {

	@Autowired
	RouteMapper mapper;
	
	public List<RouteVO> insert() throws Exception{
		List<RouteVO> result;
		result = mapper.listAll();
		return result;
	}
	
	
}
