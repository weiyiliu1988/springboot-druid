
package cn.com.study.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.study.mapper.TestMapper;
import cn.com.study.tmp.dto.TestDto;
import cn.com.study.tmp.entity.TestEntity;

/**
 * @author LIU
 *
 */
@Service
public class TestService {

	private Logger logger = LoggerFactory.getLogger(TestService.class);

	@Autowired
	private TestMapper testMapper;

	public String getName(int id) {
		return testMapper.getName(id);
	}

	public List<String> getNames() {
		PageHelper.startPage(2, 10);
		return testMapper.getNames();
	}

	public PageInfo<TestEntity> getNamesWithPage(int pageNum, int pageSize) {
		TestDto testDto = new TestDto(pageNum, pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<TestEntity> list = testMapper.getEntities(testDto);
		logger.debug("[数据数量] list->size:{}", list.size());
		PageInfo<TestEntity> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
