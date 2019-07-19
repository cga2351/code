package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.backgrounds.m;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MediaMessage;
import com.viber.voip.util.av;
import com.viber.voip.util.ca;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.j;
import java.util.List;

public class h
{
  private final Context a;
  private final i b;
  private Drawable c;
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private LongSparseArray<a> h = new LongSparseArray();
  private SparseArray<Drawable> i = new SparseArray(10);
  private SparseArray<Drawable> j = new SparseArray(10);
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private MediaInfo q;

  h(Context paramContext, i parami)
  {
    this.a = paramContext;
    this.b = parami;
    Resources localResources = paramContext.getResources();
    this.k = ContextCompat.getColor(paramContext, R.color.solid_10);
    this.n = localResources.getDimensionPixelSize(R.dimen.media_message_unsent_border_width);
    this.o = localResources.getDimensionPixelSize(R.dimen.media_message_border_width);
    this.l = dc.d(paramContext, R.attr.conversationBalloonErrorBackground);
    this.m = dc.d(paramContext, R.attr.conversationListItemMediaBorderColor);
    this.p = j.a(paramContext, 1.0F);
  }

  private Drawable a(SparseArray<Drawable> paramSparseArray, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)paramFloat);
    arrayOfInt[1] = paramInt1;
    arrayOfInt[2] = paramInt3;
    arrayOfInt[3] = paramInt4;
    arrayOfInt[4] = paramInt5;
    int i1 = ca.a(arrayOfInt);
    Object localObject = (Drawable)paramSparseArray.get(i1);
    if (localObject == null)
    {
      localObject = new ShapeDrawable(new com.viber.common.ui.a.a(paramFloat, paramInt1, paramInt2));
      ((ShapeDrawable)localObject).getPaint().setColor(paramInt3);
      if (paramSparseArray.size() == 30)
        paramSparseArray.removeAt(0);
      paramSparseArray.put(i1, localObject);
    }
    return localObject;
  }

  private Drawable f()
  {
    if (this.d == null)
      this.d = df.a(ContextCompat.getDrawable(this.a, R.drawable.video_message_default_image), dc.f(this.a, R.attr.conversationListItemIconTintColor), false);
    return this.d;
  }

  private Drawable g()
  {
    if (this.e == null)
      this.e = df.a(ContextCompat.getDrawable(this.a, R.drawable.location_message_default_image), dc.f(this.a, R.attr.conversationListItemIconTintColor), false);
    return this.e;
  }

  public float a(float paramFloat)
  {
    return paramFloat - this.p;
  }

  public int a(com.viber.voip.messages.conversation.adapter.a.a parama)
  {
    aa localaa = parama.c();
    int i1;
    if (!parama.h())
      if (localaa.ao())
        i1 = av.f(15, 1);
    while (true)
    {
      if ((parama.q()) || (localaa.bD()) || (localaa.bO()))
        i1 = av.f(i1, 3);
      if (parama.p())
        i1 = av.f(i1, 12);
      if (parama.r())
        i1 = av.f(i1, 15);
      return i1;
      i1 = av.f(15, 2);
      continue;
      i1 = 15;
    }
  }

  public int a(com.viber.voip.messages.conversation.adapter.a.a parama, MediaMessage paramMediaMessage)
  {
    aa localaa = parama.c();
    FormattedMessage localFormattedMessage = localaa.L();
    if (localFormattedMessage == null)
    {
      i2 = a(parama);
      return i2;
    }
    List localList = localFormattedMessage.getMessage();
    int i1 = localList.size();
    int i2 = 15;
    int i3 = 0;
    label51: if (i3 < i1)
      if (paramMediaMessage == localList.get(i3))
        break label77;
    label178: 
    while (true)
    {
      i3++;
      break label51;
      break;
      label77: if (i3 == 0)
        if (!parama.h())
        {
          if (localaa.ao())
            i2 = av.f(i2, 1);
        }
        else
          label106: if ((!parama.q()) && (!localaa.bD()) && (!localaa.bO()));
      for (i2 = av.f(i2, 3); ; i2 = av.f(i2, 3))
      {
        if (i3 == i1 - 1)
          break label178;
        i2 = av.f(i2, 12);
        break;
        i2 = av.f(i2, 2);
        break label106;
      }
    }
  }

  public Drawable a()
  {
    if (this.c == null)
      this.c = df.a(ContextCompat.getDrawable(this.a, R.drawable.image_message_default_image), dc.f(this.a, R.attr.conversationListItemIconTintColor), false);
    return this.c;
  }

  public Drawable a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(this.j, paramFloat, paramInt1, 0, paramInt2, paramInt3, paramInt4);
  }

  public Drawable a(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    SparseArray localSparseArray = this.i;
    int i1;
    if (paramBoolean)
    {
      i1 = this.n;
      if (!paramBoolean)
        break label52;
    }
    label52: for (int i2 = this.l; ; i2 = this.m)
    {
      return a(localSparseArray, paramFloat, paramInt1, i1, i2, paramInt2, paramInt3);
      i1 = this.o;
      break;
    }
  }

  public Drawable a(aa paramaa)
  {
    if (paramaa.aA())
      return f();
    if (paramaa.az())
      return a();
    if (paramaa.ay())
      return g();
    return null;
  }

  public a a(long paramLong)
  {
    return (a)this.h.get(paramLong);
  }

  public void a(long paramLong, a parama)
  {
    this.h.put(paramLong, parama);
  }

  public Drawable b()
  {
    if (m.b(this.a, this.b.l()))
    {
      if (this.f == null)
        this.f = ContextCompat.getDrawable(this.a, R.drawable.msg_list_icon_forward_selector);
      return this.f;
    }
    if (this.g == null)
      this.g = ContextCompat.getDrawable(this.a, R.drawable.msg_list_icon_forward_white_selector);
    return this.g;
  }

  public Uri b(aa paramaa)
  {
    if (paramaa.o() == null)
      return dx.a(paramaa);
    return dx.b(paramaa);
  }

  public String b(long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Float.valueOf((float)paramLong / 1024.0F / 1024.0F);
    return String.format("%.2fM", arrayOfObject);
  }

  public int c()
  {
    return 999;
  }

  public boolean c(aa paramaa)
  {
    return paramaa.aF();
  }

  public int d()
  {
    return this.k;
  }

  public MediaInfo e()
  {
    if (this.q == null)
    {
      this.q = new MediaInfo();
      this.q.setMediaType(MediaInfo.a.IMAGE);
      this.q.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.location_message_height));
    }
    return this.q;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.h
 * JD-Core Version:    0.6.2
 */