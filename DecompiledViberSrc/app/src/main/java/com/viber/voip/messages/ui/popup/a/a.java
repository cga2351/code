package com.viber.voip.messages.ui.popup.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.adapters.MediaLayoutPopup;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.n;
import com.viber.voip.messages.conversation.adapter.d.q;
import com.viber.voip.messages.conversation.adapter.d.v;
import com.viber.voip.messages.conversation.adapter.d.v.a;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.conversation.ah;
import com.viber.voip.messages.conversation.z;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.ImageMessage;
import com.viber.voip.messages.orm.entity.json.MediaMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.orm.entity.json.VideoMessage;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.b;
import com.viber.voip.util.e.e;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.widget.FileMessageLayout;
import com.viber.voip.widget.GifMessageLayout;
import com.viber.voip.widget.PttLayout;
import java.util.List;

public class a extends g
  implements n, q
{
  private View.OnClickListener a;
  private View.OnLongClickListener b;
  private v c;
  private boolean d;
  private boolean e;
  private final com.viber.voip.messages.ui.ai f;
  private final x g;
  private com.viber.voip.messages.d.b h;
  private final ah i;
  private dagger.a<ConversationItemLoaderEntity> j;
  private LayoutInflater k;
  private View l;
  private com.viber.voip.messages.j m;
  private com.viber.voip.messages.controller.ai n;

  public a(Activity paramActivity, z paramz, com.viber.voip.messages.d.b paramb, com.viber.voip.messages.ui.ai paramai, x paramx, com.viber.voip.messages.j paramj, ah paramah, com.viber.voip.messages.controller.ai paramai1, dagger.a<ConversationItemLoaderEntity> parama)
  {
    super(paramActivity, paramz, true);
    this.j = parama;
    this.k = paramActivity.getLayoutInflater();
    this.f = paramai;
    this.g = paramx;
    this.h = paramb;
    this.m = paramj;
    this.i = paramah;
    this.n = paramai1;
    a();
  }

  public static void a(View paramView)
  {
    if ((paramView.getTag() instanceof b))
    {
      b localb = (b)paramView.getTag();
      aa localaa = localb.a();
      if (localaa.ax())
        localb.f.a(localaa.r().toStickerId());
    }
  }

  @SuppressLint({"StringFormatInvalid"})
  private void b(View paramView, int paramInt)
  {
    int i1 = 1;
    aa localaa1 = f().f(paramInt);
    c localc = new c(paramView, paramInt, localaa1, null);
    paramView.setTag(localc);
    if (this.e)
    {
      String str2 = localaa1.bp();
      TextView localTextView2 = localc.e;
      Activity localActivity2 = g();
      int i4 = R.string.message_spam_notification_text;
      Object[] arrayOfObject2 = new Object[i1];
      arrayOfObject2[0] = str2;
      localTextView2.setText(localActivity2.getString(i4, arrayOfObject2));
      return;
    }
    if (!this.d)
    {
      String str1 = localaa1.bp();
      localc.e.setText(g().getString(R.string.popup_preview_disabled_content) + " " + str1);
      return;
    }
    aa localaa2 = localc.a();
    if (localaa1.an())
    {
      TextView localTextView1 = localc.e;
      Activity localActivity1 = g();
      int i3 = R.string.message_notification_vote_text;
      Object[] arrayOfObject1 = new Object[i1];
      arrayOfObject1[0] = "";
      localTextView1.setText(localActivity1.getString(i3, arrayOfObject1).trim());
    }
    label210: 
    while (i1 != 0)
    {
      this.f.a(localc.e, aj.b);
      return;
      if (localaa1.aE())
        localc.e.setText(localaa2.L().getPreviewText());
      else if (localaa2.aZ())
        localc.e.setText(m.a(localc.e.getContext(), localaa2.V(), localaa2.bu()));
      else
        if (this.j.get() == null)
          break label378;
    }
    label378: for (int i2 = ((ConversationItemLoaderEntity)this.j.get()).getGroupRole(); ; i2 = i1)
    {
      SpannableString localSpannableString = da.a(localaa2.h(), this.f, this.h, localaa2.N(), false, false, i1, false, aj.b, localaa2.A(), i2);
      localc.e.setText(localSpannableString);
      i1 = 0;
      break label210;
      break;
    }
  }

  private void c(View paramView, int paramInt)
  {
    aa localaa = f().f(paramInt);
    b localb = new b(paramView, paramInt, localaa, null);
    paramView.setTag(localb);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    if ((localaa.az()) || (localaa.aA()))
    {
      localb.f.a(localaa, false, true, false);
      if (!TextUtils.isEmpty(localaa.i()))
      {
        bool1 = true;
        localb.j.setText(localaa.i());
        this.f.a(localb.j, aj.b);
        bool2 = false;
        bool3 = false;
        bool4 = false;
        bool5 = true;
      }
    }
    while (true)
    {
      dj.b(localb.j, bool1);
      dj.b(localb.f, bool5);
      dj.b(localb.g, bool4);
      dj.b(localb.h, bool3);
      dj.b(localb.i, bool2);
      return;
      bool1 = false;
      break;
      if (localaa.aK())
      {
        localb.f.a(localaa, false, false, true);
        bool5 = true;
        bool1 = false;
        bool2 = false;
        bool3 = false;
        bool4 = false;
      }
      else if (localaa.ax())
      {
        localb.f.a(localaa.r().toStickerId());
        bool5 = true;
        bool1 = false;
        bool2 = false;
        bool3 = false;
        bool4 = false;
      }
      else
      {
        if (localaa.ay())
        {
          localb.f.a(localaa, true);
          if (TextUtils.isEmpty(localaa.D()));
          for (String str2 = localb.j.getContext().getString(R.string.message_type_location); ; str2 = localaa.D())
          {
            localb.j.setText(str2);
            bool1 = true;
            bool5 = true;
            bool2 = false;
            bool3 = false;
            bool4 = false;
            break;
          }
        }
        if (localaa.aJ())
        {
          this.c.a(localaa);
          Application localApplication = ViberApplication.getApplication();
          e locale = e.a(paramView.getContext());
          com.viber.voip.messages.d.b localb1 = this.h;
          com.viber.voip.messages.ui.ai localai = this.f;
          x localx = this.g;
          com.viber.voip.messages.j localj = this.m;
          ah localah = this.i;
          com.viber.voip.messages.controller.ai localai1 = this.n;
          boolean bool6 = ViberApplication.isTablet(paramView.getContext());
          com.viber.voip.messages.conversation.adapter.b.a.a locala = new com.viber.voip.messages.conversation.adapter.b.a.a();
          dagger.a locala1 = this.j;
          b localb2 = new b(this);
          com.viber.voip.messages.conversation.adapter.a.c.a.j localj1 = new com.viber.voip.messages.conversation.adapter.a.c.a.j(localApplication, locale, localb1, localai, localx, localj, localah, localai1, bool6, locala, locala1, localb2);
          localb.g.a(localaa, localj1);
          bool4 = true;
          bool1 = false;
          bool2 = false;
          bool3 = false;
          bool5 = false;
        }
        else if (localaa.aG())
        {
          FileInfo localFileInfo = localaa.bz();
          localb.h.a(localFileInfo);
          bool3 = true;
          bool1 = false;
          bool2 = false;
          bool4 = false;
          bool5 = false;
        }
        else if (localaa.aH())
        {
          localb.i.a(localaa);
          bool5 = true;
          bool1 = true;
          bool2 = true;
          bool3 = false;
          bool4 = false;
        }
        else
        {
          if (localaa.aE())
          {
            List localList = localaa.L().getMessage();
            int i1 = localList.size();
            for (int i2 = 0; ; i2++)
            {
              if (i2 >= i1)
                break label899;
              BaseMessage localBaseMessage = (BaseMessage)localList.get(i2);
              if (((localBaseMessage instanceof ImageMessage)) || ((localBaseMessage instanceof GifMessage)) || ((localBaseMessage instanceof VideoMessage)))
              {
                MediaMessage localMediaMessage = (MediaMessage)localBaseMessage;
                String str1;
                label658: Uri localUri;
                if (MessageType.GIF == localBaseMessage.getType())
                {
                  str1 = ((GifMessage)localBaseMessage).getGifUrl();
                  if (!TextUtils.isEmpty(str1))
                    break label835;
                  localUri = dx.a(localMediaMessage.getBucketName(), localMediaMessage.getDownloadId(), localMediaMessage.getPhotoUrl(), localMediaMessage.getImageType());
                  label691: if (MessageType.GIF != localBaseMessage.getType())
                    break label857;
                  localb.f.b(localUri, R.drawable.invite_to_vibe_place_holder_icon);
                  if (!dx.l(localUri))
                    break label851;
                  if ((TextUtils.isEmpty(dx.m(localUri).a)) || (TextUtils.isEmpty(localaa.L().getPreviewText())))
                    break label845;
                  bool1 = true;
                }
                while (true)
                {
                  localb.j.setText(localaa.L().getPreviewText());
                  this.f.a(localb.j, aj.b);
                  bool5 = true;
                  bool2 = false;
                  bool3 = false;
                  bool4 = false;
                  break;
                  if (MessageType.VIDEO == localBaseMessage.getType())
                  {
                    str1 = ((VideoMessage)localBaseMessage).getThumbnailUrl();
                    break label658;
                  }
                  str1 = ((ImageMessage)localBaseMessage).getImageUrl();
                  break label658;
                  label835: localUri = Uri.parse(str1);
                  break label691;
                  label845: bool1 = false;
                  continue;
                  label851: bool1 = false;
                  continue;
                  label857: if (MessageType.VIDEO == localBaseMessage.getType())
                  {
                    bool1 = true;
                    localb.f.c(localUri, R.drawable.invite_to_vibe_place_holder_icon);
                  }
                  else
                  {
                    bool1 = true;
                  }
                }
              }
            }
          }
          label899: bool1 = true;
          bool5 = true;
          bool2 = false;
          bool3 = false;
          bool4 = false;
        }
      }
    }
  }

  protected int a(int paramInt)
  {
    if (this.e)
      return 1;
    return super.a(paramInt);
  }

  public View a(View paramView, int paramInt)
  {
    if (this.e)
    {
      this.l = this.k.inflate(R.layout.hc_popup_text, null);
      b(this.l, paramInt);
    }
    while (true)
    {
      return this.l;
      if ((!this.d) || (a(paramInt) != 2))
      {
        this.l = this.k.inflate(R.layout.hc_popup_text, null);
        b(this.l, paramInt);
      }
      else
      {
        this.l = this.k.inflate(R.layout.hc_popup_media, null);
        c(this.l, paramInt);
      }
    }
  }

  public aa a(ViewPager paramViewPager, Activity paramActivity)
  {
    for (int i1 = 0; i1 < paramViewPager.getChildCount(); i1++)
    {
      a locala = (a)paramViewPager.getChildAt(i1).getTag();
      if (locala.b() == paramViewPager.getCurrentItem())
        return locala.a();
    }
    return null;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    Application localApplication = ViberApplication.getApplication();
    if (!paramaa.aS());
    for (boolean bool = true; ; bool = false)
    {
      ViberActionRunner.a(localApplication, paramaa, paramBoolean, bool);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public boolean a()
  {
    return true;
  }

  public int b()
  {
    return f().getCount();
  }

  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void h(aa paramaa)
  {
  }

  private class a
  {
    public final ImageView a;
    public final ImageView b;
    protected aa c;
    private int e;

    private a(View paramInt, int paramaa, aa arg4)
    {
      this.a = ((ImageView)paramInt.findViewById(R.id.left_arrow));
      this.b = ((ImageView)paramInt.findViewById(R.id.right_arrow));
      this.a.setOnClickListener(a.a(a.this));
      this.b.setOnClickListener(a.a(a.this));
      this.e = paramaa;
      Object localObject;
      this.c = localObject;
      ImageView localImageView1 = this.b;
      int j;
      ImageView localImageView2;
      if (-1 + a.this.f().getCount() == paramaa)
      {
        j = i;
        localImageView1.setVisibility(j);
        localImageView2 = this.a;
        if (paramaa != 0)
          break label128;
      }
      while (true)
      {
        localImageView2.setVisibility(i);
        return;
        j = 0;
        break;
        label128: i = 0;
      }
    }

    public aa a()
    {
      return this.c;
    }

    public int b()
    {
      return this.e;
    }
  }

  private class b extends a.a
  {
    public final LinearLayout e;
    public final MediaLayoutPopup f;
    public final PttLayout g;
    public final FileMessageLayout h;
    public final GifMessageLayout i;
    public final TextView j;

    private b(View paramInt, int paramaa, aa arg4)
    {
      super(paramInt, paramaa, localaa, null);
      this.e = ((LinearLayout)paramInt.findViewById(R.id.shared_media_layout));
      this.f = ((MediaLayoutPopup)paramInt.findViewById(R.id.shared_media_view));
      this.g = ((PttLayout)paramInt.findViewById(R.id.ptt_view));
      this.j = ((TextView)paramInt.findViewById(R.id.photo_description));
      this.h = ((FileMessageLayout)paramInt.findViewById(R.id.file_view));
      this.i = ((GifMessageLayout)paramInt.findViewById(R.id.gif_view));
      this.e.setOnClickListener(a.a(a.this));
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this).onClick(paramAnonymousView);
          a.b.this.f.a(paramAnonymousView);
        }
      };
      this.h.setOnClickListener(local1);
      this.i.setOnClickListener(local1);
      this.f.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this).onClick(paramAnonymousView);
          a.b.this.f.a(paramAnonymousView);
        }
      });
      if (a.b(a.this) != null)
      {
        this.e.setOnLongClickListener(a.b(a.this));
        this.f.setOnLongClickListener(a.b(a.this));
      }
      a.a(a.this, v.a(this.g.getVolumeBarsView(), null));
      a.c(a.this).a(this.g);
      a.c(a.this).a(this.g);
      this.g.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.b.this.g.c(paramAnonymousView);
        }
      });
      a.c(a.this).a(new v.a()
      {
        public void a(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          a.b.this.g.c(paramAnonymousView);
        }
      });
    }
  }

  private class c extends a.a
  {
    public final TextView e;
    public final RelativeLayout f;

    private c(View paramInt, int paramaa, aa arg4)
    {
      super(paramInt, paramaa, localaa, null);
      this.e = ((TextView)paramInt.findViewById(R.id.messageTextView));
      this.f = ((RelativeLayout)paramInt.findViewById(R.id.popupMsgLayout));
      this.e.setOnClickListener(a.a(a.this));
      this.f.setOnClickListener(a.a(a.this));
      if (a.b(a.this) != null)
      {
        this.e.setOnLongClickListener(a.b(a.this));
        this.f.setOnLongClickListener(a.b(a.this));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.a
 * JD-Core Version:    0.6.2
 */