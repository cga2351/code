package com.viber.voip.b.c.a.a;

import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f extends d
{
  b c;
  List<String> d;
  List<String> e;
  Pattern f;

  public f(b paramb, List<String> paramList1, List<String> paramList2, String paramString)
  {
    this.c = paramb;
    this.d = paramList1;
    this.e = paramList2;
    if (!TextUtils.isEmpty(paramString))
      this.f = Pattern.compile(paramString);
  }

  protected boolean a(File paramFile)
  {
    if (this.c.a(paramFile))
      return true;
    String str = paramFile.getName();
    if ((this.d != null) && (this.d.size() > 0))
    {
      Iterator localIterator2 = this.d.iterator();
      while (localIterator2.hasNext())
        if (str.startsWith((String)localIterator2.next()))
          return true;
    }
    if ((this.e != null) && (this.e.size() > 0))
    {
      Iterator localIterator1 = this.e.iterator();
      while (localIterator1.hasNext())
        if (str.endsWith((String)localIterator1.next()))
          return true;
    }
    return (this.f != null) && (this.f.matcher(str).matches());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a.f
 * JD-Core Version:    0.6.2
 */