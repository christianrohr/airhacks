package com.airhacks;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;

public class AirhacksServiceFactory extends ODataServiceFactory {

    @Override
    public ODataService createService(final ODataContext ctx) throws ODataException {
        EdmProvider edmProvider = new AirhacksMetadataProvider();
        ODataSingleProcessor singleProcessor = new AirhacksSingleProcessor();
        System.out.println("AirhacksServiceFactory.createService");
        return createODataSingleProcessorService(edmProvider, singleProcessor);
    }
}
