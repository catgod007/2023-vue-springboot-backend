package org.source.controller;

import org.source.domain.Shop;
import org.source.query.ShopQuery;
import org.source.service.IShopService;
import org.source.until.AjaxResult;
import org.source.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller+@ResponseBody组成
@RequestMapping("/name")//注解用于请求地址的解析
public class ShopController {
    @Autowired
    private IShopService shopService;//控制层根据前端的请求去调用相对应的业务层的代码，所以要注入业务层代码
    @GetMapping
    public List<Shop> queryall(){
        return shopService.selectAll();

    }
    @GetMapping("/{id}")
    public Shop queryById(@PathVariable("id")Long id){//传id类型
        return shopService.selectById(id);
    }

    @PostMapping
    public PageList<Shop> queryByPage(@RequestBody ShopQuery query){
        return shopService.queryByPage(query);
    }

    @PutMapping
    public AjaxResult AddOrUpdate(@RequestBody Shop shop){//传对象
        try{
            if(shop.getId() == null){
                shopService.insert(shop);
            }else{
                shopService.update(shop);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"操作失败!!!!");
        }
        return new AjaxResult(true,"操作成功！！！");
    }

    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id")Long id){
        try {
            shopService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
        return new AjaxResult(true,"删除成功");

    }
    @PatchMapping
    public AjaxResult batchRemove(@RequestBody List<Long> ids){
        System.out.println(ids);
        try {
            shopService.batchDelete(ids);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
        return new AjaxResult(true,"删除成功");

    }


}
