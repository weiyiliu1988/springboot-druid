package cn.com.study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.com.study.service.TestService;
import cn.com.study.tmp.entity.TestEntity;

/**
 * Controller
 * 
 * @author LIU
 *
 */
@RestController
@RequestMapping("/info")
public class InfoController {

	private Logger logger = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private TestService testService;

	@RequestMapping(path = "/greet", method = RequestMethod.GET)
	@ResponseBody
	public String info() {
		logger.debug("[test]");
		return "hello world!";
	}

	@RequestMapping(path = "/name", method = RequestMethod.GET)
	public String getName(@RequestParam("id") int id) {
		logger.debug("[获取name信息] id:{}", id);
		return testService.getName(id);
	}

	@RequestMapping(path = "/names", method = RequestMethod.GET)
	public List<String> getNames() {
		return testService.getNames();
	}

	@RequestMapping(path = "/names/page", method = RequestMethod.GET)
	public PageInfo<TestEntity> getNamesWithPage(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		logger.debug("[pageInfo获取] pageSize = {} , currentPage = {}", pageSize, pageNum);
		return testService.getNamesWithPage(pageNum, pageSize);
	}
}
