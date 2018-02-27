package cn.com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.com.study.tmp.dto.TestDto;
import cn.com.study.tmp.entity.TestEntity;

/**
 * @author LIU
 *
 */

@Mapper
public interface TestMapper {

	@Select("SELECT name FROM test WHERE id = #{id}")
	public String getName(@Param("id") int id);

	@Select("SELECT name FROM test")
	public List<String> getNames();

	@Select("SELECT * FROM test")
	public List<TestEntity> getEntities(TestDto testDto);
}
