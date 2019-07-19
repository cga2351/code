package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AudioPttControlView;

public class am
  implements f
{
  public final AnimatedLikesView a;
  public final TextView b;
  public final ImageView c;
  public final ImageView d;
  public final ImageView e;
  public final ImageView f;
  public final View g;
  public final ImageView h;
  public final AudioPttVolumeBarsView i;
  public final View j;
  public final AudioPttControlView k;
  public final TextView l;
  public final TextView m;
  public final TextView n;
  public final TextView o;
  public final View p;
  public final View q;
  public final View r;
  public final View s;
  public final TextView t;

  public am(View paramView)
  {
    this.a = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.b = ((TextView)paramView.findViewById(R.id.timestampView));
    this.c = ((ImageView)paramView.findViewById(R.id.locationView));
    this.e = ((ImageView)paramView.findViewById(R.id.statusView));
    this.f = ((ImageView)paramView.findViewById(R.id.resendView));
    this.d = ((ImageView)paramView.findViewById(R.id.broadcastView));
    this.g = paramView.findViewById(R.id.balloonView);
    this.m = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.n = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.o = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.p = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.q = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.r = paramView.findViewById(R.id.headersSpace);
    this.s = paramView.findViewById(R.id.selectionView);
    this.t = ((TextView)paramView.findViewById(R.id.referralView));
    this.h = ((ImageView)paramView.findViewById(R.id.mediaVoiceControlView));
    this.i = ((AudioPttVolumeBarsView)paramView.findViewById(R.id.mediaVoiceVolumeView));
    this.j = paramView.findViewById(R.id.volumeBarsTouchDelegateView);
    this.k = ((AudioPttControlView)paramView.findViewById(R.id.mediaVoiceProgressbarView));
    this.l = ((TextView)paramView.findViewById(R.id.mediaVoiceDurationView));
  }

  public View a()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.am
 * JD-Core Version:    0.6.2
 */