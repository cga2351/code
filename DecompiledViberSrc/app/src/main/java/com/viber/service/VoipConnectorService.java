package com.viber.service;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.h.a;
import org.greenrobot.eventbus.EventBus;

public class VoipConnectorService extends ViberService
{
  private static final Logger a = ViberEnv.getLogger();
  private EventBus b;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.b = a.b();
  }

  public void onDestroy()
  {
    stopForeground(true);
    super.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    StartMode localStartMode;
    if (paramIntent != null)
    {
      localStartMode = (StartMode)paramIntent.getParcelableExtra("service_start_mode");
      if (localStartMode != StartMode.FOREGROUND)
        break label62;
      startForeground(paramIntent.getIntExtra("notification_id", 0), (Notification)paramIntent.getParcelableExtra("notification"));
      this.b.post(new a(StartMode.FOREGROUND));
    }
    while (true)
    {
      return 2;
      label62: if (localStartMode == StartMode.BACKGROUND)
      {
        stopForeground(true);
        this.b.post(new a(StartMode.BACKGROUND));
      }
      else if (localStartMode == StartMode.START)
      {
        this.b.post(new a(StartMode.START));
      }
    }
  }

  public static enum StartMode
    implements Parcelable
  {
    public static final Parcelable.Creator<StartMode> CREATOR = new Parcelable.Creator()
    {
      public VoipConnectorService.StartMode a(Parcel paramAnonymousParcel)
      {
        return VoipConnectorService.StartMode.values()[paramAnonymousParcel.readInt()];
      }

      public VoipConnectorService.StartMode[] a(int paramAnonymousInt)
      {
        return new VoipConnectorService.StartMode[paramAnonymousInt];
      }
    };

    static
    {
      BACKGROUND = new StartMode("BACKGROUND", 1);
      FOREGROUND = new StartMode("FOREGROUND", 2);
      StartMode[] arrayOfStartMode = new StartMode[3];
      arrayOfStartMode[0] = START;
      arrayOfStartMode[1] = BACKGROUND;
      arrayOfStartMode[2] = FOREGROUND;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(ordinal());
    }
  }

  public static class a
  {
    public final VoipConnectorService.StartMode a;

    public a(VoipConnectorService.StartMode paramStartMode)
    {
      this.a = paramStartMode;
    }

    public String toString()
    {
      return "ServiceStartModeChanged{startMode=" + this.a + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.VoipConnectorService
 * JD-Core Version:    0.6.2
 */