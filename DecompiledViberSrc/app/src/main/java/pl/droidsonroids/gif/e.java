package pl.droidsonroids.gif;

import java.util.Locale;

public enum e
{
  public final String v;
  int w;

  static
  {
    e[] arrayOfe = new e[21];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    arrayOfe[5] = f;
    arrayOfe[6] = g;
    arrayOfe[7] = h;
    arrayOfe[8] = i;
    arrayOfe[9] = j;
    arrayOfe[10] = k;
    arrayOfe[11] = l;
    arrayOfe[12] = m;
    arrayOfe[13] = n;
    arrayOfe[14] = o;
    arrayOfe[15] = p;
    arrayOfe[16] = q;
    arrayOfe[17] = r;
    arrayOfe[18] = s;
    arrayOfe[19] = t;
    arrayOfe[20] = u;
  }

  private e(int paramInt, String paramString)
  {
    this.w = paramInt;
    this.v = paramString;
  }

  static e a(int paramInt)
  {
    for (e locale2 : values())
      if (locale2.w == paramInt)
        return locale2;
    e locale1 = u;
    locale1.w = paramInt;
    return locale1;
  }

  String a()
  {
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.w);
    arrayOfObject[1] = this.v;
    return String.format(localLocale, "GifError %d: %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.e
 * JD-Core Version:    0.6.2
 */