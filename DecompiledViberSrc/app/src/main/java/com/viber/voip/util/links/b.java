package com.viber.voip.util.links;

import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.util.da;

public class b
{
  public static void a(MsgInfo paramMsgInfo, String paramString1, String paramString2, LinkParser.Preview paramPreview)
  {
    MsgInfo.a locala = MsgInfo.a.fromName(paramPreview.type);
    paramMsgInfo.setText(paramString1);
    if (MsgInfo.a.DEFAULT == locala);
    while (true)
    {
      paramMsgInfo.setUrl(paramString2);
      paramMsgInfo.setTitle(da.d(paramPreview.title, 100));
      paramMsgInfo.setThumbnailUrl(paramPreview.thumbnail);
      paramMsgInfo.setUrlType(locala);
      paramMsgInfo.setContentType(paramPreview.contentType);
      paramMsgInfo.setContentLength(paramPreview.contentLength);
      paramMsgInfo.setThumbnailContentType(paramPreview.thumbnailContentType);
      return;
      paramString2 = paramPreview.url;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.b
 * JD-Core Version:    0.6.2
 */