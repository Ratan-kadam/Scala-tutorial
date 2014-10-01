package main.scala

import java.text.SimpleDateFormat
import javax.validation.Valid
import org.springframework.http.{HttpHeaders, HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._

@RestController
class Test {
	
  //****************************************************************************************
  //*                Module for creation of Users                                                   *
  //****************************************************************************************
	@RequestMapping(value = Array("/users"), method = Array(RequestMethod.POST), consumes = Array("application/json"), produces = Array("application/json"))
	@ResponseBody def createUser(@RequestBody @Valid newUserDetails : Users): Users = {
 //println (" inside test loop ") ;
      val rndnum = new scala.util.Random
      var uid0= rndnum.nextInt();
      var uid_final = ("u" + uid0);
      println("uid_final" , uid_final);
      Runapp.userCollection.put(uid_final,newUserDetails);
 // displaying the object from the hasmap 
      newUserDetails.setUserId(uid_final);
      return Runapp.userCollection.get(uid_final).get 
   
	} // Complition of responseBody 

	//****************************************************************************************
  //*                Module for getting the users information                                                   *
  //****************************************************************************************
 @RequestMapping(value= Array("/users/{user_id}"),method = Array(RequestMethod.GET))
 @ResponseBody def getHashMap1(@PathVariable user_id:String): Users = {
  
  return Runapp.userCollection.get(user_id).get} 
//********************************************************************************************
//*            Module for updating the user information - PUT 
//*********************************************************************************************
  @RequestMapping(value= Array("/users/{user_id}"),method = Array(RequestMethod.PUT))
 @ResponseBody def getHashMap1(@RequestBody newUserInfo: Users,@PathVariable user_id:String): Users = {
  
    var userInfo: Option[Users] = Runapp.userCollection.get(user_id)
   // var userInfo  = Runapp.userCollection.get(user_id).get

  userInfo.get.setUserEmail(newUserInfo.userEmail)

  userInfo.get.setUserPassword(newUserInfo.userPassword)

  //var chkUpdate: Option[Users] = Runapp.userCollection.put(userInfo.get.getId,userInfo.get)

   return Runapp.userCollection.get(user_id).get
 }
//************************************************************************************************
//*  Module for creation of ID cards for perticular users 
//*************************************************************************************************
 @RequestMapping(value= Array("/users/{user_id}/idcard"),method = Array(RequestMethod.POST))
 @ResponseBody def getHashMap1(@RequestBody newIdInfo: userIdCards ,@PathVariable user_id:String) : userIdCards = {
  
    Runapp.increment = Runapp.increment + 1 
   var ucardid = ("C" + user_id+ Runapp.increment)
   println("ucardid:" + ucardid)
   val updateVar = Runapp.userCollection.apply(user_id);
   updateVar.setUserIdCardTable
   updateVar.getUserIDcardTable.update(ucardid,newIdInfo); // put will work
   newIdInfo.setCardID(ucardid)
  
  val update2 = updateVar.getUserIDcardTable.apply(ucardid);
  return update2 
 
  }
//************************************************************************************************
//*  Module for listing all cards of user 
//************************************************************************************************* 
 @RequestMapping(value= Array("/users/{user_id}/idcard"),method = Array(RequestMethod.GET),produces= Array("application/json"))
 @ResponseBody def getHashMap2(@PathVariable user_id:String) : Array[userIdCards] = {
   
    val userDetails = Runapp.userCollection.apply(user_id)
    
        var idCards = userDetails.getUserIDcardTable.values.toArray
        idCards
 }
 
 //***************************************************************************************************
 //** Deleting particular Id card of USER . 
 //******************************************************************************************************'
 @RequestMapping(value= Array("/users/{user_id}/idcard/{idcard}"),method = Array(RequestMethod.DELETE))
 @ResponseBody def getHashMap3(@PathVariable user_id:String ,@PathVariable idcard: String ) = {
   
   val getObj = Runapp.userCollection.apply(user_id)
   getObj.getUserIDcardTable -= idcard
 
 }
 
 ///////////////////////////////////web login ////////////////////////////////
 @RequestMapping(value= Array("/users/{user_id}/weblogins"),method = Array(RequestMethod.POST))
 @ResponseBody def getHashMap4(@RequestBody newwebInfo: userWebLogin ,@PathVariable user_id:String) : userWebLogin = {
   Runapp.increment = Runapp.increment + 1 
   var ucardid = ("W" + user_id + Runapp.increment )
   val updateVar = Runapp.userCollection.apply(user_id);
   updateVar.setUserWebLoginTable
   updateVar.getUserWebLoginTable.update(ucardid,newwebInfo)
   newwebInfo.setwebLoginId(ucardid);
   val update2 = updateVar.getUserWebLoginTable.apply(ucardid);
   update2 
 
  }
//************************************************************************************************
//*                Module for listing all the web logins
//************************************************************************************************* 
 @RequestMapping(value= Array("/users/{user_id}/weblogins"),method = Array(RequestMethod.GET))
 @ResponseBody def getHashMap5(@PathVariable user_id:String) : Array[userWebLogin] = {
   
    val userDetails = Runapp.userCollection.apply(user_id)
    
        val weblogin = userDetails.getUserWebLoginTable.values.toArray
        
        return weblogin
        
 }
 
 //***************************************************************************************************
 //** Deleting particular Id card of USER . 
 //******************************************************************************************************'
 @RequestMapping(value= Array("/users/{user_id}/weblogins/{web_login}"),method = Array(RequestMethod.DELETE))
 @ResponseBody def getHashMap6(@PathVariable user_id:String ,@PathVariable web_login: String ) = {
   
   val getObj = Runapp.userCollection.apply(user_id)
   getObj.getUserWebLoginTable -= web_login
 
 }
 
 
/////////////////////////////// bank account ////////////////////////////////////////////////////////////
  @RequestMapping(value= Array("/users/{user_id}/bankaccounts"),method = Array(RequestMethod.POST))
  @ResponseBody def getHashMap5(@RequestBody newbankInfo: userBankAcc ,@PathVariable user_id:String) : userBankAcc = {
    Runapp.increment = Runapp.increment + 1 ;
    var ucardid = ("B" + user_id + Runapp.increment)
     val updateVar = Runapp.userCollection.apply(user_id);
     updateVar.setuserBankAccountTable
     newbankInfo.setwebBaId(ucardid)
     updateVar.getuserBankAccountTable.update(ucardid,newbankInfo)
     val update2 = updateVar.getuserBankAccountTable.apply(ucardid);
     update2 
  }
  ////// displaying all account
  
   @RequestMapping(value = Array("/users/{userId}/bankaccounts"), method = Array(RequestMethod.GET), produces = Array("application/json"))
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody def getBankAccountsById(@PathVariable userId: String): Array[userBankAcc] = {
        val userDetails = Runapp.userCollection.apply(userId)
        
        val bankAccounts = userDetails.getuserBankAccountTable.values.toArray
        bankAccounts
   }

  //Delete bank account of <userId>
   @RequestMapping(value = Array("users/{userId}/bankaccounts/{bankId}"), method = Array(RequestMethod.DELETE), produces = Array("application/json"))
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @ResponseBody def deleteBankAccountById(@PathVariable userId: String, @PathVariable bankId: String): Unit = {
        val userDetails = Runapp.userCollection.apply(userId)
        userDetails.getuserBankAccountTable -= bankId
   }
}

