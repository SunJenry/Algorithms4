package org.sun.chapter1.section2.exe;

public class Exercise16 {
    public static void main(String[] args) {

    }

    public static class RationalNumbers {

        private final static String ASSERT_AVOIDING_OVERFLOW_MESSAGE = "Operation would cause overflow";
        private long numerator;
        private long denominator;

        public RationalNumbers(int numerator, int denominator) {
            if (denominator == 0) {
                throw new RuntimeException("Denominator cannot be 0");
            }

            this.numerator = numerator;
            this.denominator = denominator;

            int gcd = gcd(numerator, denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;

            if (this.denominator < 0) {
                this.denominator = -1 * this.denominator;
                this.numerator = -1 * this.numerator;
            }
        }

        private int gcd(int numerator, int denominator) {
            if (denominator == 0) {
                return numerator;
            } else {
                return gcd(denominator, numerator % denominator);
            }
        }

        public int numerator() {
            return (int) numerator;
        }

        public int denominator() {
            return (int) denominator;
        }

        public RationalNumbers plus(RationalNumbers b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            long newNumeratorA = this.numerator() * b.denominator();
            long newNumeratorB = b.numerator() * this.denominator();

            assert newNumeratorA + newNumeratorB <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert newNumeratorA + newNumeratorB >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            int resultNumerator = (int) (newNumeratorA + newNumeratorB);

            assert this.denominator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.denominator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            int resultDenominator = this.denominator() * b.denominator();
            return new RationalNumbers(resultNumerator, resultDenominator);
        }

        public RationalNumbers minus(RationalNumbers b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert b.numerator * this.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            long newNumeratorA = this.numerator() * b.denominator();
            long newNumeratorB = b.numerator() * this.denominator();

            assert newNumeratorA - newNumeratorB >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            int resultNumerator = (int) (newNumeratorA - newNumeratorB);

            assert this.denominator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            int resultDenominator = this.denominator() * b.denominator();

            return new RationalNumbers(resultNumerator, resultDenominator);
        }

        public RationalNumbers times(RationalNumbers b) {
            assert this.numerator * b.numerator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.denominator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.numerator * b.numerator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;
            assert this.denominator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW_MESSAGE;

            int resultNumerator = this.numerator() * b.numerator();
            int resultDenominator = this.denominator() * b.denominator();
            return new RationalNumbers(resultNumerator, resultDenominator);
        }

        public RationalNumbers dividedBy(RationalNumbers b) {
            RationalNumbers bReciprocal = new RationalNumbers(b.denominator(), b.numerator());
            return times(bReciprocal);
        }

        public boolean equals(Object x) {
            if (this == x) {
                return true;
            }
            if (x == null) {
                return false;
            }
            if (this.getClass() != x.getClass()) {
                return false;
            }

            RationalNumbers that = (RationalNumbers) x;
            if (this.numerator() != that.numerator()) {
                return false;
            }
            if (this.denominator() != that.denominator()) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.numerator() + "/" + this.denominator();
        }
    }
}
