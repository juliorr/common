package com.ns.task.common;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
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
    return this.price;
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
    for (int i = 0; i < this.getSigFields().length; ++i) {
      if (!Objects.equals(this.getSigFields()[i], that.getSigFields()[i])) {
        return false;
      }
    }
    return true;
  }

  @Override public int hashCode() {
    return Objects.hash(this.getSigFields());
  }

  @Override public String toString() {
    return "id: " + this.id + "\nname: " + this.name + "\ndescription: "
        + this.description + "\nprice: " + this.price;
  }

  /**
   * Return all the fields of the POJO.
   * @return Object[] with all the fields of the POJO
   */
  private Object[] getSigFields() {
    Object[] result = {
        this.id, this.name, this.description, this.price,
    };
    return result;
  }
}
