package main.scala

import java.util.Date

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._
import javax.validation.constraints.{NotNull, Size}
import scala.collection.mutable.HashMap


@RestController
@EnableAutoConfiguration
@ComponentScan
class Users {
	private var userId: String =_
			@NotNull @Size(min = 1) var userEmail: String = _ // act as a validations for empty string 
			@NotNull @Size(min = 1) var userPassword: String = _
			private var userName: String = _
			private var creationDT: Date = new Date()
			private var updateOn: Date = new Date()
			private var userIDcardtable : HashMap[String,userIdCards] = _  // _ --> Initialization 
		    private var userWebLoginTable : HashMap[String,userWebLogin] = _
		    private var userBankAccountTable : HashMap[String,userBankAcc] = _

			// getter setter methods for request class.
			def getUserId = this.userId
			def getUserEmail = this.userEmail
			def getUserName = this.userName
			def getUserPassword = this.userPassword
			def getCreationDT = this.creationDT
			def getUpdateOn  =  this.updateOn
			def getUserIDcardTable = this.userIDcardtable
			def getUserWebLoginTable = this.userWebLoginTable
            def getuserBankAccountTable = this.userBankAccountTable
            //
			def setUserId(newUserId : String ) = this.userId = newUserId
			def setUserEmail(newUserEmail : String ) = this.userEmail = newUserEmail
			def setUserPassword(newUserPassword : String) = this.userPassword = newUserPassword
			def setUserName(newUserName :String ) = this.userName = newUserName
			def setUserIdCardTable = this.userIDcardtable = new HashMap	
			def setUserWebLoginTable = this.userWebLoginTable = new HashMap
			def setuserBankAccountTable = this.userBankAccountTable = new HashMap
			

}   

