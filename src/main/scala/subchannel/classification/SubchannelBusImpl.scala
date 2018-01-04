package subchannel.classification

import akka.actor.ActorRef
import akka.event.{EventBus, SubchannelClassification}
import akka.util.Subclassification

case class MsgEnvelope(topic: String, payload: Any)

class SubchannelBusImpl extends EventBus with SubchannelClassification {

  override type Event = MsgEnvelope
  override type Classifier = String
  override type Subscriber = ActorRef

  override protected implicit def subclassification: Subclassification[Classifier] = new StartsWithSubclassification

  override protected def classify(event: Event): Classifier = event.topic

  override protected def publish(event: Event, subscriber: Subscriber): Unit = subscriber ! event.payload
}
