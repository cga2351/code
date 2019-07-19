package com.viber.voip.analytics.a;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.x;
import java.util.LinkedList;
import java.util.List;

public class k
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final List<Uri> b = new LinkedList();

  public void a()
  {
  }

  public void a(Uri paramUri)
  {
    this.b.add(paramUri);
  }

  public void a(h paramh)
  {
  }

  public void a(boolean paramBoolean)
  {
    x.a(this, paramBoolean);
  }

  public void b()
  {
  }

  public List<Uri> c()
  {
    return this.b;
  }

  public boolean f()
  {
    return x.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.k
 * JD-Core Version:    0.6.2
 */