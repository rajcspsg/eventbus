package actor.classification

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("test")
  val observer1  = system.actorOf(Props(new PrinterActor(("observer1"))))
  val observer2 = system.actorOf(Props(new PrinterActor(("observer2"))))

  val subscriber1  = system.actorOf(Props(new PrinterActor(("subscriber1"))))
  val subscriber2 = system.actorOf(Props(new PrinterActor(("subscriber2"))))

  val actorBus = new ActorBusImpl(system)

  actorBus.subscribe(subscriber1, observer1)
  actorBus.subscribe(subscriber2, observer1)
  actorBus.subscribe(subscriber2, observer2)
  actorBus.publish(Notification(observer1, 100))
  actorBus.publish(Notification(observer2, 101))

  system.terminate()

}
