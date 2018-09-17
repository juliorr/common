package com.ns.task.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Product {
  private static final int SCALE_ROUNDING = 3;

  private Integer id;
  private String name;
  private String description;
  private BigDecimal price;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return this.price.setScale(SCALE_ROUNDING, RoundingMode.HALF_UP);
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Product)) {
      return false;
    }
    Product that = (Product)object;
    Object[] fields = this.getSignificantFields();
    Object[] thatFields = that.getSignificantFields();

    for (int i = 0; i < fields.length; ++i) {
      if (!Objects.equals(fields[i], thatFields[i])) {
        return false;
      }
    }
    return true;
  }

  @Override public int hashCode() {
    return Objects.hash(this.getSignificantFields());
  }

  @Override public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

  /**
   * Return all the fields of the POJO.
   * @return Object[] with all the fields of the POJO
   */
  private Object[] getSignificantFields() {
    Object[] result = {
        this.id, this.name, this.description, this.price,
    };
    return result;
  }
}
