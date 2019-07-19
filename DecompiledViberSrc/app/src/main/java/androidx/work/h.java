package androidx.work;

import java.util.List;

public abstract class h
{
  private static final String a = i.a("InputMerger");

  public static h a(String paramString)
  {
    try
    {
      h localh = (h)Class.forName(paramString).newInstance();
      return localh;
    }
    catch (Exception localException)
    {
      i.a().e(a, "Trouble instantiating + " + paramString, new Throwable[] { localException });
    }
    return null;
  }

  public abstract e a(List<e> paramList);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.h
 * JD-Core Version:    0.6.2
 */