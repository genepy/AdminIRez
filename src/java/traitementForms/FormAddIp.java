package traitementForms;

import beans.BeanAdresseIp;
import javax.servlet.http.HttpServletRequest;

public final class FormAddIp {

    private static final String CHAMP_IP = "ip";
    private static final String CHAMP_DESCRIPTION = "description";

    public BeanAdresseIp ajouterIp(HttpServletRequest request) {
        String adresseIp = request.getParameter(CHAMP_IP);
        String description = request.getParameter(CHAMP_DESCRIPTION);

        BeanAdresseIp adresseip = new BeanAdresseIp();

        adresseip.setAdresseIp(adresseIp);
        adresseip.setDescription(description);
        return adresseip;
    }
}
