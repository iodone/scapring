package com.github.iodone.scapring.app.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus._

abstract class BusinessException(val errorCode: Int, val message: String, val statusCode: HttpStatus) extends Exception(message)

class ExitTrappedException(message: String = "System.exit call caught") extends Exception(message)

case class BadRequetException(override val message: String)
  extends BusinessException(4007400, message, BAD_REQUEST)

case class ValidateException(override val message: String)
  extends BusinessException(4007401, message, BAD_REQUEST)

case class EngineNotSupportedException(override val message: String)
  extends BusinessException(4007404, message, NOT_FOUND)


case class InternalException(override val message: String)
  extends BusinessException(4007500, message, INTERNAL_SERVER_ERROR)

case class StateTransitionException(override val message: String)
  extends BusinessException(4007501, message, INTERNAL_SERVER_ERROR)

case class YarnException(override val message: String)
  extends BusinessException(4007502, message, INTERNAL_SERVER_ERROR)

case class ZookeeperException(override val message: String)
  extends BusinessException(4007503, message, INTERNAL_SERVER_ERROR)

case class SparkServiceException(override val message: String)
  extends BusinessException(4007504, message, INTERNAL_SERVER_ERROR)

case class TaskKillException(override val message: String)
  extends BusinessException(4007505, message, INTERNAL_SERVER_ERROR)

case class MetaServiceException(override val message: String)
  extends BusinessException(4007506, message, INTERNAL_SERVER_ERROR)




