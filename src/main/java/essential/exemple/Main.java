package essential.exemple;

import java.lang.management.*;
import javax.management.*;

public class Main {

    // "throws Exception"  pour une gestion des exceptions plus fine. 
    public static void main(String[] args) throws Exception {
        // Obtenir le serveur MBean
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construire l'ObjectName pour le MBean que nous voulons l'enregistrer
        ObjectName name = new ObjectName("essential.exemple:type=Hello");

        // Créer le MBean
        Hello mbean = new Hello();

        // Enregistrer le MBean
        mbs.registerMBean(mbean, name);

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
