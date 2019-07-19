package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
{
  private static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public int a = -1;
  public int b = -1;

  private boolean a(String paramString)
  {
    Matcher localMatcher = c.matcher(paramString);
    if (localMatcher.find())
      try
      {
        int i = Integer.parseInt(localMatcher.group(1), 16);
        int j = Integer.parseInt(localMatcher.group(2), 16);
        if ((i > 0) || (j > 0))
        {
          this.a = i;
          this.b = j;
          return true;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return false;
  }

  public boolean a()
  {
    return (this.a != -1) && (this.b != -1);
  }

  public boolean a(int paramInt)
  {
    int i = paramInt >> 12;
    int j = paramInt & 0xFFF;
    if ((i > 0) || (j > 0))
    {
      this.a = i;
      this.b = j;
      return true;
    }
    return false;
  }

  public boolean a(Metadata paramMetadata)
  {
    for (int i = 0; ; i++)
    {
      int j = paramMetadata.length();
      boolean bool = false;
      Metadata.Entry localEntry;
      if (i < j)
      {
        localEntry = paramMetadata.get(i);
        if ((localEntry instanceof CommentFrame))
        {
          CommentFrame localCommentFrame = (CommentFrame)localEntry;
          if ((!"iTunSMPB".equals(localCommentFrame.description)) || (!a(localCommentFrame.text)))
            continue;
          bool = true;
        }
      }
      else
      {
        return bool;
      }
      if ((localEntry instanceof InternalFrame))
      {
        InternalFrame localInternalFrame = (InternalFrame)localEntry;
        if (("com.apple.iTunes".equals(localInternalFrame.domain)) && ("iTunSMPB".equals(localInternalFrame.description)) && (a(localInternalFrame.text)))
          return true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.k
 * JD-Core Version:    0.6.2
 */