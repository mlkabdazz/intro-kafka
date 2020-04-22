package id.co.djinggoo.introkafka.model.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseTemp {

    @Id private UUID id;
    @Column (name="created_by") String createdBy;
    @Column (name="created_at") Date createdAt;

}
