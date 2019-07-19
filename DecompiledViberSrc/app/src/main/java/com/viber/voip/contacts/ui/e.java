package com.viber.voip.contacts.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import com.viber.common.dialogs.l.a;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.contacts.adapters.a.a.d;
import com.viber.voip.contacts.model.a.a.b;
import com.viber.voip.model.f;
import com.viber.voip.model.j;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class e
  implements a.d
{
  static final Logger a = ViberEnv.getLogger();
  protected final ContactDetailsFragment b;
  private final dagger.a<com.viber.voip.analytics.story.b.a.h> c;
  private k d;
  private com.viber.voip.contacts.a.a.b e;
  private String f;
  private final c g;
  private final com.viber.common.permission.b h;

  public e(ContactDetailsFragment paramContactDetailsFragment, Context paramContext, k paramk, dagger.a<com.viber.voip.analytics.story.b.a.h> parama)
  {
    this.b = paramContactDetailsFragment;
    this.d = paramk;
    this.g = c.a(paramContext);
    this.c = parama;
    this.h = new com.viber.voip.permissions.e(this.b, paramk.a(new int[] { 3, 4 }))
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 44:
        case 45:
        case 36:
        case 37:
        }
        ArrayList localArrayList;
        do
        {
          Bundle localBundle;
          do
          {
            return;
            e.this.a((com.viber.voip.contacts.model.a)paramAnonymousObject);
            return;
            localBundle = (Bundle)paramAnonymousObject;
          }
          while (localBundle == null);
          localArrayList = localBundle.getParcelableArrayList("participants");
        }
        while (localArrayList == null);
        e.this.a(new HashSet(localArrayList));
      }
    };
  }

  private j b(com.viber.voip.contacts.model.a parama)
  {
    String str = parama.b;
    if (str == null)
      return null;
    Map localMap = e();
    Iterator localIterator = this.b.c().a().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (str.equals(localf.c()))
      {
        j localj = (j)localMap.get(localf.b());
        if (localj != null)
          return localj;
      }
    }
    return null;
  }

  private Map<String, j> e()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.b.b().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      localHashMap.put(localj.c(), localj);
    }
    return localHashMap;
  }

  protected final Context a()
  {
    return this.b.getContext();
  }

  public com.viber.voip.contacts.adapters.a.a a(RecyclerView paramRecyclerView, List<com.viber.voip.contacts.model.a> paramList)
  {
    String str;
    int i;
    label58: com.viber.voip.contacts.model.a locala;
    int k;
    if (this.e != null)
    {
      a.b localb = (a.b)this.e.c();
      if (localb != null)
      {
        str = localb.g();
        this.f = str;
      }
    }
    else
    {
      this.e = new com.viber.voip.contacts.a.a.b();
      Iterator localIterator = paramList.iterator();
      i = 0;
      if (!localIterator.hasNext())
        break label272;
      locala = (com.viber.voip.contacts.model.a)localIterator.next();
      if (!com.viber.voip.contacts.model.a.a.a.equals(locala.a))
        break label252;
      com.viber.voip.contacts.a.a.b localb1 = this.e;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = locala.b;
      arrayOfObject1[1] = locala;
      localb1.a(arrayOfObject1);
      com.viber.voip.contacts.a.a.b localb2 = this.e;
      int m = -1 + this.e.b();
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = locala;
      arrayOfObject2[1] = Integer.valueOf(3);
      localb2.a(m, arrayOfObject2);
      if (!ViberApplication.getInstance().getHardwareParameters().isGsmSupportedOrHavePhoneType())
        break label353;
      com.viber.voip.contacts.a.a.b localb3 = this.e;
      int n = -1 + this.e.b();
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = locala.b;
      arrayOfObject3[1] = Integer.valueOf(4);
      localb3.a(n, arrayOfObject3);
      k = i;
    }
    label272: label353: 
    while (true)
    {
      i = k;
      break label58;
      str = null;
      break;
      label252: if (com.viber.voip.contacts.model.a.a.b.equals(locala.a))
      {
        k = 1;
        continue;
        if (i != 0)
          d();
        int j = this.e.a(this.f);
        if (-1 == j)
          j = 0;
        this.e.d(j).d();
        DefaultItemAnimator localDefaultItemAnimator = new DefaultItemAnimator();
        localDefaultItemAnimator.setSupportsChangeAnimations(false);
        paramRecyclerView.setItemAnimator(localDefaultItemAnimator);
        return new com.viber.voip.contacts.adapters.a.a(a(), this.e, this);
      }
      else
      {
        k = i;
      }
    }
  }

  public void a(Bundle paramBundle)
  {
    if (paramBundle != null);
    for (String str = paramBundle.getString("call_ways_expanded_section_description"); ; str = null)
    {
      this.f = str;
      return;
    }
  }

  public void a(View paramView, com.viber.voip.contacts.a.a.a.a parama)
  {
    switch (parama.a())
    {
    default:
    case 3:
    case 4:
      com.viber.voip.model.b localb;
      do
      {
        return;
        a(parama);
        return;
        com.viber.voip.analytics.story.b.a.h localh = (com.viber.voip.analytics.story.b.a.h)this.c.get();
        h.a.a locala = h.a.i();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ((String)parama.b());
        localh.a(locala.a(arrayOfString).b("Cellular Call").a("Contact Profile").a());
        localb = this.b.c();
      }
      while (localb == null);
      ViberDialogHandlers.ag localag = new ViberDialogHandlers.ag(localb.p(), (String)parama.b());
      com.viber.voip.ui.dialogs.b.i().a(localag).b(this.b);
      return;
    case 2:
    }
    b(parama);
  }

  void a(com.viber.voip.contacts.a.a.a.a parama)
  {
    com.viber.voip.contacts.model.a locala = (com.viber.voip.contacts.model.a)parama.b();
    if (this.g.a(n.h))
    {
      a(locala);
      return;
    }
    int i = this.d.a(4);
    this.g.a(this.b, i, n.h, locala);
  }

  void a(com.viber.voip.contacts.model.a parama)
  {
    this.b.a(parama);
    g.a().a(com.viber.voip.analytics.story.l.h.b());
  }

  void a(Set<ParticipantSelector.Participant> paramSet)
  {
    this.b.a(ContactDetailsFragment.e.c, paramSet);
  }

  public void b()
  {
    this.g.a(this.h);
  }

  public void b(Bundle paramBundle)
  {
    a.b localb;
    if (this.e != null)
    {
      localb = (a.b)this.e.c();
      if (localb == null)
        break label35;
    }
    label35: for (String str = localb.g(); ; str = null)
    {
      paramBundle.putString("call_ways_expanded_section_description", str);
      return;
    }
  }

  void b(com.viber.voip.contacts.a.a.a.a parama)
  {
    ContactDetailsFragment localContactDetailsFragment = this.b;
    j[] arrayOfj = new j[1];
    arrayOfj[0] = ((j)parama.b());
    Set localSet = localContactDetailsFragment.b(Arrays.asList(arrayOfj));
    if (this.g.a(n.g))
    {
      a(localSet);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("participants", new ArrayList(localSet));
    int i = this.d.a(3);
    this.g.a(this.b, i, n.g, localBundle);
  }

  public void c()
  {
    this.g.b(this.h);
  }

  public void d()
  {
    int i = 0;
    int j = 0;
    int k;
    if (i < this.e.b())
    {
      k = 0;
      label18: if (k >= this.e.b(i))
        break label151;
      if (2 != this.e.b(i, k).a());
    }
    label151: for (int m = 1; ; m = 0)
    {
      if (m == 0)
      {
        j localj = b((com.viber.voip.contacts.model.a)this.e.d(i).b());
        if (localj != null)
        {
          com.viber.voip.contacts.a.a.b localb = this.e;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = localj;
          arrayOfObject[1] = Integer.valueOf(2);
          localb.a(i, 0, arrayOfObject);
          j = 1;
        }
      }
      i++;
      break;
      k++;
      break label18;
      if (j != 0)
      {
        com.viber.voip.contacts.adapters.a.a locala = this.b.a();
        if (locala != null)
          locala.notifyDataSetChanged();
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.e
 * JD-Core Version:    0.6.2
 */