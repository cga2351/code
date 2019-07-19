package com.viber.voip.ui;

import android.text.Editable;
import android.text.Html.TagHandler;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class j
  implements Html.TagHandler, ContentHandler
{
  protected Editable a;
  private ContentHandler b;

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.b != null)
      this.b.characters(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void endDocument()
    throws SAXException
  {
    if (this.b != null)
      this.b.endDocument();
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (this.b != null)
      this.b.endElement(paramString1, paramString2, paramString3);
  }

  public void endPrefixMapping(String paramString)
    throws SAXException
  {
    if (this.b != null)
      this.b.endPrefixMapping(paramString);
  }

  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if (paramBoolean)
      if ("update_handler".equalsIgnoreCase(paramString))
      {
        this.b = paramXMLReader.getContentHandler();
        paramXMLReader.setContentHandler(this);
        this.a = paramEditable;
      }
    while (!"update_handler".equalsIgnoreCase(paramString))
      return;
    paramXMLReader.setContentHandler(this.b);
    this.b = null;
    this.a = null;
  }

  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.b != null)
      this.b.ignorableWhitespace(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void processingInstruction(String paramString1, String paramString2)
    throws SAXException
  {
    if (this.b != null)
      this.b.processingInstruction(paramString1, paramString2);
  }

  public void setDocumentLocator(Locator paramLocator)
  {
    if (this.b != null)
      this.b.setDocumentLocator(paramLocator);
  }

  public void skippedEntity(String paramString)
    throws SAXException
  {
    if (this.b != null)
      this.b.skippedEntity(paramString);
  }

  public void startDocument()
    throws SAXException
  {
    if (this.b != null)
      this.b.startDocument();
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (this.b != null)
      this.b.startElement(paramString1, paramString2, paramString3, paramAttributes);
  }

  public void startPrefixMapping(String paramString1, String paramString2)
    throws SAXException
  {
    if (this.b != null)
      this.b.startPrefixMapping(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.j
 * JD-Core Version:    0.6.2
 */