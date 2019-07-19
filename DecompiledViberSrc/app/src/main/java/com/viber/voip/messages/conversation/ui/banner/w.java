package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.i.c.h;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.d.x;
import com.viber.voip.messages.conversation.af;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.util.ae;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.o;

public class w extends q
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private TextView b;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private Pin g;
  private int h;
  private boolean i;
  private long j;
  private long k;
  private boolean l;
  private String m;
  private Context n;
  private a o;
  private ai p;
  private com.viber.voip.messages.d.b q;
  private e r;

  public w(Context paramContext, ViewGroup paramViewGroup, e parame, a parama, com.viber.voip.messages.d.b paramb, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.pin_banner, paramViewGroup, paramLayoutInflater);
    this.n = paramContext;
    this.o = parama;
    this.layout.setOnClickListener(this);
    this.b = ((TextView)this.layout.findViewById(R.id.text));
    this.c = ((TextView)this.layout.findViewById(R.id.info));
    this.d = ((ImageView)this.layout.findViewById(R.id.delete_btn));
    this.e = ((ImageView)this.layout.findViewById(R.id.icon));
    this.f = ((ImageView)this.layout.findViewById(R.id.video_play_icon));
    this.d.setOnClickListener(this);
    this.p = new ai(paramContext);
    this.q = paramb;
    this.r = parame;
  }

  private String a(String paramString, long paramLong, boolean paramBoolean)
  {
    Resources localResources = this.layout.getResources();
    Object localObject = null;
    String str2;
    if (paramBoolean)
    {
      str2 = com.viber.voip.messages.d.c.c().a(paramString, 2, 1);
      boolean bool = localResources.getString(R.string.unknown).equals(str2);
      localObject = null;
      if (!bool)
        break label245;
    }
    while (true)
    {
      int i1;
      if (!da.a((CharSequence)localObject))
        i1 = 1;
      while (ae.a(paramLong))
        if (i1 != 0)
        {
          int i3 = R.string.pinned_by_user_today_banner;
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = localObject;
          arrayOfObject2[1] = ae.e(paramLong);
          return localResources.getString(i3, arrayOfObject2);
          i1 = 0;
        }
        else
        {
          int i2 = R.string.pinned_today_msg_notification;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = ae.e(paramLong);
          return localResources.getString(i2, arrayOfObject1);
        }
      if (ae.b(paramLong))
      {
        if (i1 != 0)
          return localResources.getString(R.string.pinned_by_user_yesterday_banner, new Object[] { localObject });
        return localResources.getString(R.string.pinned_yesterday_msg_notification);
      }
      String str1 = ae.a(this.layout.getContext(), paramLong, false);
      if (i1 != 0)
        return localResources.getString(R.string.pinned_by_user_date_banner, new Object[] { localObject, str1 });
      return localResources.getString(R.string.pinned_date_msg_notification, new Object[] { str1 });
      label245: localObject = str2;
    }
  }

  private void a(final int paramInt)
  {
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        final Sticker localSticker = i.a().u(paramInt);
        final com.viber.voip.stickers.f localf = i.a().e();
        av.e.a.a().post(new Runnable()
        {
          public void run()
          {
            if (localSticker.getColSpan() > localSticker.getRowSpan())
              w.a(w.this, w.a(w.this).getResources().getDimensionPixelSize(R.dimen.pin_banner_rect_icon_width));
            while (true)
            {
              com.viber.voip.stickers.ui.f localf = new com.viber.voip.stickers.ui.f(localf, w.a(w.this));
              localf.a(localSticker);
              localf.a(false, true, com.viber.voip.stickers.w.b);
              return;
              w.a(w.this, w.a(w.this).getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
            }
          }
        });
      }
    });
  }

  private void a(TextView paramTextView, Pin paramPin, int paramInt1, int paramInt2)
  {
    if (paramPin.getExtendedInfo() == null)
    {
      paramTextView.setTypeface(paramTextView.getTypeface(), paramInt1);
      return;
    }
    if ((paramPin.getMediaType() == 8) && (!"gif".equals(paramPin.getExtendedInfo().getFileExt())))
    {
      paramTextView.setTypeface(paramTextView.getTypeface(), paramInt2);
      return;
    }
    paramTextView.setTypeface(paramTextView.getTypeface(), paramInt1);
  }

  private void a(Pin paramPin, Uri paramUri, boolean paramBoolean)
  {
    int i1 = 1;
    if (av.d(paramPin.getFlags(), i1))
    {
      this.e.setImageDrawable(this.e.getResources().getDrawable(R.drawable.ic_composer_vote_normal));
      b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
      dj.b(this.e, i1);
      dj.b(this.f, false);
      return;
    }
    ExtendedInfo localExtendedInfo = paramPin.getExtendedInfo();
    if (localExtendedInfo == null)
    {
      dj.b(this.e, false);
      dj.b(this.f, false);
      return;
    }
    boolean bool;
    int i3;
    label175: ImageView localImageView;
    switch (paramPin.getMediaType())
    {
    case 2:
    case 6:
    case 7:
    case 11:
    default:
      bool = false;
      i3 = i1;
      a(bool);
      dj.b(this.e, i3);
      localImageView = this.f;
      if ((i3 == 0) || (paramPin.getMediaType() != 3))
        break;
    case 0:
    case 8:
    case 12:
    case 1:
    case 3:
    case 10:
    case 9:
    case 5:
    case 4:
    }
    while (true)
    {
      dj.b(localImageView, i1);
      return;
      if ("gif".equals(localExtendedInfo.getFileExt()))
      {
        b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
        this.r.a(Uri.parse(localExtendedInfo.getDownloadId()), this.e, com.viber.voip.util.e.f.a(R.drawable.reply_banner_default_thumb));
        bool = i1;
        i3 = i1;
        break label175;
      }
      bool = false;
      int i4 = 0;
      break label175;
      b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
      if (da.a(localExtendedInfo.getDownloadId()))
      {
        this.r.a(paramUri, this.e, com.viber.voip.util.e.f.a(R.drawable.reply_banner_default_thumb));
        i4 = i1;
        bool = false;
        break label175;
      }
      if (paramBoolean)
      {
        this.r.a(dx.a(localExtendedInfo.getDownloadId(), 400, null), this.e, com.viber.voip.util.e.f.a());
        i4 = i1;
        bool = false;
        break label175;
      }
      this.r.a(dx.a(localExtendedInfo.getDownloadId(), null, EncryptionParams.unserializeEncryptionParams(localExtendedInfo.getEncryptionParams()), i.c.b, i.o.a, null), this.e, com.viber.voip.util.e.f.a());
      i4 = i1;
      bool = false;
      break label175;
      b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
      if ("gif".equals(localExtendedInfo.getFileExt()))
      {
        if (da.a(localExtendedInfo.getDownloadId()))
        {
          this.r.a(paramUri, this.e, com.viber.voip.util.e.f.a(R.drawable.reply_banner_default_thumb));
          bool = i1;
          i4 = i1;
          break label175;
        }
        this.r.a(dx.a(false, localExtendedInfo.getDownloadId(), paramBoolean, null, null, EncryptionParams.unserializeEncryptionParams(localExtendedInfo.getEncryptionParams())), this.e, com.viber.voip.util.e.f.a());
        bool = i1;
        i4 = i1;
        break label175;
      }
      this.e.setImageResource(R.drawable.reply_file_thumb);
      i4 = i1;
      bool = false;
      break label175;
      b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_square_icon_width));
      this.r.a(dx.a(localExtendedInfo.getDownloadId()), this.e, com.viber.voip.util.e.f.b(this.n));
      i4 = i1;
      bool = false;
      break label175;
      int i5 = Integer.valueOf(localExtendedInfo.getLat()).intValue();
      int i6 = Integer.valueOf(localExtendedInfo.getLng()).intValue();
      Uri localUri = Uri.parse(com.viber.voip.messages.extras.map.b.a(this.e.getResources(), i5, i6));
      b(this.e.getResources().getDimensionPixelSize(R.dimen.pin_banner_rect_icon_width));
      this.r.a(localUri, this.e, com.viber.voip.util.e.f.a());
      i4 = i1;
      bool = false;
      break label175;
      a(Integer.valueOf(localExtendedInfo.getDownloadId()).intValue());
      break;
      int i2 = 0;
    }
  }

  private void a(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      if (!paramBoolean)
        break label36;
    }
    label36: for (ImageView.ScaleType localScaleType = ImageView.ScaleType.CENTER_CROP; ; localScaleType = ImageView.ScaleType.FIT_CENTER)
    {
      this.e.setAdjustViewBounds(bool);
      this.e.setScaleType(localScaleType);
      return;
      bool = false;
      break;
    }
  }

  private void b(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    if (localLayoutParams.width != paramInt)
    {
      localLayoutParams.width = paramInt;
      this.e.setLayoutParams(localLayoutParams);
    }
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.j;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, Pin paramPin)
  {
    this.g = paramPin;
    this.b.setText(dg.a(this.g, "no_sp", this.p, this.q, paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole(), true));
    this.p.a(this.b, aj.c);
    try
    {
      a(this.b, this.g, 1, 3);
      a(this.g, null, paramConversationItemLoaderEntity.isPublicGroupBehavior());
      dj.c(this.d, 8);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.a(localException, "can't bind pin icon");
        dj.b(this.e, false);
      }
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, af paramaf, boolean paramBoolean)
  {
    String str1 = a(paramaf.g(), paramaf.c(), paramaf.f());
    int i1 = paramConversationItemLoaderEntity.getGroupRole();
    int i2 = paramConversationItemLoaderEntity.getConversationType();
    this.i = cd.h(i1, i2);
    boolean bool1;
    ImageView localImageView;
    if ((!paramConversationItemLoaderEntity.isCommunityBlocked()) && ((cd.g(i1, i2)) || (this.i)))
    {
      bool1 = true;
      localImageView = this.d;
      if ((!bool1) || (!c.h.d.e()))
        break label159;
    }
    label159: for (boolean bool2 = true; ; bool2 = false)
    {
      dj.b(localImageView, bool2);
      this.g = paramaf.d();
      if ((paramBoolean) || (paramaf.b() != this.k) || (bool1 != this.l) || (i1 != this.h) || (!str1.equals(this.m)))
        break label165;
      return;
      bool1 = false;
      break;
    }
    label165: this.m = str1;
    this.k = paramaf.b();
    this.l = bool1;
    this.h = i1;
    this.j = paramConversationItemLoaderEntity.getId();
    this.c.setText(str1);
    if (da.a(paramaf.h()));
    for (String str2 = "no_sp"; ; str2 = paramaf.h())
    {
      this.b.setText(dg.a(this.g, str2, this.p, this.q, paramConversationItemLoaderEntity.getConversationType(), i1, true));
      this.p.a(this.b, aj.c);
      try
      {
        a(this.b, this.g, 1, 3);
        a(this.g, paramaf.e(), paramConversationItemLoaderEntity.isPublicGroupBehavior());
        return;
      }
      catch (Exception localException)
      {
        a.a(localException, "can't bind pin icon");
        dj.b(this.e, false);
        return;
      }
    }
  }

  protected a createAlertViewUiCustomizer()
  {
    return new com.viber.voip.messages.conversation.ui.banner.a.c();
  }

  public void onClick(View paramView)
  {
    if (R.id.delete_btn == paramView.getId())
      if (this.i)
        this.o.a(this.k, this.j);
    long l1;
    do
    {
      return;
      Pin localPin = new Pin();
      localPin.setText(this.g.getText());
      localPin.setToken(this.g.getToken());
      localPin.setAction(Pin.a.DELETE);
      this.o.a(localPin);
      return;
      l1 = this.g.getToken();
    }
    while (l1 == 0L);
    this.o.a_(l1, this.g.getSeqInPG(), 1000L);
  }

  public static abstract interface a extends x
  {
    public abstract void a(long paramLong1, long paramLong2);

    public abstract void a(Pin paramPin);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.w
 * JD-Core Version:    0.6.2
 */