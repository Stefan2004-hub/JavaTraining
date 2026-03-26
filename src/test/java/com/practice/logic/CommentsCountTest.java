package com.practice.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CommentsCountTest {

  @Test
  void countDerogatoryComments_ShouldCountCaseInsensitiveContains() {
    String[] comments = {"bad_word_here", "this_is_Fine", "BAD_news", "no_bad_vibes"};
    assertEquals(3, CommentsCount.countDerogatoryComments("bad", comments));
  }

  @Test
  void countDerogatoryComments2_ShouldMatchWholeUnderscoreTokens() {
    String[] comments = {"very_bad_news", "badday_today", "all_good", "BAD_topic"};
    assertEquals(2, CommentsCount.countDerogatoryComments2(4,"bad", comments));
  }

  @Test
  void countDerogatoryComments2_ShouldReturnZero_ForNullHandling() {
    assertEquals(0, CommentsCount.countDerogatoryComments2(0, "bad", null));
  }
}
