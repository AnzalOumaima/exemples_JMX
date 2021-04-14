package com.example.mbeans;

import javax.management.*;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int DEFAULT_CACHE_SIZE = 200;
    private long sequenceNumber = 1;

    public void sayHello() {
        System.out.println("hello, world");
    }

    public int add(int x, int y) {
        return x + y;
    }

    /* Obtenir l'attribut Name. ici, la valeur d'attribut jamais
    change, mais pour d'autres attributs, cela peut changer à mesure que le
    l'application s'exécute. Considérons un attribut représentant
    des statistiques telles que l'utilisation de la mémoire, par exemple. un tel attribut
    ne peut pas être modifié via l'interface de gestion.  */
    public String getName() {
        return this.name;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    // Setter pour changer la valeur de l'attribut CacheSize. 
    public synchronized void setCacheSize(int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;

        System.out.println("Cache size now " + this.cacheSize);

        /* Créez une notification décrivant le changement de cet attribut.
        le "source" d'une notification est le nom d'objet du MBean qui l'a émis.
        un MBean peut mettre une référence à lui-même ("this") dans la source, et le serveur MBean
        remplacez-le par ObjectName avant d'envoyer la notification à ses clients.

        Pour faire bonne mesure, nous maintenons un numéro de séquence pour chaque
        notification émise par ce MBean.  */
        Notification n = new AttributeChangeNotification(this,
                sequenceNumber++,
                System.currentTimeMillis(),
                "CacheSize changed",
                "CacheSize",
                "int",
                oldSize,
                this.cacheSize);

        /* Envoyez la notification.
        la méthode sendNotification hérité de la classe parente NotificationBroadcasterSupport.  */
        sendNotification(n);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE};
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }

}
