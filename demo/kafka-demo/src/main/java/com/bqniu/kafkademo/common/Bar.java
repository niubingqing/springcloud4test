package com.bqniu.kafkademo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Bar {

    public String bar;
    public Bar() {
        super();
    }

    public Bar(String bar) {
        this.bar = bar;
    }

    public String getBar() {
        return this.bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
    @Override
    public String toString() {
        return "Bar [bar=" + this.bar + "]";
    }
}
