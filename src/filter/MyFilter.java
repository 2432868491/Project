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
		System.out.println("----������������......");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("--->���뵽Filter��.....");
		//String uname= arg0.getParameter("uname");
		//System.out.println("��ȡ��ֵ��"+uname);
		//������������
		HttpServletRequest request= (HttpServletRequest)arg0;
		request.setCharacterEncoding(this.setEncoding);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("----��������ʼ��......");
		//��ʼ�� tomcat������Ŀ��ʱ�����web.xml������param-value
		//this.setEncoding=arg0.getInitParameter("setEncoding");
		//System.out.println("----��ʼ������������ʱ��"+this.setEncoding);
		Enumeration<String> names= arg0.getInitParameterNames();
		while(names.hasMoreElements()){
			//������ʼ��param-name
			//ͨ�����ƻ�ȡ����Ӧ��ֵ 
			String aaa= arg0.getInitParameter(names.nextElement());
			System.out.println(aaa);
			if(names.nextElement().equals("setEncoding")){
				System.out.println("---���뵽���뼯���ã�");
				this.setEncoding=arg0.getInitParameter(names.nextElement());
			}
		}
	}
	
}
