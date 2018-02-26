
package cn.com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.study.mapper.TestMapper;

/**
 * @author LIU
 *
 */
@Service
public class TestService {

	@Autowired
	private TestMapper testMapper;

	public String getName(int id) {
		return testMapper.getName(id);
	}
}
