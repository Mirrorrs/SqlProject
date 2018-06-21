package com.hansoma.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTime());
	}
	
	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String result = df.format(new Date());// new Date()为获取当前系统时间
        return result;
	}

}
