package com.viber.voip.shareviber.invitescreen;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArraySet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.f;
import com.viber.voip.shareviber.invitescreen.b.k;
import com.viber.voip.shareviber.invitescreen.b.k.a;
import com.viber.voip.util.ae;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Presenter
  implements a.a, d
{
  private static final Logger a = ViberEnv.getLogger();
  private static final c b = (c)cl.b(c.class);
  private final a c;
  private final b d;
  private final k e;
  private final com.viber.voip.analytics.story.g.a f;
  private c g = b;
  private State h;
  private final k.a i = new k.a()
  {
    public void a(List<com.viber.voip.model.a> paramAnonymousList)
    {
      Presenter.a(Presenter.this).a(paramAnonymousList);
    }
  };
  private boolean j;

  public Presenter(a parama, b paramb, k paramk, com.viber.voip.analytics.story.g.a parama1, String paramString)
  {
    this.c = parama;
    this.d = paramb;
    this.e = paramk;
    this.f = parama1;
    this.h = new State("", new ArraySet(), false, true, null, paramString);
    this.c.a(this);
  }

  public void a()
  {
    if (!this.h.hasContactsPermissions())
      return;
    this.g.c();
  }

  public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
  {
    String str = paramc.w().c();
    if (paramBoolean)
    {
      this.h.getSelectedNumbers().add(str);
      this.g.a(this.h.getSelectedNumbers().size());
    }
    while (true)
    {
      this.g.c();
      return;
      this.h.getSelectedNumbers().remove(str);
      if (this.h.isSelectAll())
        this.h = new State(this.h.getSearchQuery(), this.h.getSelectedNumbers(), false, this.h.hasContactsPermissions(), this.h.getShareText(), this.h.getEntryPoint());
      if (this.h.getSelectedNumbers().size() == 0)
        this.g.a();
      else
        this.g.a(this.h.getSelectedNumbers().size());
    }
  }

  public void a(c paramc, Parcelable paramParcelable)
  {
    this.g = paramc;
    if ((paramParcelable instanceof State))
      this.h = ((State)paramParcelable);
    this.g.a(this.c.a(), this.h.isSelectAll());
    c localc;
    if (this.h.getSelectedNumbers().size() > 0)
    {
      this.g.a(this.h.getSelectedNumbers().size());
      localc = this.g;
      if (da.a(this.h.getSearchQuery()))
        break label117;
    }
    label117: for (boolean bool = true; ; bool = false)
    {
      localc.a(bool);
      return;
      this.g.a();
      break;
    }
  }

  public void a(String paramString)
  {
    boolean bool1 = true;
    if (!this.h.hasContactsPermissions())
      return;
    boolean bool2;
    c localc;
    if (da.a(this.h.getSearchQuery()) != da.a(paramString))
    {
      bool2 = bool1;
      if (bool2)
      {
        localc = this.g;
        if (da.a(paramString))
          break label124;
      }
    }
    while (true)
    {
      localc.a(bool1);
      this.h = new State(paramString, this.h.getSelectedNumbers(), this.h.isSelectAll(), this.h.hasContactsPermissions(), this.h.getShareText(), this.h.getEntryPoint());
      this.c.a(this.h.getSearchQuery());
      return;
      bool2 = false;
      break;
      label124: bool1 = false;
    }
  }

  public void a(Collection<com.viber.voip.model.c> paramCollection, boolean paramBoolean)
  {
    if (this.h.isSelectAll())
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        com.viber.voip.model.c localc = (com.viber.voip.model.c)localIterator.next();
        if (localc.w() != null)
        {
          String str = localc.w().c();
          if (!da.a(str))
            this.h.getSelectedNumbers().add(str);
        }
      }
      if (this.h.getSelectedNumbers().size() > 0)
        this.g.a(this.h.getSelectedNumbers().size());
    }
    if ((paramCollection.isEmpty()) && (!da.a(this.h.getSearchQuery())));
    for (boolean bool = true; ; bool = false)
    {
      this.g.a(bool, this.h.getSearchQuery());
      if (this.j)
      {
        this.j = false;
        this.e.a(this.i);
      }
      if ((paramBoolean) && (paramCollection.isEmpty()))
        this.j = true;
      this.g.b();
      return;
    }
  }

  public void b()
  {
    this.g = b;
  }

  public boolean b(String paramString)
  {
    return this.h.getSelectedNumbers().contains(paramString);
  }

  public State c()
  {
    return this.h;
  }

  public void d()
  {
    if (!this.h.hasContactsPermissions())
      return;
    this.c.b();
    this.e.a(this.i);
  }

  public void e()
  {
    this.c.c();
  }

  public void f()
  {
    if (!this.h.hasContactsPermissions());
    int k;
    do
    {
      return;
      k = this.h.getSelectedNumbers().size();
    }
    while (this.h.getSelectedNumbers().size() <= 0);
    ArrayList localArrayList = new ArrayList(this.h.getSelectedNumbers());
    this.d.a(localArrayList, this.h.getShareText());
    this.f.a(ae.b(), this.h.getEntryPoint(), k);
  }

  public void g()
  {
    if (!this.h.hasContactsPermissions())
      return;
    String str = this.h.getSearchQuery();
    ArraySet localArraySet = this.h.getSelectedNumbers();
    if (!this.h.isSelectAll());
    for (boolean bool = true; ; bool = false)
    {
      this.h = new State(str, localArraySet, bool, this.h.hasContactsPermissions(), this.h.getShareText(), this.h.getEntryPoint());
      if (!this.h.isSelectAll())
      {
        this.h.getSelectedNumbers().clear();
        this.g.a();
      }
      this.c.d();
      return;
    }
  }

  public void h()
  {
    this.h = new State(this.h.getSearchQuery(), this.h.getSelectedNumbers(), this.h.isSelectAll(), false, this.h.getShareText(), this.h.getEntryPoint());
    this.c.c();
    this.g.d();
  }

  public void i()
  {
    this.h = new State(this.h.getSearchQuery(), this.h.getSelectedNumbers(), this.h.isSelectAll(), true, this.h.getShareText(), this.h.getEntryPoint());
    this.c.b();
    this.j = true;
    this.g.b();
  }

  public static class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public Presenter.State a(Parcel paramAnonymousParcel)
      {
        return new Presenter.State(paramAnonymousParcel);
      }

      public Presenter.State[] a(int paramAnonymousInt)
      {
        return new Presenter.State[paramAnonymousInt];
      }
    };
    private final String mEntryPoint;
    private final boolean mHasContactsPermissions;
    private final String mSearchQuery;
    private final boolean mSelectAll;
    private final ArraySet<String> mSelectedNumbers;
    private final String mShareText;

    protected State(Parcel paramParcel)
    {
      this.mSearchQuery = paramParcel.readString();
      ArrayList localArrayList = paramParcel.createStringArrayList();
      this.mSelectedNumbers = new ArraySet(localArrayList.size());
      this.mSelectedNumbers.addAll(localArrayList);
      int j;
      if (paramParcel.readByte() == i)
      {
        j = i;
        this.mSelectAll = j;
        if (paramParcel.readByte() != i)
          break label96;
      }
      while (true)
      {
        this.mHasContactsPermissions = i;
        this.mShareText = paramParcel.readString();
        this.mEntryPoint = paramParcel.readString();
        return;
        j = 0;
        break;
        label96: i = 0;
      }
    }

    State(String paramString1, ArraySet<String> paramArraySet, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3)
    {
      this.mSearchQuery = paramString1;
      this.mSelectedNumbers = paramArraySet;
      this.mSelectAll = paramBoolean1;
      this.mHasContactsPermissions = paramBoolean2;
      this.mShareText = paramString2;
      this.mEntryPoint = paramString3;
    }

    public int describeContents()
    {
      return 0;
    }

    public String getEntryPoint()
    {
      return this.mEntryPoint;
    }

    public String getSearchQuery()
    {
      return this.mSearchQuery;
    }

    public ArraySet<String> getSelectedNumbers()
    {
      return this.mSelectedNumbers;
    }

    public String getShareText()
    {
      return this.mShareText;
    }

    public boolean hasContactsPermissions()
    {
      return this.mHasContactsPermissions;
    }

    public boolean isSelectAll()
    {
      return this.mSelectAll;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.mSearchQuery);
      paramParcel.writeStringList(new ArrayList(this.mSelectedNumbers));
      int j;
      if (this.mSelectAll)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        if (!this.mHasContactsPermissions)
          break label78;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeString(this.mShareText);
        paramParcel.writeString(this.mEntryPoint);
        return;
        j = 0;
        break;
        label78: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.Presenter
 * JD-Core Version:    0.6.2
 */