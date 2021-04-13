package com.github.iodone.scapring.common.helper

import com.github.iodone.scapring.app.domain.entity.Entity
import com.github.iodone.scapring.app.domain.exception.BusinessException
import org.springframework.http.{HttpHeaders, ResponseEntity}
import org.springframework.http.HttpStatus.OK


object ResponseHelper {

  final case class Meta(errCode: Int, errMsg: String) extends Entity
  final case class Response(meta: Meta, data: Object) extends Entity

  def success(data: Object) = {
    val headers = new HttpHeaders()
    headers.add("Content-Type", "application/json")
    new ResponseEntity(Response(Meta(0, ""), data), headers, OK)
  }

  def fail(ex: BusinessException) = {
    val headers = new HttpHeaders()
    headers.add("Content-Type", "application/json")
    new ResponseEntity(Response(Meta(ex.errorCode, ex.message), None), headers, ex.statusCode)
  }

}
