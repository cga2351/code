package com.viber.voip.widget.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class a extends LinearLayout
{
  public static b a = new b(R.drawable.ic_undobar_undo, R.string.undo, 5000L, 0);
  private final View b;
  private final TextView c;
  private final TextView d;
  private final Handler e = new Handler();
  private a f;
  private b g = a;
  private d h;
  private Parcelable i;
  private CharSequence j;
  private final Runnable k = new Runnable()
  {
    public void run()
    {
      a.a(a.this, false);
    }
  };

  private a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.undobar, this, true);
    this.b = findViewById(R.id._undobar);
    this.c = ((TextView)findViewById(R.id.undobar_message));
    this.d = ((TextView)findViewById(R.id.undobar_button));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.a(a.this) != null)
          a.a(a.this).a(a.b(a.this));
        a.a(a.this, false);
      }
    });
    this.h = new d(getContext());
    a(true);
  }

  private static Animation a(Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    return localAlphaAnimation;
  }

  private static a a(View paramView)
  {
    View localView = paramView.findViewById(R.id._undobar);
    a locala = null;
    if (localView != null)
      locala = (a)localView.getParent();
    return locala;
  }

  public static a a(View paramView, CharSequence paramCharSequence, a parama, Parcelable paramParcelable, boolean paramBoolean, b paramb)
  {
    Object localObject = a(paramView);
    if (localObject == null)
    {
      a locala = new a(paramView.getContext(), null);
      ((ViewGroup)paramView.findViewById(16908290)).addView(locala);
      localObject = locala;
    }
    ((a)localObject).g = paramb;
    ((a)localObject).setUndoListener(parama);
    ((a)localObject).a(paramBoolean, paramCharSequence, paramParcelable);
    return localObject;
  }

  public static a a(View paramView, CharSequence paramCharSequence, a parama, b paramb)
  {
    return a(paramView, paramCharSequence, parama, null, false, paramb);
  }

  private void a(boolean paramBoolean)
  {
    this.e.removeCallbacks(this.k);
    this.i = null;
    if (paramBoolean)
    {
      setVisibility(8);
      return;
    }
    clearAnimation();
    startAnimation(a(null));
    setVisibility(8);
  }

  private void a(boolean paramBoolean, CharSequence paramCharSequence, Parcelable paramParcelable)
  {
    this.i = paramParcelable;
    this.j = paramCharSequence;
    this.c.setText(this.j);
    if (this.g.b > 0)
    {
      this.d.setVisibility(0);
      this.d.setText(this.g.b);
      this.h.d(this.g.d);
      if (!com.viber.common.d.a.a())
        break label171;
      this.b.setBackground(((c)this.h.a()).a());
    }
    while (true)
    {
      this.e.removeCallbacks(this.k);
      if (this.g.c > 0L)
        this.e.postDelayed(this.k, this.g.c);
      if (!paramBoolean)
      {
        clearAnimation();
        startAnimation(b(null));
      }
      setVisibility(0);
      return;
      this.d.setVisibility(8);
      break;
      label171: this.b.setBackgroundDrawable(((c)this.h.a()).a());
    }
  }

  private static Animation b(Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    return localAlphaAnimation;
  }

  private void setUndoListener(a parama)
  {
    this.f = parama;
  }

  public a getUndoListener()
  {
    return this.f;
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.j = localBundle.getCharSequence("undo_message");
      this.i = localBundle.getParcelable("undo_token");
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("undo_message", this.j);
    localBundle.putParcelable("undo_token", this.i);
    return localBundle;
  }

  public static abstract interface a
  {
    public abstract void a(Parcelable paramParcelable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.c.a
 * JD-Core Version:    0.6.2
 */