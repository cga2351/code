package com.viber.voip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.messages.conversation.adapter.d;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.ui.af;
import com.viber.voip.ui.af.a;
import com.viber.voip.ui.af.c;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;

public class ConversationListView extends af
{
  private static final Logger v = ViberEnv.getLogger();
  private TextView A;
  private final float B = getResources().getDimension(R.dimen.caller_container_default_size);
  private float C;
  private float D;
  private boolean E = false;
  private boolean F;
  private boolean G = false;
  private List<a> H = new ArrayList();
  private Runnable I = new Runnable()
  {
    public void run()
    {
      ConversationListView.a(ConversationListView.this, false);
      ConversationListView.b(ConversationListView.this, false);
      ConversationListView.a(ConversationListView.this, -1);
    }
  };
  private Runnable J = new Runnable()
  {
    public void run()
    {
      ConversationListView.a(ConversationListView.this);
    }
  };
  private TextView K;
  private k L;
  public final Handler a = av.a(av.e.a);
  int b = 0;
  long c = -1L;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;

  public ConversationListView(Context paramContext)
  {
    super(a(paramContext));
    o();
  }

  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    o();
    setOverscrollHeader(null);
    setOverscrollFooter(null);
    this.G = ViberApplication.isTablet(paramContext);
  }

  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a(paramContext), paramAttributeSet, paramInt);
    o();
  }

  private void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.z) && (this.x) && (this.w != -1))
    {
      if (paramInt != 0)
        break label99;
      int i = this.L.c();
      int j = i + paramAbsListView.getFirstVisiblePosition();
      int k = i + paramAbsListView.getLastVisiblePosition();
      int m = i + this.w;
      if ((m > k) || (m < j))
        postDelayed(this.J, 30L);
    }
    else
    {
      return;
    }
    post(this.I);
    return;
    label99: removeCallbacks(this.I);
    removeCallbacks(this.J);
  }

  private boolean a(float paramFloat)
  {
    float f1 = paramFloat + this.D;
    float f2;
    if (f1 > this.B)
      f2 = this.B;
    while (f2 != this.D)
    {
      this.D = f2;
      invalidate();
      return true;
      boolean bool = f1 < 0.0F;
      f2 = 0.0F;
      if (!bool)
        f2 = f1;
    }
    return false;
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0);
    int i;
    int j;
    do
    {
      View localView;
      do
      {
        return;
        localView = getChildAt(-1 + getChildCount());
      }
      while (localView == null);
      i = paramInt2 - localView.getTop();
      j = getPositionForView(localView);
    }
    while (j <= 0);
    setSelectionFromTop(j, paramInt1 - i);
  }

  private int getScrollToPositionOffset()
  {
    if (this.F)
      return 0;
    return this.L.a(k.b.a.a, true);
  }

  private int getTargetScrollPosition()
  {
    if (this.F)
      return this.w;
    return this.w + this.L.c();
  }

  private void o()
  {
    this.p = false;
  }

  private void p()
  {
    if (this.L.a().getCount() == 0);
    do
    {
      View localView;
      do
      {
        return;
        if ((this.A != null) && (this.A.getVisibility() != 8))
        {
          dj.c(this.A, 0);
          this.A.setTag(R.id.sticky_header, Boolean.valueOf(false));
        }
        localView = getChildAt(this.m).findViewById(R.id.dateHeaderView);
      }
      while (!(localView instanceof TextView));
      this.A = ((TextView)localView);
    }
    while ((this.A.getVisibility() == 8) || (!this.e));
    dj.c(this.A, 4);
    this.A.setTag(R.id.sticky_header, Boolean.valueOf(true));
  }

  private void q()
  {
    smoothScrollToPositionFromTop(getTargetScrollPosition(), getScrollToPositionOffset(), 250);
    postDelayed(this.I, 250L);
  }

  protected void a(int paramInt, View paramView)
  {
    if ((paramView instanceof ConstraintLayout))
    {
      View localView = ((ConstraintLayout)paramView).a(R.id.dateHeaderView);
      if (localView != null)
        this.k.b = (localView.getTop() - this.k.c.getPaddingTop());
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    removeCallbacks(this.I);
    this.x = false;
    this.y = false;
    this.z = false;
    this.w = paramInt;
    this.F = paramBoolean2;
    requestLayout();
  }

  public void a(a parama)
  {
    if (!this.H.contains(parama))
      this.H.add(parama);
  }

  public void a(af.c paramc)
  {
    if ((!this.g) && (this.h == this.k.a()))
      return;
    this.h = this.k.a();
    i locali;
    i.a locala;
    int i;
    if ((paramc != null) && (this.L.a() != null))
    {
      locali = this.L.a().b();
      if (locali != null)
      {
        this.K.setText(paramc.b());
        locala = locali.I();
        if (!this.k.a())
          break label138;
        i = locali.L().a;
      }
    }
    while (true)
    {
      this.K.setTextColor(i);
      this.K.setShadowLayer(locala.b, locala.c, locala.d, locala.e);
      a();
      p();
      return;
      label138: if (locala.f)
        i = locali.G();
      else
        i = locali.L().a;
    }
  }

  protected boolean a(int paramInt)
  {
    return (this.L != null) && (paramInt == -1 + (this.L.getCount() - this.L.d()));
  }

  public boolean a(long paramLong)
  {
    int i = getFirstVisiblePosition();
    if (i == 0)
      return false;
    Object localObject = this.L.getItem(i);
    if ((localObject instanceof a))
    {
      aa localaa = ((a)localObject).c();
      if (localaa != null)
      {
        if (localaa.y() > paramLong);
        for (boolean bool = true; ; bool = false)
          return bool;
      }
    }
    return true;
  }

  @SuppressLint({"NewApi"})
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!b()))
      return false;
    o_();
    return true;
  }

  public void b(a parama)
  {
    this.H.remove(parama);
  }

  public boolean b()
  {
    k localk = this.L;
    boolean bool = false;
    if (localk != null)
    {
      int i = getChildCount();
      bool = false;
      if (i > 0)
      {
        View localView = getChildAt(-1 + getChildCount());
        int j = getLastVisiblePosition();
        int k = -1 + (this.L.getCount() - this.L.d());
        bool = false;
        if (j >= k)
        {
          bool = false;
          if (localView != null)
          {
            int m = localView.getBottom();
            int n = getHeight() - getPaddingBottom();
            bool = false;
            if (m <= n)
              bool = true;
          }
        }
      }
    }
    return bool;
  }

  protected af.a c()
  {
    af.a locala = new af.a(false);
    locala.c = inflate(getContext(), R.layout.conversation_header_timestamp, null);
    locala.d = locala.c.findViewById(R.id.dateHeaderView);
    this.K = ((TextView)locala.d);
    return locala;
  }

  public void d()
  {
    View localView = null;
    int i = getChildCount();
    if ((i == 0) || (this.L == null))
      return;
    int j = i - 1;
    Object localObject = null;
    while (true)
    {
      if (j >= 0)
      {
        localView = getChildAt(j);
        localObject = localView.getTag(R.id.list_item_id);
        if (localObject == null);
      }
      else
      {
        if (localObject != null)
          break;
        this.c = -1L;
        return;
      }
      j--;
    }
    this.b = localView.getTop();
    this.c = ((Long)localObject).longValue();
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.E)
      paramCanvas.translate(0.0F, this.D);
    super.dispatchDraw(paramCanvas);
  }

  public boolean e()
  {
    int i = 0;
    this.w = -1;
    if ((getChildCount() == 0) || (this.L == null) || (this.c == -1L))
      return false;
    d locald = this.L.a();
    if (i < locald.getCount())
      if (locald.getItemId(i) != this.c);
    while (true)
    {
      if (i > -1)
        setSelectionFromTop(i + this.L.c() + getHeaderViewsCount(), this.b);
      return true;
      i++;
      break;
      i = -1;
    }
  }

  protected int getHeaderTag()
  {
    return -1;
  }

  protected void layoutChildren()
  {
    if (!this.x)
    {
      this.x = true;
      postDelayed(this.I, 300L);
    }
    if (this.y)
      if (isInTouchMode())
        setSelectionFromTop(getCount(), -32768);
    while (true)
    {
      super.layoutChildren();
      return;
      setSelection(-1 + getCount());
      continue;
      if ((this.w != -1) && (this.L != null))
        if (this.z)
          q();
        else
          setSelectionFromTop(getTargetScrollPosition(), getScrollToPositionOffset());
    }
  }

  public void o_()
  {
    removeCallbacks(this.I);
    this.x = false;
    this.y = true;
    this.z = false;
    this.w = -1;
    requestLayout();
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    setSelection(getCount());
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    a(paramAbsListView, paramInt);
    super.onScrollStateChanged(paramAbsListView, paramInt);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b(paramInt2, paramInt4);
    f();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = this.H.size();
    for (int j = 0; j < i; j++)
      ((a)this.H.get(j)).a(paramMotionEvent);
    int k = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    if ((k == 0) || (k == 2))
    {
      removeCallbacks(this.J);
      post(this.I);
    }
    if ((this.G) && (k != 1) && (k != 3))
    {
      if (this.C > 0.0F);
      for (float f2 = f1 - this.C; ; f2 = 0.0F)
      {
        this.C = f1;
        if ((!this.E) || (ViberApplication.getInstance().getEngine(false).getCallHandler().getCallInfo() == null) || ((!h()) && ((h()) || (this.D <= 0.0F) || (f2 >= 0.0F))) || (!a(f2)))
          break;
        scrollTo(0, 0);
        return true;
      }
    }
    this.C = -1.0F;
    return super.a(paramMotionEvent, k, f1);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof k))
    {
      this.L = ((k)paramListAdapter);
      i locali = this.L.a().b();
      this.k.b(locali.a());
    }
    super.setAdapter(paramListAdapter);
  }

  public void setPushdownEnabled(boolean paramBoolean)
  {
    this.E = paramBoolean;
    this.D = 0.0F;
    postInvalidate();
  }

  public static abstract interface a
  {
    public abstract void a(MotionEvent paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ConversationListView
 * JD-Core Version:    0.6.2
 */