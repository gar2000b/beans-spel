///*
// * Copyright 2014 by TGM Computer Consulting Services Inc. All rights reserved.
// *
// * This source code, and resulting software, is the confidential and proprietary 
// * information ("Proprietary Information") and is the intellectual property 
// * ("Intellectual Property") of TGM Computer Consulting Services Inc., ("The Company"). 
// *
// * You shall not disclose such Proprietary Information and or Intellectual Property 
// * and shall use it only in accordance with the terms and conditions of any and all 
// * license agreements you have entered into with The Company.
// */
//
//package com.onlineinteract.beansspel.config.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.HttpMediaTypeNotAcceptableException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.srdms.SrdRuntimeException;
//import com.srdms.core.service.SrdServiceException;
//import com.srdms.core.web.BadRequestException;
//import com.srdms.core.web.ResourceConflictException;
//import com.srdms.core.web.ResourceNotFoundException;
//
///**
// * AdviceController localizes exception handling for all controllers.
// * 
// * @author thomas
// */
//@ControllerAdvice
//public class AdviceController extends ResponseEntityExceptionHandler {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private boolean debugError = true;
//
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        StringBuilder sb = new StringBuilder("supported methods are:");
//        for (HttpMethod method : ex.getSupportedHttpMethods()) {
//            sb.append(" " + method.toString());
//        }
//        return AdviceControllerUtil.getWarningResponse(sb.toString(), headers, status, request);
//    }
//
//    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        StringBuilder sb = new StringBuilder("supported media types are:");
//        for (MediaType mediaType : ex.getSupportedMediaTypes()) {
//            sb.append(" " + mediaType.toString());
//        }
//        return AdviceControllerUtil.getWarningResponse(sb.toString(), headers, status, request);
//    }
//
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String warningText = "input message is not readable";
//        return AdviceControllerUtil.getWarningResponse(warningText, headers, status, request);
//    }
//
//    /**
//     * Handles {@link BadRequestException}.
//     * 
//     * <p>
//     * These always return 400 (bad request).
//     * </p>
//     * 
//     * @param e the BadRequestException
//     * @param request the HttpServletRequest
//     * @param response the HttpServletResponse
//     */
//    @ExceptionHandler(BadRequestException.class)
//    public void handleBadRequestException(BadRequestException e, HttpServletRequest request,
//            HttpServletResponse response) {
//        if (debugError) {
//            logger.error("{}", ExceptionUtils.getRootCauseMessage(e));
//        }
//        AdviceControllerUtil.processWarningResponse(e, HttpServletResponse.SC_BAD_REQUEST, request, response);
//    }
//
//    /**
//     * Handles {@link ResourceNotFoundException}.
//     * 
//     * <p>
//     * These always return 404 (not found).
//     * </p>
//     * 
//     * @param e the ResourceNotFoundException
//     * @param request the HttpServletRequest
//     * @param response the HttpServletResponse
//     */
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public void handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request,
//            HttpServletResponse response) {
//        if (debugError) {
//            logger.error("{}", ExceptionUtils.getRootCauseMessage(e));
//        }
//        AdviceControllerUtil.processWarningResponse(e, HttpServletResponse.SC_NOT_FOUND, request, response);
//    }
//
//    /**
//     * Handles {@link ResourceConflictException}.
//     * 
//     * <p>
//     * These always return 409 (conflict).
//     * </p>
//     * 
//     * @param e the ResourceConflictException
//     * @param request the HttpServletRequest
//     * @param response the HttpServletResponse
//     */
//    @ExceptionHandler(ResourceConflictException.class)
//    public void handleResourceConflictException(ResourceConflictException e, HttpServletRequest request,
//            HttpServletResponse response) {
//        if (debugError) {
//            logger.error("{}", ExceptionUtils.getRootCauseMessage(e));
//        }
//        AdviceControllerUtil.processWarningResponse(e, HttpServletResponse.SC_CONFLICT, request, response);
//    }
//
//    /**
//     * Handles {@link SrdServiceException}.
//     * 
//     * <p>
//     * These always return 500 (internal server error).
//     * </p>
//     * 
//     * @param e the SrdServiceException
//     * @param request the HttpServletRequest
//     * @param response the HttpServletResponse
//     */
//    @ExceptionHandler(SrdServiceException.class)
//    public void handleSrdServiceException(SrdServiceException e, HttpServletRequest request,
//            HttpServletResponse response) {
//        if (debugError) {
//            logger.error("SrdServiceException", e);
//        } else {
//            logger.error("{}", ExceptionUtils.getRootCauseMessage(e));
//        }
//        AdviceControllerUtil.processErrorResponse(e, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, request, response);
//    }
//
//    /**
//     * Handles {@link SrdRuntimeException}.
//     * 
//     * <p>
//     * These always return 500 (internal server error).
//     * </p>
//     * 
//     * @param e the SrdRuntimeException
//     * @param request the HttpServletRequest
//     * @param response the HttpServletResponse
//     */
//    @ExceptionHandler(SrdRuntimeException.class)
//    public void handleSrdRuntimeException(SrdRuntimeException e, HttpServletRequest request,
//            HttpServletResponse response) {
//        if (debugError) {
//            logger.error("SrdRuntimeException", e);
//        } else {
//            logger.error("{}", ExceptionUtils.getRootCauseMessage(e));
//        }
//        AdviceControllerUtil.processErrorResponse(e, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, request, response);
//    }
//}