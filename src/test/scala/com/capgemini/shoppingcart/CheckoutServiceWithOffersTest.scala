package com.capgemini.shoppingcart

import com.capgemini.shoppingcart.service.{OfferCalculator, CheckoutService}
import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

class CheckoutServiceWithOffersTest extends FlatSpec with Matchers with BeforeAndAfter {

  var checkoutService: CheckoutService =_

  before  {
    checkoutService =new CheckoutService() with OfferCalculator
  }

  "Checkout service with Offers" should "result total cost 1 apple and 1 orange to 0.85" in {
    checkoutService on ("Apple", "Orange") should be(0.85)
  }

  it should "result total cost to 1 apple to .60" in {
    checkoutService on ("Apple", "Apple") should be(.60)
  }

  it should "result to total 3 apples to 1.2" in {
    checkoutService on ("Apple", "Apple", "Apple") should be(1.2)
  }

  it should "result total of 1 orange to 0.25" in {

    checkoutService on "Orange" should be(.25)
  }

  it should "result total of 3 oranges to .50" in {

    checkoutService on ("Orange", "Orange", "Orange") should be(.50)
  }

  it should "result total of 4 oranges to .75" in {

    checkoutService on ("Orange", "Orange", "Orange", "Orange") should be(.75)
  }
}
