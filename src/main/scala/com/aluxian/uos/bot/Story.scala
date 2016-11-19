package com.aluxian.uos.bot

import com.aluxian.uos.bot.ai.{BotInterface, BotPast}
import com.aluxian.uos.bot.models.BotAction
import com.twitter.util.Future

trait Story {
  /**
    * @return whether this story can handle the message
    */
  def analyse(past: BotPast, bot: BotInterface): Boolean

  /**
    * Try to resolve the story and obtain next actions (e.g. a response).
    */
  def run(past: BotPast, bot: BotInterface): Future[List[BotAction]]
}
