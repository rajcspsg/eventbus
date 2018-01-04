package lookup.classification

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val lookupBus = new LookupBusImpl
  val system = ActorSystem("test")
  val actor1 = system.actorOf(Props(new PrinterActor(("printer1"))))
  val actor2 = system.actorOf(Props(new PrinterActor(("printer2"))))

  lookupBus.subscribe(actor1, "greetings")
  lookupBus.subscribe(actor2, "greetings")

  lookupBus.publish(MsgEnvelope("greetings", System.currentTimeMillis()))
  lookupBus.publish(MsgEnvelope("time", System.currentTimeMillis()))
  lookupBus.publish(MsgEnvelope("greetings", "hello"))

  system.terminate()

}
