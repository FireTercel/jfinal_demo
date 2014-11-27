package com.demo.clothes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ClothesValidator extends Validator {

	@Override
	protected void validate(Controller controller) {
		validateRequiredString("clothes.clothname", "clothnameMsg", "请输入产品名称！");
		validateDouble("clothes.price", "priceMsg", "请输入产品价格！");
		validateRequiredString("clothes.description", "descriptionMsg", "请输入产品描述");
		validateRequiredString("clothes.commant", "commantMsg", "请输入产品评论");
		validateRequiredString("clothes.uploadtime", "uploadtimeMsg", "请输入产品上传时间");
		try {
			validateDate("clothes.uploadtime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2014-01-01 00:00:00"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2015-01-01 00:00:00"), "uploadtimeMsg", "请输入正确时间格式");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Clothes.class);
		String actionKey=getActionKey();
		
		if(actionKey.equals("/clothes/save")){
			controller.render("add.html");
		}else if(actionKey.equals("/clothes/update")){
			controller.render("edit.html");
		}

	}

}
