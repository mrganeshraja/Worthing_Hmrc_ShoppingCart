package com.capgemini.shoppingcart.model

trait Item {

  def cost: Double

  def name: String
}

case class Apple(val cost: Double = .6, val name: String = "Apple") extends Item

case class Orange(val cost: Double = .25, val name: String = "Orange") extends Item

object Item {

  def apply(typ: String): Option[Item] = typ.toLowerCase match {

    case "apple" => Some(new Apple)
    case "orange" => Some(new Orange)
    case _ => throw new IllegalArgumentException("Product not listed!")

  }
}
