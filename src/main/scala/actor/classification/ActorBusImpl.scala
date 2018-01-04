package actor.classification

import akka.actor.{ActorRef, ActorSystem}
import akka.event.{ActorClassifier, ActorEventBus}
import akka.event.ManagedActorClassification


final case class Notification(ref: ActorRef, id: Int)


class ActorBusImpl(val system: ActorSystem) extends ActorEventBus with ActorClassifier with ManagedActorClassification {

  type Event = Notification

  // is used for extracting the classifier from the incoming events
  override protected def classify(event: Event): ActorRef = event.ref

  // determines the initial size of the index data structure
  // used internally (i.e. the expected number of different classifiers)
  override protected def mapSize: Int = 128
}
