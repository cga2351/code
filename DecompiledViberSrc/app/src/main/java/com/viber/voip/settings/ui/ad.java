package com.viber.voip.settings.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.widget.Toast;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.l;
import com.viber.voip.settings.d.a;
import com.viber.voip.settings.d.bj;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.dialogs.DialogCode;

public class ad extends SettingsHeadersActivity.a
{
  private static final Logger b = ViberEnv.getLogger();
  private volatile int c;
  private volatile int d;
  private final Handler e = av.a(av.e.a);
  private b f = new b()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
    }

    public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      ad.a(ad.this);
      ad.a(ad.this, -1);
    }

    public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      ad.a(ad.this, -1);
    }

    public void onStickerPackageDownloadScheduled(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      ad.a(ad.this, 1);
    }

    public void onStickerPackageDownloadStarted(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloading(com.viber.voip.stickers.entity.a paramAnonymousa, int paramAnonymousInt)
    {
    }
  };
  private Runnable g = new Runnable()
  {
    public void run()
    {
      ad.b(ad.this);
      ad localad = ad.this;
      if (ad.c(ad.this) > 0);
      for (int i = R.string.restore_msg_stickers_restored; ; i = R.string.restore_msg_no_stickers_restored)
      {
        ad.b(localad, i);
        return;
      }
    }
  };

  private void c(int paramInt)
  {
    this.e.removeCallbacks(this.g);
    this.c = (paramInt + this.c);
    if (this.c <= 0)
      this.e.postDelayed(this.g, 1000L);
  }

  private void d(int paramInt)
  {
    if ((isAdded()) && (!isRemoving()))
    {
      z.a(this, DialogCode.D_PROGRESS_OVERLAY);
      String str = getString(paramInt);
      Toast.makeText(getActivity(), str, 1).show();
    }
  }

  private void j()
  {
    boolean bool = k();
    a(d.a.h.c()).a(bool);
    a(d.a.i.c()).a(bool);
  }

  private boolean k()
  {
    long l = d.bj.r.d();
    if (System.currentTimeMillis() - l > 3600000L);
    while (d.bj.s.d() < 2)
      return true;
    return false;
  }

  private void l()
  {
    long l1 = d.bj.r.d();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 3600000L)
    {
      d.bj.r.a(l2);
      d.bj.s.a(1);
    }
    while (true)
    {
      j();
      return;
      int i = d.bj.s.d();
      if (i < 2)
      {
        int j = i + 1;
        d.bj.s.a(j);
      }
    }
  }

  private void m()
  {
    i.a().b(this.f);
  }

  private void n()
  {
    l();
    com.viber.voip.ui.dialogs.ad.c().b(this);
    this.c = 0;
    this.d = 0;
    p();
    l.a(new ae(this), true);
  }

  private void o()
  {
    l();
    com.viber.voip.ui.dialogs.ad.c().b(this);
    l.a(new af(this));
  }

  private void p()
  {
    i.a().a(this.f);
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (d.a.h.c().equals(str))
      o();
    while (true)
    {
      return true;
      if (d.a.i.c().equals(str))
        n();
    }
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_purchases, paramString);
    j();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ad
 * JD-Core Version:    0.6.2
 */