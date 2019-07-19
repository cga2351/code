package com.viber.voip.b.c.a;

import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.c;
import com.viber.voip.util.at;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class f
{
  private static final Logger b = ViberEnv.getLogger();
  protected c a;
  private final Set<String> c;
  private boolean d;
  private volatile boolean e;
  private boolean f;
  private int g;
  private int h;

  public f(c paramc)
  {
    this(paramc, 32);
  }

  public f(c paramc, int paramInt)
  {
    this.c = new HashSet(paramInt);
    this.a = paramc;
    this.g = 300;
    this.h = 250;
  }

  protected int a()
  {
    return this.h;
  }

  public List<File> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    this.a.a(this.c);
    this.a.a(localArrayList, paramFile, 0, this.d);
    return localArrayList;
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  public void a(String paramString)
  {
    if (paramString != null)
      this.c.add(paramString);
  }

  public void a(Collection<String> paramCollection)
  {
    this.c.clear();
    this.c.addAll(paramCollection);
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public boolean a(List<File> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.e)
        return false;
      int i;
      if (this.f)
        i = paramList.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label97;
        SystemClock.sleep(a());
        if (this.e)
        {
          return false;
          i = Math.min(b(), paramList.size());
          break;
        }
        at.f((File)paramList.get(j));
      }
    }
    label97: return true;
  }

  protected int b()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void c()
  {
    this.e = true;
    this.a.a();
  }

  public void d()
  {
    this.c.clear();
  }

  public Set<String> e()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.f
 * JD-Core Version:    0.6.2
 */