package main.scala

import javax.validation.constraints.{NotNull, Size}

import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._

@RestController
//@EnableAutoConfiguration
@ComponentScan
class userWebLogin {
  private var webloginId: String =_
  @NotNull @Size(min = 1) private var webloginUrl: String =_
  @NotNull @Size(min = 1) private var weblogin: String =_
  @NotNull @Size(min = 1) private var webpassword: String =_

  def getwebLoginId = this.webloginId

  def setwebLoginId(newId: String) = this.webloginId = newId

  def setwebLoginUrl(newLoginUrl: String) = this.webloginUrl = newLoginUrl

  def getwebLoginUrl = this.webloginUrl

  def setwebLogin(newLogin: String) = this.weblogin = newLogin

  def getwebLogin = this.weblogin

  def setwebPassword(newPassword: String) = this.webpassword = newPassword

  def getwebPassword = this.webpassword
}