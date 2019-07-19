package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int height;
  private final int width;

  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    URL localURL = getTileUrl(paramInt1, paramInt2, paramInt3);
    if (localURL == null)
      return NO_TILE;
    try
    {
      int i = this.width;
      int j = this.height;
      InputStream localInputStream = localURL.openStream();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int k = localInputStream.read(arrayOfByte);
        if (k == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
      }
      Tile localTile = new Tile(i, j, localByteArrayOutputStream.toByteArray());
      return localTile;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.UrlTileProvider
 * JD-Core Version:    0.6.2
 */