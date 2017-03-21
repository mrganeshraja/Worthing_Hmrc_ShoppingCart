package com.capgemini.shoppingcart.service

import com.capgemini.shoppingcart.model.Item

trait Calculator {

   def on(items:String*):Double
}

class CheckoutService extends Calculator {

   override def on(items: String*): Double =  {

      items.map(Item(_).get.cost).foldLeft[BigDecimal](0.0)(_ + _).toDouble
   }
}


