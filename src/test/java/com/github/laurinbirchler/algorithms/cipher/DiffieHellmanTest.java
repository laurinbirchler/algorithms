package com.github.laurinbirchler.algorithms.cipher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;


public class DiffieHellmanTest {
    private static final BigInteger PRIME = new BigInteger("23");
    private static final BigInteger BASE = new BigInteger("5");

    /*
    @Test
    @Disabled
    public void testPublicKey() {
        DiffieHellman alice = new DiffieHellman(PRIME, BASE);
        BigInteger actual = alice.getPublicKey();
        BigInteger expected = BASE.modPow(new BigInteger("6"), PRIME);  // assume secret value is 6
        assertEquals(expected, actual);
    }
    */

    @Test
    public void testSharedSecret() {
        DiffieHellman alice = new DiffieHellman(PRIME, BASE);
        DiffieHellman bob = new DiffieHellman(PRIME, BASE);

        BigInteger alicePublicKey = alice.getPublicKey();
        BigInteger bobPublicKey = bob.getPublicKey();

        BigInteger aliceSharedSecret = alice.computeSharedSecret(bobPublicKey);
        BigInteger bobSharedSecret = bob.computeSharedSecret(alicePublicKey);

        assertEquals(aliceSharedSecret, bobSharedSecret);
    }

    @Test
    public void testGeneratePrime() {
        int bitLength = 256;
        BigInteger prime = DiffieHellman.generatePrime(bitLength);
        assertTrue(prime.isProbablePrime(10));
        assertEquals(bitLength, prime.bitLength());
    }
}