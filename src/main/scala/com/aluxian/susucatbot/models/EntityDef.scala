package com.aluxian.susucatbot.models

object EntityDef {
  sealed abstract class Type(name: String, example: String)

  // entity definitions
  final case class WitLocation(name: String, example: String) extends Type(name, example)

  object Intent {
    sealed abstract class DefType(name: String) extends EntityDef.Type(name, "")

    // intent definitions
    case object GetWeather extends DefType("get_weather")
    case object GetMum extends DefType("get_mum")
    case object GetYouCanDoIt extends DefType("get_youcandoit")
    case object GetCheat extends DefType("get_cheat")
    case object GetPompey extends DefType("get_pompey")
    case object GetSolent extends DefType("get_solent")
    case object GetLove extends DefType("get_love")
    case object GetTurtles extends DefType("get_turtles")
    case object GetCutest extends DefType("get_cutest")
    case object GetCutestCat extends DefType("get_cutest_cat")

    case object Greeting extends DefType("greeting")
    case object HowAreYou extends DefType("how_are_you")
    case object ThankYou extends DefType("thank_you")
    case object Insult extends DefType("insult")
    case object Meow extends DefType("meow")
    case object FavThing extends DefType("fav_thing")

    case object GetEat extends DefType("get_eat")
    case object GetBathroom extends DefType("get_bathroom")
    case object GetBeer extends DefType("get_beer")

    case object GetMail extends DefType("get_mail")
    case object GetCoursework extends DefType("get_coursework")
    case object GetMap extends DefType("get_map")
  }
}

sealed case class Entity(name: String, value: String)
sealed case class Intent(value: String) {
  def toEntity = Entity("intent", value)
}

object Intent {
  def find(entities: List[Entity]): Option[Intent] = {
    entities.find(_.name equals "intent").map(e => Intent(e.value))
  }

  // intent definitions
//  case object GetWeather extends Intent("get_weather")
}
