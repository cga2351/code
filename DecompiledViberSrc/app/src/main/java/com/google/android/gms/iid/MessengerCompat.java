package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzq();
  private Messenger zzad;
  private zzl zzcd;

  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzad = new Messenger(paramIBinder);
      return;
    }
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      this.zzcd = ((zzl)localObject);
      return;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
      if ((localIInterface instanceof zzl))
        localObject = (zzl)localIInterface;
      else
        localObject = new zzm(paramIBinder);
    }
  }

  private final IBinder getBinder()
  {
    if (this.zzad != null)
      return this.zzad.getBinder();
    return this.zzcd.asBinder();
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
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
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
    if (this.zzad != null)
    {
      this.zzad.send(paramMessage);
      return;
    }
    this.zzcd.send(paramMessage);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.zzad != null)
    {
      paramParcel.writeStrongBinder(this.zzad.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzcd.asBinder());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * JD-Core Version:    0.6.2
 */