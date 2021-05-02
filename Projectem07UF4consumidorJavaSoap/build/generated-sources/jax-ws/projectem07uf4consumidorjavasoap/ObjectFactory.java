
package projectem07uf4consumidorjavasoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the projectem07uf4consumidorjavasoap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IniciarJocResponse_QNAME = new QName("http://daw2.fje.edu/", "iniciarJocResponse");
    private final static QName _PedrapapertisoresResponse_QNAME = new QName("http://daw2.fje.edu/", "pedrapapertisoresResponse");
    private final static QName _AcabarJocResponse_QNAME = new QName("http://daw2.fje.edu/", "acabarJocResponse");
    private final static QName _MoureJugador_QNAME = new QName("http://daw2.fje.edu/", "moureJugador");
    private final static QName _IniciarJoc_QNAME = new QName("http://daw2.fje.edu/", "iniciarJoc");
    private final static QName _ConsultarEstatPartida_QNAME = new QName("http://daw2.fje.edu/", "consultarEstatPartida");
    private final static QName _ConsultarEstatPartidaResponse_QNAME = new QName("http://daw2.fje.edu/", "consultarEstatPartidaResponse");
    private final static QName _MoureJugadorResponse_QNAME = new QName("http://daw2.fje.edu/", "moureJugadorResponse");
    private final static QName _Pedrapapertisores_QNAME = new QName("http://daw2.fje.edu/", "pedrapapertisores");
    private final static QName _AcabarJoc_QNAME = new QName("http://daw2.fje.edu/", "acabarJoc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: projectem07uf4consumidorjavasoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IniciarJocResponse }
     * 
     */
    public IniciarJocResponse createIniciarJocResponse() {
        return new IniciarJocResponse();
    }

    /**
     * Create an instance of {@link PedrapapertisoresResponse }
     * 
     */
    public PedrapapertisoresResponse createPedrapapertisoresResponse() {
        return new PedrapapertisoresResponse();
    }

    /**
     * Create an instance of {@link AcabarJocResponse }
     * 
     */
    public AcabarJocResponse createAcabarJocResponse() {
        return new AcabarJocResponse();
    }

    /**
     * Create an instance of {@link MoureJugador }
     * 
     */
    public MoureJugador createMoureJugador() {
        return new MoureJugador();
    }

    /**
     * Create an instance of {@link IniciarJoc }
     * 
     */
    public IniciarJoc createIniciarJoc() {
        return new IniciarJoc();
    }

    /**
     * Create an instance of {@link ConsultarEstatPartida }
     * 
     */
    public ConsultarEstatPartida createConsultarEstatPartida() {
        return new ConsultarEstatPartida();
    }

    /**
     * Create an instance of {@link ConsultarEstatPartidaResponse }
     * 
     */
    public ConsultarEstatPartidaResponse createConsultarEstatPartidaResponse() {
        return new ConsultarEstatPartidaResponse();
    }

    /**
     * Create an instance of {@link MoureJugadorResponse }
     * 
     */
    public MoureJugadorResponse createMoureJugadorResponse() {
        return new MoureJugadorResponse();
    }

    /**
     * Create an instance of {@link Pedrapapertisores }
     * 
     */
    public Pedrapapertisores createPedrapapertisores() {
        return new Pedrapapertisores();
    }

    /**
     * Create an instance of {@link AcabarJoc }
     * 
     */
    public AcabarJoc createAcabarJoc() {
        return new AcabarJoc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "iniciarJocResponse")
    public JAXBElement<IniciarJocResponse> createIniciarJocResponse(IniciarJocResponse value) {
        return new JAXBElement<IniciarJocResponse>(_IniciarJocResponse_QNAME, IniciarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PedrapapertisoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "pedrapapertisoresResponse")
    public JAXBElement<PedrapapertisoresResponse> createPedrapapertisoresResponse(PedrapapertisoresResponse value) {
        return new JAXBElement<PedrapapertisoresResponse>(_PedrapapertisoresResponse_QNAME, PedrapapertisoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "acabarJocResponse")
    public JAXBElement<AcabarJocResponse> createAcabarJocResponse(AcabarJocResponse value) {
        return new JAXBElement<AcabarJocResponse>(_AcabarJocResponse_QNAME, AcabarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "moureJugador")
    public JAXBElement<MoureJugador> createMoureJugador(MoureJugador value) {
        return new JAXBElement<MoureJugador>(_MoureJugador_QNAME, MoureJugador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "iniciarJoc")
    public JAXBElement<IniciarJoc> createIniciarJoc(IniciarJoc value) {
        return new JAXBElement<IniciarJoc>(_IniciarJoc_QNAME, IniciarJoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEstatPartida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "consultarEstatPartida")
    public JAXBElement<ConsultarEstatPartida> createConsultarEstatPartida(ConsultarEstatPartida value) {
        return new JAXBElement<ConsultarEstatPartida>(_ConsultarEstatPartida_QNAME, ConsultarEstatPartida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEstatPartidaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "consultarEstatPartidaResponse")
    public JAXBElement<ConsultarEstatPartidaResponse> createConsultarEstatPartidaResponse(ConsultarEstatPartidaResponse value) {
        return new JAXBElement<ConsultarEstatPartidaResponse>(_ConsultarEstatPartidaResponse_QNAME, ConsultarEstatPartidaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "moureJugadorResponse")
    public JAXBElement<MoureJugadorResponse> createMoureJugadorResponse(MoureJugadorResponse value) {
        return new JAXBElement<MoureJugadorResponse>(_MoureJugadorResponse_QNAME, MoureJugadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedrapapertisores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "pedrapapertisores")
    public JAXBElement<Pedrapapertisores> createPedrapapertisores(Pedrapapertisores value) {
        return new JAXBElement<Pedrapapertisores>(_Pedrapapertisores_QNAME, Pedrapapertisores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2.fje.edu/", name = "acabarJoc")
    public JAXBElement<AcabarJoc> createAcabarJoc(AcabarJoc value) {
        return new JAXBElement<AcabarJoc>(_AcabarJoc_QNAME, AcabarJoc.class, null, value);
    }

}
