package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm;

import android.text.Editable;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.ui.j;
import com.viber.voip.util.bf;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class a extends j
{
  private final View.OnClickListener b;

  public a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if ("lnk".equalsIgnoreCase(paramString2))
      super.endElement(paramString1, paramString2, paramString3);
  }

  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    super.handleTag(paramBoolean, paramString, paramEditable, paramXMLReader);
    if (paramBoolean)
      if ("lnk".equalsIgnoreCase(paramString))
        bf.a(paramEditable, new a(null));
    while (!"lnk".equalsIgnoreCase(paramString))
      return;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        a.a(a.this).onClick(paramAnonymousView);
      }
    };
    arrayOfObject[1] = new UnderlineSpan();
    arrayOfObject[2] = new StyleSpan(1);
    bf.a(paramEditable, a.class, arrayOfObject);
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if ("lnk".equalsIgnoreCase(paramString2))
      super.startElement(paramString1, paramString2, paramString3, paramAttributes);
  }

  private static class a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.a
 * JD-Core Version:    0.6.2
 */