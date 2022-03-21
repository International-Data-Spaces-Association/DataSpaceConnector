package io.dataspaceconnector.controller.resource.type;

import io.dataspaceconnector.config.BasePath;
import io.dataspaceconnector.controller.resource.base.BaseResourceController;
import io.dataspaceconnector.controller.resource.base.tag.ResourceDescription;
import io.dataspaceconnector.controller.resource.base.tag.ResourceName;
import io.dataspaceconnector.controller.resource.view.daps.DapsView;
import io.dataspaceconnector.model.daps.Daps;
import io.dataspaceconnector.model.daps.DapsDesc;
import io.dataspaceconnector.service.resource.type.DapsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Offers the endpoints for managing daps.
 */
@RestController
@RequestMapping(BasePath.DAPS)
@Tag(name = ResourceName.DAPS, description = ResourceDescription.DAPS)
public class DapsController extends BaseResourceController<Daps, DapsDesc, DapsView,
        DapsService> {
}
