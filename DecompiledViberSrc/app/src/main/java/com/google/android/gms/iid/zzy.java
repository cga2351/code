package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class zzy
{
  final Messenger zzad;
  final MessengerCompat zzco;

  zzy(IBinder paramIBinder)
    throws RemoteException
  {
    String str1 = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str1))
    {
      this.zzad = new Messenger(paramIBinder);
      this.zzco = null;
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str1))
    {
      this.zzco = new MessengerCompat(paramIBinder);
      this.zzad = null;
      return;
    }
    String str2 = String.valueOf(str1);
    if (str2.length() != 0);
    for (String str3 = "Invalid interface descriptor: ".concat(str2); ; str3 = new String("Invalid interface descriptor: "))
    {
      Log.w("MessengerIpcClient", str3);
      throw new RemoteException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzy
 * JD-Core Version:    0.6.2
 */