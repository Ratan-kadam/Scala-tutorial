package main.scala

import org.springframework.boot.SpringApplication
import scala.collection.mutable.HashMap

object Runapp {

		var userCollection = new HashMap[String,Users]; // all user info
  
		def main(args: Array[String]) {
         
		println("hello this is main ()")
		SpringApplication.run(classOf[Users])
		
		
	}
}