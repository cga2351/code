package com.viber.voip.b.c.a;

import android.content.Context;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.util.af;
import com.viber.voip.util.at;
import java.io.File;
import java.util.List;

public abstract class d extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public d(Context paramContext)
  {
    super(paramContext);
  }

  private void a(String paramString, b paramb, a parama)
  {
    Cursor localCursor = null;
    try
    {
      localCursor = paramb.a(paramString, null);
      while (localCursor.moveToNext())
      {
        File localFile = parama.a(localCursor.getString(0));
        if (at.a(localFile))
          this.b.a(localFile.getAbsolutePath());
      }
    }
    finally
    {
      af.a(localCursor);
    }
    af.a(localCursor);
  }

  public void a()
  {
    this.b = new f(new g(new com.viber.voip.b.c.a.a.a()));
  }

  protected void b()
  {
    if (this.a);
    List localList;
    do
    {
      return;
      a("SELECT viber_image FROM participants_info WHERE viber_image IS NOT NULL AND viber_image != ''", com.viber.provider.messages.b.d.a(this.c), f());
      a("SELECT photo FROM vibernumbers WHERE photo IS NOT NULL AND photo != ''", com.viber.provider.contacts.a.a.a(this.c), g());
      localList = this.b.a(h());
    }
    while (this.a);
    this.b.a(localList);
  }

  abstract a f();

  abstract a g();

  abstract File h();

  static abstract interface a
  {
    public abstract File a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.d
 * JD-Core Version:    0.6.2
 */