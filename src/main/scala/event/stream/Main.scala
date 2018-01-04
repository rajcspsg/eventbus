package event.stream

import akka.actor.{ActorSystem, Props}
import event.stream.Messages.{AllKindsOfMusic, Electronic, Jazz}

object Main extends App {

  val system = ActorSystem("test")
  val jazzListener = system.actorOf(Props[Listener], "JazzListener")
  val musicListener = system.actorOf(Props[Listener], "musicListener")
  system.eventStream.subscribe(jazzListener, classOf[Jazz])
  system.eventStream.subscribe(musicListener, classOf[AllKindsOfMusic])

  // only musicListener gets this message, since it listens to *all* kinds of music:
  system.eventStream.publish(Electronic("Parov Stelar"))

  // jazzListener and musicListener will be notified about Jazz:
  system.eventStream.publish(Jazz("Sonny Rollins"))

  system.terminate()

}
