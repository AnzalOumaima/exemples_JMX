package com.example.mbeans;

import java.lang.management.*;
import javax.management.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Obtenir le serveur MBean
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construire l'ObjectName pour le MBean que nous voulons l'enregistrer
        ObjectName name = new ObjectName("com.example.mbeans:type=Hello");

        // création de MBean
        Hello mbean = new Hello();

        // enregistrement de MBean
        mbs.registerMBean(mbean, name);

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
