package com.github.iodone.scapring.app.domain.entity


trait Entity extends Serializable


object Entity {

  // for common

  // for bussiness
  type Id = Long

  final case class UserId(id: Id) extends Entity
  final case class User(name: String, sex: String, age: Int) extends Entity

  final case class UserQueryReq(name: String) extends Entity

}

