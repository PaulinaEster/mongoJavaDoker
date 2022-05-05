package com.paulina.mongoJava.Repository;

import com.paulina.mongoJava.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LivroRepository extends MongoRepository<Livro, String> {
}
