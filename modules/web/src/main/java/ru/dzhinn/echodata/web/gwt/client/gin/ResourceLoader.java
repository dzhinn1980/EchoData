package ru.dzhinn.echodata.web.gwt.client.gin;

import com.google.inject.Inject;
import ru.dzhinn.echodata.web.gwt.client.resources.AppResources;

/**
 * Created by A.Dzhioev on 09.02.2017.
 */
public class ResourceLoader {
    @Inject
    ResourceLoader(AppResources resources) {


        //... Inject more css into the document here on boot
    }
}
