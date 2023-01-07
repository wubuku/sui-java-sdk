package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Copy, PartialEq, PartialOrd, Eq, Ord, Debug, Hash)]
 * #[must_use = "this `Result` may be an `Err` variant, which should be handled"]
 * #[rustc_diagnostic_item = "Result"]
 * #[stable(feature = "rust1", since = "1.0.0")]
 * pub enum Result<T, E> {
 *     /// Contains the success value
 *     #[lang = "Ok"]
 *     #[stable(feature = "rust1", since = "1.0.0")]
 *     Ok(#[stable(feature = "rust1", since = "1.0.0")] T),
 *
 *     /// Contains the error value
 *     #[lang = "Err"]
 *     #[stable(feature = "rust1", since = "1.0.0")]
 *     Err(#[stable(feature = "rust1", since = "1.0.0")] E),
 * }
 * </pre>
 */
public class Result<T, E> {
    @JsonProperty("Ok")
    private T ok;
    @JsonProperty("Err")
    private E err;

    public Result() {
    }

    public Result(T ok, E err) {
        this.ok = ok;
        this.err = err;
    }

    public T getOk() {
        return ok;
    }

    public void setOk(T ok) {
        this.ok = ok;
    }

    public E getErr() {
        return err;
    }

    public void setErr(E err) {
        this.err = err;
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok=" + ok +
                ", err=" + err +
                '}';
    }
}
