package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.viber.common.dialogs.h.a;
import com.viber.common.ui.ShapeImageView;
import com.viber.jni.Engine;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.VideoMessage;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.d.e.b;
import com.viber.voip.util.ViberActionRunner.w;
import com.viber.voip.util.an;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.PlayableImageView;

public class o extends h<FrameLayout, VideoMessage>
{
  private static final com.viber.common.a.e m = ViberEnv.getLogger();
  private boolean n;
  private final VideoMessage o;
  private final com.viber.voip.messages.extensions.c p;

  public o(VideoMessage paramVideoMessage, Context paramContext, a parama, i parami, b paramb, com.viber.voip.messages.extensions.c paramc)
  {
    super(paramVideoMessage, paramContext, parama, parami, paramb);
    this.o = paramVideoMessage;
    this.p = paramc;
    this.n = a(this.c);
  }

  private boolean a(aa paramaa)
  {
    return (an.e()) && (paramaa.aQ()) && ((this.o.getAction() instanceof OpenUrlAction));
  }

  public void a(FrameLayout paramFrameLayout)
  {
    super.a(paramFrameLayout);
    ImageView localImageView = (ImageView)paramFrameLayout.findViewById(R.id.preview);
    this.l.a(localImageView);
    PlayableImageView localPlayableImageView = (PlayableImageView)paramFrameLayout.findViewById(R.id.play_btn);
    localPlayableImageView.a(false);
    localPlayableImageView.setClickable(false);
  }

  boolean b(View paramView)
  {
    if (super.b(paramView));
    do
    {
      return true;
      if (!this.n)
        return false;
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      if ((localEngine.getCurrentCall() != null) || (localEngine.isGSMCallActive()))
      {
        com.viber.voip.ui.dialogs.o.n().d();
        return true;
      }
    }
    while (!cj.c(this.a));
    String str1 = ((OpenUrlAction)this.o.getAction()).getUrl();
    String str2 = this.o.getThumbnailUrl();
    MsgInfo localMsgInfo = this.c.bx();
    MediaPlayer.VisualSpec localVisualSpec = com.viber.voip.messages.ui.media.player.c.e.a(str1, str2).a(1);
    com.viber.voip.messages.ui.media.player.a.c localc = com.viber.voip.messages.ui.media.player.a.c.a(localMsgInfo.getTitle(), null);
    if (this.p.f());
    MediaPlayerControls.VisualSpec localVisualSpec1;
    for (int i = 1; ; i = 0)
    {
      localVisualSpec1 = localc.a(i);
      if (!dj.e(this.a))
        break;
      an.a(this.a);
      ViberApplication.getInstance().getPlayerWindowManager().a(localVisualSpec, localVisualSpec1, new a(localVisualSpec, localVisualSpec1));
      return true;
    }
    ViberActionRunner.w.b(this.a, localVisualSpec, localVisualSpec1, null);
    return true;
  }

  public FrameLayout g()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.a);
    localFrameLayout.setTag(R.id.no_intercept_touch, Boolean.valueOf(true));
    PlayableImageView localPlayableImageView = new PlayableImageView(this.a);
    localPlayableImageView.setId(R.id.play_btn);
    ShapeImageView localShapeImageView = this.l.a();
    localShapeImageView.setId(R.id.preview);
    localShapeImageView.setSelector(R.drawable.fm_video_item_bg_selector);
    localFrameLayout.addView(localShapeImageView, new FrameLayout.LayoutParams(-1, -1));
    int i = j.a(40.0F);
    localFrameLayout.addView(localPlayableImageView, new FrameLayout.LayoutParams(i, i, 17));
    return localFrameLayout;
  }

  public VideoMessage j()
  {
    return this.o;
  }

  public static class a
    implements e.b
  {
    private final MediaPlayer.VisualSpec a;
    private final MediaPlayerControls.VisualSpec b;

    public a(MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1)
    {
      this.a = paramVisualSpec;
      this.b = paramVisualSpec1;
    }

    public void a()
    {
      ViberActionRunner.w.b(ViberApplication.getApplication(), this.a, this.b, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.o
 * JD-Core Version:    0.6.2
 */