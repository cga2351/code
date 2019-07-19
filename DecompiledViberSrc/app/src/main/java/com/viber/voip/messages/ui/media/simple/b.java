package com.viber.voip.messages.ui.media.simple;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.z;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch.b;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.h.a;
import java.io.File;

public class b extends e
{
  private View c;
  private ImageViewTouch d;
  private View e;
  private TextView f;
  private ProgressBar g;
  private boolean h;
  private String i;
  private h.a j = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        b.a(b.this).setVisibility(8);
        b.a(b.this).setOnClickListener(null);
        b.c(b.this).setOnClickListener(b.b(b.this));
        b.d(b.this).setVisibility(0);
        b.e(b.this).setVisibility(0);
        b.f(b.this).setVisibility(8);
        b.d(b.this).setText(R.string.dialog_download_fail);
        b.this.b.a(b.g(b.this));
        return;
      }
      b.a(b.this).setVisibility(0);
      b.c(b.this).setOnClickListener(null);
      b.a(b.this).setOnClickListener(b.b(b.this));
      b.a(b.this).setExternalScrollListener(b.h(b.this));
      b.d(b.this).setVisibility(8);
      b.e(b.this).setVisibility(8);
      b.a(b.this).a(paramAnonymousBitmap, true);
      b.this.b.a(b.g(b.this), paramAnonymousUri);
    }
  };
  private y.a k = new y.a()
  {
    public void a(ImageView paramAnonymousImageView, pl.droidsonroids.gif.b paramAnonymousb)
    {
      z.a(this, paramAnonymousImageView, paramAnonymousb);
    }

    public void a(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      if (paramAnonymousb == null)
      {
        b.a(b.this).setOnClickListener(null);
        b.c(b.this).setOnClickListener(b.b(b.this));
        b.this.b.a(b.g(b.this));
      }
      do
      {
        return;
        b.c(b.this).setOnClickListener(null);
        b.a(b.this).setVisibility(0);
        b.a(b.this).setOnClickListener(b.b(b.this));
        b.e(b.this).setVisibility(8);
        b.a(b.this).setScaleType(ImageView.ScaleType.CENTER);
        b.a(b.this).setAdjustViewBounds(true);
        b.a(b.this).getLayoutParams().width = -1;
        b.a(b.this).getLayoutParams().height = -1;
        b.this.b.a(b.g(b.this), paramAnonymousUri);
      }
      while ((paramAnonymousb.getIntrinsicWidth() <= 0) || (paramAnonymousb.getIntrinsicHeight() <= 0));
      b.this.b.a(b.g(b.this), paramAnonymousb.getIntrinsicWidth(), paramAnonymousb.getIntrinsicHeight());
    }

    public void b(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      z.a(this, paramAnonymousb, paramAnonymousString, paramAnonymousUri);
    }
  };
  private ImageViewTouch.b l = new ImageViewTouch.b()
  {
    public void a(boolean paramAnonymousBoolean)
    {
      b.this.b.a(paramAnonymousBoolean);
    }
  };
  private View.OnClickListener m = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (b.this.a.h())
      {
        b.this.a.g();
        return;
      }
      b.this.a.f();
    }
  };

  public static b a(String paramString, int paramInt)
  {
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putString("media_url", paramString);
    localBundle.putInt("media_type", paramInt);
    localb.setArguments(localBundle);
    return localb;
  }

  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Uri localUri = Uri.parse(this.i);
    File localFile = dv.a.b(localFragmentActivity, localUri.toString(), false);
    if ((localFile != null) && (localFile.exists()))
      localUri = Uri.fromFile(localFile);
    if (this.h)
    {
      y.a().a(localUri, this.d, this.k);
      return;
    }
    com.viber.voip.util.e.e.a(getActivity()).a(localUri, new f.a().a(1280, 1280).c(), this.j);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_view_image_simple, null);
    this.c = localView.findViewById(R.id.root);
    this.c.setOnClickListener(this.m);
    this.d = ((ImageViewTouch)localView.findViewById(R.id.image));
    this.e = localView.findViewById(R.id.loading);
    this.g = ((ProgressBar)localView.findViewById(R.id.media_loading_progress_bar));
    this.f = ((TextView)localView.findViewById(R.id.media_loading_text));
    if (1005 == getArguments().getInt("media_type"));
    for (boolean bool = true; ; bool = false)
    {
      this.h = bool;
      this.i = getArguments().getString("media_url");
      return localView;
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((!getUserVisibleHint()) && (this.d != null))
      this.d.b(1.0F);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.b
 * JD-Core Version:    0.6.2
 */