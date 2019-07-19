package com.viber.voip.viberout.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.GestureDetectorCompat;
import android.text.TextUtils;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.b.g;
import com.viber.voip.billing.f;
import com.viber.voip.messages.extras.map.BalloonLayout;
import com.viber.voip.util.bs;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends ScrollView
{
  private static final Logger a = ViberEnv.getLogger();
  private GestureDetectorCompat b;
  private View c;
  private View d;
  private View e;
  private List<View> f = new ArrayList();
  private a g;
  private View.OnClickListener h = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = paramAnonymousView.getId();
      String str1;
      IabProductId localIabProductId;
      if (i == R.id.google_play_btn)
      {
        str1 = a.this.getContext().getString(R.string.google_play_option);
        localIabProductId = (IabProductId)a.b(a.this).getTag();
      }
      while (true)
      {
        if (!TextUtils.isEmpty(str1))
        {
          if (i != R.id.credit_card_btn)
            break label189;
          String str2 = localIabProductId.toString();
          if (!TextUtils.isEmpty(str2))
            CreditCardCheckoutWebActivity.a(str2, a.a(a.this).b());
        }
        while (true)
        {
          if (a.a(a.this) != null)
            a.a(a.this).a(localIabProductId);
          return;
          if (i == R.id.credit_card_btn)
          {
            str1 = a.this.getContext().getString(R.string.credit_card_option);
            localIabProductId = (IabProductId)a.c(a.this).getTag();
            break;
          }
          if (i != R.id.amazon_btn)
            break label233;
          str1 = a.this.getContext().getString(R.string.amazon_option);
          localIabProductId = (IabProductId)a.d(a.this).getTag();
          break;
          label189: if (!TextUtils.isEmpty(localIabProductId.getJson()))
            ViberOutDialogs.a(localIabProductId.getJson(), a.a(a.this).c(), a.a(a.this).b());
        }
        label233: localIabProductId = null;
        str1 = null;
      }
    }
  };

  public a(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    setClickable(true);
    setBackgroundResource(R.color.solid_60);
    View localView = LayoutInflater.from(getContext()).inflate(R.layout.checkout_dialog_layout, this, true);
    this.c = localView.findViewById(R.id.google_play_btn);
    this.d = localView.findViewById(R.id.credit_card_btn);
    this.e = localView.findViewById(R.id.amazon_btn);
    this.f.add(this.c);
    this.f.add(this.d);
    this.f.add(this.e);
    findViewById(R.id.overlay_message).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
      }
    });
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((View)localIterator.next()).setOnClickListener(this.h);
    ((BalloonLayout)localView.findViewById(R.id.overlay_content)).setMaxWidth(getContext().getResources().getDimensionPixelSize(R.dimen.checkout_dialog_overlay_width));
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.a(a.this) != null)
          a.a(a.this).a();
      }
    });
    this.b = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }

      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        a.this.performClick();
        return true;
      }
    });
    this.b.setOnDoubleTapListener(null);
  }

  public boolean a(b.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    f[] arrayOff = paramg.d();
    int i = arrayOff.length;
    int j = 0;
    if (j < i)
    {
      f localf = arrayOff[j];
      if (("google_play".equals(localf.b().getProviderId())) && (paramg.c() == null))
      {
        localArrayList.add(this.c);
        this.c.setTag(localf.b());
      }
      while (true)
      {
        j++;
        break;
        if ("credit_card".equals(localf.b().getProviderId()))
        {
          localArrayList.add(this.d);
          this.d.setTag(localf.b());
        }
        else if (("amazon".equals(localf.b().getProviderId())) && (bs.a()))
        {
          localArrayList.add(this.e);
          this.e.setTag(localf.b());
        }
      }
    }
    boolean bool1 = localArrayList.isEmpty();
    boolean bool2 = false;
    if (!bool1)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        dj.b(localView, localArrayList.contains(localView));
      }
      bool2 = true;
    }
    return bool2;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.b.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setOnStoreItemSelectedListener(a parama)
  {
    this.g = parama;
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(IabProductId paramIabProductId);

    public abstract boolean b();

    public abstract boolean c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.a
 * JD-Core Version:    0.6.2
 */