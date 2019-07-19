package com.viber.voip.d;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class a<T> extends Handler
{
  private WeakReference<T> a;

  protected a(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  public void a(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  public abstract void a(T paramT, Message paramMessage);

  public final void handleMessage(Message paramMessage)
  {
    if (this.a == null);
    Object localObject;
    do
    {
      return;
      localObject = this.a.get();
    }
    while (localObject == null);
    a(localObject, paramMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.d.a
 * JD-Core Version:    0.6.2
 */