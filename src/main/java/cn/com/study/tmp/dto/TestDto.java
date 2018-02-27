package cn.com.study.tmp.dto;

/**
 * @author LIU
 *
 */
public class TestDto {

	private int pageNum;
	private int pageSize = 10; // 默认10条

	public TestDto() {

	}

	/**
	 * @param pageNum
	 * @param pageSize
	 */
	public TestDto(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum
	 *            the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
