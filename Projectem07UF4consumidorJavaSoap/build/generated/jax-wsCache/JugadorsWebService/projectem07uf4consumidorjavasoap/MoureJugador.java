
package projectem07uf4consumidorjavasoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para moureJugador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="moureJugador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="njugador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipusmoviment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moureJugador", propOrder = {
    "codi",
    "njugador",
    "tipusmoviment"
})
public class MoureJugador {

    protected int codi;
    protected int njugador;
    protected String tipusmoviment;

    /**
     * Obtiene el valor de la propiedad codi.
     * 
     */
    public int getCodi() {
        return codi;
    }

    /**
     * Define el valor de la propiedad codi.
     * 
     */
    public void setCodi(int value) {
        this.codi = value;
    }

    /**
     * Obtiene el valor de la propiedad njugador.
     * 
     */
    public int getNjugador() {
        return njugador;
    }

    /**
     * Define el valor de la propiedad njugador.
     * 
     */
    public void setNjugador(int value) {
        this.njugador = value;
    }

    /**
     * Obtiene el valor de la propiedad tipusmoviment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipusmoviment() {
        return tipusmoviment;
    }

    /**
     * Define el valor de la propiedad tipusmoviment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipusmoviment(String value) {
        this.tipusmoviment = value;
    }

}
