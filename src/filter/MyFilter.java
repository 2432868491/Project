package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter{

	private String setEncoding;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----过滤器已销毁......");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("--->进入到Filter中.....");
		//String uname= arg0.getParameter("uname");
		//System.out.println("获取的值："+uname);
		//中文乱码问题
		HttpServletRequest request= (HttpServletRequest)arg0;
		request.setCharacterEncoding(this.setEncoding);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("----过滤器初始化......");
		//初始化 tomcat启动项目的时候加载web.xml容器的param-value
		//this.setEncoding=arg0.getInitParameter("setEncoding");
		//System.out.println("----初始化加载容器的时候："+this.setEncoding);
		Enumeration<String> names= arg0.getInitParameterNames();
		while(names.hasMoreElements()){
			//遍历初始化param-name
			//通过名称获取到对应的值 
			String aaa= arg0.getInitParameter(names.nextElement());
			System.out.println(aaa);
			if(names.nextElement().equals("setEncoding")){
				System.out.println("---进入到编码集设置！");
				this.setEncoding=arg0.getInitParameter(names.nextElement());
			}
		}
	}
	
}
