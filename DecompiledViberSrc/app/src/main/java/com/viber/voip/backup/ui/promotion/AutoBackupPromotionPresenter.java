package com.viber.voip.backup.ui.promotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.analytics.story.StoryConstants.c.a;
import com.viber.voip.backup.ui.a.b.b.a;
import com.viber.voip.util.cl;

class AutoBackupPromotionPresenter
{
  private final d a = (d)cl.b(d.class);
  private final com.viber.voip.backup.b b;
  private final com.viber.voip.backup.ui.a.b.b c;
  private final com.viber.voip.analytics.story.g.a d;
  private final c e;
  private final b.a f = new b.a()
  {
    public void a(int paramAnonymousInt)
    {
      AutoBackupPromotionPresenter.a(AutoBackupPromotionPresenter.this);
    }

    public void a(int paramAnonymousInt1, int paramAnonymousInt2)
    {
    }
  };
  private d g = this.a;
  private com.viber.voip.backup.a h = com.viber.voip.backup.a.a;

  public AutoBackupPromotionPresenter(com.viber.voip.backup.b paramb, com.viber.voip.backup.ui.a.b.b paramb1, com.viber.voip.analytics.story.g.a parama, c paramc)
  {
    this.b = paramb;
    this.c = paramb1;
    this.d = parama;
    this.e = paramc;
  }

  private void h()
  {
    this.b.a(this.h);
    this.d.a(StoryConstants.c.a.a(this.h), "Backup Promo Screen");
    this.e.a();
  }

  public void a()
  {
    this.c.a();
  }

  public void a(int paramInt)
  {
    this.h = com.viber.voip.backup.a.a(paramInt);
    c();
  }

  public void a(d paramd, Parcelable paramParcelable)
  {
    this.g = paramd;
    if ((paramParcelable instanceof SaveState))
      this.h = ((SaveState)paramParcelable).getSelectedPeriod();
    paramd.a(this.h.d(), com.viber.voip.backup.a.e());
    this.c.a(this.f);
  }

  public void b()
  {
    this.c.b();
  }

  public void c()
  {
    d locald = this.g;
    if (this.h != com.viber.voip.backup.a.a);
    for (boolean bool = true; ; bool = false)
    {
      locald.a(bool);
      return;
    }
  }

  public void d()
  {
    switch (2.a[this.h.ordinal()])
    {
    default:
      if (this.c.h())
        h();
      break;
    case 1:
      return;
    case 2:
      h();
      return;
    }
    this.c.a(1000);
  }

  public Parcelable e()
  {
    return new SaveState(this.h);
  }

  public boolean f()
  {
    this.g.a();
    return true;
  }

  public void g()
  {
    this.g = this.a;
    this.c.a(null);
  }

  static class SaveState
    implements Parcelable
  {
    public static final Parcelable.Creator<SaveState> CREATOR = new Parcelable.Creator()
    {
      public AutoBackupPromotionPresenter.SaveState a(Parcel paramAnonymousParcel)
      {
        return new AutoBackupPromotionPresenter.SaveState(paramAnonymousParcel);
      }

      public AutoBackupPromotionPresenter.SaveState[] a(int paramAnonymousInt)
      {
        return new AutoBackupPromotionPresenter.SaveState[paramAnonymousInt];
      }
    };
    private final com.viber.voip.backup.a mSelectedPeriod;

    protected SaveState(Parcel paramParcel)
    {
      this.mSelectedPeriod = com.viber.voip.backup.a.a(paramParcel.readLong());
    }

    public SaveState(com.viber.voip.backup.a parama)
    {
      this.mSelectedPeriod = parama;
    }

    public int describeContents()
    {
      return 0;
    }

    public com.viber.voip.backup.a getSelectedPeriod()
    {
      return this.mSelectedPeriod;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.mSelectedPeriod.a());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.promotion.AutoBackupPromotionPresenter
 * JD-Core Version:    0.6.2
 */