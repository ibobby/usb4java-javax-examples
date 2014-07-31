package org.usb4java.javax.examples;

import org.usb4java.Device;

import javax.usb.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bobby on 31.07.2014.
 */
public class MyAttempt {

    public static void main(String[] args) throws UsbException {
        try {
            List<UsbDevice> devices = getDevices();
            System.out.println(devices);
            System.out.println(devices.size());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static List<UsbDevice> getDevices()
            throws SecurityException, UsbException, UnsupportedEncodingException
    {
        ArrayList<UsbDevice> devices = new ArrayList<UsbDevice>();

        UsbServices services = UsbHostManager.getUsbServices();
        UsbHub root = services.getRootUsbHub();
        devices.addAll( getHubDevices( root ) );

        return devices;
    }

    public static List<UsbDevice> getHubDevices( UsbHub hub )
            throws UnsupportedEncodingException, UsbException
    {
        ArrayList<UsbDevice> devices = new ArrayList<UsbDevice>();

        @SuppressWarnings( "unchecked" )
        List<UsbDevice> children = hub.getAttachedUsbDevices();

        Iterator<UsbDevice> it = children.iterator();

        while( it.hasNext() )
        {
            UsbDevice child = it.next();

            if( child.isUsbHub() )
            {
                devices.addAll( getHubDevices( (UsbHub)child ) );
            }
            else
            {
                devices.add( child );
            }
        }

        return devices;
    }




}
