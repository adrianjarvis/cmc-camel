package jarvis.cmcdownload;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class CmcRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("direct:start")
                .to("bean:prognosisproducer[method=prognosisPeriods]")
                .to("log:jarvis.cmcdownload.route?level=INFO");
//        .to("ahc:http://http://dd.weatheroffice.gc.ca/model_gem_global/low_resolution/grib2/lat_lon/00/000/CMC_glb_ABSV_ISBL_250_latlon2x2_2012101300_P000.grib2")
//                .to("file:target/foo.grib2");
    }

}
