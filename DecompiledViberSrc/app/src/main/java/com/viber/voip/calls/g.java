package com.viber.voip.calls;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.c;

public class g extends com.viber.provider.d
{
  private static final Logger m = ViberEnv.getLogger();
  protected LruCache<Integer, c> l = new LruCache(20)
  {
    protected int a(Integer paramAnonymousInteger, c paramAnonymousc)
    {
      return 1;
    }
  };
  private Handler n = av.e.a.a();
  private String o;
  private final Runnable p = new Runnable()
  {
    public void run()
    {
      g.this.l();
    }
  };
  private g.b q = new g.b()
  {
    public void a()
    {
      g.this.l();
    }
  };
  private d.c r = new d.c()
  {
    public void a()
    {
      g.this.l();
    }
  };

  protected g(int paramInt1, Uri paramUri, Context paramContext, LoaderManager paramLoaderManager, d.a parama, int paramInt2)
  {
    super(paramInt1, paramUri, paramContext, paramLoaderManager, parama, paramInt2);
  }

  public g(Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    this(16, com.viber.voip.model.entity.d.e.getContentUri(), paramContext, paramLoaderManager, parama, 0);
    a(com.viber.voip.model.entity.d.e.getProjections());
    d("low_display_name ASC");
    r();
  }

  private static Pair<String, String[]> a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      String str = paramString1 + " AND " + paramString2;
      String[] arrayOfString = new String[4];
      arrayOfString[0] = ("%" + paramString3 + "%");
      arrayOfString[1] = ("%" + paramString3 + "%");
      arrayOfString[2] = ("%" + paramString3 + "%");
      arrayOfString[3] = ("%" + paramString3 + "%");
      return new Pair(str, arrayOfString);
    }
    return new Pair("phonebookcontact._id IN(0)", null);
  }

  private void r()
  {
    Pair localPair = a("phonebookcontact.has_number=1", "(phonebookcontact._id NOT IN (SELECT phonebookdata.contact_id FROM calls LEFT OUTER JOIN phonebookdata ON (calls.canonized_number=phonebookdata.data2) WHERE phonebookdata.contact_id NOT NULL )) AND (phonebookcontact.numbers_name LIKE ? OR phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1 LIKE ? OR phonebookdata.data2 LIKE ? OR phonebookdata.data2 LIKE ?))) AND mime_type=0", this.o);
    a((String)localPair.first);
    b((String[])localPair.second);
  }

  public c e(int paramInt)
  {
    c localc = (c)this.l.get(Integer.valueOf(paramInt));
    if ((localc == null) && (b_(paramInt)))
    {
      localc = (c)com.viber.voip.model.entity.d.e.createInstance(this.f);
      this.l.put(Integer.valueOf(paramInt), localc);
    }
    return localc;
  }

  public void f(String paramString)
  {
    if (paramString != null);
    for (String str = PhoneNumberUtils.stripSeparators(paramString); ; str = "")
    {
      this.o = str;
      r();
      this.n.removeCallbacks(this.p);
      this.n.postDelayed(this.p, 200L);
      return;
    }
  }

  protected void m()
  {
    super.m();
    this.l.evictAll();
  }

  public void p()
  {
    super.p();
    ViberApplication.getInstance().getContactManager().a(this.q);
    ViberApplication.getInstance().getRecentCallsManager().a(this.r);
  }

  public void q()
  {
    super.q();
    ViberApplication.getInstance().getContactManager().b(this.q);
    ViberApplication.getInstance().getRecentCallsManager().b(this.r);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.g
 * JD-Core Version:    0.6.2
 */