package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.design.b.a;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater
{
  protected AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new a(paramContext, paramAttributeSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.6.2
 */