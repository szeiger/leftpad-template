package com.novocode.leftpad

object LeftPad {
  def leftPad(s: String, len: Int, ch: Char = ' '): String =
    ch.toString * (len-s.length) + s
}
