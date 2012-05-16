package com.stankurdziel.stackoverflow.question10611034;

import junit.framework.TestCase;

import java.util.Arrays;

public class WsdlParseTest extends TestCase {
    public void testListOperations() throws Exception {
        String[] expected = { "GetLastTradePrice", "GetLastTradePrice" };
        assertEquals(expected, new WsdlParser().listOperations("sample1.wsdl"));
    }

    public void testListOperationsUnique() throws Exception {
        String[] expected = { "GetLastTradePrice" };
        assertEquals(expected, new WsdlParser().listOperationsUnique("sample1.wsdl"));
    }

    public static <E> void assertEquals(E[] a1, E[] a2) {
        assertEquals(Arrays.toString(a1), Arrays.toString(a2));
    }
}
