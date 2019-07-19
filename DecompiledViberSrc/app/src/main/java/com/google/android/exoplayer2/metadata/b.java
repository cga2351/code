package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

public abstract interface b
{
  public static final b a = new b()
  {
    public boolean a(Format paramAnonymousFormat)
    {
      String str = paramAnonymousFormat.sampleMimeType;
      return ("application/id3".equals(str)) || ("application/x-emsg".equals(str)) || ("application/x-scte35".equals(str));
    }

    public a b(Format paramAnonymousFormat)
    {
      String str = paramAnonymousFormat.sampleMimeType;
      int i = -1;
      switch (str.hashCode())
      {
      default:
      case -1248341703:
      case 1154383568:
      case 1652648887:
      }
      while (true)
        switch (i)
        {
        default:
          throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
          if (str.equals("application/id3"))
          {
            i = 0;
            continue;
            if (str.equals("application/x-emsg"))
            {
              i = 1;
              continue;
              if (str.equals("application/x-scte35"))
                i = 2;
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        }
      return new com.google.android.exoplayer2.metadata.id3.a();
      return new com.google.android.exoplayer2.metadata.emsg.a();
      return new com.google.android.exoplayer2.metadata.scte35.a();
    }
  };

  public abstract boolean a(Format paramFormat);

  public abstract a b(Format paramFormat);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.b
 * JD-Core Version:    0.6.2
 */