package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.PageVO;

public interface BrandService {
	public List<TbBrand> findAll();

	public TbBrand findByKey(Long key);
	
	/**
	 * 品牌分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageVO findPage(int pageNum,int pageSize);
	/**
	 * 品牌分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageVO findPage(int pageNum,int pageSize,TbBrand brand);
	
	/**
	 * 增加
	 * @param brand
	 */
	public void add(TbBrand brand);
	
	/**
	 * 修改
	 * @param brand
	 */
	public void update(TbBrand brand);
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(Long[] ids);
	
	/**
	 * 返回下拉列表数据
	 * @return
	 */
	public  List<Map> selectOptionList();
}
