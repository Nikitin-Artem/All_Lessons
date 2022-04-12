package com.company.StreamAPI;

import java.util.Objects;

public class Phone {
    private String name;
    private String company;
    private int price;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Phone(String name, String company, int price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (price != phone.price) return false;
        if (name != null ? !name.equals(phone.name) : phone.name != null) return false;
        return company != null ? company.equals(phone.company) : phone.company == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
