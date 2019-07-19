package com.viber.voip.flatbuffers.b;

import android.content.Context;
import android.util.Log;
import com.viber.voip.flatbuffers.model.a.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;

public class e
{
  public static final a a = a.a;
  private static Context b;
  private static volatile d<MsgInfo> c;
  private static volatile d<a> d;
  private static volatile d<QuotedMessageData> e;
  private static volatile d<ConferenceInfo> f;
  private static volatile d<MyCommunitySettings> g;
  private static a h = a.a;
  private static a i = a.a;
  private static a j = a.a;

  public static d<MsgInfo> a()
  {
    if (c == null);
    while (true)
    {
      try
      {
        if (c == null);
        switch (1.a[h.ordinal()])
        {
        default:
          Log.e("ParserManager", "unknown MsgInfo factory type");
          c = null;
          return c;
        case 1:
          c = new com.viber.voip.flatbuffers.b.c.c(b);
          continue;
        case 2:
        }
      }
      finally
      {
      }
      c = new com.viber.voip.flatbuffers.b.c.e();
    }
  }

  public static void a(Context paramContext, a parama)
  {
    b = paramContext;
    h = parama;
    i = parama;
    j = parama;
    c = null;
    e = null;
    f = null;
  }

  public static void a(a parama)
  {
    try
    {
      h = parama;
      c = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static d<QuotedMessageData> b()
  {
    if (e == null)
      while (true)
      {
        try
        {
          if (e == null);
          switch (1.a[i.ordinal()])
          {
          default:
            Log.e("ParserManager", "unknown QuotedMessageData factory type");
            e = null;
            d locald = e;
            return locald;
          case 1:
            e = new com.viber.voip.flatbuffers.b.e.c(b);
            continue;
          case 2:
          }
        }
        finally
        {
        }
        e = new com.viber.voip.flatbuffers.b.e.e();
      }
    return e;
  }

  public static void b(a parama)
  {
    try
    {
      i = parama;
      e = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static d<ConferenceInfo> c()
  {
    if (f == null)
      while (true)
      {
        try
        {
          if (f == null);
          switch (1.a[j.ordinal()])
          {
          default:
            Log.e("ParserManager", "unknown ConferenceInfo factory type");
            f = null;
            d locald = f;
            return locald;
          case 1:
            f = new com.viber.voip.flatbuffers.b.a.c(b);
            continue;
          case 2:
          }
        }
        finally
        {
        }
        f = new com.viber.voip.flatbuffers.b.a.e();
      }
    return f;
  }

  public static d<a> d()
  {
    if (d == null);
    try
    {
      if (d == null)
        d = new com.viber.voip.flatbuffers.b.f.b();
      return d;
    }
    finally
    {
    }
  }

  public static d<MyCommunitySettings> e()
  {
    if (g == null);
    try
    {
      if (g == null)
        g = new com.viber.voip.flatbuffers.b.d.b();
      return g;
    }
    finally
    {
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    public static String[] a()
    {
      a[] arrayOfa = values();
      String[] arrayOfString = new String[arrayOfa.length];
      for (int i = 0; i < arrayOfa.length; i++)
        arrayOfString[i] = arrayOfa[i].name();
      return arrayOfString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.e
 * JD-Core Version:    0.6.2
 */