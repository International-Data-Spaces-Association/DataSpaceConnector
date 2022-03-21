/*
 * Copyright 2022 Sovity Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dataspaceconnector.model.daps;

import io.dataspaceconnector.model.base.RemoteService;
import io.dataspaceconnector.model.named.NamedEntity;
import io.dataspaceconnector.model.util.UriConverter;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.net.URI;

import static io.dataspaceconnector.model.config.DatabaseConstants.URI_COLUMN_LENGTH;

/**
 * The entity where connectors can be verified
 */
@javax.persistence.Entity
@Table(name = "daps")
@SQLDelete(sql = "UPDATE broker SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
@Getter
@Setter(AccessLevel.PACKAGE)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Daps extends NamedEntity implements RemoteService {

    /**
     * Serial version uid.
     **/
    private static final long serialVersionUID = 1L;

    /**
     * The access url of the DAPS.
     */
    @Convert(converter = UriConverter.class)
    @Column(length = URI_COLUMN_LENGTH)
    private URI location;

}
