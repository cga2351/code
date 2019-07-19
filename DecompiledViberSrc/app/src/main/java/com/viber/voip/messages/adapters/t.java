package com.viber.voip.messages.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.an;
import com.viber.voip.an.c;
import com.viber.voip.an.d;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.v;
import com.viber.voip.messages.k;
import com.viber.voip.messages.l;
import com.viber.voip.messages.ui.media.ViewMediaActivity.e;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.o;
import java.util.HashMap;
import java.util.Map;

public class t extends FragmentStatePagerAdapter
  implements an.d
{
  private static final Logger a = ViberEnv.getLogger();
  private v b;
  private Context c;
  private Map<Long, Pair<Boolean, Integer>> d;
  private boolean e;
  private int f;
  private an g;
  private ViewMediaActivity.e h;

  public t(Context paramContext, FragmentManager paramFragmentManager, v paramv, ViewMediaActivity.e parame, an paraman)
  {
    super(paramFragmentManager);
    this.c = paramContext;
    this.b = paramv;
    this.d = new HashMap();
    this.e = o.b();
    this.g = paraman;
    this.g.a(this);
    this.h = parame;
  }

  private void e()
  {
    if (this.f != -1)
      notifyDataSetChanged();
  }

  private void f()
  {
    this.g.b();
  }

  public int a(aa paramaa)
  {
    if (TextUtils.isEmpty(paramaa.o()));
    for (Uri localUri = null; !this.e; localUri = Uri.parse(paramaa.o()))
      return 3;
    if (!o.a())
      return 6;
    if (((localUri != null) && (!at.d(this.c, localUri.toString()))) || ((localUri == null) && ((paramaa.B() == null) || (paramaa.f() == -2))))
      return 2;
    if (localUri == null)
    {
      if (!cj.b(this.c))
        return 1;
      return 5;
    }
    return 0;
  }

  public aa a(int paramInt)
  {
    return this.b.f(paramInt);
  }

  public void a()
  {
    if ((this.f != -1 + getCount()) && (this.f != 0))
    {
      this.g.c();
      this.f = -1;
    }
  }

  public void a(int paramInt, Uri paramUri)
  {
    e();
  }

  public void a(int paramInt, an.c paramc)
  {
    e();
  }

  public void a(v paramv)
  {
    this.b = paramv;
  }

  public Pair<Boolean, Integer> b(aa paramaa)
  {
    boolean bool1 = true;
    Pair localPair1 = (Pair)this.d.get(Long.valueOf(paramaa.a()));
    Pair localPair2;
    if (localPair1 == null)
    {
      int j;
      if (!paramaa.ab())
      {
        j = 1 + paramaa.n();
        if (paramaa.ab())
          break label123;
      }
      label123: for (boolean bool2 = bool1; ; bool2 = false)
      {
        localPair2 = new Pair(Boolean.valueOf(bool2), Integer.valueOf(j));
        this.d.put(Long.valueOf(paramaa.a()), localPair2);
        ViberApplication.getInstance().getMessagesManager().c().e(paramaa.y());
        return localPair2;
        j = -1 + paramaa.n();
        break;
      }
    }
    int i;
    if (!((Boolean)localPair1.first).booleanValue())
    {
      i = 1 + ((Integer)localPair1.second).intValue();
      label156: if (((Boolean)localPair1.first).booleanValue())
        break label207;
    }
    while (true)
    {
      localPair2 = new Pair(Boolean.valueOf(bool1), Integer.valueOf(i));
      break;
      i = -1 + ((Integer)localPair1.second).intValue();
      break label156;
      label207: bool1 = false;
    }
  }

  public void b()
  {
    this.g.c();
    this.f = -1;
  }

  public void b(int paramInt)
  {
    this.f = paramInt;
    aa localaa = a(paramInt);
    if ((localaa.az()) && (!TextUtils.isEmpty(localaa.o())))
      this.g.d(paramInt, Uri.parse(localaa.o()), l.j(localaa.q()));
    while ((!localaa.aA()) || (!dx.d(localaa.bo())))
      return;
    this.g.a(paramInt, localaa.bo());
  }

  public void b(int paramInt, an.c paramc)
  {
  }

  public void c()
  {
    b();
    this.g.b(this);
    f();
  }

  public void d()
  {
    this.g.a();
  }

  public int getCount()
  {
    return this.b.getCount();
  }

  public Fragment getItem(int paramInt)
  {
    aa localaa = a(paramInt);
    int i = a(localaa);
    Bundle localBundle = new Bundle();
    if (localaa.az())
    {
      if (TextUtils.isEmpty(localaa.o()));
      for (Object localObject = null; ; localObject = Uri.parse(localaa.o()))
      {
        localBundle.putInt("status", i);
        localBundle.putParcelable("extra_uri", (Parcelable)localObject);
        localBundle.putInt("mime_type", localaa.q());
        localBundle.putInt("fragmentPosition", paramInt);
        return this.h.a(localBundle);
      }
    }
    localBundle.putInt("fragmentPosition", paramInt);
    localBundle.putInt("status", i);
    if ((!localaa.aS()) && (!localaa.ag()));
    for (boolean bool = true; ; bool = false)
    {
      localBundle.putBoolean("can_navigate_to_gallery", bool);
      localBundle.putParcelable("extra_uri", localaa.bo());
      return this.h.b(localBundle);
    }
  }

  public int getItemPosition(Object paramObject)
  {
    return -2;
  }

  public void notifyDataSetChanged()
  {
    this.e = o.b();
    this.d.clear();
    try
    {
      super.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.t
 * JD-Core Version:    0.6.2
 */