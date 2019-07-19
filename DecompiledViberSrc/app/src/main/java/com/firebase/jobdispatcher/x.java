package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class x
  implements s
{
  private final s a;

  public x(s params)
  {
    this.a = params;
  }

  private static void a(List<String> paramList)
  {
    if (paramList != null)
      throw new a("JobParameters is invalid", paramList);
  }

  public List<String> a(p paramp)
  {
    return this.a.a(paramp);
  }

  public final void b(p paramp)
  {
    a(a(paramp));
  }

  public static final class a extends RuntimeException
  {
    private final List<String> a;

    public a(String paramString, List<String> paramList)
    {
      super();
      this.a = paramList;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.x
 * JD-Core Version:    0.6.2
 */