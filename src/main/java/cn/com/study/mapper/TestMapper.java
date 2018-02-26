package cn.com.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LIU
 *
 */

@Mapper
public interface TestMapper {

	@Select("SELECT name FROM test WHERE id = #{id}")
	public String getName(@Param("id") int id);
}
