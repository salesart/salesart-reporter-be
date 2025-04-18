package com.saleart.reporter.filter;

import com.saleart.reporter.properties.ReportProperties;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReportRequestSizeFilter implements Filter {

    private static final String REQUEST_ENTITY_TOO_LARGE_BODY = "{\"error\": \"Request entity too large\"}";

    private final long postRequestSizeLimit;

    public ReportRequestSizeFilter(ReportProperties reportProperties) {
        this.postRequestSizeLimit = reportProperties.getPostRequestSizeLimit();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (HttpMethod.POST.name().equalsIgnoreCase(httpRequest.getMethod())
            && httpRequest.getContentLength() > postRequestSizeLimit) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            httpResponse.getWriter().write(REQUEST_ENTITY_TOO_LARGE_BODY);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
