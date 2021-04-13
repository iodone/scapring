package com.github.iodone.scapring.app.controller

import com.github.iodone.scapring.app.domain.entity.Entity.{UserId, UserQueryReq}
import com.github.iodone.scapring.app.domain.exception.StateTransitionException
import com.github.iodone.scapring.app.domain.service.UserService
import com.github.iodone.scapring.common.helper.ResponseHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

/**
 * @ClassName UserController
 * @Description 用戶Controller
 * @Version 1.0
 */

@RestController
@RequestMapping(Array("/api/v1/user"))
class UserController @Autowired()(val userService : UserService)  {

  /**
   * 分页用戶信息
   * @param param
   */
  @PostMapping(value = Array("/list"))
  def list(@RequestBody param: UserQueryReq)={
    val ret = userService.list(param.name)
    ResponseHelper.success(ret)
  }

  /**
   * ready
   */
  @PostMapping(value = Array("/detail"))
  def detail(@RequestBody userId: UserId)= {
    val ret = userService.detail(userId.id)
    ResponseHelper.success(ret)
  }
}
