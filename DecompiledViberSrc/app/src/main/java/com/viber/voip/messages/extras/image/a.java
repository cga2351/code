package com.viber.voip.messages.extras.image;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.l;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile a b;
  private final Set<a> c = new HashSet();
  private Set<Integer> d = new HashSet();
  private Set<Integer> e = new HashSet();
  private Handler f = av.a(av.e.f);

  @Deprecated
  public static a a()
  {
    if (b == null);
    try
    {
      b = new a();
      return b;
    }
    finally
    {
    }
  }

  private void a(final int paramInt1, final SendMediaDataContainer paramSendMediaDataContainer, final int paramInt2, final int paramInt3)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        synchronized (a.a(a.this))
        {
          HashSet localHashSet = new HashSet(a.a(a.this));
          Iterator localIterator = localHashSet.iterator();
          if (localIterator.hasNext())
            ((a.a)localIterator.next()).a(paramInt1, paramSendMediaDataContainer, paramInt2, paramInt3);
        }
      }
    });
  }

  private void a(final int paramInt, final SendMediaDataContainer[] paramArrayOfSendMediaDataContainer)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        synchronized (a.a(a.this))
        {
          HashSet localHashSet = new HashSet(a.a(a.this));
          Iterator localIterator = localHashSet.iterator();
          if (localIterator.hasNext())
            ((a.a)localIterator.next()).a(paramInt, paramArrayOfSendMediaDataContainer);
        }
      }
    });
  }

  public void a(int paramInt)
  {
    synchronized (this.d)
    {
      this.d.add(Integer.valueOf(paramInt));
      return;
    }
  }

  public void a(int paramInt1, Context paramContext, Uri[] paramArrayOfUri, String paramString, dv paramdv, int paramInt2)
  {
    this.f.post(new b(paramInt1, paramContext, paramArrayOfUri, paramString, paramdv, 1280, paramInt2, true));
  }

  public void a(int paramInt1, Context paramContext, Uri[] paramArrayOfUri, String paramString, dv paramdv, int paramInt2, int paramInt3)
  {
    this.f.post(new b(paramInt1, paramContext, paramArrayOfUri, paramString, paramdv, paramInt2, paramInt3, false));
  }

  public void a(a parama)
  {
    synchronized (this.c)
    {
      this.c.add(parama);
      return;
    }
  }

  public void b(int paramInt)
  {
    synchronized (this.e)
    {
      this.e.add(Integer.valueOf(paramInt));
      return;
    }
  }

  public void b(a parama)
  {
    synchronized (this.c)
    {
      this.c.remove(parama);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, SendMediaDataContainer paramSendMediaDataContainer, int paramInt2, int paramInt3);

    public abstract void a(int paramInt, SendMediaDataContainer[] paramArrayOfSendMediaDataContainer);
  }

  private class b
    implements Runnable
  {
    private Context b;
    private Uri[] c;
    private String d;
    private dv e = dv.a;
    private int f;
    private int g;
    private int h;
    private boolean i;

    public b(int paramContext, Context paramArrayOfUri, Uri[] paramString, String paramdv, dv paramInt1, int paramInt2, int paramBoolean, boolean arg9)
    {
      this.b = paramArrayOfUri;
      this.c = paramString;
      this.d = paramdv;
      this.e = paramInt1;
      this.f = paramBoolean;
      this.h = paramContext;
      this.g = paramInt2;
      boolean bool;
      this.i = bool;
    }

    private SendMediaDataContainer a(Uri paramUri, int paramInt, boolean paramBoolean)
    {
      Object localObject1;
      Object localObject2;
      if (a(paramUri))
      {
        localObject1 = j.c(paramUri);
        localObject2 = localObject1;
      }
      try
      {
        SendMediaDataContainer localSendMediaDataContainer;
        if ("image".equals(this.d))
        {
          Uri localUri = j.a(this.b, localObject2, this.e, paramInt, paramInt, true, this.f);
          localObject1 = localUri;
          if (localObject1 == null)
            localSendMediaDataContainer = null;
        }
        do
        {
          return localSendMediaDataContainer;
          localObject1 = j.a(this.b, paramUri, this.d);
          localObject2 = localObject1;
          break;
          Object localObject3 = localObject1;
          localSendMediaDataContainer = new SendMediaDataContainer();
          localSendMediaDataContainer.fileUri = localObject2;
          localSendMediaDataContainer.croppedImage = localObject3;
          localSendMediaDataContainer.type = l.b(this.d);
        }
        while (!paramBoolean);
        localSendMediaDataContainer.thumbnailUri = c.a(this.b, localObject2, localSendMediaDataContainer.type);
        return localSendMediaDataContainer;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ViberApplication.getInstance().onOutOfMemory();
        return null;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        return null;
      }
      catch (IOException localIOException)
      {
        return null;
      }
      catch (SecurityException localSecurityException)
      {
      }
      return null;
    }

    private void a(SendMediaDataContainer[] paramArrayOfSendMediaDataContainer)
    {
      int j = 0;
      if (j < paramArrayOfSendMediaDataContainer.length)
      {
        SendMediaDataContainer localSendMediaDataContainer = paramArrayOfSendMediaDataContainer[j];
        if (localSendMediaDataContainer == null);
        while (true)
        {
          j++;
          break;
          at.d(this.b, localSendMediaDataContainer.croppedImage);
          at.d(this.b, localSendMediaDataContainer.thumbnailUri);
        }
      }
    }

    private boolean a(Uri paramUri)
    {
      String str = paramUri.getScheme();
      return (str != null) && (str.startsWith("http"));
    }

    private boolean a(SendMediaDataContainer[] paramArrayOfSendMediaDataContainer, SendMediaDataContainer paramSendMediaDataContainer)
    {
      synchronized (a.b(a.this))
      {
        if (a.b(a.this).remove(Integer.valueOf(this.h)))
        {
          a(paramArrayOfSendMediaDataContainer);
          return true;
        }
        synchronized (a.c(a.this))
        {
          if (a.c(a.this).remove(Integer.valueOf(this.h)))
            return true;
        }
      }
      return false;
    }

    public void run()
    {
      if (this.c == null)
        return;
      int j = this.c.length;
      SendMediaDataContainer[] arrayOfSendMediaDataContainer = new SendMediaDataContainer[j];
      for (int k = 0; ; k++)
      {
        if (k >= j)
          break label95;
        if (a(arrayOfSendMediaDataContainer, null))
          break;
        arrayOfSendMediaDataContainer[k] = a(this.c[k], this.g, this.i);
        if (a(arrayOfSendMediaDataContainer, arrayOfSendMediaDataContainer[k]))
          break;
        if (arrayOfSendMediaDataContainer[k] != null)
          a.a(a.this, this.h, arrayOfSendMediaDataContainer[k], k, j);
      }
      label95: a.a(a.this, this.h, arrayOfSendMediaDataContainer);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.a
 * JD-Core Version:    0.6.2
 */