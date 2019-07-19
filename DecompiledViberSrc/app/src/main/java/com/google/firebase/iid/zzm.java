package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;

public class zzm
  implements Parcelable
{
  public static final Parcelable.Creator<zzm> CREATOR = new an();
  private Messenger zzao;
  private av zzap;

  public zzm(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzao = new Messenger(paramIBinder);
      return;
    }
    this.zzap = new ax(paramIBinder);
  }

  private final IBinder getBinder()
  {
    if (this.zzao != null)
      return this.zzao.getBinder();
    return this.zzap.asBinder();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    try
    {
      boolean bool = getBinder().equals(((zzm)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    return false;
  }

  public int hashCode()
  {
    return getBinder().hashCode();
  }

  public final void send(Message paramMessage)
    throws RemoteException
  {
    if (this.zzao != null)
    {
      this.zzao.send(paramMessage);
      return;
    }
    this.zzap.a(paramMessage);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.zzao != null)
    {
      paramParcel.writeStrongBinder(this.zzao.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzap.asBinder());
  }

  public static final class a extends ClassLoader
  {
    protected final Class<?> loadClass(String paramString, boolean paramBoolean)
      throws ClassNotFoundException
    {
      if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
      {
        if (FirebaseInstanceId.zzm())
          Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
        return zzm.class;
      }
      return super.loadClass(paramString, paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.zzm
 * JD-Core Version:    0.6.2
 */