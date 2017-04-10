package com.novocode.leftpad

object LeftPad {
  def leftPad(s: String, len: Int, ch: Char = ' '): String =
    if(s.length >= len) s else ch.toString * (len-s.length) + s
}
