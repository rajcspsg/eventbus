package scanning.classification

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val scanningBus = new ScanningBusImpl
  val system = ActorSystem("test")
  val actor1 = system.actorOf(Props(new PrinterActor(("printer1"))))
  val actor2 = system.actorOf(Props(new PrinterActor(("printer2"))))

  scanningBus.subscribe(actor2, 3)
  scanningBus.subscribe(actor1, 3)

  scanningBus.publish("xyzabc")
  scanningBus.publish("ab")
  scanningBus.publish("abc")

  system.terminate()

}
