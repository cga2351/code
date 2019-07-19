package com.viber.voip.messages.ui.media.player.a;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.viber.common.d.a;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.messages.ui.media.player.a.a.c;
import com.viber.voip.util.ae;
import com.viber.voip.util.ch;
import com.viber.voip.util.dj;

public class f extends b<c>
{
  protected Toolbar m;
  protected View n;
  protected TextView o;
  protected TextView p;

  public f(View paramView)
  {
    this.m = ((Toolbar)paramView.findViewById(R.id.video_url_web_player_expanded_toolbar));
    this.m.setOnClickListener(this);
    a(this.m);
    this.g = ((ImageView)paramView.findViewById(R.id.video_url_web_player_expanded_play_pause_button));
    this.g.setOnClickListener(this);
    this.h = ((ImageView)paramView.findViewById(R.id.video_url_web_player_collapsed_send_button));
    this.h.setOnClickListener(this);
    this.n = paramView.findViewById(R.id.bottom_section);
    this.o = ((TextView)paramView.findViewById(R.id.current_time));
    this.p = ((TextView)paramView.findViewById(R.id.all_time));
    this.i = ((SeekBar)paramView.findViewById(R.id.seek_bar));
    Drawable localDrawable;
    if (!a.g())
    {
      if (!a.a())
        break label209;
      localDrawable = this.i.getThumb();
      if (localDrawable == null)
        break label223;
    }
    label209: label223: for (int i = localDrawable.getIntrinsicWidth(); ; i = 0)
    {
      if (i > 0)
        this.i.setThumbOffset(i / 2);
      this.f = paramView.findViewById(R.id.video_url_web_player_expanded_controls);
      this.j = new c(this.m, this.n, this.g);
      return;
      localDrawable = ContextCompat.getDrawable(paramView.getContext(), R.drawable.preview_media_seek_thumb);
      break;
    }
  }

  private void a(Toolbar paramToolbar)
  {
    paramToolbar.inflateMenu(R.menu.menu_full_screen_video_player);
    paramToolbar.setNavigationIcon(R.drawable.ic_ab_theme_dark_back);
    paramToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        f.this.a.j();
      }
    });
    Menu localMenu = paramToolbar.getMenu();
    for (int i = 0; i < localMenu.size(); i++)
    {
      View localView = localMenu.getItem(i).getActionView();
      if (localView != null)
        localView.setOnClickListener(this);
    }
  }

  protected void a(int paramInt)
  {
    super.a(paramInt);
    MenuItem localMenuItem = this.m.getMenu().findItem(R.id.menu_favorite_links_bot);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      localMenuItem.setVisible(false);
      return;
    case 1:
      localMenuItem.setVisible(true);
      ((ImageView)localMenuItem.getActionView()).setImageResource(R.drawable.ic_embedded_player_expanded_favorites);
      return;
    case 2:
    }
    localMenuItem.setVisible(true);
    ((ImageView)localMenuItem.getActionView()).setImageResource(R.drawable.ic_media_preview_favorites_highlighted);
  }

  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    super.a(paramInt, paramLong1, paramLong2);
    this.o.setText(ae.h(paramLong2));
    this.p.setText(ae.h(paramLong1));
  }

  protected void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    this.m.setTitle(paramCharSequence);
  }

  public void b(int paramInt)
  {
    super.b(paramInt);
    dj.b(this.n, ch.c(paramInt));
    dj.b(this.m, ch.d(paramInt));
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.menu_collapse)
    {
      this.a.k();
      return;
    }
    if (i == R.id.menu_favorite_links_bot)
    {
      this.a.l();
      return;
    }
    if (i == R.id.video_url_web_player_expanded_toolbar)
    {
      j();
      return;
    }
    if (i == R.id.video_url_web_player_collapsed_send_button)
    {
      this.a.m();
      return;
    }
    super.onClick(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.f
 * JD-Core Version:    0.6.2
 */