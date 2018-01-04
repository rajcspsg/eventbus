package event.stream

object Messages {

  abstract class AllKindsOfMusic { def artist: String }
  case class Jazz(artist: String) extends AllKindsOfMusic
  case class Electronic(artist: String) extends AllKindsOfMusic

}
