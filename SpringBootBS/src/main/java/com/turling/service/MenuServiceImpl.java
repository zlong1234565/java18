package com.turling.service;

import com.turling.dao.MenuMapper;
import com.turling.entity.Attribute;
import com.turling.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements  MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        List<Menu> list = menuMapper.findMenu();
        for (Menu m:list){
            m.setChildren(menuMapper.findMenuById(m.getId()));
        }
        return list;
    }

    @Override
    public List<Menu> findAllMenu() {
        return getFatherNode(menuMapper.findAll());
    }

    /**
     * 根据节点集合获得所有的父节点为pid的节点，并且都设置了子元素
     * @param list 所有的菜单集合
     * @param  父节点
     * @return 父节点集合，父节点里装载了子节点
     */
    private List<Menu> getFatherNode(List<Menu> list){
        List<Menu> fatherList = new ArrayList<Menu>();
        for(Menu s:list){
            if(s.getPid()==0){
                //获取父节点下的子节点，根据父节点递归调用获取所有的子节点
                s.setChildren(getChildrenNode(s.getId(),list));
                fatherList.add(s);
            }
        }
        return fatherList;
    }

    /**
     * 递归调用
     * @param pid 父节点
     * @param list 要循环的集合
     * @return 将所有子节点设置到父节点对象里的list集合里
     */
    private List<Menu> getChildrenNode(int pid,List<Menu> list){
        List<Menu> findChildrenList = new ArrayList<Menu>();
        //循环传入的集合
        for(Menu s:list){
            if(s.getPid()==0){
                //父节点，不需要装载子元素
                continue;
            }
            if(s.getPid()==pid){
                //根据父id找到了一个子节点，加入到子节点集合中去
                Attribute att=new Attribute();
                att.setUrl(s.getUrl());
                att.setIcon(s.getIcon());
                s.setAttributes(att);
                findChildrenList.add(s);
                //设置子节点集合，递归调用
                s.setChildren(getChildrenNode(s.getId(),list));
            }
        }
        return findChildrenList;
    }
}
