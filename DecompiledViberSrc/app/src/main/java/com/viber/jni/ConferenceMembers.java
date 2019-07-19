package com.viber.jni;

import android.os.Bundle;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

public class ConferenceMembers
{
  private ArrayList<Pair<String, String>> mConferenceMembers = new ArrayList();

  public void add(String paramString1, String paramString2)
  {
    this.mConferenceMembers.add(Pair.create(paramString1, paramString2));
  }

  Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    if (this.mConferenceMembers.isEmpty())
      return localBundle;
    String[] arrayOfString1 = new String[this.mConferenceMembers.size()];
    String[] arrayOfString2 = new String[this.mConferenceMembers.size()];
    Iterator localIterator = this.mConferenceMembers.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Pair localPair = (Pair)localIterator.next();
      arrayOfString1[i] = localPair.first.toString();
      j = i + 1;
      arrayOfString2[i] = localPair.second.toString();
    }
    localBundle.putStringArray("mids", arrayOfString1);
    localBundle.putStringArray("names", arrayOfString2);
    return localBundle;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ConferenceMembers
 * JD-Core Version:    0.6.2
 */