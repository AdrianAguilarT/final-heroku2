
package org.unitec.finalheroku;

import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioMensajito extends MongoRepository<Mensajito, String>{
    
}
