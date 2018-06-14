package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.PageVO;
import com.pinyougou.vo.ResultVO;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSpecification> findAll() {
		return specificationService.findAll();
	}

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageVO findPage(int page, int rows) {
		return specificationService.findPage(page, rows);
	}

	/**
	 * 增加
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/add")
	public ResultVO add(@RequestBody Specification specification) {
		try {
			specificationService.add(specification);
			return new ResultVO(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/update")
	public ResultVO update(@RequestBody Specification specification) {
		try {
			specificationService.update(specification);
			return new ResultVO(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "修改失败");
		}
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Specification findOne(Long id) {
		return specificationService.findOne(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultVO delete(Long[] ids) {
		try {
			specificationService.delete(ids);
			return new ResultVO(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageVO search(@RequestBody TbSpecification specification, int page, int rows) {
		return specificationService.findPage(specification, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return specificationService.selectOptionList();
	}
}
