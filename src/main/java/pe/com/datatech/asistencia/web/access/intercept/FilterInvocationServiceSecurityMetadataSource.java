package pe.com.datatech.asistencia.web.access.intercept;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;


import pe.com.datatech.asistencia.web.access.expression.CustomWebSecurityExpressionHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;



@Component("filterInvocationServiceSecurityMetadataSource")
public class FilterInvocationServiceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean{
	private FilterInvocationSecurityMetadataSource delegate;
	private SecurityExpressionHandler<FilterInvocation> expressionHandler;

	@Autowired
	public FilterInvocationServiceSecurityMetadataSource(CustomWebSecurityExpressionHandler expressionHandler,
			RequestConfigMappingService filterInvocationService) {
		this.expressionHandler = expressionHandler;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return this.delegate.getAllConfigAttributes();
	}

	public Collection<ConfigAttribute> getAttributes(Object object) {
		return this.delegate.getAttributes(object);
	}

	public boolean supports(Class<?> clazz) {
		return this.delegate.supports(clazz);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
		this.delegate = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);
	}
}