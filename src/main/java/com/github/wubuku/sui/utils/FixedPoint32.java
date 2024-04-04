package com.github.wubuku.sui.utils;

import java.math.BigInteger;
import java.util.Objects;

public class FixedPoint32 {
    public static final BigInteger MAX_U64 = new BigInteger("18446744073709551615");

    public static final BigInteger SCALING_FACTOR = BigInteger.ONE.shiftLeft(32);

    public static final FixedPoint32 ONE = createFromRawValue(SCALING_FACTOR);

    public static final FixedPoint32 ZERO = createFromRawValue(BigInteger.ZERO);

    /*
    /// Define a fixed-point numeric type with 32 fractional bits.
    /// This is just a u64 integer but it is wrapped in a struct to
    /// make a unique type. This is a binary representation, so decimal
    /// values may not be exactly representable, but it provides more
    /// than 9 decimal digits of precision both before and after the
    /// decimal point (18 digits total). For comparison, double precision
    /// floating-point has less than 16 decimal digits of precision, so
    /// be careful about using floating-point to convert these values to
    /// decimal.
    struct FixedPoint32 has copy, drop, store { value: u64 }
     */
    private BigInteger value;

    private FixedPoint32(BigInteger value) {
        if (value.compareTo(MAX_U64) > 0) {
            throw new IllegalArgumentException("Value out of range");
        } else if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.value = value;
    }

    /*
    /// Create a fixed-point value from a rational number specified by its
    /// numerator and denominator. Calling this function should be preferred
    /// for using `Self::create_from_raw_value` which is also available.
    /// This will abort if the denominator is zero. It will also
    /// abort if the numerator is nonzero and the ratio is not in the range
    /// 2^-32 .. 2^32-1. When specifying decimal fractions, be careful about
    /// rounding errors: if you round to display N digits after the decimal
    /// point, you can use a denominator of 10^N to avoid numbers where the
    /// very small imprecision in the binary representation could change the
    /// rounding, e.g., 0.0125 will round down to 0.012 instead of up to 0.013.
    public fun create_from_rational(numerator: u64, denominator: u64): FixedPoint32 {
        // If the denominator is zero, this will abort.
        // Scale the numerator to have 64 fractional bits and the denominator
        // to have 32 fractional bits, so that the quotient will have 32
        // fractional bits.
        let scaled_numerator = (numerator as u128) << 64;
        let scaled_denominator = (denominator as u128) << 32;
        assert!(scaled_denominator != 0, EDENOMINATOR);
        let quotient = scaled_numerator / scaled_denominator;
        assert!(quotient != 0 || numerator == 0, ERATIO_OUT_OF_RANGE);
        // Return the quotient as a fixed-point number. We first need to check whether the cast
        // can succeed.
        assert!(quotient <= MAX_U64, ERATIO_OUT_OF_RANGE);
        FixedPoint32 { value: (quotient as u64) }
    }
     */
    public static FixedPoint32 createFromRational(BigInteger numerator, BigInteger denominator) {
        BigInteger scaledNumerator = numerator.shiftLeft(64);
        BigInteger scaledDenominator = denominator.shiftLeft(32);
        if (scaledDenominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator is zero");
        }
        BigInteger quotient = scaledNumerator.divide(scaledDenominator);
        if (quotient.equals(BigInteger.ZERO) && !numerator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Ratio out of range");
        }
        if (quotient.compareTo(MAX_U64) > 0) {
            throw new IllegalArgumentException("Ratio out of range");
        }
        return new FixedPoint32(quotient);
    }

    /*
    /// Create a fixedpoint value from a raw value.
    public fun create_from_raw_value(value: u64): FixedPoint32 {
        FixedPoint32 { value }
    }
     */
    public static FixedPoint32 createFromRawValue(BigInteger value) {
        return new FixedPoint32(value);
    }

    public static FixedPoint32 valueOf(BigInteger value) {
        return createFromRawValue(value.multiply(SCALING_FACTOR));
    }

    /*
    public fun one_minus(value: FixedPoint32): FixedPoint32 {
        fixed_point32::create_from_raw_value(
            SCALING_FACTOR - fixed_point32::get_raw_value(value)
        )
    }
     */
    public static FixedPoint32 oneMinus(FixedPoint32 value) {
        return FixedPoint32.createFromRawValue(SCALING_FACTOR.subtract(value.getRawValue()));
    }

    /*
    /// Multiply a u64 integer by a fixed-point number, truncating any
    /// fractional part of the product. This will abort if the product
    /// overflows.
    public fun multiply_u64(val: u64, multiplier: FixedPoint32): u64 {
        // The product of two 64 bit values has 128 bits, so perform the
        // multiplication with u128 types and keep the full 128 bit product
        // to avoid losing accuracy.
        let unscaled_product = (val as u128) * (multiplier.value as u128);
        // The unscaled product has 32 fractional bits (from the multiplier)
        // so rescale it by shifting away the low bits.
        let product = unscaled_product >> 32;
        // Check whether the value is too large.
        assert!(product <= MAX_U64, EMULTIPLICATION);
        (product as u64)
    }
     */
    public static BigInteger multiplyU64(BigInteger val, FixedPoint32 multiplier) {
        BigInteger unscaledProduct = val.multiply(multiplier.getRawValue());
        BigInteger product = unscaledProduct.shiftRight(32);
        if (product.compareTo(MAX_U64) > 0) {
            throw new IllegalArgumentException("Multiplication");
        }
        return product;
    }

    /*

    /// Divide a u64 integer by a fixed-point number, truncating any
    /// fractional part of the quotient. This will abort if the divisor
    /// is zero or if the quotient overflows.
    public fun divide_u64(val: u64, divisor: FixedPoint32): u64 {
        // Check for division by zero.
        assert!(divisor.value != 0, EDIVISION_BY_ZERO);
        // First convert to 128 bits and then shift left to
        // add 32 fractional zero bits to the dividend.
        let scaled_value = (val as u128) << 32;
        let quotient = scaled_value / (divisor.value as u128);
        // Check whether the value is too large.
        assert!(quotient <= MAX_U64, EDIVISION);
        // the value may be too large, which will cause the cast to fail
        // with an arithmetic error.
        (quotient as u64)
    }
     */
    public static BigInteger divideU64(BigInteger val, FixedPoint32 divisor) {
        if (divisor.getRawValue().equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Division by zero");
        }
        BigInteger scaledValue = val.shiftLeft(32);
        BigInteger quotient = scaledValue.divide(divisor.getRawValue());
        if (quotient.compareTo(MAX_U64) > 0) {
            throw new IllegalArgumentException("Division");
        }
        return quotient;
    }

    public BigInteger multiply(BigInteger val) {
        return multiplyU64(val, this);
    }

    /*
    /// Accessor for the raw u64 value. Other less common operations, such as
    /// adding or subtracting FixedPoint32 values, can be done using the raw
    /// values directly.
    public fun get_raw_value(num: FixedPoint32): u64 {
        num.value
    }
     */
    public BigInteger getRawValue() {
        return value;
    }

    /*
    /// Returns true if the ratio is zero.
    public fun is_zero(num: FixedPoint32): bool {
        num.value == 0
    }
     */
    public boolean isZero() {
        return value.equals(BigInteger.ZERO);
    }

    /*
    /// Return the value of a base raised to a power
    public fun pow(base: FixedPoint32, exponent: u64): FixedPoint32 {
        let res = SCALING_FACTOR; // 1
        while (exponent >= 1) {
            if (exponent % 2 == 0) {
                //base = base * base;
                base = fixed_point32::create_from_rational(
                    fixed_point32::multiply_u64(fixed_point32::get_raw_value(base), base),
                    SCALING_FACTOR
                );
                exponent = exponent / 2;
            } else {
                //res = res * base;
                res = fixed_point32::multiply_u64(res, base);
                exponent = exponent - 1;
            }
        };
        fixed_point32::create_from_raw_value(res)
    }
     */
    public FixedPoint32 pow(BigInteger exponent) {
        FixedPoint32 base = this;
        BigInteger res = SCALING_FACTOR;
        while (exponent.compareTo(BigInteger.ONE) >= 0) {
            if (exponent.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                base = FixedPoint32.createFromRational(base.multiply(base.getRawValue()), SCALING_FACTOR);
                exponent = exponent.divide(BigInteger.valueOf(2));
            } else {
                res = base.multiply(res);
                exponent = exponent.subtract(BigInteger.ONE);
            }
        }
        return FixedPoint32.createFromRawValue(res);
    }

    /*
    public fun divide(value: FixedPoint32, divisor: FixedPoint32): FixedPoint32 {
        let d = (fixed_point32::get_raw_value(value) as u128)
            * (SCALING_FACTOR as u128)
            / (fixed_point32::get_raw_value(divisor) as u128);
        fixed_point32::create_from_raw_value((d as u64))
    }
     */
    public FixedPoint32 divide(FixedPoint32 divisor) {
        FixedPoint32 value = this;
        BigInteger d = value.getRawValue().multiply(SCALING_FACTOR).divide(divisor.getRawValue());
        return FixedPoint32.createFromRawValue(d);
    }

    /*
    public fun multiply(multiplier: FixedPoint32): FixedPoint32 {
        let m = (fixed_point32::get_raw_value(value) as u128)
            * (fixed_point32::get_raw_value(multiplier) as u128)
            / (SCALING_FACTOR as u128);
        fixed_point32::create_from_raw_value((m as u64))
    }
     */
    public FixedPoint32 multiply(FixedPoint32 multiplier) {
        FixedPoint32 value = this;
        BigInteger m = value.getRawValue().multiply(multiplier.getRawValue()).divide(SCALING_FACTOR);
        return FixedPoint32.createFromRawValue(m);
    }

    /*
    /// multiplicative inverse
    public fun reciprocal(value: FixedPoint32): FixedPoint32 {
        fixed_point32::create_from_rational(
            SCALING_FACTOR, fixed_point32::get_raw_value(value)
        )
    }
     */
    public FixedPoint32 reciprocal() {
        FixedPoint32 value = this;
        return FixedPoint32.createFromRational(SCALING_FACTOR, value.getRawValue());
    }

    /*
    public fun plus_one(value: FixedPoint32): FixedPoint32 {
        fixed_point32::create_from_raw_value(
            fixed_point32::get_raw_value(value) + SCALING_FACTOR
        )
    }
     */
    public FixedPoint32 plusOne() {
        FixedPoint32 value = this;
        return FixedPoint32.createFromRawValue(value.getRawValue().add(SCALING_FACTOR));
    }

    /*
        public fun minus_one(value: FixedPoint32): FixedPoint32 {
        fixed_point32::create_from_raw_value(
            fixed_point32::get_raw_value(value) - SCALING_FACTOR
        )
    }
     */
    public FixedPoint32 minusOne() {
        FixedPoint32 value = this;
        return FixedPoint32.createFromRawValue(value.getRawValue().subtract(SCALING_FACTOR));
    }

    /*
    public fun greater_or_equal_than_one(value: FixedPoint32): bool {
        fixed_point32::get_raw_value(value) >= SCALING_FACTOR
    }
     */
    public boolean greaterOrEqualThanOne() {
        return value.compareTo(SCALING_FACTOR) >= 0;
    }

    /*
    public fun greater_than_one(value: FixedPoint32): bool {
        fixed_point32::get_raw_value(value) > SCALING_FACTOR
    }
     */
    public boolean greaterThanOne() {
        return value.compareTo(SCALING_FACTOR) > 0;
    }

    /*
    public fun less_than_one(value: FixedPoint32): bool {
        fixed_point32::get_raw_value(value) < SCALING_FACTOR
    }
     */
    public boolean lessThanOne() {
        return value.compareTo(SCALING_FACTOR) < 0;
    }

    public BigInteger toBigInteger() {
        return value.divide(SCALING_FACTOR);
    }

    /*
    /// Return integer part and fractional of a fixed point number
    public fun integer_and_fractional(value: FixedPoint32): (u64, u64) {
        let raw_value = fixed_point32::get_raw_value(value);
        (raw_value / SCALING_FACTOR, raw_value % SCALING_FACTOR)
    }
     */
    public BigInteger[] integerAndFractional() {
        BigInteger rawValue = value;
        return new BigInteger[]{rawValue.divide(SCALING_FACTOR), rawValue.mod(SCALING_FACTOR)};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedPoint32 that = (FixedPoint32) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        BigInteger[] parts = integerAndFractional();
        BigInteger integerPart = parts[0];
        BigInteger fractionalPart = parts[1];
        return new java.math.BigDecimal(integerPart)
                .add(new java.math.BigDecimal(fractionalPart)
                        .divide(new java.math.BigDecimal(SCALING_FACTOR), 32, java.math.RoundingMode.DOWN)
                )
                .toString();
    }
}
