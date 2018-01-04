package subchannel.classification

import akka.util.Subclassification

class StartsWithSubclassification extends Subclassification[String] {
  override def isEqual(x: String, y: String): Boolean = x == y

  override def isSubclass(x: String, y: String): Boolean = x.startsWith(y)
}
