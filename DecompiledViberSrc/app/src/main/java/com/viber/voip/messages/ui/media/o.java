package com.viber.voip.messages.ui.media;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.CdrConst.OriginalScreen;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.an.a;
import com.viber.voip.an.c;
import com.viber.voip.util.dj;
import java.util.Locale;

public class o extends k
  implements View.OnClickListener, ViewMediaActivity.a
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private b c;
  private boolean d = false;
  private boolean e;
  private int f;
  private k.a g;

  private void a(View paramView)
  {
    Bundle localBundle = getArguments();
    Uri localUri = a((Uri)localBundle.getParcelable("extra_uri"));
    String str = localBundle.getString("camera_image");
    an.c localc = this.g.a(this.f, localUri, str);
    if (localc != null);
    for (Bitmap localBitmap = localc.e.a; ; localBitmap = null)
    {
      this.b = new a(paramView, localBitmap);
      if (!e())
        a(g());
      this.b.d.setOnClickListener(this);
      if (!((ViewMediaActivity)getActivity()).g())
        break;
      this.b.a(false);
      return;
    }
    this.b.a(true);
  }

  private Intent h()
  {
    if (getActivity() != null)
      return getActivity().getIntent();
    return null;
  }

  public void a()
  {
    this.b.a(false);
    if (this.c != null)
      this.c.b();
  }

  public void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.b.a(true);
      ((ViewMediaActivity)getActivity()).h(this.d);
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
  }

  protected void a(Bundle paramBundle)
  {
    this.c = new b(null);
    if (this.d)
      this.c.a();
    do
    {
      return;
      if ((h() != null) && (h().getBooleanExtra("with_splash", false)))
      {
        h().removeExtra("with_splash");
        this.c.a();
        return;
      }
    }
    while ((paramBundle == null) || (!paramBundle.getBoolean("splash_visibility")));
    this.c.a();
  }

  public void a(String paramString)
  {
    this.b.b.setImageBitmap(null);
    this.b.a.setVisibility(0);
    this.b.a.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }

  public void b()
  {
    this.b.a(false);
  }

  public void b(int paramInt)
  {
    if ((this.d) && (this.c != null))
      this.c.b();
  }

  public void b(boolean paramBoolean)
  {
    if (e())
    {
      a(0);
      a locala = this.b;
      boolean bool = false;
      if (!paramBoolean)
        bool = true;
      locala.a(bool);
      return;
    }
    a(g());
  }

  public void c()
  {
    if (this.c != null)
      this.c.a();
  }

  public void d()
  {
    if (this.c != null)
      this.c.b();
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.g = ((k.a)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    throw new ClassCastException(paramActivity.toString() + " must implement ViewMediaFragmentCallback");
  }

  public void onClick(View paramView)
  {
    if (getActivity() == null);
    int i;
    do
    {
      do
      {
        do
        {
          return;
          i = paramView.getId();
          if (i == R.id.play_again)
          {
            if (this.c != null)
              this.c.b();
            ((ViewMediaActivity)getActivity()).r();
            return;
          }
          if (i == R.id.forward_via_viber)
          {
            ((ViewMediaActivity)getActivity()).f(true);
            return;
          }
          if (i == R.id.share)
          {
            ((ViewMediaActivity)getActivity()).g(true);
            return;
          }
          if (i != R.id.close)
            break;
        }
        while (this.c == null);
        this.c.b();
        return;
        if (i == R.id.home_button)
        {
          getActivity().finish();
          return;
        }
        if (i == R.id.remove)
        {
          ((ViewMediaActivity)getActivity()).e(true);
          return;
        }
        if (i != R.id.chat_media)
          break;
        ((ViewMediaActivity)getActivity()).v();
      }
      while (this.c == null);
      this.c.b();
      return;
    }
    while (i != R.id.mainLayout);
    ((ViewMediaActivity)getActivity()).k();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.c != null)
      b.a(this.c);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = getArguments().getInt("fragmentPosition");
    ((ViewMediaActivity)getActivity()).a(this.f, this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.view_video_layout, paramViewGroup, false);
    a(localView);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.e = localBundle.getBoolean("can_navigate_to_gallery", false);
      if (localBundle.getBoolean("show_splash", true))
        a(paramBundle);
    }
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ((ViewMediaActivity)getActivity()).a(this.f);
    if ((this.d) && (this.c != null))
      this.c.b();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("splash_visibility", this.d);
  }

  protected static class a
  {
    final TextView a;
    final ImageView b;
    final ImageView c;
    final ViewGroup d;
    final View e;

    protected a(View paramView, Bitmap paramBitmap)
    {
      this.a = ((TextView)paramView.findViewById(R.id.media_loading_text));
      this.b = ((ImageView)paramView.findViewById(R.id.thumbnail));
      this.c = ((ImageView)paramView.findViewById(R.id.loading_icon));
      this.d = ((ViewGroup)paramView.findViewById(R.id.mainLayout));
      this.e = paramView.findViewById(R.id.thumb_background);
      if (paramBitmap != null)
        a(paramBitmap);
    }

    private void a(Bitmap paramBitmap)
    {
      if (paramBitmap != null)
      {
        this.b.setBackgroundResource(R.color.solid_80);
        this.b.setImageBitmap(paramBitmap);
        this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
    }

    public ViewGroup a()
    {
      return this.d;
    }

    public void a(boolean paramBoolean)
    {
      View localView = this.e;
      int i;
      ImageView localImageView;
      int j;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
        localImageView = this.b;
        j = 0;
        if (!paramBoolean)
          break label43;
      }
      while (true)
      {
        localImageView.setVisibility(j);
        return;
        i = 8;
        break;
        label43: j = 8;
      }
    }
  }

  private class b
  {
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;

    private b()
    {
    }

    private void c()
    {
      ViewGroup localViewGroup = o.b(o.this).a();
      localViewGroup.removeView(localViewGroup.findViewById(R.id.video_splash_layout));
      this.b = null;
    }

    private void d()
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)o.this.getActivity().getSystemService("layout_inflater");
      ViewGroup localViewGroup = o.b(o.this).a();
      View localView1 = localViewGroup.findViewById(R.id.video_splash_layout);
      this.b = localView1;
      if (localView1 == null)
        this.b = localLayoutInflater.inflate(R.layout.video_actions_splash, localViewGroup, true);
      this.b.setVisibility(8);
      this.c = this.b.findViewById(R.id.play_again);
      this.d = this.b.findViewById(R.id.forward_via_viber);
      this.e = this.b.findViewById(R.id.share);
      this.l = ((TextView)this.b.findViewById(R.id.txt_media_count));
      this.k = this.b.findViewById(R.id.close);
      this.f = this.b.findViewById(R.id.remove);
      this.g = this.b.findViewById(R.id.chat_media);
      this.m = ((TextView)this.b.findViewById(R.id.txt_conversation_name));
      this.h = this.b.findViewById(R.id.home_button);
      this.i = this.b.findViewById(R.id.txt_share);
      this.j = this.b.findViewById(R.id.txt_forward_via_viber);
      View localView2 = this.g;
      if (o.c(o.this));
      for (int n = 0; ; n = 8)
      {
        localView2.setVisibility(n);
        this.c.setOnClickListener(o.this);
        this.d.setOnClickListener(o.this);
        this.e.setOnClickListener(o.this);
        this.k.setOnClickListener(o.this);
        this.f.setOnClickListener(o.this);
        if (o.c(o.this))
          this.g.setOnClickListener(o.this);
        this.l.setOnClickListener(o.this);
        this.h.setOnClickListener(o.this);
        this.b.setOnClickListener(o.this);
        return;
      }
    }

    public void a()
    {
      if (!o.a(o.this))
      {
        int i2 = CdrConst.OriginalScreen.fromConversationType(((ViewMediaActivity)o.this.getActivity()).j());
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportScreenDisplay(3, i2);
      }
      o.a(o.this, true);
      if (this.b == null)
        d();
      this.b.setVisibility(0);
      int n = ((ViewMediaActivity)o.this.getActivity()).s();
      int i1 = ((ViewMediaActivity)o.this.getActivity()).i();
      CharSequence localCharSequence = ((ViewMediaActivity)o.this.getActivity()).q();
      String str = o.this.getActivity().getResources().getString(R.string.video_splash_video_count);
      TextView localTextView = this.l;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(n - i1);
      arrayOfObject[1] = Integer.valueOf(n);
      localTextView.setText(String.format(localLocale, str, arrayOfObject));
      this.m.setText(localCharSequence);
      dj.b(this.f, ((ViewMediaActivity)o.this.getActivity()).t());
      a(((ViewMediaActivity)o.this.getActivity()).u());
      ((ViewMediaActivity)o.this.getActivity()).h(true);
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.e.setVisibility(0);
        this.i.setVisibility(0);
        this.d.setVisibility(0);
        this.j.setVisibility(0);
        return;
      }
      this.e.setVisibility(8);
      this.i.setVisibility(8);
      this.d.setVisibility(8);
      this.j.setVisibility(8);
    }

    public void b()
    {
      o.a(o.this, false);
      ((ViewMediaActivity)o.this.getActivity()).h(false);
      c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.o
 * JD-Core Version:    0.6.2
 */