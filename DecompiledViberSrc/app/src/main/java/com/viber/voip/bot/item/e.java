package com.viber.voip.bot.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.j;
import com.viber.voip.util.bf;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

class e extends j
{
  private static final Logger b = ViberEnv.getLogger();
  private final Context c;
  private final float d;

  e(Context paramContext, float paramFloat)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramFloat;
  }

  private a a()
  {
    return new a(-1);
  }

  private void a(Editable paramEditable)
  {
    a locala = (a)bf.a(paramEditable, a.class);
    if (locala != null)
    {
      int i = locala.a();
      if ((i >= 12) && (i <= 32))
      {
        int j = (int)TypedValue.applyDimension(2, locala.a(), this.c.getResources().getDisplayMetrics());
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = new RelativeSizeSpan(j / this.d);
        bf.a(paramEditable, locala, arrayOfObject);
      }
    }
    else
    {
      return;
    }
    paramEditable.removeSpan(locala);
  }

  private void a(Editable paramEditable, String paramString)
  {
    try
    {
      bf.a(paramEditable, new a(Integer.parseInt(paramString)));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      bf.a(paramEditable, a());
    }
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if ((this.a != null) && ("font".equalsIgnoreCase(paramString2)))
      a(this.a);
    super.endElement(paramString1, paramString2, paramString3);
  }

  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    super.handleTag(paramBoolean, paramString, paramEditable, paramXMLReader);
    if (paramBoolean)
      if ("s".equalsIgnoreCase(paramString))
        bf.a(paramEditable, new b(null));
    while (!"s".equalsIgnoreCase(paramString))
      return;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new StrikethroughSpan();
    bf.a(paramEditable, b.class, arrayOfObject);
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if ((this.a != null) && ("font".equalsIgnoreCase(paramString2)))
    {
      String str = paramAttributes.getValue("", "size");
      if (str == null)
        break label54;
      a(this.a, str);
    }
    while (true)
    {
      super.startElement(paramString1, paramString2, paramString3, paramAttributes);
      return;
      label54: bf.a(this.a, a());
    }
  }

  private static class a
  {
    private final int a;

    a(int paramInt)
    {
      this.a = paramInt;
    }

    public int a()
    {
      return this.a;
    }
  }

  private static class b
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.item.e
 * JD-Core Version:    0.6.2
 */