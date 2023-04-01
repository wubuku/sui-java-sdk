package com.github.wubuku.sui.bean;

import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Debug, JsonSchema, Serialize, Deserialize)]
 * #[serde(rename_all = "camelCase")]
 * pub struct Page<T, C> {
 *     pub data: Vec<T>,
 *     pub next_cursor: Option<C>,
 *     pub has_next_page: bool,
 * }
 * </pre>
 *
 * @param <T>
 * @param <C>
 */
public class Page<T, C> {
    private List<T> data;
    private C nextCursor;

    private Boolean hasNextPage;

    public Page() {
    }

    public Page(List<T> data, C nextCursor) {
        this.data = data;
        this.nextCursor = nextCursor;
    }

    public static boolean hasNextPage(Page page) {
        return page != null && (
                page.getHasNextPage() != null && page.getHasNextPage() && page.nextCursor != null
        );
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public C getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(C nextCursor) {
        this.nextCursor = nextCursor;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", nextCursor=" + nextCursor +
                ", hasNextPage=" + hasNextPage +
                '}';
    }
}
