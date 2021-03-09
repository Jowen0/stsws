package org.zerock.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zerock.service.Chef;
import org.zerock.service.Restaurant;

public class Main {
	
	//bad code - 예외는 던진다.
	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		System.out.println(ctx);
		
//		Object obj = ctx.getBean("m1");
//		
//		System.out.println(obj); //Bean으로 등록하면 스프링은 기본적으로 싱글턴이다.
//		
//		MenuService service = (MenuService)ctx.getBean("m1");
//		
//		System.out.println(service.getAllmenus());
		
//		MenuUI ui = (MenuUI) ctx.getBean("mui");
//		
//		System.out.println(ui);
		
		Chef chef = ctx.getBean(Chef.class);
		
		System.out.println(chef);
		
		Restaurant res = ctx.getBean(Restaurant.class);
		
		System.out.println(res);
		
	}
	
}
