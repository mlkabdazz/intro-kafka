package id.co.djinggoo.introkafka.model.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseMaster {
    @Id private UUID id;
    @Column(name = "created_by") private String createdBy;
    @Column(name = "created_at") private String createdAt;
    @Column(name = "updated_by") private String updatedBy;
    @Column(name = "updated_at") private String updatedAt;
}
