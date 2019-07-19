package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class PullProvider
  implements Provider
{
  private final XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

  public PullProvider()
    throws Exception
  {
    this.factory.setNamespaceAware(true);
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.factory.newPullParser();
    if (paramInputStream != null)
      localXmlPullParser.setInput(paramInputStream, null);
    return new PullReader(localXmlPullParser);
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.factory.newPullParser();
    if (paramReader != null)
      localXmlPullParser.setInput(paramReader);
    return new PullReader(localXmlPullParser);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.PullProvider
 * JD-Core Version:    0.6.2
 */