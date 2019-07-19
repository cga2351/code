package com.viber.voip.messages.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.ui.bf;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AudioPttControlView;
import com.viber.voip.widget.PreviewAudioTrashView;
import com.viber.voip.widget.c;

public class PreviewPttMessageView extends ConstraintLayout
  implements View.OnTouchListener
{
  private long g = 300L;
  private PreviewAudioTrashView h;
  private Animator.AnimatorListener i;
  private a j;
  private bf k;
  private GestureDetector l;
  private b m;

  public PreviewPttMessageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PreviewPttMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public PreviewPttMessageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.preview_ptt_message_view, this, true);
    this.m = new b();
    ImageView localImageView = (ImageView)localView.findViewById(R.id.playControlView);
    Drawable localDrawable1 = dc.g(paramContext, R.attr.conversationPttPreviewPlayIcon);
    Drawable localDrawable2 = dc.g(paramContext, R.attr.conversationPttPreviewPauseIcon);
    this.k = new bf(localImageView, (AudioPttVolumeBarsView)localView.findViewById(R.id.mediaVoiceVolumeView), localView.findViewById(R.id.volumeBarsTouchDelegateView), (AudioPttControlView)localView.findViewById(R.id.mediaVoiceProgressbarView), (TextView)localView.findViewById(R.id.mediaVoiceDurationView), ViberApplication.getInstance().getMessagesManager().c(), ViberApplication.getInstance().getMessagesManager().m(), av.a(av.e.a), paramContext, ce.a, localDrawable1, localDrawable1, localDrawable2);
    this.l = new GestureDetector(this.k.a().getContext(), this.m);
    this.k.a().setOnTouchListener(this);
    this.h = ((PreviewAudioTrashView)localView.findViewById(R.id.trashIconView));
    this.h.setOnClickListener(new cf(this));
    this.i = new c()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!this.b)
        {
          dj.b(PreviewPttMessageView.this, false);
          PreviewPttMessageView.a(PreviewPttMessageView.this).c();
        }
      }
    };
    localImageView.setOnClickListener(new cg(this));
  }

  public void a(MessageEntity paramMessageEntity)
  {
    this.k.a(new aa(paramMessageEntity), false);
  }

  public void b()
  {
    animate().alpha(0.0F).setDuration(this.g).setListener(this.i);
  }

  public void c()
  {
    setAlpha(0.0F);
    dj.b(this, true);
    animate().alpha(1.0F).setDuration(this.g).setListener(null);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = this.l.onTouchEvent(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    if ((3 == n) || (1 == n) || (4 == n))
      this.m.a();
    return bool;
  }

  public void setPreviewDeletedListener(a parama)
  {
    this.j = parama;
  }

  public static abstract interface a
  {
    public abstract void z();
  }

  class b extends GestureDetector.SimpleOnGestureListener
  {
    b()
    {
    }

    void a()
    {
      PreviewPttMessageView.a(PreviewPttMessageView.this).b(PreviewPttMessageView.a(PreviewPttMessageView.this).a());
    }

    public boolean onDown(MotionEvent paramMotionEvent)
    {
      PreviewPttMessageView.a(PreviewPttMessageView.this).a(PreviewPttMessageView.a(PreviewPttMessageView.this).a());
      return true;
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      PreviewPttMessageView.a(PreviewPttMessageView.this).a(PreviewPttMessageView.a(PreviewPttMessageView.this).a(), paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      return true;
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      PreviewPttMessageView.a(PreviewPttMessageView.this).d();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.PreviewPttMessageView
 * JD-Core Version:    0.6.2
 */