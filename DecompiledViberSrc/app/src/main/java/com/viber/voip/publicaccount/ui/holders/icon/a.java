package com.viber.voip.publicaccount.ui.holders.icon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.util.at;
import com.viber.voip.util.ay;
import com.viber.voip.util.ay.a;
import com.viber.voip.util.cb;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;

public class a extends PublicAccountEditUIHolder<IconData, b>
  implements cb
{
  private static final Logger d = ViberEnv.getLogger();
  View.OnClickListener c = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      a.c(a.this);
    }
  };
  private final Fragment e;
  private final d f;
  private com.viber.voip.util.e.e g;
  private f h;
  private final boolean i;
  private h.a j;
  private final com.viber.common.permission.c k;
  private final com.viber.common.permission.b l;

  public a(Fragment paramFragment, d paramd, boolean paramBoolean)
  {
    this.e = paramFragment;
    this.f = paramd;
    this.i = paramBoolean;
    this.g = com.viber.voip.util.e.e.a(this.e.getContext());
    this.h = f.a(R.drawable.ic_vibe_loading);
    this.k = com.viber.common.permission.c.a(this.e.getActivity());
    Fragment localFragment = this.e;
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(12);
    this.l = new com.viber.voip.permissions.e(localFragment, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        ((IconData)a.a(a.this)).mImageCameraUri = ay.c(a.b(a.this), 100);
      }
    };
  }

  private void a(Intent paramIntent)
  {
    Uri localUri1 = Uri.parse(paramIntent.getAction());
    ((IconData)this.a).mIconUri = localUri1;
    IconData localIconData = (IconData)this.a;
    if (localUri1 != null);
    for (boolean bool = true; ; bool = false)
    {
      localIconData.mIconValid = bool;
      a(localUri1, true);
      Uri localUri2 = (Uri)paramIntent.getParcelableExtra("originalUri");
      Context localContext = this.e.getContext();
      if (dv.a(localUri2, dv.g, localContext))
        at.d(localContext, localUri2);
      return;
    }
  }

  private void a(Uri paramUri, final boolean paramBoolean)
  {
    if (paramUri != null)
    {
      this.j = new h.a()
      {
        public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
        {
          ((b)a.d(a.this)).a(paramAnonymousBitmap);
          if (!a.e(a.this))
            ((b)a.f(a.this)).b();
          if (paramBoolean)
            a.g(a.this).a(a.this, true);
          a.h(a.this);
          a.a(a.this, null);
        }
      };
      this.g.a(paramUri, this.h, this.j);
    }
  }

  private void a(ay.a parama)
  {
    Intent localIntent = ay.a(this.e.getActivity(), parama, 400, 400);
    if (localIntent != null)
      this.e.startActivityForResult(localIntent, 103);
  }

  private void f()
  {
    if (((IconData)this.a).mIconValid)
      this.f.a(this, true);
  }

  private void g()
  {
    if (this.k.a(n.b))
    {
      ((IconData)this.a).mImageCameraUri = ay.c(this.e, 100);
      return;
    }
    this.k.a(this.e, 12, n.b);
  }

  public void a()
  {
    super.a();
    this.k.b(this.l);
  }

  public void a(View paramView)
  {
    super.a(paramView);
    this.k.a(this.l);
  }

  protected void a(IconData paramIconData, b paramb)
  {
  }

  protected void a(b paramb, IconData paramIconData)
  {
    if (((IconData)this.a).mIsVisibleForUser)
    {
      ((b)this.b).a(true);
      if (((IconData)this.a).mIconValid)
        a(((IconData)this.a).mIconUri, false);
      return;
    }
    ((b)this.b).a(false);
  }

  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 100) || (paramInt1 == 103))
    {
      if (paramInt2 != 0)
      {
        ay.a locala = ay.a(this.e.getActivity(), paramIntent, ((IconData)this.a).mImageCameraUri);
        if (paramInt1 != 100)
          break label53;
        a(locala);
      }
      while (true)
      {
        return true;
        label53: a(paramIntent);
      }
    }
    return false;
  }

  protected Class<b> b()
  {
    return b.class;
  }

  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    f();
  }

  protected b c(View paramView)
  {
    return new c(paramView, this.c);
  }

  protected IconData e()
  {
    return new IconData();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.icon.a
 * JD-Core Version:    0.6.2
 */