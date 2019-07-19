package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.ProgressBar;

class q extends RelativeLayout
  implements h.a
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private ProgressBar j;
  private ShapeImageView k;
  private ImageView l;
  private ViberTextView m;
  private TextView n;

  public q(Context paramContext)
  {
    super(paramContext);
    g();
  }

  private void g()
  {
    Resources localResources = getContext().getResources();
    this.b = localResources.getDimensionPixelSize(R.dimen.suggest_pg_item_width);
    this.c = localResources.getDimensionPixelSize(R.dimen.suggest_pg_item_height);
    this.d = localResources.getDimensionPixelSize(R.dimen.suggest_pg_stroke_width);
    this.e = (this.b - 2 * this.d);
    this.f = localResources.getDimensionPixelSize(R.dimen.pgroups_suggestion_text_horizontal_padding);
    this.g = localResources.getDimensionPixelSize(R.dimen.pgroups_suggestion_text_top_padding);
    this.h = localResources.getDimensionPixelSize(R.dimen.pgroups_suggestion_text_middle_padding);
    this.i = localResources.getDimensionPixelSize(R.dimen.pgroups_suggestion_text_bottom_padding);
  }

  public void a()
  {
    Resources localResources = getContext().getResources();
    setLayoutParams(new RelativeLayout.LayoutParams(this.b, this.c));
    setPadding(this.d, this.d, this.d, this.d);
    setBackgroundResource(R.drawable.item_public_group_suggestion_bg);
    this.j = new ProgressBar(getContext());
    this.j.setProgressColor(getContext().getResources().getColor(R.color.progress_gray));
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(this.e / 3, this.e / 3);
    localLayoutParams1.topMargin = (this.e / 2 - this.e / 6);
    localLayoutParams1.leftMargin = localLayoutParams1.topMargin;
    addView(this.j, localLayoutParams1);
    this.k = new ShapeImageView(getContext());
    this.k.setId(R.id.public_group_suggestion_image_id);
    this.k.setShape(b.b.b);
    this.k.setRoundedCornerMask(3);
    this.k.setCornerRadius(localResources.getDimensionPixelSize(R.dimen.media_image_corner_radius_small));
    addView(this.k, new RelativeLayout.LayoutParams(this.e, this.e));
    this.l = new ImageView(getContext());
    this.l.setId(R.id.public_group_suggestion_verified_id);
    this.l.setImageResource(dc.a(getContext(), R.attr.conversationsListItemVerifiedAccountBadge));
    this.l.setVisibility(8);
    this.l.setPadding(0, 0, this.f, 0);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, this.k.getId());
    localLayoutParams2.addRule(11);
    addView(this.l, localLayoutParams2);
    this.m = new ViberTextView(getContext());
    this.m.setId(R.id.public_group_suggestion_name_id);
    this.m.setMaxWidth(this.e);
    this.m.setTextColor(localResources.getColor(R.color.main_text));
    this.m.setTextSize(2, 12.0F);
    this.m.setMaxLines(2);
    this.m.setEllipsize(TextUtils.TruncateAt.END);
    this.m.setPadding(this.f, this.g, this.f, this.h);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams3.addRule(3, this.k.getId());
    localLayoutParams3.addRule(0, this.l.getId());
    addView(this.m, localLayoutParams3);
    this.n = new ViberTextView(getContext());
    this.n.setTextColor(localResources.getColor(R.color.weak_text));
    this.n.setTextSize(2, 12.0F);
    this.n.setSingleLine(true);
    this.n.setEllipsize(TextUtils.TruncateAt.END);
    this.n.setPadding(this.f, 0, this.f, this.i);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams4.addRule(3, this.m.getId());
    addView(this.n, localLayoutParams4);
  }

  public ViberTextView b()
  {
    return this.m;
  }

  public View c()
  {
    return this.l;
  }

  public TextView d()
  {
    return this.n;
  }

  public ImageView e()
  {
    return this.k;
  }

  public void f()
  {
    if (this.j != null);
    try
    {
      this.j.setVisibility(8);
      removeView(this.j);
      this.j = null;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.q
 * JD-Core Version:    0.6.2
 */