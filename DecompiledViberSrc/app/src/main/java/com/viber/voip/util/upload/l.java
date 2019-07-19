package com.viber.voip.util.upload;

import android.net.Uri;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class l
{
  private static final Logger a = ViberEnv.getLogger();
  private static long b = 0L;
  private static final ArrayList<WeakReference<m>> c = new ArrayList();
  private static final Map<Uri, Integer> d = new HashMap();

  public static void a(m paramm)
  {
    if (paramm != null);
    while (true)
    {
      int j;
      synchronized (c)
      {
        int i = c.size();
        j = 0;
        if (j < i)
        {
          if (paramm != ((Reference)c.get(j)).get())
            break label71;
          return;
        }
        c.add(new WeakReference(paramm));
        return;
      }
      return;
      label71: j++;
    }
  }

  protected static void b(Uri paramUri, int paramInt)
  {
    long l1;
    ArrayList localArrayList;
    int i;
    synchronized (d)
    {
      d.put(paramUri, Integer.valueOf(paramInt));
      l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - b;
      if ((paramInt == 100) || (l2 > 50L))
      {
        localArrayList = c;
        i = 0;
      }
    }
    try
    {
      if (i < c.size())
      {
        m localm = (m)((WeakReference)c.get(i)).get();
        if (localm == null)
          c.remove(i);
        for (int j = i; ; j = i + 1)
        {
          i = j;
          break;
          localObject1 = finally;
          throw localObject1;
          localm.a(paramUri, paramInt);
        }
      }
      b = l1;
      return;
    }
    finally
    {
    }
  }

  public static void b(m paramm)
  {
    while (true)
    {
      int j;
      synchronized (c)
      {
        int i = c.size();
        j = 0;
        if (j < i)
        {
          if (paramm == ((Reference)c.get(j)).get())
            c.remove(j);
        }
        else
          return;
      }
      j++;
    }
  }

  public static void d(Uri paramUri)
  {
    synchronized (d)
    {
      d.remove(paramUri);
      return;
    }
  }

  public static Integer e(Uri paramUri)
  {
    synchronized (d)
    {
      Integer localInteger = (Integer)d.get(paramUri);
      return localInteger;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.l
 * JD-Core Version:    0.6.2
 */