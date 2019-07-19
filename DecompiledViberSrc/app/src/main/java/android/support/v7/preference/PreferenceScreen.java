package android.support.v7.preference;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;

public final class PreferenceScreen extends PreferenceGroup
{
  private boolean b = true;

  public PreferenceScreen(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.preferenceScreenStyle, 16842891));
  }

  protected boolean f()
  {
    return false;
  }

  public boolean i()
  {
    return this.b;
  }

  protected void k()
  {
    if ((r() != null) || (s() != null) || (e() == 0));
    j.b localb;
    do
    {
      return;
      localb = L().j();
    }
    while (localb == null);
    localb.b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.PreferenceScreen
 * JD-Core Version:    0.6.2
 */