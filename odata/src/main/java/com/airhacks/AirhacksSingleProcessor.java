
package com.airhacks;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;

/**
 *
 * @author airhacks.com
 */
public class AirhacksSingleProcessor extends ODataSingleProcessor {

    @Override
    public ODataResponse readEntitySet(GetEntitySetUriInfo uriInfo, String contentType) throws ODataException {
        trace(uriInfo);
        EdmEntitySet startEntitySet = uriInfo.getTargetEntitySet();
        return EntityProvider.writeFeed(contentType, startEntitySet, this.loadData(), this.createWriteProperties());
    }

    @Override
    public ODataResponse readEntity(final GetEntityUriInfo uriInfo, final String contentType) throws ODataException {
        trace(uriInfo);
        return EntityProvider.writeEntry(contentType, uriInfo.getTargetEntitySet(),
                this.createEntity(), this.createWriteProperties());
    }

    EntityProviderWriteProperties createWriteProperties() throws ODataException {
        URI uri = getContext().getPathInfo().getServiceRoot();
        return EntityProviderWriteProperties.serviceRoot(uri).build();
    }

    List<Map<String, Object>> loadData() {
        return Stream.generate(this::createEntity).limit(10).collect(Collectors.toList());
    }

    void trace(GetEntitySetUriInfo uriInfo) {
        System.out.println("uriInfo = " + uriInfo);
    }
    void trace(GetEntityUriInfo uriInfo) {
        System.out.println("uriInfo = " + uriInfo);
    }

    Map<String, Object> createEntity() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "name -> " + System.currentTimeMillis());
        data.put("age", System.nanoTime());
        data.put("skills", "java");
        data.put("id", "::" + System.currentTimeMillis());
        return data;
    }
}
