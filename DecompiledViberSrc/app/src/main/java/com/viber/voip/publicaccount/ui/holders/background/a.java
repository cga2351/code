package com.viber.voip.publicaccount.ui.holders.background;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.p;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.settings.d.i;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.at;
import com.viber.voip.util.ay;
import com.viber.voip.util.ay.a;
import com.viber.voip.util.cb;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;

public class a extends PublicAccountEditUIHolder<BackgroundData, c>
  implements View.OnClickListener, com.viber.voip.messages.extras.image.a.a, cb, h.a
{
  private static final Logger c = ViberEnv.getLogger();
  private final Fragment d;
  private final com.viber.voip.publicaccount.ui.holders.d e;
  private final com.viber.voip.messages.extras.image.a f;
  private final e g;
  private final f h;
  private final GroupController i;
  private final Handler j;
  private com.viber.common.dialogs.m k;

  public a(Fragment paramFragment, com.viber.voip.publicaccount.ui.holders.d paramd)
  {
    this.d = paramFragment;
    this.e = paramd;
    this.f = com.viber.voip.messages.extras.image.a.a();
    Context localContext = this.d.getContext();
    this.g = e.a(localContext);
    this.h = f.a(localContext);
    this.i = ViberApplication.getInstance().getMessagesManager().d();
    this.j = av.e.f.a();
  }

  private void a(Intent paramIntent, Uri paramUri)
  {
    int m;
    if (paramIntent != null)
    {
      m = paramIntent.getIntExtra("backgroundId", -1);
      if ((paramIntent == null) || (!paramIntent.getBooleanExtra("is_tile", false)))
        break label44;
    }
    label44: for (boolean bool1 = true; ; bool1 = false)
    {
      if ((paramUri != null) || (m != -1))
        break label50;
      return;
      m = -1;
      break;
    }
    label50: if (m > -1)
    {
      ((BackgroundData)this.a).setDefaultBackground(m, bool1);
      b(m);
    }
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.e.a(this, bool2);
      return;
      ((BackgroundData)this.a).setNonProcessedCustomBackground(paramUri);
      b(paramUri);
    }
  }

  private void a(Uri paramUri)
  {
    this.g.a(paramUri, this.h, this);
  }

  private void a(final String paramString)
  {
    this.j.post(new Runnable()
    {
      public void run()
      {
        Uri[] arrayOfUri = com.viber.voip.backgrounds.b.a().a(paramString);
        a.a(a.this, arrayOfUri[0]);
      }
    });
  }

  private void b(int paramInt)
  {
    this.j.post(new b(this, paramInt));
  }

  private void b(Uri paramUri)
  {
    g();
    this.f.a(this);
    this.f.a(2, this.d.getContext(), new Uri[] { paramUri }, "image", dv.h, 1000, -1);
  }

  private void f()
  {
    String str = d.i.d.d();
    p localp = com.viber.voip.backgrounds.m.a(str, 0);
    if (localp != null)
    {
      b(localp.a);
      return;
    }
    b(Uri.parse(str));
  }

  private void g()
  {
    if (this.k == null)
      this.k = ad.b().b(this.d);
  }

  private void h()
  {
    if (this.k != null)
    {
      this.k.dismiss();
      this.k = null;
    }
  }

  public void a()
  {
    super.a();
    this.f.b(this);
  }

  public void a(int paramInt1, SendMediaDataContainer paramSendMediaDataContainer, int paramInt2, int paramInt3)
  {
  }

  public void a(int paramInt, SendMediaDataContainer[] paramArrayOfSendMediaDataContainer)
  {
    h();
    if (paramArrayOfSendMediaDataContainer != null);
    for (SendMediaDataContainer localSendMediaDataContainer = paramArrayOfSendMediaDataContainer[0]; ; localSendMediaDataContainer = null)
    {
      if ((paramInt == 2) && (localSendMediaDataContainer != null))
      {
        this.f.b(this);
        Context localContext = this.d.getContext();
        if (dv.a(localSendMediaDataContainer.fileUri, dv.g, localContext))
          at.d(localContext, localSendMediaDataContainer.fileUri);
        ((BackgroundData)this.a).setCustomBackground(localSendMediaDataContainer.croppedImage);
        a(((BackgroundData)this.a).mBackgroundUri);
        this.e.a(this, true);
      }
      return;
    }
  }

  protected void a(BackgroundData paramBackgroundData, c paramc)
  {
  }

  protected void a(c paramc, BackgroundData paramBackgroundData)
  {
    if (paramBackgroundData.mBackgroundUri != null)
    {
      a(paramBackgroundData.mBackgroundUri);
      return;
    }
    if (paramBackgroundData.mNonProcessedBackgroundUri != null)
    {
      b(paramBackgroundData.mNonProcessedBackgroundUri);
      return;
    }
    if (!da.a(paramBackgroundData.mBackgroundId))
    {
      Pair localPair = com.viber.voip.backgrounds.m.e(paramBackgroundData.mBackgroundId);
      if (((Integer)localPair.first).intValue() > -1)
      {
        b(((Integer)localPair.first).intValue());
        return;
      }
      a(paramBackgroundData.mBackgroundId);
      return;
    }
    f();
  }

  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 101)
    {
      if ((paramInt2 != 0) && (paramIntent != null))
        a(paramIntent, ay.a(this.d.getActivity(), paramIntent, null).b);
      return true;
    }
    return false;
  }

  protected Class<c> b()
  {
    return c.class;
  }

  protected c c(View paramView)
  {
    return new d(paramView, this);
  }

  protected BackgroundData e()
  {
    return new BackgroundData();
  }

  public void onClick(View paramView)
  {
    this.d.startActivityForResult(new Intent("com.viber.voip.action.SELECT_VIBE_BACKGROUND"), 101);
  }

  public void onLoadComplete(Uri paramUri, final Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.d.isAdded())
      av.e.a.a().post(new Runnable()
      {
        public void run()
        {
          if (paramBitmap != null)
          {
            ((c)a.a(a.this)).a(paramBitmap);
            return;
          }
          a.b(a.this);
        }
      });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.background.a
 * JD-Core Version:    0.6.2
 */