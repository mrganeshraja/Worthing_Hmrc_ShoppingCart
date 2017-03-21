package com.capgemini.shoppingcart.service

import com.capgemini.shoppingcart.model.{AppleTwoForOneOffer, Offer, OrangeThreeForTwoOffer}

trait OfferCalculator extends Calculator {

  val offers :List[Offer] = List(AppleTwoForOneOffer(), OrangeThreeForTwoOffer() )

  abstract override def on(items: String*): Double =
    BigDecimal(super.on(items:_*)) - BigDecimal(offers.foldLeft(0.0){ (r, x)=>  r +  applyOffer(items, x) }) toDouble

  def applyOffer(items:Seq[String], offer:Offer) :Double = {
    items.count(_.equalsIgnoreCase(offer.item.name))/ offer.offerType._2 * offer.item.cost
  }

}
