package com.qline.web.controller.ajax;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.qline.web.controller.AbstractController;
import com.qline.web.json.JsonRpc;
import com.qline.web.json.JsonRpcError;

public abstract class AbstractAjaxController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAjaxController.class);
	
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	    @ResponseBody
	    public JsonRpc<String> handleException(Exception ex) {
	        final String message = String.format("An error has occured: %s", ex.getMessage());

	        LOGGER.error(message, ex);

	        final JsonRpc<String> resp = new JsonRpc<String>();
	        final Object errorObject = LOGGER.isDebugEnabled() ? ex : message;
	        final int errorCode =  0;

	        final JsonRpcError error = new JsonRpcError(errorCode, message, errorObject);
	        resp.setError(error);

	        return resp;
	    }
}
