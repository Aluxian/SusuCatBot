package com.aluxian.uos.bot.ai

import com.aluxian.uos.bot.models.Entity

case class QuickReply(text: String, payload: String)

sealed abstract class BotResponse(entities: List[Entity] = List(),
                                  quickReplies: List[QuickReply] = List())

final case class TextBotResponse(text: String,
                                 entities: List[Entity] = List(),
                                 quickReplies: List[QuickReply] = List()
                                ) extends BotResponse(entities, quickReplies)

final case class ImageBotResponse(url: String,
                                  entities: List[Entity] = List(),
                                  quickReplies: List[QuickReply] = List()
                                 ) extends BotResponse(entities, quickReplies)

class BotInterface(val memory: BotMemory) {
}
