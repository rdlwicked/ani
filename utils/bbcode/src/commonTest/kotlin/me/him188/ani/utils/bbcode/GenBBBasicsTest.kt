// @formatter:off
@file:Suppress("RedundantVisibilityModifier")

// Generated by me.him188.ani.utils.bbcode.BBCodeTestGenerator
package me.him188.ani.utils.bbcode

import kotlin.test.Test

public class GenBBBasicsTest : BBCodeParserTestHelper() {
    @Test
    public fun parse137138206() {
        BBCode.parse("[b]Hello World![/b]")
        .run {
            assertText(elements.at(0), value="Hello World!", bold=true)
        }
    }

    @Test
    public fun parse398420167() {
        BBCode.parse("[url]https://example.com[/url]")
        .run {
            assertText(elements.at(0), value="https://example.com", jumpUrl="https://example.com")
        }
    }

    @Test
    public fun parse181699913() {
        BBCode.parse("[url=https://example.com]Hello World![/url]")
        .run {
            assertText(elements.at(0), value="Hello World!", jumpUrl="https://example.com")
        }
    }

    @Test
    public fun parse307708920() {
        BBCode.parse("[url=http://example.com]Hello World![/url]")
        .run {
            assertText(elements.at(0), value="Hello World!", jumpUrl="http://example.com")
        }
    }

    @Test
    public fun parse2136488827() {
        BBCode.parse("[url=invalidurl]Hello World![/url]")
        .run {
            assertText(elements.at(0), value="Hello World!", jumpUrl="invalidurl")
        }
    }

    @Test
    public fun parse1690130686() {
        BBCode.parse("[size=1]Hello World![/size]")
        .run {
            assertText(elements.at(0), value="Hello World!", size=1)
        }
    }

    @Test
    public fun parse323759858() {
        BBCode.parse("(=v=) Hello World! (-w=)")
        .run {
            assertKanmoji(elements.at(0), id="(=v=)")
            assertText(elements.at(1), value=" Hello World! ")
            assertKanmoji(elements.at(2), id="(-w=)")
        }
    }

    @Test
    public fun parse682053775() {
        BBCode.parse("(bgm123) Hello World! (bgm2)")
        .run {
            assertBangumiSticker(elements.at(0), id=123)
            assertText(elements.at(1), value=" Hello World! ")
            assertBangumiSticker(elements.at(2), id=2)
        }
    }

    @Test
    public fun parse250499401() {
        BBCode.parse("(bgm 2)")
        .run {
            assertText(elements.at(0), value="(bgm")
            assertText(elements.at(1), value=" 2)")
        }
    }

    @Test
    public fun parse1238845362() {
        BBCode.parse("(bgm 2")
        .run {
            assertText(elements.at(0), value="(bgm")
            assertText(elements.at(1), value=" 2")
        }
    }

    @Test
    public fun parse1967962848() {
        BBCode.parse("Hello (bgm 2")
        .run {
            assertText(elements.at(0), value="Hello ")
            assertText(elements.at(1), value="(bgm")
            assertText(elements.at(2), value=" 2")
        }
    }

    @Test
    public fun parse394436571() {
        BBCode.parse("Hello(=v=)")
        .run {
            assertText(elements.at(0), value="Hello")
            assertKanmoji(elements.at(1), id="(=v=)")
        }
    }
}


// @formatter:on
