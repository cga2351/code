package com.viber.voip.engagement.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.c.c;
import com.viber.voip.engagement.c.c.a;
import com.viber.voip.engagement.data.GifsMediaViewData;
import com.viber.voip.engagement.data.GifsMediaViewData.GifItem;
import com.viber.voip.engagement.data.SelectMediaViewData;
import com.viber.voip.engagement.data.StickersMediaViewData;
import com.viber.voip.engagement.data.StickersMediaViewData.StickerItem;
import com.viber.voip.engagement.data.d;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.cl;

public class Presenter
  implements c.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final e b = (e)cl.b(e.class);
  private final c c;
  private final b d;
  private final cj e;
  private final i f;
  private final com.viber.voip.engagement.carousel.b.a g;
  private final cj.b h = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != -1) && (!Presenter.a(Presenter.this).isEmpty()))
        Presenter.b(Presenter.this).e();
    }
  };
  private e i = b;
  private int j;
  private int k;
  private SelectMediaViewData l = new SelectMediaViewData();
  private boolean m = true;
  private boolean n;

  public Presenter(int paramInt, c paramc, b paramb, cj paramcj, i parami, com.viber.voip.engagement.carousel.b.a parama)
  {
    this.c = paramc;
    this.d = paramb;
    this.k = paramInt;
    this.e = paramcj;
    this.f = parami;
    this.g = parama;
  }

  private void a(SelectMediaViewData paramSelectMediaViewData)
  {
    int i1 = 1;
    int i3 = f(i1);
    int i4 = f(0);
    if ((i3 == 0) && (i4 == 0))
    {
      this.g.a(i1);
      return;
    }
    label66: e locale;
    int i5;
    if (i3 == 0)
    {
      this.k = 0;
      if (!this.m)
        break label164;
      this.j = d(i4);
      this.m = false;
      this.i.a(this.f.a());
      a(paramSelectMediaViewData, false);
      locale = this.i;
      if (f(i1) <= 0)
        break label184;
      i5 = i1;
      label107: if (f(0) <= 0)
        break label190;
    }
    while (true)
    {
      locale.a(i5, i1);
      this.i.b(this.k);
      return;
      if (i4 == 0)
      {
        this.k = i1;
        i4 = i3;
        break;
      }
      i4 = g();
      break;
      label164: if (this.j < i4)
        break label66;
      this.j = (i4 - 1);
      break label66;
      label184: int i6 = 0;
      break label107;
      label190: int i2 = 0;
    }
  }

  private void a(SelectMediaViewData paramSelectMediaViewData, boolean paramBoolean)
  {
    switch (this.k)
    {
    default:
      return;
    case 0:
      this.i.a(paramSelectMediaViewData.getGifsMediaViewData(), this.f, this.j, paramBoolean);
      return;
    case 1:
    }
    this.i.a(paramSelectMediaViewData.getStickersMediaViewData(), this.f, this.j, paramBoolean);
  }

  private int d(int paramInt)
  {
    return (paramInt - 1) / 2;
  }

  private boolean e(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < g());
  }

  private int f(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return this.l.getStickersMediaViewData().getItemsCount();
    case 0:
    }
    return this.l.getGifsMediaViewData().getItemsCount();
  }

  private int g()
  {
    return f(this.k);
  }

  public Parcelable a()
  {
    return new SaveState(this.l, this.m, this.k, this.j, this.n);
  }

  public void a(int paramInt)
  {
    if (e(paramInt))
      this.j = paramInt;
  }

  public void a(e parame, Parcelable paramParcelable)
  {
    this.i = parame;
    if ((paramParcelable instanceof SaveState))
    {
      SaveState localSaveState = (SaveState)paramParcelable;
      this.l = localSaveState.selectMediaViewData;
      this.k = localSaveState.selectedItemsType;
      this.j = localSaveState.selectedItemPosition;
      this.m = localSaveState.firstLoad;
      this.n = localSaveState.contentWasSwitched;
    }
    this.e.a(this.h);
  }

  public void a(com.viber.voip.engagement.data.a parama)
  {
    com.viber.voip.util.b.a locala = parama.a();
    this.l = new SelectMediaViewData(this.d.a(locala), this.d.b(locala), locala.g());
    this.f.a(parama.b());
    a(this.l);
  }

  public void b()
  {
    if (this.m)
    {
      this.i.c();
      this.c.a(this);
      this.c.a();
      return;
    }
    a(this.l);
  }

  public void b(int paramInt)
  {
    if ((f(paramInt) > 0) && (this.k != paramInt))
    {
      this.k = paramInt;
      this.j = d(f(this.k));
      this.i.b(paramInt);
      a(this.l, true);
      this.n = true;
    }
  }

  public void c()
  {
    this.i.a(this.f.a());
  }

  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    case 2:
    }
    this.i.d();
  }

  public d d()
  {
    d locald;
    switch (this.k)
    {
    default:
      boolean bool2 = e(this.j);
      locald = null;
      if (bool2)
        locald = new d((StickersMediaViewData.StickerItem)this.l.getStickersMediaViewData().getItem(this.j), this.l.getRichMessageMsgInfo());
      break;
    case 0:
    }
    boolean bool1;
    do
    {
      return locald;
      bool1 = e(this.j);
      locald = null;
    }
    while (!bool1);
    return new d((GifsMediaViewData.GifItem)this.l.getGifsMediaViewData().getItem(this.j), this.l.getRichMessageMsgInfo());
  }

  public void e()
  {
    this.i = b;
    this.c.d();
    this.e.b(this.h);
  }

  public void f()
  {
    this.g.a(2);
  }

  protected static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public Presenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new Presenter.SaveState(paramAnonymousParcel);
      }

      public Presenter.SaveState[] a(int paramAnonymousInt)
      {
        return new Presenter.SaveState[paramAnonymousInt];
      }
    };
    final boolean contentWasSwitched;
    final boolean firstLoad;
    final SelectMediaViewData selectMediaViewData;
    final int selectedItemPosition;
    final int selectedItemsType;

    protected SaveState(Parcel paramParcel)
    {
      this.selectMediaViewData = ((SelectMediaViewData)paramParcel.readParcelable(SelectMediaViewData.class.getClassLoader()));
      boolean bool2;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.firstLoad = bool2;
        this.selectedItemsType = paramParcel.readInt();
        this.selectedItemPosition = paramParcel.readInt();
        if (paramParcel.readByte() == 0)
          break label70;
      }
      while (true)
      {
        this.contentWasSwitched = bool1;
        return;
        bool2 = false;
        break;
        label70: bool1 = false;
      }
    }

    public SaveState(SelectMediaViewData paramSelectMediaViewData, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
    {
      this.selectMediaViewData = paramSelectMediaViewData;
      this.firstLoad = paramBoolean1;
      this.selectedItemsType = paramInt1;
      this.selectedItemPosition = paramInt2;
      this.contentWasSwitched = paramBoolean2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b1 = 1;
      paramParcel.writeParcelable(this.selectMediaViewData, paramInt);
      byte b2;
      if (this.firstLoad)
      {
        b2 = b1;
        paramParcel.writeByte(b2);
        paramParcel.writeInt(this.selectedItemsType);
        paramParcel.writeInt(this.selectedItemPosition);
        if (!this.contentWasSwitched)
          break label62;
      }
      while (true)
      {
        paramParcel.writeByte(b1);
        return;
        b2 = 0;
        break;
        label62: b1 = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.Presenter
 * JD-Core Version:    0.6.2
 */