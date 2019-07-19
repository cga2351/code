package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.IReporter;
import org.json.JSONObject;

public class md
{
  private final ge<mb> a;
  private final mc b;
  private final Context c;

  public md(Context paramContext, ge<mb> paramge)
  {
    this(paramContext, paramge, new mc());
  }

  public md(Context paramContext, ge<mb> paramge, mc parammc)
  {
    this.a = paramge;
    this.c = paramContext;
    this.b = parammc;
  }

  public void a()
  {
    mi.a(this.c).reportEvent("sdk_list", this.b.b(this.b.a(((mb)this.a.a()).a)).toString());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.md
 * JD-Core Version:    0.6.2
 */