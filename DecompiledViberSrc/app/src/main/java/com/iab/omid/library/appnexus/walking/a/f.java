package com.iab.omid.library.appnexus.walking.a;

import android.text.TextUtils;
import com.iab.omid.library.appnexus.d.b;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class f extends a
{
  public f(b.b paramb, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble)
  {
    super(paramb, paramHashSet, paramJSONObject, paramDouble);
  }

  private void b(String paramString)
  {
    com.iab.omid.library.appnexus.b.a locala = com.iab.omid.library.appnexus.b.a.a();
    if (locala != null)
    {
      Iterator localIterator = locala.b().iterator();
      while (localIterator.hasNext())
      {
        com.iab.omid.library.appnexus.adsession.a locala1 = (com.iab.omid.library.appnexus.adsession.a)localIterator.next();
        if (this.a.contains(locala1.getAdSessionId()))
          locala1.getAdSessionStatePublisher().a(paramString, this.c);
      }
    }
  }

  protected String a(Object[] paramArrayOfObject)
  {
    if (b.b(this.b, this.d.b()))
      return null;
    this.d.a(this.b);
    return this.b.toString();
  }

  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      b(paramString);
    super.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a.f
 * JD-Core Version:    0.6.2
 */