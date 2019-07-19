package android.support.design.a;

import android.support.design.R.id;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class d extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> a = new d("childrenAlpha");

  private d(String paramString)
  {
    super(Float.class, paramString);
  }

  public Float a(ViewGroup paramViewGroup)
  {
    Float localFloat = (Float)paramViewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
    if (localFloat != null)
      return localFloat;
    return Float.valueOf(1.0F);
  }

  public void a(ViewGroup paramViewGroup, Float paramFloat)
  {
    float f = paramFloat.floatValue();
    paramViewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int i = 0;
    int j = paramViewGroup.getChildCount();
    while (i < j)
    {
      paramViewGroup.getChildAt(i).setAlpha(f);
      i++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.d
 * JD-Core Version:    0.6.2
 */