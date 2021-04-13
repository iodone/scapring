package com.github.iodone.scapring.app.controller

import com.github.iodone.scapring.app.domain.exception.{BusinessException, InternalException}
import com.github.iodone.scapring.common.helper.ResponseHelper
import org.springframework.web.bind.annotation.{ControllerAdvice, ExceptionHandler, ResponseBody}
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Array(classOf[Exception]))
  final def handleAllExceptions(ex: Exception, request: HttpServletRequest) = {
    logger.error(ex.getMessage, ex)
    val intelnalEx = InternalException("Internal server error")
    ResponseHelper.fail(intelnalEx)

  }

  @ExceptionHandler(Array(classOf[BusinessException]))
  final def handleBusinessException(sEx: BusinessException) = {
    ResponseHelper.fail(sEx)
  }
}


