package com.aluxian.susucatbot.models

import java.util.Date

import org.joda.time.DateTime

case class PastMessage(messageType: MessageType,
                       senderType: CorrespondentType,
                       receiverType: CorrespondentType,
                       text: Option[String],
                       entities: List[Entity],
                       timestamp: Date) {
  val sentByBot: Boolean = senderType equals CorrespondentType.Bot
  val sentByUser: Boolean = senderType equals CorrespondentType.User
  val intent: Option[Intent] = Intent.find(entities)
  def hasEntity(name: String): Boolean = entities.exists(_.name equals name)
  def hasIntent(intentName: String): Boolean = intent.isDefined && intent.get.equals(Intent(intentName))
  def getEntity(name: String): Entity = entities.find(_.name equals name).get
}
