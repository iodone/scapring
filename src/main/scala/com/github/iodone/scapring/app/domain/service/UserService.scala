package com.github.iodone.scapring.app.domain.service

import com.github.iodone.scapring.app.domain.entity.Entity._
import com.typesafe.scalalogging.LazyLogging
import org.springframework.stereotype.Service

@Service
class UserService extends LazyLogging {

  /**
   * 获取用户详情
   * @param userId
   * @return
   */
  def detail(userId: Long): Option[User] = {

    Some(User("hello", "man", 1))
  }

  def list(name: String): List[User] = {
    List(User("zhangsan", "man", 1), User("lisi", "man", 2))
  }

}
