package com.capgemini.shoppingcart

import com.capgemini.shoppingcart.service.CheckoutService
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class CheckoutServiceTest extends FlatSpec with Matchers with BeforeAndAfter {

   var checkoutService: CheckoutService =_

   before  {
      checkoutService = new CheckoutService()
   }

   "Checkout service" should "result total of 1 apple to 0.60" in {
      checkoutService on "Apple" should be(0.60)
   }

   it should "result total of 1 orange and apple to 0.85" in {
      checkoutService on ("Apple", "Orange") should be(0.85)
   }

   it should "result total 2 apples to 1.2" in {
      checkoutService on ("Apple", "Apple") should be(1.2)
   }

   it should "alert when item or product does not exist " in {
      val thrown = the [IllegalArgumentException] thrownBy(checkoutService on ("mango"))
      thrown.getMessage equals "Product not listed!"
   }

   it should "result total 2 apples and oranges to 2.3" in {
      checkoutService on ("apple", "orange", "apple", "apple", "orange") should be(2.3)
   }


}
