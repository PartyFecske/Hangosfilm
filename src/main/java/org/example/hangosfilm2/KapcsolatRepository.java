package org.example.hangosfilm2;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
public interface KapcsolatRepository extends CrudRepository<Kapcsolat, Integer>
{
    Optional<Kapcsolat> findByName(String name);
}
