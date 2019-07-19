package com.viber.voip.viberout.ui.products;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import com.viber.voip.R.color;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import java.util.Locale;

public class e
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private Context b;
  private g c;

  public e(Context paramContext, g paramg)
  {
    this.b = paramContext;
    this.c = paramg;
  }

  public String a()
  {
    if (this.b != null)
    {
      if (bp.a(this.b))
        return this.c.a(a.a.a, true);
      if (bp.a(this.b.getResources()).getLanguage().startsWith("ru"))
        return this.c.a(a.a.b, true);
    }
    return null;
  }

  public String a(String paramString)
  {
    String str = this.c.a(a.a.c, true);
    if ((this.b != null) && (bp.a(this.b)) && (!da.b(str)))
      paramString = String.format("%s %s", new Object[] { str, paramString });
    return paramString;
  }

  public ColorStateList b()
  {
    String str = this.c.a(a.a.e, true);
    try
    {
      if ((this.b != null) && (!da.b(str)) && (Color.parseColor(str) == ContextCompat.getColor(this.b, R.color.blue_button_idle)))
      {
        ColorStateList localColorStateList = ContextCompat.getColorStateList(this.b, R.color.btn_solid_blue);
        return localColorStateList;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.e
 * JD-Core Version:    0.6.2
 */