package application.dao;

import application.beans.Arduino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArduinoDAO extends JpaRepository<Arduino, Integer>
{

}
