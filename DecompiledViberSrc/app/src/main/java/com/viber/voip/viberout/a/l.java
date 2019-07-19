package com.viber.voip.viberout.a;

import com.viber.voip.api.a.b.a.d;
import com.viber.voip.api.a.b.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class l
{
  private Map<String, List<m>> a = new HashMap();
  private Map<String, List<d>> b = new HashMap();

  public List<m> a(String paramString)
  {
    return (List)this.a.get(paramString);
  }

  public void a()
  {
    this.b = new HashMap();
    this.a = new HashMap();
  }

  public void a(String paramString, List<m> paramList)
  {
    this.a.put(paramString, new ArrayList(paramList));
  }

  public List<d> b(String paramString)
  {
    return (List)this.b.get(paramString);
  }

  public void b(String paramString, List<d> paramList)
  {
    this.b.put(paramString, new ArrayList(paramList));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.l
 * JD-Core Version:    0.6.2
 */