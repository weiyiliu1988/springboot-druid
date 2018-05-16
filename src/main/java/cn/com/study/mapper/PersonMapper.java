package cn.com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.com.study.entity.Person;

@Mapper
public interface PersonMapper {

	@Select("SELECT * FROM person")
	public List<Person> getAll();

	@Insert("INSERT INTO person(name,city,sex,birthday)"//
			+ " values (#{name},#{city},#{sex},#{birthday})")
	public int insertPerson(Person person);
}
