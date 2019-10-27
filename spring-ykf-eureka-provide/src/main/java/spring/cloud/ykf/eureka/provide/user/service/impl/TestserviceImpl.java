package spring.cloud.ykf.eureka.provide.user.service.impl;


import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.ykf.eureka.provide.user.dao.TestDao;
import spring.cloud.ykf.eureka.provide.user.service.Testservice;
import spring.cloud.ykf.eureka.provide.user.vo.Menu;
import spring.cloud.ykf.eureka.provide.user.vo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestserviceImpl implements Testservice {
    @Autowired
    TestDao testDao ;
    @Override
    public String getS(int findById) {
        //User info = testDao.findById(findById);
     //   List<Menu> menus = testDao.queryMenuList(null);多次查询返回菜单

     //   List<Menu> menus=testDao.queryAllMenuList();//
        List<Menu> menuss=testDao.queryAllMenuLists();
        List<Menu>  fmeun = getMeun(menuss);
        String s = JSONArray.toJSONString(fmeun);
        return s;
    }

    private  List<Menu> getMeun(List<Menu> list ) {//生成菜单树

        List<Menu> menuList=new ArrayList<Menu>();
        /**
         * 找根菜单
         */
        List<Menu> topMenu = list.stream().filter(p -> "0".equals(p.getParentId())||p.getParentId()==null).
                sorted(Comparator.comparing(Menu::getItemIndex) ).collect(Collectors.toList());
        if(topMenu.size()>0){
            topMenu.forEach(menu ->{
                List<Menu> childs = findChilds(list, menu);//找子菜单
                menu.setChildren(childs);
                menuList.add(menu);
            });

        }
        return menuList;
    }

    /**
     *
     * 递归找所有子菜单
     * @param list
     * @param menu
     * @return
     */
    private  List<Menu> findChilds(List<Menu> list ,Menu menu) {//递归找所有子菜单

       List<Menu> menuList=new ArrayList<Menu>();

        List<Menu>  childMenu=list.stream().filter(menu1 -> menu.getId().equals(menu1.getParentId()))
                .sorted(Comparator.comparing(Menu::getItemIndex) ).collect(Collectors.toList());
        menu.setChildren(childMenu);
        if(childMenu.size()>0){
            menuList.addAll(childMenu);
            list.removeAll(childMenu);
            childMenu.forEach(p->{
                findChilds(list,p);
            });
        }
        return menuList;
    }





}
