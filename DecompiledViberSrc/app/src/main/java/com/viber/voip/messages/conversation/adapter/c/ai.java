package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.StickerClickerConstraintHelper;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AnimatedSoundIconView;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.ClickGroup;
import com.viber.voip.widget.ProgressBar;

public class ai
  implements f
{
  public final AnimatedLikesView a;
  public final TextView b;
  public final ImageView c;
  public final ImageView d;
  public final ImageView e;
  public final ImageView f;
  public final View g;
  public final TextView h;
  public final TextView i;
  public final TextView j;
  public final View k;
  public final View l;
  public final View m;
  public final View n;
  public final TextView o;
  public final ClickGroup p;
  public final ImageView q;
  public final StickerSvgContainer r;
  public final ImageView s;
  public final ProgressBar t;
  public final ImageView u;
  public final StickerClickerConstraintHelper v;
  public final AnimatedSoundIconView w;

  public ai(View paramView)
  {
    this.a = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.b = ((TextView)paramView.findViewById(R.id.timestampView));
    this.c = ((ImageView)paramView.findViewById(R.id.locationView));
    this.d = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.e = ((ImageView)paramView.findViewById(R.id.statusView));
    this.f = ((ImageView)paramView.findViewById(R.id.resendView));
    this.g = paramView.findViewById(R.id.balloonView);
    this.h = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.j = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.k = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.l = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.m = paramView.findViewById(R.id.headersSpace);
    this.n = paramView.findViewById(R.id.selectionView);
    this.o = ((TextView)paramView.findViewById(R.id.referralView));
    this.p = ((ClickGroup)paramView.findViewById(R.id.onClickHelperView));
    this.q = ((ImageView)paramView.findViewById(R.id.stickerImageView));
    this.r = ((StickerSvgContainer)paramView.findViewById(R.id.stickerSvgContainerView));
    this.s = ((ImageView)paramView.findViewById(R.id.stickerFrameView));
    this.t = ((ProgressBar)paramView.findViewById(R.id.stickerProgressView));
    this.u = ((ImageView)paramView.findViewById(R.id.offerClickerView));
    this.v = ((StickerClickerConstraintHelper)paramView.findViewById(R.id.clickerHelperView));
    this.w = ((AnimatedSoundIconView)paramView.findViewById(R.id.soundwavesIconView));
  }

  public View a()
  {
    if (this.r.getVisibility() == 0)
      return this.r;
    return this.q;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.ai
 * JD-Core Version:    0.6.2
 */