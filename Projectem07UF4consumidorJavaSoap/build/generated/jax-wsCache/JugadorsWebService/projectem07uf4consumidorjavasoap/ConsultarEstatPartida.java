
package projectem07uf4consumidorjavasoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarEstatPartida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarEstatPartida">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarEstatPartida", propOrder = {
    "codi"
})
public class ConsultarEstatPartida {

    protected int codi;

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

}
