package actor.classification

import akka.actor.Actor

class PrinterActor(name: String) extends Actor {

  override def receive: Receive = {
    case msg => println(s"$name actor received message $msg")
  }
}
