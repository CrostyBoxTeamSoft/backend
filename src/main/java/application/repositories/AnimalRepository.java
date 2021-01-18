package application.repositories;

import application.beans.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * Permet de realiser des operations sur la table Animal dans la base de donnees
 * @deprecated
 */
public interface AnimalRepository extends CrudRepository<Animal, Integer>
{
}
