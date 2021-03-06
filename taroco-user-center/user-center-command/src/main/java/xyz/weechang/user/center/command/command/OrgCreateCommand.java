package xyz.weechang.user.center.command.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.hibernate.validator.constraints.NotEmpty;
import xyz.weechang.taroco.core.command.command.AuditAbleAbstractCommand;
import xyz.weechang.taroco.core.query.domain.AuditEntry;
import xyz.weechang.user.center.command.dto.OrgCreateRequest;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * 说明：
 *
 * @author zhangwei
 * @version 2017/11/19 22:37.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrgCreateCommand extends AuditAbleAbstractCommand {

    private static final long serialVersionUID = 8693514247658926855L;

    @TargetAggregateIdentifier
    private String id;

    private String parentId;

    @NotNull
    @NotEmpty
    private String name;

    public OrgCreateCommand(AuditEntry auditEntry, OrgCreateRequest request) {
        super(auditEntry);
        this.id = UUID.randomUUID().toString();
        this.parentId = request.getParentId();
        this.name = request.getName();
    }
}
