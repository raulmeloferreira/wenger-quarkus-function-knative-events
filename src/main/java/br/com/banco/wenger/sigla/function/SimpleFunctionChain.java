package br.com.banco.wenger.sigla.function;

import org.jboss.logging.Logger;

import br.com.banco.wenger.sigla.function.dto.RequestDTO;
import br.com.banco.wenger.sigla.function.dto.ResponseDTO;
import io.quarkus.funqy.Context;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;

public class SimpleFunctionChain {
    private static final Logger log = Logger.getLogger(SimpleFunctionChain.class);

    /**
     * This is triggered by defaultChain and is example of using application.properties to
     * map the cloud event to this function and to map response.  Response will trigger
     * the annotatedChain function.
     *
     * application.properties will have:
     *
     * quarkus.funqy.knative-events.mapping.configChain.trigger= trigger name 
     * quarkus.funqy.knative-events.mapping.configChain.response-type= response  type
     * quarkus.funqy.knative-events.mapping.configChain.response-source= response source
     *
     *
     *
     * @param input
     * @return
     */
    @Funq
    public ResponseDTO pojoFunc(RequestDTO req, @Context CloudEvent event) {
        log.info("*** execute ***" + event.id());
        log.info("*** req ***" + req.getData());
        
        ResponseDTO resp = new ResponseDTO();
        resp.setData("req" + req.getData());
        resp.setId(event.id());
        
        return resp;
    }
    
    @Funq
    public String stringFunc(String req, @Context CloudEvent event) {
        log.info("*** execute ***" + event.id());
        log.info("*** req ***" + req);
        
        return "resp+" + req;
    }
    
    @Funq
    public ResponseDTO pojoFuncSemCloudEvent(RequestDTO req, @Context CloudEvent event) {
        log.info("*** execute ***" + event.id());
        log.info("*** req ***" + req.getData());
        
        ResponseDTO resp = new ResponseDTO();
        resp.setData("req" + req.getData());
        resp.setId(event.id());
        
        return resp;
    }
}
