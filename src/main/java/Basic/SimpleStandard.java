package Basic;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;

public class SimpleStandard extends NotificationBroadcasterSupport implements SimpleStandardMBean {

    public int getNbChanges() {
        return nbChanges;
    }

    public void reset() {
        AttributeChangeNotification acn
                = new AttributeChangeNotification(this,
                        0,
                        0,
                        "NbChanges reset",
                        "NbChanges",
                        "Integer",
                        new Integer(nbChanges),
                        new Integer(0));
        state = "initial state";
        nbChanges = 0;
        nbResets++;
        sendNotification(acn);
    }

    public int getNbResets() {
        return nbResets;
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[]{
            new MBeanNotificationInfo(
            new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE},
            AttributeChangeNotification.class.getName(),
            "This notification is emitted when the reset() method is called.")
        };
    }

    private String state = "initial state";
    private int nbChanges = 0;
    private int nbResets = 0;

    @Override
    public String getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
