package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.a.c;
import com.google.android.exoplayer2.e.h.b;
import com.google.android.exoplayer2.e.h.g;

public abstract interface h
{
  public static final h a = new h()
  {
    public boolean a(Format paramAnonymousFormat)
    {
      String str = paramAnonymousFormat.sampleMimeType;
      return ("text/vtt".equals(str)) || ("text/x-ssa".equals(str)) || ("application/ttml+xml".equals(str)) || ("application/x-mp4-vtt".equals(str)) || ("application/x-subrip".equals(str)) || ("application/x-quicktime-tx3g".equals(str)) || ("application/cea-608".equals(str)) || ("application/x-mp4-cea-608".equals(str)) || ("application/cea-708".equals(str)) || ("application/dvbsubs".equals(str)) || ("application/pgs".equals(str));
    }

    public f b(Format paramAnonymousFormat)
    {
      String str = paramAnonymousFormat.sampleMimeType;
      int i = -1;
      switch (str.hashCode())
      {
      default:
      case -1004728940:
      case 822864842:
      case -1026075066:
      case 1693976202:
      case 1668750253:
      case 691401887:
      case 1566015601:
      case 930165504:
      case 1566016562:
      case -1351681404:
      case -1248334819:
      }
      while (true)
        switch (i)
        {
        default:
          throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
          if (str.equals("text/vtt"))
          {
            i = 0;
            continue;
            if (str.equals("text/x-ssa"))
            {
              i = 1;
              continue;
              if (str.equals("application/x-mp4-vtt"))
              {
                i = 2;
                continue;
                if (str.equals("application/ttml+xml"))
                {
                  i = 3;
                  continue;
                  if (str.equals("application/x-subrip"))
                  {
                    i = 4;
                    continue;
                    if (str.equals("application/x-quicktime-tx3g"))
                    {
                      i = 5;
                      continue;
                      if (str.equals("application/cea-608"))
                      {
                        i = 6;
                        continue;
                        if (str.equals("application/x-mp4-cea-608"))
                        {
                          i = 7;
                          continue;
                          if (str.equals("application/cea-708"))
                          {
                            i = 8;
                            continue;
                            if (str.equals("application/dvbsubs"))
                            {
                              i = 9;
                              continue;
                              if (str.equals("application/pgs"))
                                i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        }
      return new g();
      return new com.google.android.exoplayer2.e.d.a(paramAnonymousFormat.initializationData);
      return new b();
      return new com.google.android.exoplayer2.e.f.a();
      return new com.google.android.exoplayer2.e.e.a();
      return new com.google.android.exoplayer2.e.g.a(paramAnonymousFormat.initializationData);
      return new com.google.android.exoplayer2.e.a.a(paramAnonymousFormat.sampleMimeType, paramAnonymousFormat.accessibilityChannel);
      return new c(paramAnonymousFormat.accessibilityChannel, paramAnonymousFormat.initializationData);
      return new com.google.android.exoplayer2.e.b.a(paramAnonymousFormat.initializationData);
      return new com.google.android.exoplayer2.e.c.a();
    }
  };

  public abstract boolean a(Format paramFormat);

  public abstract f b(Format paramFormat);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h
 * JD-Core Version:    0.6.2
 */