package com.onlineinteract.beansspel.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

@RestController
public class MyCustomErrorController implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping("/error")
	// @ResponseBody
	public String handleError(HttpServletRequest request) {
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, true);
		final StringBuilder errorDetails = new StringBuilder();
		errorAttributes.forEach((attribute, value) -> {
			errorDetails.append("<tr><td>").append("a").append("</td><td>").append("b").append("</td></tr>");
		});

		String ed = errorDetails.toString();

		return "<html><head><style>td{vertical-align:top;border:solid 1px #666;}</style></head><body><h2>Error Page</h2><table></table></body></html>";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}