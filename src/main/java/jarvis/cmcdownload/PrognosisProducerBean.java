package jarvis.cmcdownload;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adge
 */
public class PrognosisProducerBean {
    @EndpointInject(uri="direct:prognosis")
    ProducerTemplate producer;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PrognosisProducerBean.class);

    public PrognosisProducerBean() {
        LOGGER.info("i'm alive!");
    }

    
    
    public void produce(Exchange exchange) {
        for (String prognosisString : new String[] {"000", "006", "012"}) {
            LOGGER.info("Sending {}", prognosisString);
            producer.sendBody(prognosisString);
        }
    }
}
