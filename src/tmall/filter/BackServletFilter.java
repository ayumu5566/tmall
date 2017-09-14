package tmall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class BackServletFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * /admin_category_list
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午4:40:16
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String contextPath = request.getServletContext().getContextPath();
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		if (uri.startsWith("/admin_")) {
			String servletPath = StringUtils.substringBetween(uri, "_", "_") + "Servlet";
			String method = StringUtils.substringAfterLast(uri, "_");
			request.setAttribute("method", method);
			servletRequest.getRequestDispatcher("/" + servletPath).forward(request, response);
			return;
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
