package com.example.picpay.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.picpay.Client.NotificationClient;
import com.example.picpay.Models.Transfer;

@Service
public class Notification {

    private static final Logger logger = LoggerFactory.getLogger(Notification.class);
    private final NotificationClient ntc;

    public Notification(NotificationClient ntc) {
        this.ntc = ntc;
    }

    public void sendnotification(Transfer trans)
    {
        try {
            logger.info("Sending notification ...");
            var resp = ntc.sendNotification(trans);
            if(resp.getStatusCode().isError())
            {
                logger.error("Error while sending notification");
            }
        } catch (Exception e) {
            logger.error("Error while sending notification ",e);
        }
    }    
}
