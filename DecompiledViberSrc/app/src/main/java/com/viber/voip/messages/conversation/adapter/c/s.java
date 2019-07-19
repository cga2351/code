package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AudioPttControlView;
import com.viber.voip.widget.AvatarWithInitialsView;

public class s
  implements f
{
  public final AvatarWithInitialsView a;
  public final TextView b;
  public final AnimatedLikesView c;
  public final TextView d;
  public final ImageView e;
  public final View f;
  public final TextView g;
  public final TextView h;
  public final TextView i;
  public final View j;
  public final View k;
  public final View l;
  public final ImageView m;
  public final TextView n;
  public final ImageView o;
  public final AudioPttVolumeBarsView p;
  public final View q;
  public final AudioPttControlView r;
  public final TextView s;
  public final View t;

  public s(View paramView)
  {
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.b = ((TextView)paramView.findViewById(R.id.nameView));
    this.c = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.d = ((TextView)paramView.findViewById(R.id.timestampView));
    this.e = ((ImageView)paramView.findViewById(R.id.locationView));
    this.f = paramView.findViewById(R.id.balloonView);
    this.g = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.j = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.k = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.l = paramView.findViewById(R.id.headersSpace);
    this.t = paramView.findViewById(R.id.selectionView);
    this.m = ((ImageView)paramView.findViewById(R.id.adminIndicatorView));
    this.n = ((TextView)paramView.findViewById(R.id.referralView));
    this.o = ((ImageView)paramView.findViewById(R.id.mediaVoiceControlView));
    this.p = ((AudioPttVolumeBarsView)paramView.findViewById(R.id.mediaVoiceVolumeView));
    this.q = paramView.findViewById(R.id.volumeBarsTouchDelegateView);
    this.r = ((AudioPttControlView)paramView.findViewById(R.id.mediaVoiceProgressbarView));
    this.s = ((TextView)paramView.findViewById(R.id.mediaVoiceDurationView));
  }

  public View a()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.s
 * JD-Core Version:    0.6.2
 */