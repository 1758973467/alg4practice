package TestChapter5;

import Chapter5.RegExp.NFA;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegexp {
    @Test
    public void testNFA(){
        NFA nfa=new NFA("..oo..oo");
        Assert.assertEquals(nfa.recognizes("bloodroot"),true);
        Assert.assertEquals(nfa.recognizes("nincompoophood"),false);

        nfa=new NFA("[^aeiou]{6}");
        Assert.assertEquals(nfa.recognizes("rhythm"),true);
        Assert.assertEquals(nfa.recognizes("rhythms"),false);
    }
}
