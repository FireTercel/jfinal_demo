package com.demo.clothes;


import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;

public class ClothesController extends Controller {
	
	@Before({CacheInterceptor.class,EvictInterceptor.class})
	@CacheName("/clothes")
	public void index(){
		setAttr("clothPage", Clothes.dao.paginate(getParaToInt(0, 1), 10));
		
		render("clothes.html");
	}
	
	@Before({CacheInterceptor.class,EvictInterceptor.class})
	@CacheName("/clothes/list")
	public void list(){
		List<Clothes> clotheslist=Clothes.dao.find("select * from clothes");
		setAttr("clotheslist", clotheslist);
		render("clothbootstrap.html");
	}
	
	public void clothbootstrap(){}
	
	public void add(){}
	
	@Before(ClothesValidator.class)
	public void save(){
		getModel(Clothes.class).set("flag", "12").save();
		
		redirect("/clothes");
	}
	
	public void edit(){
		//setAttr("clothes",Clothes.dao.)
	}

}
