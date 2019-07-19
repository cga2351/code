package com.viber.voip.contacts;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.c;
import com.viber.voip.util.da;

public class e extends com.viber.provider.d
  implements a
{
  private static final Creator l = com.viber.voip.model.entity.d.e;
  private final g m;
  private boolean n;
  private String o;
  private g.b p = new g.b()
  {
    public void a()
    {
      e.this.l();
    }
  };
  private final Runnable q = new Runnable()
  {
    public void run()
    {
      e.this.l();
    }
  };

  public e(Context paramContext, LoaderManager paramLoaderManager, g paramg, d.a parama)
  {
    super(29, l.getContentUri(), paramContext, paramLoaderManager, parama, 0);
    this.m = paramg;
    a(l.getProjections());
    a("phonebookcontact.viber=0");
    d("phonebookcontact.low_display_name ASC, phonebookcontact._id DESC");
  }

  private String a(String paramString1, String paramString2)
  {
    if (da.a(paramString1));
    while (true)
    {
      if (da.a(paramString2))
        paramString2 = "";
      return paramString2;
      if (da.a(paramString2))
        paramString2 = paramString1;
      else
        paramString2 = paramString1 + " AND " + paramString2;
    }
  }

  private String[] h(String paramString)
  {
    String str = "%" + paramString + "%";
    return new String[] { str, str, str, str };
  }

  public String a()
  {
    return this.o;
  }

  public c c(int paramInt)
  {
    if (b_(paramInt))
      return (c)l.createInstance(this.f);
    return null;
  }

  public void f(String paramString)
  {
    if (!d())
      return;
    boolean bool;
    if (!da.a(paramString))
    {
      bool = true;
      this.n = bool;
      if (!this.n)
        break label93;
      this.o = paramString.toLowerCase();
      b(h(this.o));
      a(a("phonebookdata.mime_type=0 AND (phonebookcontact.low_display_name LIKE ? OR phonebookdata.data1 LIKE ? OR phonebookdata.data2 LIKE ? OR phonebookdata.data3 LIKE ?)", "phonebookcontact.viber=0"));
    }
    while (true)
    {
      this.i.removeCallbacks(this.q);
      this.i.postDelayed(this.q, 200L);
      return;
      bool = false;
      break;
      label93: b(null);
      a("phonebookcontact.viber=0");
    }
  }

  public void g(String paramString)
  {
    f(paramString);
    i();
  }

  public void p()
  {
    super.p();
    this.m.a(this.p);
  }

  public void q()
  {
    super.q();
    this.m.b(this.p);
  }

  public boolean x_()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.e
 * JD-Core Version:    0.6.2
 */