package main.scala


import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._
import javax.validation.constraints.{NotNull, Size}
import scala.collection.mutable.HashMap


//@RestController
//@EnableAutoConfiguration
//@ComponentScan
@ComponentScan
class userIdCards {
  //private var userName: String = _
  private var cardName : String =_ ;
  private var cardNum : String=_;
  private var CardID : String=_; 
  private var ExpDT :String=_
  
  // getter setter methods 
  
  def getCardNum = this.cardNum
  def setCardNum (newCardNumber : String) = this.cardNum = newCardNumber ;
  //***************************
  def getcardName = this.cardName
  def setcardName (newCardName : String) = this.cardName = newCardName ;
  //*************************
  def getCardID = this.CardID
  def setCardID (newCardID : String) = this.CardID = newCardID ;
  //**********************************
  def getExpDT = this.ExpDT
  def setExpDT (newExpDT : String) = this.ExpDT = newExpDT ;
  //**********************************
  
  
}