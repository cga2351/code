package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class m
{
  private final Messenger a;
  private final zzm b;

  m(IBinder paramIBinder)
    throws RemoteException
  {
    String str1 = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str1))
    {
      this.a = new Messenger(paramIBinder);
      this.b = null;
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str1))
    {
      this.b = new zzm(paramIBinder);
      this.a = null;
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

  final void a(Message paramMessage)
    throws RemoteException
  {
    if (this.a != null)
    {
      this.a.send(paramMessage);
      return;
    }
    if (this.b != null)
    {
      this.b.send(paramMessage);
      return;
    }
    throw new IllegalStateException("Both messengers are null");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.m
 * JD-Core Version:    0.6.2
 */