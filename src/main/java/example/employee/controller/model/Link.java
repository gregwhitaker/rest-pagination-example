package example.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * HATEOS resource link.
 */
@JsonPropertyOrder({
        "rel",
        "type",
        "href"
})
public class Link {

    private String rel;
    private String type;
    private String href;

    public Link() {}

    public Link(String rel, String href) {
        this(rel, "GET", href);
    }

    public Link(String rel, String type, String href) {
        this.rel = rel;
        this.type = type;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
