package com.tripster.controller;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.tripster.domain.PageMaker;
import com.tripster.domain.SearchCriteria;
import com.tripster.elasticsearch.EsRepository;

@Controller
public class SearchController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Inject
	private EsRepository repository;
	
	
	// 통합검색 결과리스트 
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public void search(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		logger.info(cri.toString());
		
		model.addAttribute("search", repository.findSongWithPrefix(cri.getKeyword()));
		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		
//		pageMaker.setTotalCount(repository.);
		
	}
	
}
