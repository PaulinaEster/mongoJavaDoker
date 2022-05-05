package com.paulina.mongoJava.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Livro {
    @Id
    public String id;

    public String name;
    public String author;

    public String isbn;

    public Livro() {
    }

    public Livro(String name, String author, String isbn) {
        this(null, name, author, isbn);
    }

    public Livro(String id, String name, String author, String isbn) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro that = (Livro) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
