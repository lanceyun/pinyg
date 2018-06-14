package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageVO;
import com.pinyougou.vo.ResultVO;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}

	@RequestMapping("/findById")
	public TbBrand findByKey(Long id) {
		System.out.println("id=" + id);
		return brandService.findByKey(id);
	}

	@RequestMapping("/findPage")
	public PageVO findPage(int page, int size) {
		return brandService.findPage(page, size);
	}

	@RequestMapping("/add")
	public ResultVO add(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new ResultVO(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "增加失败");
		}
	}

	@RequestMapping("/update")
	public ResultVO update(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new ResultVO(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "修改失败");
		}
	}

	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findByKey(id);
	}
	@RequestMapping("/delete")
	public ResultVO detete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new ResultVO(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "删除失败");
		}
	}
	@RequestMapping("/search")
	public PageVO search(int page, int size,@RequestBody TbBrand brand) {
		return brandService.findPage(page, size, brand);
	}
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return brandService.selectOptionList();
	}
}
