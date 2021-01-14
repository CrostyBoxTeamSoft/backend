package application.repositories;

import application.beans.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * Permet de realiser des operations sur la table Animal dans la base de donnees
 */
public interface AnimalRepository extends CrudRepository<Animal, Integer>
{
}
