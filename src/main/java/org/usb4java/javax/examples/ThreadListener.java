package org.usb4java.javax.examples;

import org.usb4java.LibUsb;

import javax.usb.UsbDevice;
import javax.usb.event.UsbDeviceDataEvent;
import javax.usb.event.UsbDeviceErrorEvent;
import javax.usb.event.UsbDeviceEvent;
import javax.usb.event.UsbDeviceListener;

/**
 * Created by WhiteMountiens on 31.07.2014.
 */
public class ThreadListener implements Runnable {

    UsbDevice device;

    public ThreadListener(UsbDevice device) {
        this.device = device;
    }


    @Override
    public void run() {
        device.addUsbDeviceListener(new UsbDeviceListener() {
            @Override
            public void usbDeviceDetached(UsbDeviceEvent usbDeviceEvent) {
                System.out.println("some happened: Detached");
            }

            @Override
            public void errorEventOccurred(UsbDeviceErrorEvent usbDeviceErrorEvent) {
                System.out.println("some happened: errorEventOccurred");
            }

            @Override
            public void dataEventOccurred(UsbDeviceDataEvent usbDeviceDataEvent) {
                System.out.println("some happened: dataEventOccurred");
            }

        });
        while (true) {

        }
    }
}
