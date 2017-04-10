package com.novocode.leftpad.plugin

import sbt._
import Keys._
import com.novocode.leftpad.LeftPad

object LeftpadPlugin extends AutoPlugin {
  lazy val cmd = Command.args("leftPad", "<arg>") {
    case (state, Seq(s, len, ch)) =>
      println(LeftPad.leftPad(s, len.toInt, ch.head))
      state
    case (state, Seq(s, len)) =>
      println(LeftPad.leftPad(s, len.toInt))
      state
    case (state, _) => state.fail
  }

  override lazy val globalSettings = Seq(commands += cmd)

  // Enable this plugin by default
  override def requires = sbt.plugins.JvmPlugin
  override def trigger = allRequirements
}
