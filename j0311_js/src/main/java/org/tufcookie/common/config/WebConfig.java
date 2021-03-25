package org.tufcookie.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.tufcookie.board.config.BoardConfig;
import org.tufcookie.reply.config.ReplyConfig;
import org.tufcookie.time.config.TimeConfig;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {CommonConfig.class,
							TimeConfig.class,
							BoardConfig.class,
							ReplyConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
