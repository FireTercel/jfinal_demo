package com.demo.clothes;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Clothes model
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Clothes extends Model<Clothes> {
	
	public static final Clothes dao=new Clothes();
	
	public Page<Clothes> paginate(int pageNumber,int pageSize){
		return paginate(pageNumber, pageSize, "select *", "from clothes order by id asc");
	}
	
	public Clothes getClothes(){
		Clothes list=dao.findById(Clothes.dao.set("id", 1));
		return list;
	}

}
