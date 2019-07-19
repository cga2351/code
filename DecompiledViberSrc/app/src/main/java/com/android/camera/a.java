package com.android.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dq;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static a c = null;
  private final WeakHashMap<Thread, b> b = new WeakHashMap();

  public static a a()
  {
    try
    {
      if (c == null)
        c = new a();
      a locala = c;
      return locala;
    }
    finally
    {
    }
  }

  private void a(Thread paramThread, BitmapFactory.Options paramOptions)
  {
    try
    {
      c(paramThread).b = paramOptions;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private b c(Thread paramThread)
  {
    try
    {
      b localb = (b)this.b.get(paramThread);
      if (localb == null)
      {
        localb = new b(null);
        this.b.put(paramThread, localb);
      }
      return localb;
    }
    finally
    {
    }
  }

  public Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions)
  {
    if (paramOptions.mCancel)
      return null;
    Thread localThread = Thread.currentThread();
    if (!b(localThread))
    {
      a.b("Thread ? is not allowed to decode.", new Object[] { localThread });
      return null;
    }
    a(localThread, paramOptions);
    Bitmap localBitmap = dq.a(paramFileDescriptor, null, paramOptions);
    a(localThread);
    return localBitmap;
  }

  void a(Thread paramThread)
  {
    try
    {
      ((b)this.b.get(paramThread)).b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b(Thread paramThread)
  {
    boolean bool1 = true;
    try
    {
      b localb = (b)this.b.get(paramThread);
      if (localb == null)
        return bool1;
      a locala1 = localb.a;
      a locala2 = a.a;
      if (locala1 != locala2);
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        bool1 = bool2;
        break;
      }
    }
    finally
    {
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }

  private static class b
  {
    public a.a a = a.a.b;
    public BitmapFactory.Options b;

    public String toString()
    {
      String str;
      if (this.a == a.a.a)
        str = "Cancel";
      while (true)
      {
        return "thread state = " + str + ", options = " + this.b;
        if (this.a == a.a.b)
          str = "Allow";
        else
          str = "?";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a
 * JD-Core Version:    0.6.2
 */