package TestChapter5;

import Chapter5.RegExp.NFA;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegexp {
    @Test
    public void testNFA(){
        NFA nfa=new NFA("..oo..oo.");
        Assert.assertEquals(nfa.recognizes("bloodroot"),true);
        Assert.assertEquals(nfa.recognizes("nincompoophood"),false);
    }

    @Test
    public void testExample(){
        //error
        NFA nfa=new NFA("(((A|B)*|CD*|EFG)*)*");
        Assert.assertEquals(nfa.recognizes("AAACDEFGEFG"),true);
    }
}
