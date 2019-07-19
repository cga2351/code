package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.support.v7.preference.Preference;
import android.support.v7.preference.l;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.ui.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class PreferenceWithImage extends Preference
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private ShapeDrawable c;

  public PreferenceWithImage(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PreferenceWithImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public PreferenceWithImage(Context paramContext, String paramString)
  {
    super(paramContext);
    a(paramContext);
    this.b = paramString;
  }

  private void a(Context paramContext)
  {
    c(R.layout.layout_preference_with_image);
    Resources localResources = paramContext.getResources();
    this.c = new ShapeDrawable(new a(localResources.getDimensionPixelSize(R.dimen.public_group_info_background_icon_corner_radius), 15, localResources.getDimensionPixelSize(R.dimen.bg_pref_border_size)));
    this.c.getPaint().setColor(dc.d(paramContext, R.attr.backgroundIconStrokeColor));
  }

  public void a(l paraml)
  {
    super.a(paraml);
    ((TextView)paraml.a(R.id.text1)).setText(y());
    ImageView localImageView = (ImageView)paraml.a(R.id.image_bg);
    localImageView.setBackground(this.c);
    if (TextUtils.isEmpty(this.b))
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
    try
    {
      f localf = f.a(ViberApplication.getApplication());
      e.a(I()).a(Uri.parse(this.b), localImageView, localf);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(String paramString)
  {
    this.b = paramString;
    d_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PreferenceWithImage
 * JD-Core Version:    0.6.2
 */