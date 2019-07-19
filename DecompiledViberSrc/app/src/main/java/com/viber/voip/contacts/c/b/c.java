package com.viber.voip.contacts.c.b;

import android.os.Handler;
import com.viber.jni.Engine;

public class c extends b
{
  private final Handler a;
  private final b[] b;

  public c(Handler paramHandler, b[] paramArrayOfb)
  {
    this.a = paramHandler;
    this.b = paramArrayOfb;
  }

  public void a()
  {
    b[] arrayOfb = this.b;
    int i = arrayOfb.length;
    for (int j = 0; j < i; j++)
      arrayOfb[j].a();
  }

  public void a(Engine paramEngine)
  {
    b[] arrayOfb = this.b;
    int i = arrayOfb.length;
    for (int j = 0; j < i; j++)
      arrayOfb[j].a(paramEngine);
  }

  public void onBlockListReply(final int paramInt)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        b[] arrayOfb = c.a(c.this);
        int i = arrayOfb.length;
        for (int j = 0; j < i; j++)
          arrayOfb[j].onBlockListReply(paramInt);
      }
    });
  }

  public void onConnect()
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        b[] arrayOfb = c.a(c.this);
        int i = arrayOfb.length;
        for (int j = 0; j < i; j++)
          arrayOfb[j].onConnect();
      }
    });
  }

  public void onConnectionStateChange(final int paramInt)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        b[] arrayOfb = c.a(c.this);
        int i = arrayOfb.length;
        for (int j = 0; j < i; j++)
          arrayOfb[j].onConnectionStateChange(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.b.c
 * JD-Core Version:    0.6.2
 */