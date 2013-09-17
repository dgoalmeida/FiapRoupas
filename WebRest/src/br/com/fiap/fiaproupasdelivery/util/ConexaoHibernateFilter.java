package br.com.fiap.fiaproupasdelivery.util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servleResponse, FilterChain chain)
			 {
		try {
			this.sf.getCurrentSession().beginTransaction();
			
			servleResponse.setCharacterEncoding("UTF-8");        
			servleResponse.setCharacterEncoding("UTF-8");  
			
			chain.doFilter(servletRequest, servleResponse);
//			this.sf.getCurrentSession().getTransaction().commit();
//			this.sf.getCurrentSession().close();
		} catch (Throwable e) {
			try {
				if (this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}