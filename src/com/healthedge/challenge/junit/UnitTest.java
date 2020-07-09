package com.healthedge.challenge.junit;

import com.healthedge.challenge.BalancedString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.LinkedList;

public class UnitTest {

    @Test
    public void testIsBalanced(){
        Assert.assertEquals(1, BalancedString.isBalanced("[]", new LinkedList<>(), 0));
        Assert.assertEquals(1, BalancedString.isBalanced("$$", new LinkedList<>(), 0));
        Assert.assertEquals(1, BalancedString.isBalanced("[$]]", new LinkedList<>(), 0));
        Assert.assertEquals(1, BalancedString.isBalanced("[[]$", new LinkedList<>(), 0));
        Assert.assertEquals(1, BalancedString.isBalanced("[$]", new LinkedList<>(), 0));
        Assert.assertEquals(0, BalancedString.isBalanced("]$[", new LinkedList<>(), 0));


    }

}
