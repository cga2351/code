package com.viber.voip.bot.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Frame;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.d;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.f;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.z;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.EllipsizedEndDynamicMaxLinesTextView;
import java.util.Arrays;

public class a extends c<BotKeyboardItem>
  implements View.OnClickListener
{
  private static final com.viber.common.a.e g = ViberEnv.getLogger();
  protected ImageView a;
  protected TextView b;
  private a h;
  private com.viber.voip.bot.item.a i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private View m;
  private View n;
  private com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b o;
  private int[] p;
  private Spanned q;
  private com.viber.voip.bot.b r;
  private String s;
  private final b t;
  private final b u;

  public a(com.viber.voip.stickers.ui.c paramc, com.viber.voip.bot.item.a parama)
  {
    super(paramc);
    this.i = parama;
    this.j = paramc.getImgBackground();
    this.k = paramc.getImgPicture();
    this.l = paramc.getPlayBtn();
    this.a = paramc.getImgGif();
    this.b = paramc.getTextView();
    this.m = paramc.getFrameView();
    this.n = paramc.getOverlayView();
    this.c.setOnClickListener(this);
    this.b.setTextColor(-16777216);
    this.r = com.viber.voip.bot.b.a();
    this.t = new b(this.j, null);
    this.u = new b(this.k, null);
  }

  private int a(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a parama, com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb)
  {
    int i1 = 16;
    int i2 = 1;
    if (parama != null);
    switch (1.a[parama.ordinal()])
    {
    case 2:
    default:
      if (paramb != null)
        switch (1.b[paramb.ordinal()])
        {
        case 2:
        default:
        case 1:
        case 3:
        }
      break;
    case 1:
    case 3:
    }
    while (true)
    {
      return i1 | i2;
      i2 = 3;
      break;
      i2 = 5;
      break;
      i1 = 48;
      continue;
      i1 = 80;
    }
  }

  private int a(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb, b paramb1)
  {
    if (paramb == com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.TOP)
      return paramb1.c();
    return 0;
  }

  private Drawable a(Resources paramResources, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(paramResources.getColor(R.color.transparent));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramResources.getColor(R.color.negative_50));
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable);
    localStateListDrawable.addState(StateSet.WILD_CARD, localColorDrawable);
    return localStateListDrawable;
  }

  private Drawable a(String paramString, com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb)
  {
    if (paramb == com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.MIDDLE);
    while (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      int i1 = Color.parseColor(paramString);
      GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.TOP_BOTTOM;
      if (paramb == com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.TOP)
        localOrientation = GradientDrawable.Orientation.BOTTOM_TOP;
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = 0;
      arrayOfInt[1] = ColorUtils.setAlphaComponent(i1, 10);
      arrayOfInt[2] = ColorUtils.setAlphaComponent(i1, 90);
      arrayOfInt[3] = i1;
      GradientDrawable localGradientDrawable = new GradientDrawable(localOrientation, arrayOfInt);
      localGradientDrawable.setCornerRadius(0.0F);
      return localGradientDrawable;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private ImageView.ScaleType a(ReplyButton.f paramf)
  {
    if (paramf == ReplyButton.f.FILL)
      return ImageView.ScaleType.FIT_XY;
    if (paramf == ReplyButton.f.FIT)
      return ImageView.ScaleType.FIT_CENTER;
    return ImageView.ScaleType.CENTER_CROP;
  }

  private void a(BotKeyboardItem paramBotKeyboardItem)
  {
    ImageView localImageView = this.l;
    if ((paramBotKeyboardItem.replyButton.getOpenUrlMediaType().equals(ReplyButton.d.VIDEO)) || (paramBotKeyboardItem.replyButton.getOpenUrlMediaType().equals(ReplyButton.d.AUDIO)));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localImageView, bool);
      return;
    }
  }

  private void a(BotKeyboardItem paramBotKeyboardItem, long paramLong, int paramInt, b paramb)
  {
    ReplyButton localReplyButton = paramBotKeyboardItem.replyButton;
    Uri localUri;
    if (localReplyButton.getBgColor() != null)
    {
      Frame localFrame = paramBotKeyboardItem.replyButton.getFrame();
      if (localFrame != null)
      {
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(localReplyButton.getBgColor().intValue());
        localGradientDrawable.setShape(0);
        localGradientDrawable.setCornerRadius(j.a(localFrame.getCornerRadius()));
        dj.a(this.c, localGradientDrawable);
        if ((localReplyButton.getBgMediaType() != ReplyButton.c.PICTURE) || (localReplyButton.getBgMedia() == null))
          break label261;
        if (localReplyButton.getBgMediaScaleType() != null)
        {
          ImageView.ScaleType localScaleType2 = a(localReplyButton.getBgMediaScaleType());
          this.j.setScaleType(localScaleType2);
        }
        localUri = a(localReplyButton.getBgMedia());
        if (!localUri.equals(this.t.a()))
          break label212;
        dj.c(this.j, 0);
      }
    }
    while (true)
    {
      dj.c(this.j, 0);
      a();
      dj.c(this.a, 8);
      return;
      this.c.setBackgroundColor(localReplyButton.getBgColor().intValue());
      break;
      dj.a(this.c, null);
      break;
      label212: this.j.setImageDrawable(null);
      this.t.a(localUri);
      paramb.a().a(localUri, paramb.a(localReplyButton), this.t);
      dj.c(this.j, 0);
    }
    label261: if (a(localReplyButton))
    {
      if (this.h == null)
        this.h = b();
      this.h.a(localReplyButton.hasBgLoop());
      String str2;
      if (!localReplyButton.hasBgLoop())
      {
        str2 = f();
        if (this.r.a(str2))
          this.h.b(true);
      }
      while (true)
      {
        if (localReplyButton.getBgMediaScaleType() != null)
        {
          ImageView.ScaleType localScaleType1 = a(localReplyButton.getBgMediaScaleType());
          this.a.setScaleType(localScaleType1);
        }
        dj.c(this.j, 8);
        dj.c(this.a, 0);
        String str1 = b(localReplyButton);
        if (str1.equals(this.s))
          break;
        this.s = str1;
        this.h.c();
        y.a().a(str1, localReplyButton.getBgMedia(), this.a, this.h, 3460301, e(), true);
        return;
        this.r.a(str2, Boolean.TRUE);
        this.h.b(false);
        continue;
        this.h.b(false);
      }
      this.h.d();
      return;
    }
    a();
    dj.c(this.a, 8);
    dj.c(this.j, 8);
  }

  private void a(BotKeyboardItem paramBotKeyboardItem, b paramb)
  {
    ReplyButton localReplyButton = paramBotKeyboardItem.replyButton;
    Uri localUri1 = localReplyButton.getImageUri();
    if (localUri1 != null)
    {
      if (localReplyButton.getImageScaleType() != null)
      {
        ImageView.ScaleType localScaleType = a(localReplyButton.getImageScaleType());
        this.k.setScaleType(localScaleType);
      }
      Uri localUri2 = a(localUri1);
      if (localUri2.equals(this.u.a()))
      {
        dj.c(this.k, 0);
        return;
      }
      this.k.setImageDrawable(null);
      this.u.a(localUri2);
      paramb.a().a(localUri2, paramb.a(localReplyButton), this.u);
      dj.c(this.k, 0);
      return;
    }
    dj.c(this.k, 8);
  }

  private void a(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb, int[] paramArrayOfInt, b paramb1)
  {
    int i1;
    int i2;
    label78: int i3;
    label108: int i4;
    if ((this.o != paramb) || (!Arrays.equals(this.p, paramArrayOfInt)))
    {
      this.o = paramb;
      this.p = paramArrayOfInt;
      if ((this.p == null) || (this.p.length != 4))
        break label184;
      i1 = 1;
      if ((i1 == 0) || (!a(this.p[1])))
        break label190;
      i2 = j.a(this.p[1]);
      if ((i1 == 0) || (!a(this.p[3])))
        break label199;
      i3 = j.a(this.p[3]);
      if ((i1 == 0) || (!a(this.p[0])))
        break label208;
      i4 = j.a(this.p[0]);
      label138: if ((i1 == 0) || (!a(this.p[2])))
        break label219;
    }
    label184: label190: label199: label208: label219: for (int i5 = j.a(this.p[2]); ; i5 = b(paramb, paramb1))
    {
      this.b.setPadding(i2, i4, i3, i5);
      return;
      i1 = 0;
      break;
      i2 = paramb1.b();
      break label78;
      i3 = paramb1.b();
      break label108;
      i4 = a(paramb, paramb1);
      break label138;
    }
  }

  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 12);
  }

  private int b(com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb, b paramb1)
  {
    if (paramb == com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.BOTTOM)
      return paramb1.c();
    return 0;
  }

  private void b(BotKeyboardItem paramBotKeyboardItem)
  {
    Frame localFrame = paramBotKeyboardItem.replyButton.getFrame();
    if (localFrame != null)
    {
      int i1 = j.a(localFrame.getCornerRadius());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(0);
      localGradientDrawable.setShape(0);
      localGradientDrawable.setCornerRadius(i1);
      localGradientDrawable.setStroke(localFrame.getBorderWidth().intValue(), localFrame.getBorderColor().intValue());
      Drawable localDrawable = a(this.n.getResources(), i1);
      dj.a(this.n, localDrawable);
      dj.c(this.n, 0);
      dj.a(this.m, localGradientDrawable);
      dj.c(this.m, 0);
      return;
    }
    dj.c(this.n, 8);
    dj.c(this.m, 8);
  }

  private void b(BotKeyboardItem paramBotKeyboardItem, b paramb)
  {
    ReplyButton localReplyButton = paramBotKeyboardItem.replyButton;
    if (!TextUtils.isEmpty(localReplyButton.getText()))
    {
      float f = paramb.a(localReplyButton.getTextSize());
      a(paramBotKeyboardItem, f);
      this.b.setTextSize(0, f);
      if ((localReplyButton.isTextShouldFit()) && ((this.b instanceof EllipsizedEndDynamicMaxLinesTextView)))
        ((EllipsizedEndDynamicMaxLinesTextView)this.b).setMinTextSizePx(this.b.getResources().getDimension(R.dimen.bot_keyboard_button_text_size_small));
      com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a locala = localReplyButton.getTextHorizontalAlign();
      com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b localb = localReplyButton.getTextVerticalAlign();
      this.b.setGravity(a(locala, localb));
      dj.a(this.b, a(localReplyButton.getTextBgGradientColor(), localb));
      a(localb, localReplyButton.getTextPaddings(), paramb);
      this.b.setAlpha(localReplyButton.getTextOpacity() / 100.0F);
      dj.c(this.b, 0);
      return;
    }
    dj.c(this.b, 8);
    this.b.setText(null);
    this.q = null;
  }

  protected Uri a(Uri paramUri)
  {
    return paramUri;
  }

  public void a()
  {
    super.a();
    if (this.h != null)
    {
      this.h.b();
      this.h = null;
    }
    this.s = null;
  }

  protected void a(BotKeyboardItem paramBotKeyboardItem, float paramFloat)
  {
    Spanned localSpanned = paramBotKeyboardItem.getCachedHtmlText(this.b.getContext(), paramFloat);
    if (this.q != localSpanned)
    {
      this.q = localSpanned;
      ReplyButton localReplyButton = paramBotKeyboardItem.replyButton;
      int i1 = localReplyButton.getRows() * c(localReplyButton);
      if (this.b.getMaxLines() != i1)
        this.b.setMaxLines(i1);
      this.b.setText(this.q);
      this.b.append("﻿");
    }
  }

  public void a(BotKeyboardItem paramBotKeyboardItem, int paramInt, long paramLong, com.viber.voip.messages.adapters.c paramc)
  {
    super.a(paramBotKeyboardItem, paramInt, paramLong, paramc);
    b localb = (b)paramc;
    a(paramBotKeyboardItem, paramLong, paramInt, localb);
    a(paramBotKeyboardItem, localb);
    a(paramBotKeyboardItem);
    b(paramBotKeyboardItem, localb);
    b(paramBotKeyboardItem);
    View localView = this.n;
    if (paramBotKeyboardItem.replyButton.getActionType() != ReplyButton.a.NONE);
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      return;
    }
  }

  boolean a(ReplyButton paramReplyButton)
  {
    return (paramReplyButton.getBgMediaType() == ReplyButton.c.GIF) && (paramReplyButton.getBgMedia() != null);
  }

  protected a b()
  {
    return new a(this.a);
  }

  String b(ReplyButton paramReplyButton)
  {
    return f() + paramReplyButton.getBgMedia().toString();
  }

  protected int c(ReplyButton paramReplyButton)
  {
    if (paramReplyButton.getTextSize() == ReplyButton.g.LARGE)
      return 2;
    return 3;
  }

  protected String c()
  {
    return "KEYBOARD_";
  }

  public void d()
  {
    if ((this.r.a(f())) && (this.h != null))
    {
      this.h.a();
      this.h.b(false);
      this.h.e();
      this.h.b(true);
    }
  }

  protected dv e()
  {
    return dv.u;
  }

  public void onClick(View paramView)
  {
    this.i.a(null, null, ((BotKeyboardItem)this.d).replyButton);
    d();
  }

  static class a
    implements y.a
  {
    final ImageView a;
    volatile boolean b;
    volatile boolean c;
    private pl.droidsonroids.gif.b d;
    private boolean e;

    public a(ImageView paramImageView)
    {
      this.a = paramImageView;
    }

    private void a(pl.droidsonroids.gif.b paramb)
    {
      if (((!this.c) || (this.e)) && (paramb.c() == 1) && ((!paramb.isPlaying()) || (paramb.i() > 0)))
      {
        paramb.stop();
        paramb.b(0);
        paramb.b();
      }
    }

    void a()
    {
      this.e = false;
    }

    public void a(ImageView paramImageView, pl.droidsonroids.gif.b paramb)
    {
      z.a(this, paramImageView, paramb);
    }

    public void a(pl.droidsonroids.gif.b paramb, String paramString, Uri paramUri)
    {
      if (paramb == null)
        return;
      a(paramb);
    }

    void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public void b()
    {
      this.a.setTag(null);
      c();
    }

    public void b(pl.droidsonroids.gif.b paramb, String paramString, Uri paramUri)
    {
      if (this.d != paramb);
      for (boolean bool = true; ; bool = false)
      {
        this.e = bool;
        this.d = paramb;
        if (paramb != null)
          break;
        return;
      }
      e();
    }

    void b(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }

    void c()
    {
      this.d = null;
    }

    public void d()
    {
      if (this.d == null)
        return;
      if (this.a.getDrawable() != this.d)
        this.a.setImageDrawable(this.d);
      a(this.d);
    }

    protected void e()
    {
      pl.droidsonroids.gif.b localb = this.d;
      if (localb == null);
      label93: 
      do
      {
        return;
        if (this.b);
        for (int i = 0; ; i = 1)
          while (true)
          {
            if (localb.c() != i)
              localb.a(i);
            if (!this.c)
              break label93;
            try
            {
              if (localb.isPlaying())
                localb.stop();
              int j = localb.i();
              int k = -2 + localb.d();
              if ((j >= k) || (k <= 0))
                break;
              localb.b(k);
              return;
            }
            catch (Throwable localThrowable)
            {
              return;
            }
          }
      }
      while (localb.isPlaying());
      localb.b(0);
      localb.b();
      localb.start();
    }
  }

  private static final class b
    implements h.a
  {
    private ImageView a;
    private Uri b;

    private b(ImageView paramImageView)
    {
      this.a = paramImageView;
    }

    Uri a()
    {
      return this.b;
    }

    void a(Uri paramUri)
    {
      this.b = paramUri;
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      if ((this.a != null) && (paramUri.equals(this.b)))
      {
        this.a.setImageBitmap(paramBitmap);
        if (paramBitmap == null)
          this.b = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a.a
 * JD-Core Version:    0.6.2
 */