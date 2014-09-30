package main.scala

import javax.validation.constraints.{NotNull, Size}

import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._

@RestController
//@EnableAutoConfiguration
@ComponentScan
class userBankAcc {
  private var webbaId: String =_
  private var webaccountName: String =_
  @NotNull @Size(min = 1) private var webroutineNumber: String =_
  @NotNull @Size(min = 1) private var webaccountNumber: String =_

  def getwebBaId = this.webbaId

  def setwebBaId(newBaId: String) = this.webbaId = newBaId

  def setwebAccountName(newAccountName: String) = this.webaccountName = newAccountName

  def getwebAccountName = this.webaccountName

  def setwebRoutineNumber(newRoutineNumber: String) = this.webroutineNumber = newRoutineNumber

  def getwebRoutineNumber = this.webroutineNumber

  def setwebAccountNumber(newAccountNumber: String) = this.webaccountNumber = newAccountNumber

  def getwebAccountNumber = this.webaccountNumber
}