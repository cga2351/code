package com.viber.voip.sound.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BtControl
{
  private static final String ACTION_HEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
  private static final String ACTION_SCO_AUDIO_STATE_CHANGED = "android.media.SCO_AUDIO_STATE_CHANGED";
  private static final String ACTION_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
  private static final int DEVICE_CONNECTION_NOTIFY_DELAY = 1200;
  public static final String EXTRA_STATE = "android.bluetooth.headset.extra.STATE";
  private static final Logger L = ViberEnv.getLogger();
  private static final int RECONNECTION_DELAY = 400;
  private static final int RECONNECT_ATTEMPTS_LIMIT = 3;
  public static final int STATE_CONNECTED = 2;
  public static final int STATE_CONNECTING = 1;
  public static final int STATE_DISCONNECTED = 0;
  public static final int STATE_ERROR = -1;
  private AudioManager mAudioManager;
  private BtConnectionDetector mConnectionDetector;
  private final BroadcastReceiver mConnectionStateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = -1;
      String str = paramAnonymousIntent.getAction();
      BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (localBluetoothDevice == null)
        return;
      if ("android.bluetooth.headset.action.STATE_CHANGED".equals(str))
        i = paramAnonymousIntent.getIntExtra("android.bluetooth.headset.extra.STATE", i);
      while (true)
      {
        BtControl.this.handleConnectionStateChange(localBluetoothDevice, i);
        return;
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str))
          i = paramAnonymousIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      }
    }
  };
  private Set<IBluetoothDeviceListener> mListeners = new HashSet();
  private Handler mMainThreadDelegate = av.a(av.e.a);
  private int mScoState = -1;
  private final BroadcastReceiver mScoStateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      String str = paramAnonymousIntent.getAction();
      if (("android.media.SCO_AUDIO_STATE_CHANGED".equals(str)) || ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(str)))
      {
        int i = BtControl.this.getScoStateFromIntent(paramAnonymousIntent);
        BtControl.this.handleScoStateChange(i);
      }
    }
  };

  public BtControl(AudioManager paramAudioManager, Context paramContext, IBluetoothDeviceListener paramIBluetoothDeviceListener)
  {
    this.mAudioManager = paramAudioManager;
    this.mConnectionDetector = new BtConnectionDetector(paramContext);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    Intent localIntent = paramContext.registerReceiver(this.mScoStateReceiver, localIntentFilter1);
    if (localIntent != null)
      this.mScoState = getScoStateFromIntent(localIntent);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    paramContext.registerReceiver(this.mConnectionStateReceiver, localIntentFilter2);
    registerStateListener(paramIBluetoothDeviceListener);
  }

  protected static String getDeviceClassString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "OTHER";
    case 1032:
      return "AUDIO_VIDEO_HANDSFREE";
    case 1056:
      return "AUDIO_VIDEO_CAR_AUDIO";
    case 1048:
      return "AUDIO_VIDEO_HEADPHONES";
    case 1064:
      return "AUDIO_VIDEO_HIFI_AUDIO";
    case 1040:
      return "AUDIO_VIDEO_MICROPHONE";
    case 1052:
      return "AUDIO_VIDEO_PORTABLE_AUDIO";
    case 1044:
      return "AUDIO_VIDEO_LOUDSPEAKER";
    case 1028:
    }
    return "AUDIO_VIDEO_WEARABLE_HEADSET";
  }

  private int getScoStateFromIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
  }

  protected static String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "unknown";
    case 1:
      return "connected";
    case 2:
      return "in progress";
    case 0:
      return "disconnected";
    case -1:
    }
    return "error";
  }

  private void handleConnectionStateChange(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return;
    case 2:
      notifyDeviceConnected(paramBluetoothDevice);
      return;
    case 0:
      notifyDeviceDisconnected(paramBluetoothDevice);
      return;
    case -1:
    }
    notifyDeviceConnectionError(paramBluetoothDevice);
  }

  private void notifyDeviceConnected(final BluetoothDevice paramBluetoothDevice)
  {
    this.mMainThreadDelegate.postDelayed(new Runnable()
    {
      public void run()
      {
        synchronized (BtControl.this.mListeners)
        {
          Iterator localIterator = BtControl.this.mListeners.iterator();
          if (localIterator.hasNext())
            ((BtControl.IBluetoothDeviceListener)localIterator.next()).onDeviceConnected(paramBluetoothDevice);
        }
      }
    }
    , 1200L);
  }

  private void notifyDeviceConnectionError(final BluetoothDevice paramBluetoothDevice)
  {
    this.mMainThreadDelegate.post(new Runnable()
    {
      public void run()
      {
        synchronized (BtControl.this.mListeners)
        {
          Iterator localIterator = BtControl.this.mListeners.iterator();
          if (localIterator.hasNext())
            ((BtControl.IBluetoothDeviceListener)localIterator.next()).onError(paramBluetoothDevice);
        }
      }
    });
  }

  private void notifyDeviceDisconnected(final BluetoothDevice paramBluetoothDevice)
  {
    this.mMainThreadDelegate.post(new Runnable()
    {
      public void run()
      {
        synchronized (BtControl.this.mListeners)
        {
          Iterator localIterator = BtControl.this.mListeners.iterator();
          if (localIterator.hasNext())
            ((BtControl.IBluetoothDeviceListener)localIterator.next()).onDeviceDisconnected(paramBluetoothDevice);
        }
      }
    });
  }

  private void registerStateListener(IBluetoothDeviceListener paramIBluetoothDeviceListener)
  {
    synchronized (this.mListeners)
    {
      this.mListeners.add(paramIBluetoothDeviceListener);
      return;
    }
  }

  public void disableBluetoothRoute()
  {
    try
    {
      this.mAudioManager.setBluetoothScoOn(false);
      this.mAudioManager.stopBluetoothSco();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void enableBluetoothRoute()
  {
    try
    {
      boolean bool = isHeadsetConnected();
      if (!bool);
      while (true)
      {
        return;
        this.mAudioManager.startBluetoothSco();
        this.mAudioManager.setBluetoothScoOn(true);
      }
    }
    finally
    {
    }
  }

  protected void handleScoStateChange(int paramInt)
  {
    try
    {
      this.mScoState = paramInt;
      switch (this.mScoState)
      {
      default:
        int i = this.mScoState;
        if (2 == i)
          break;
      case 0:
      case 1:
      }
      return;
    }
    finally
    {
    }
  }

  public boolean isA2dpOn()
  {
    return this.mAudioManager.isBluetoothA2dpOn();
  }

  public boolean isHeadsetConnected()
  {
    if (this.mConnectionDetector == null);
    while ((this.mConnectionDetector.getConnectedHeadsets().size() == 0) || (!this.mAudioManager.isBluetoothScoAvailableOffCall()))
      return false;
    return true;
  }

  public boolean isScoOn()
  {
    return this.mAudioManager.isBluetoothScoOn();
  }

  public static abstract interface IBluetoothDeviceListener
  {
    public abstract void onDeviceConnected(BluetoothDevice paramBluetoothDevice);

    public abstract void onDeviceDisconnected(BluetoothDevice paramBluetoothDevice);

    public abstract void onError(BluetoothDevice paramBluetoothDevice);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.bluetooth.BtControl
 * JD-Core Version:    0.6.2
 */