package com.viber.voip.gallery.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.util.dk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d extends b<ArrayList<GalleryItem>>
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "_id", "mime_type" };
  private final int c;
  private final List<GalleryItem> d;

  public d(List<GalleryItem> paramList, int paramInt, Context paramContext)
  {
    super(paramContext);
    this.d = paramList;
    this.c = paramInt;
  }

  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(" DESC");
    if (paramInt > 0)
      localStringBuilder.append(" LIMIT ").append(paramInt);
    return localStringBuilder.toString();
  }

  private static String a(String paramString, List<Long> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList.size() > 0)
    {
      localStringBuilder.append(paramString).append(" IN(");
      localStringBuilder.append(TextUtils.join(",", paramList));
      localStringBuilder.append(")");
    }
    return localStringBuilder.toString();
  }

  private void a(ArrayList<GalleryItem> paramArrayList)
  {
    if (this.c > 0);
    for (List localList = this.d.subList(0, this.c); ; localList = this.d)
    {
      paramArrayList.addAll(localList);
      return;
    }
  }

  private void b(ArrayList<GalleryItem> paramArrayList)
  {
    ContentResolver localContentResolver = getContext().getContentResolver();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      String str3 = ((GalleryItem)localIterator.next()).getItemUri().getLastPathSegment();
      try
      {
        localArrayList.add(Long.valueOf(Long.parseLong(str3)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
    Cursor localCursor = localContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, b, a("_id", localArrayList), null, a("datetaken", this.c));
    if (localCursor != null)
      try
      {
        if (localCursor.moveToNext())
        {
          String str1 = localCursor.getString(localCursor.getColumnIndex("_id"));
          String str2 = localCursor.getString(localCursor.getColumnIndex("mime_type"));
          paramArrayList.add(GalleryItem.from(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(str1).build(), str2));
        }
      }
      finally
      {
        localCursor.close();
      }
  }

  public ArrayList<GalleryItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d.size() > 0)
    {
      if (dk.b(((GalleryItem)this.d.get(0)).getItemUri()))
        a(localArrayList);
    }
    else
      return localArrayList;
    b(localArrayList);
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.b.d
 * JD-Core Version:    0.6.2
 */