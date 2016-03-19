package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.service.UniversiteMetier;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "universiteDocument")
@ApplicationScoped
public class UniversiteDocument {

    @Autowired
    private UniversiteMetier universiteMetier;
    private List<Universite> uv;
    
    private final ApplicationContext bf;
    
    public UniversiteDocument() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier= (UniversiteMetier) bf.getBean("universiteMetier");
    }
    
    @PostConstruct
    public void init(){
        uv= universiteMetier.findAll();
    }
    
    /* ---- Creation d'un deuxième getter getDocument pour récupérer l'image insérée ---- */
    public StreamedContent getDocument() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String univId = context.getExternalContext().getRequestParameterMap().get("univId");
            Universite univ = universiteMetier.findById(Integer.valueOf(univId));
            return new DefaultStreamedContent(new ByteArrayInputStream(univ.getDocument()));
        }
    }
    
}
