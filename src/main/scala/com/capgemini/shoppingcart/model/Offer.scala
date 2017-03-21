package com.capgemini.shoppingcart.model

trait Offer {

  def item:Item

  type strategy= (Int, Int)

  def offerType:strategy

}

case class AppleTwoForOneOffer() extends Offer {

  def offerType:strategy= (1,2)

  override def item: Apple = Apple()
}

case class OrangeThreeForTwoOffer() extends Offer {

  override def offerType:strategy = (2, 3)

  override def item: Orange = Orange()
}





