package event.stream

import akka.actor.Actor
import event.stream.Messages.{Electronic, Jazz}

class Listener extends Actor {

  def receive = {
    case m: Jazz       ⇒ println(s"${self.path.name} is listening to: ${m.artist}")
    case m: Electronic ⇒ println(s"${self.path.name} is listening to: ${m.artist}")
  }

}


