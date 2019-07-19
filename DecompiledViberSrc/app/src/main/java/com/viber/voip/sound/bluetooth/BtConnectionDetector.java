package com.viber.voip.sound.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.List;

public class BtConnectionDetector
{
  private static final Logger L = ViberEnv.getLogger();
  BluetoothHeadset headset = null;
  BluetoothProfile.ServiceListener headsetProfileListener = new BluetoothProfile.ServiceListener()
  {
    public void onServiceConnected(int paramAnonymousInt, BluetoothProfile paramAnonymousBluetoothProfile)
    {
      if (1 == paramAnonymousInt)
        BtConnectionDetector.this.headset = ((BluetoothHeadset)paramAnonymousBluetoothProfile);
    }

    public void onServiceDisconnected(int paramAnonymousInt)
    {
      if (1 == paramAnonymousInt)
        BtConnectionDetector.this.headset = null;
    }
  };

  public BtConnectionDetector(Context paramContext)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
      return;
    try
    {
      localBluetoothAdapter.getProfileProxy(paramContext, this.headsetProfileListener, 1);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public boolean anyHeadsetConnected()
  {
    if (this.headset == null);
    while (this.headset.getConnectedDevices().size() <= 0)
      return false;
    return true;
  }

  public void close()
  {
    if (this.headset != null)
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if ((localBluetoothAdapter != null) && (this.headset != null))
        localBluetoothAdapter.closeProfileProxy(1, this.headset);
    }
  }

  public List<BluetoothDevice> getConnectedHeadsets()
  {
    if (this.headset == null)
      return new ArrayList(1);
    return this.headset.getConnectedDevices();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.bluetooth.BtConnectionDetector
 * JD-Core Version:    0.6.2
 */