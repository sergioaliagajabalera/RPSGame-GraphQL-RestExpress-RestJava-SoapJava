
package projectem07uf4consumidorjavasoap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "JugadorsWebService", targetNamespace = "http://daw2.fje.edu/", wsdlLocation = "http://localhost:8084/Projectem07UF4Soap/JugadorsWebService?wsdl")
public class JugadorsWebService_Service
    extends Service
{

    private final static URL JUGADORSWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException JUGADORSWEBSERVICE_EXCEPTION;
    private final static QName JUGADORSWEBSERVICE_QNAME = new QName("http://daw2.fje.edu/", "JugadorsWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8084/Projectem07UF4Soap/JugadorsWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        JUGADORSWEBSERVICE_WSDL_LOCATION = url;
        JUGADORSWEBSERVICE_EXCEPTION = e;
    }

    public JugadorsWebService_Service() {
        super(__getWsdlLocation(), JUGADORSWEBSERVICE_QNAME);
    }

    public JugadorsWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), JUGADORSWEBSERVICE_QNAME, features);
    }

    public JugadorsWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, JUGADORSWEBSERVICE_QNAME);
    }

    public JugadorsWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, JUGADORSWEBSERVICE_QNAME, features);
    }

    public JugadorsWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public JugadorsWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns JugadorsWebService
     */
    @WebEndpoint(name = "JugadorsWebServicePort")
    public JugadorsWebService getJugadorsWebServicePort() {
        return super.getPort(new QName("http://daw2.fje.edu/", "JugadorsWebServicePort"), JugadorsWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns JugadorsWebService
     */
    @WebEndpoint(name = "JugadorsWebServicePort")
    public JugadorsWebService getJugadorsWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://daw2.fje.edu/", "JugadorsWebServicePort"), JugadorsWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (JUGADORSWEBSERVICE_EXCEPTION!= null) {
            throw JUGADORSWEBSERVICE_EXCEPTION;
        }
        return JUGADORSWEBSERVICE_WSDL_LOCATION;
    }

}
