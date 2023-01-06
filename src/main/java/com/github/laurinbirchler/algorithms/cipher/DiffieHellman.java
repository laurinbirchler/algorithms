package com.github.laurinbirchler.algorithms.cipher;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final SecureRandom RANDOM = new SecureRandom();

    private BigInteger prime;
    private BigInteger base;
    private final BigInteger secret;
    private final BigInteger publicKey;

    /**
     * Constructs a new DiffieHellman instance with the given prime and base.
     *
     * @param prime the prime number to use
     * @param base  the base to use
     */
    public DiffieHellman(BigInteger prime, BigInteger base) {
        this.prime = prime;
        this.base = base;
        this.secret = new BigInteger(prime.bitLength(), RANDOM);
        this.publicKey = base.modPow(secret, prime);
    }

    /**
     * Returns the public key of this DiffieHellman instance.
     *
     * @return the public key
     */
    public BigInteger getPublicKey() {
        return publicKey;
    }

    /**
     * Computes the shared secret using the given public key.
     *
     * @param publicKey the public key of the other party
     * @return the shared secret
     */
    public BigInteger computeSharedSecret(BigInteger publicKey) {
        return publicKey.modPow(secret, prime);
    }

    /**
     * Generates a random prime number of the given bit length.
     *
     * @param bitLength the bit length of the prime to generate
     * @return a random prime of the given bit length
     */
    public static BigInteger generatePrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, RANDOM);
    }

}
