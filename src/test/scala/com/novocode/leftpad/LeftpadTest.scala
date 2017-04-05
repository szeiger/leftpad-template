package com.novocode.leftpad

import org.junit.Test
import org.junit.Assert._

class LeftpadTest {
  @Test def test1: Unit = {
    assertEquals("foo", LeftPad.leftPad("foo", 2))
    assertEquals("foo", LeftPad.leftPad("foo", 3))
    assertEquals(" foo", LeftPad.leftPad("foo", 4))
    assertEquals("  foo", LeftPad.leftPad("foo", 5))
    assertEquals("__foo", LeftPad.leftPad("foo", 5, '_'))
  }
}
