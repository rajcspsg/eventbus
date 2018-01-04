package subchannel.classification

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val subChannelBus = new SubchannelBusImpl
  val system = ActorSystem("test")
  val actor1 = system.actorOf(Props(new PrinterActor(("printer1"))))
  val actor2 = system.actorOf(Props(new PrinterActor(("printer2"))))

  subChannelBus.subscribe(actor1, "abc")
  subChannelBus.subscribe(actor2, "abc")

  subChannelBus.publish(MsgEnvelope("xyzabc", "x"))
  subChannelBus.publish(MsgEnvelope("bcdef", "b"))
  subChannelBus.publish(MsgEnvelope("abc", "c"))
  // subChannelBus.publish(MsgEnvelope("abc", "d"))
  subChannelBus.publish(MsgEnvelope("abcdef", "d"))

  system.terminate()

}
