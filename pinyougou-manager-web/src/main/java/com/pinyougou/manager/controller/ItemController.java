package com.pinyougou.manager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.sellergoods.service.ItemService;

import com.pinyougou.vo.PageVO;
import com.pinyougou.vo.ResultVO;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

	@Reference
	private ItemService itemService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbItem> findAll(){			
		return itemService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageVO  findPage(int page,int rows){			
		return itemService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param item
	 * @return
	 */
	@RequestMapping("/add")
	public ResultVO add(@RequestBody TbItem item){
		try {
			itemService.add(item);
			return new ResultVO(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param item
	 * @return
	 */
	@RequestMapping("/update")
	public ResultVO update(@RequestBody TbItem item){
		try {
			itemService.update(item);
			return new ResultVO(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbItem findOne(Long id){
		return itemService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultVO delete(Long [] ids){
		try {
			itemService.delete(ids);
			return new ResultVO(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVO(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageVO search(@RequestBody TbItem item, int page, int rows  ){
		return itemService.findPage(item, page, rows);		
	}
	
}
