package com.viber.voip.messages.ui.d.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.tones.IRingtonePlayer;

public abstract class b<PRESENTER extends a> extends ConstraintLayout
{
  protected static final Logger g = ViberEnv.getLogger();
  protected PRESENTER h;
  protected TextView i;
  private TextView j;
  private ImageView k;
  private ImageView l;

  public b(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    a(LayoutInflater.from(paramContext));
    b();
  }

  private void b(boolean paramBoolean)
  {
    if (this.h != null)
      this.h.a(paramBoolean);
  }

  private void c()
  {
    if (this.h != null)
    {
      ViberApplication.getInstance().getRingtonePlayer().stopStickerPromo();
      this.h.a();
    }
  }

  protected abstract void a(LayoutInflater paramLayoutInflater);

  public void a(boolean paramBoolean)
  {
    if ((this.k.getDrawable() instanceof com.viber.voip.ui.d.d))
    {
      ((com.viber.voip.ui.d.d)this.k.getDrawable()).a();
      this.k.invalidate();
    }
    b(paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.l.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    ImageView localImageView = this.l;
    if (paramBoolean2);
    for (int m = R.drawable.ic_sticker_sound; ; m = R.drawable.ic_sticker_anim)
    {
      localImageView.setImageResource(m);
      return;
    }
  }

  protected void b()
  {
    this.k = ((ImageView)findViewById(R.id.thumbnail));
    this.k.setOnClickListener(new c(this));
    this.j = ((TextView)findViewById(R.id.name));
    this.i = ((TextView)findViewById(R.id.download_button));
    this.i.setOnClickListener(new d(this));
    this.l = ((ImageView)findViewById(R.id.play_button));
  }

  public void setName(String paramString)
  {
    this.j.setText(com.viber.common.d.c.b(paramString));
  }

  public void setPresenter(PRESENTER paramPRESENTER)
  {
    this.h = paramPRESENTER;
  }

  public void setThumbnail(Drawable paramDrawable)
  {
    this.k.setImageDrawable(paramDrawable);
  }

  public abstract void setWeight(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.b
 * JD-Core Version:    0.6.2
 */