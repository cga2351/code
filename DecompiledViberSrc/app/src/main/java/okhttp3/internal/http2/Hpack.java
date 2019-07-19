package okhttp3.internal.http2;

import f.c;
import f.e;
import f.f;
import f.l;
import f.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;

final class Hpack
{
  static final Map<f, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  static final Header[] STATIC_HEADER_TABLE;

  static
  {
    Header[] arrayOfHeader = new Header[61];
    arrayOfHeader[0] = new Header(Header.TARGET_AUTHORITY, "");
    arrayOfHeader[1] = new Header(Header.TARGET_METHOD, "GET");
    arrayOfHeader[2] = new Header(Header.TARGET_METHOD, "POST");
    arrayOfHeader[3] = new Header(Header.TARGET_PATH, "/");
    arrayOfHeader[4] = new Header(Header.TARGET_PATH, "/index.html");
    arrayOfHeader[5] = new Header(Header.TARGET_SCHEME, "http");
    arrayOfHeader[6] = new Header(Header.TARGET_SCHEME, "https");
    arrayOfHeader[7] = new Header(Header.RESPONSE_STATUS, "200");
    arrayOfHeader[8] = new Header(Header.RESPONSE_STATUS, "204");
    arrayOfHeader[9] = new Header(Header.RESPONSE_STATUS, "206");
    arrayOfHeader[10] = new Header(Header.RESPONSE_STATUS, "304");
    arrayOfHeader[11] = new Header(Header.RESPONSE_STATUS, "400");
    arrayOfHeader[12] = new Header(Header.RESPONSE_STATUS, "404");
    arrayOfHeader[13] = new Header(Header.RESPONSE_STATUS, "500");
    arrayOfHeader[14] = new Header("accept-charset", "");
    arrayOfHeader[15] = new Header("accept-encoding", "gzip, deflate");
    arrayOfHeader[16] = new Header("accept-language", "");
    arrayOfHeader[17] = new Header("accept-ranges", "");
    arrayOfHeader[18] = new Header("accept", "");
    arrayOfHeader[19] = new Header("access-control-allow-origin", "");
    arrayOfHeader[20] = new Header("age", "");
    arrayOfHeader[21] = new Header("allow", "");
    arrayOfHeader[22] = new Header("authorization", "");
    arrayOfHeader[23] = new Header("cache-control", "");
    arrayOfHeader[24] = new Header("content-disposition", "");
    arrayOfHeader[25] = new Header("content-encoding", "");
    arrayOfHeader[26] = new Header("content-language", "");
    arrayOfHeader[27] = new Header("content-length", "");
    arrayOfHeader[28] = new Header("content-location", "");
    arrayOfHeader[29] = new Header("content-range", "");
    arrayOfHeader[30] = new Header("content-type", "");
    arrayOfHeader[31] = new Header("cookie", "");
    arrayOfHeader[32] = new Header("date", "");
    arrayOfHeader[33] = new Header("etag", "");
    arrayOfHeader[34] = new Header("expect", "");
    arrayOfHeader[35] = new Header("expires", "");
    arrayOfHeader[36] = new Header("from", "");
    arrayOfHeader[37] = new Header("host", "");
    arrayOfHeader[38] = new Header("if-match", "");
    arrayOfHeader[39] = new Header("if-modified-since", "");
    arrayOfHeader[40] = new Header("if-none-match", "");
    arrayOfHeader[41] = new Header("if-range", "");
    arrayOfHeader[42] = new Header("if-unmodified-since", "");
    arrayOfHeader[43] = new Header("last-modified", "");
    arrayOfHeader[44] = new Header("link", "");
    arrayOfHeader[45] = new Header("location", "");
    arrayOfHeader[46] = new Header("max-forwards", "");
    arrayOfHeader[47] = new Header("proxy-authenticate", "");
    arrayOfHeader[48] = new Header("proxy-authorization", "");
    arrayOfHeader[49] = new Header("range", "");
    arrayOfHeader[50] = new Header("referer", "");
    arrayOfHeader[51] = new Header("refresh", "");
    arrayOfHeader[52] = new Header("retry-after", "");
    arrayOfHeader[53] = new Header("server", "");
    arrayOfHeader[54] = new Header("set-cookie", "");
    arrayOfHeader[55] = new Header("strict-transport-security", "");
    arrayOfHeader[56] = new Header("transfer-encoding", "");
    arrayOfHeader[57] = new Header("user-agent", "");
    arrayOfHeader[58] = new Header("vary", "");
    arrayOfHeader[59] = new Header("via", "");
    arrayOfHeader[60] = new Header("www-authenticate", "");
    STATIC_HEADER_TABLE = arrayOfHeader;
  }

  static f checkLowercase(f paramf)
    throws IOException
  {
    int i = 0;
    int j = paramf.h();
    while (i < j)
    {
      int k = paramf.a(i);
      if ((k >= 65) && (k <= 90))
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramf.a());
      i++;
    }
    return paramf;
  }

  private static Map<f, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    for (int i = 0; i < STATIC_HEADER_TABLE.length; i++)
      if (!localLinkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name))
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
    return Collections.unmodifiableMap(localLinkedHashMap);
  }

  static final class Reader
  {
    Header[] dynamicTable = new Header[8];
    int dynamicTableByteCount = 0;
    int headerCount = 0;
    private final List<Header> headerList = new ArrayList();
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    int nextHeaderIndex = -1 + this.dynamicTable.length;
    private final e source;

    Reader(int paramInt1, int paramInt2, t paramt)
    {
      this.headerTableSizeSetting = paramInt1;
      this.maxDynamicTableByteCount = paramInt2;
      this.source = l.a(paramt);
    }

    Reader(int paramInt, t paramt)
    {
      this(paramInt, paramInt, paramt);
    }

    private void adjustDynamicTableByteCount()
    {
      if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
      {
        if (this.maxDynamicTableByteCount == 0)
          clearDynamicTable();
      }
      else
        return;
      evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
    }

    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (-1 + this.dynamicTable.length);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }

    private int dynamicTableIndex(int paramInt)
    {
      return paramInt + (1 + this.nextHeaderIndex);
    }

    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      if (paramInt > 0)
      {
        for (int j = -1 + this.dynamicTable.length; (j >= this.nextHeaderIndex) && (paramInt > 0); j--)
        {
          paramInt -= this.dynamicTable[j].hpackSize;
          this.dynamicTableByteCount -= this.dynamicTable[j].hpackSize;
          this.headerCount = (-1 + this.headerCount);
          i++;
        }
        System.arraycopy(this.dynamicTable, 1 + this.nextHeaderIndex, this.dynamicTable, i + (1 + this.nextHeaderIndex), this.headerCount);
        this.nextHeaderIndex = (i + this.nextHeaderIndex);
      }
      return i;
    }

    private f getName(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
        return Hpack.STATIC_HEADER_TABLE[paramInt].name;
      int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
      if ((i < 0) || (i >= this.dynamicTable.length))
        throw new IOException("Header index too large " + (paramInt + 1));
      return this.dynamicTable[i].name;
    }

    private void insertIntoDynamicTable(int paramInt, Header paramHeader)
    {
      this.headerList.add(paramHeader);
      int i = paramHeader.hpackSize;
      if (paramInt != -1)
        i -= this.dynamicTable[dynamicTableIndex(paramInt)].hpackSize;
      if (i > this.maxDynamicTableByteCount)
      {
        clearDynamicTable();
        return;
      }
      int j = evictToRecoverBytes(i + this.dynamicTableByteCount - this.maxDynamicTableByteCount);
      if (paramInt == -1)
      {
        if (1 + this.headerCount > this.dynamicTable.length)
        {
          Header[] arrayOfHeader = new Header[2 * this.dynamicTable.length];
          System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
          this.nextHeaderIndex = (-1 + this.dynamicTable.length);
          this.dynamicTable = arrayOfHeader;
        }
        int m = this.nextHeaderIndex;
        this.nextHeaderIndex = (m - 1);
        this.dynamicTable[m] = paramHeader;
        this.headerCount = (1 + this.headerCount);
      }
      while (true)
      {
        this.dynamicTableByteCount = (i + this.dynamicTableByteCount);
        return;
        int k = paramInt + (j + dynamicTableIndex(paramInt));
        this.dynamicTable[k] = paramHeader;
      }
    }

    private boolean isStaticHeader(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= -1 + Hpack.STATIC_HEADER_TABLE.length);
    }

    private int readByte()
      throws IOException
    {
      return 0xFF & this.source.i();
    }

    private void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        Header localHeader = Hpack.STATIC_HEADER_TABLE[paramInt];
        this.headerList.add(localHeader);
        return;
      }
      int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
      if ((i < 0) || (i >= this.dynamicTable.length))
        throw new IOException("Header index too large " + (paramInt + 1));
      this.headerList.add(this.dynamicTable[i]);
    }

    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
    }

    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
    }

    private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      f localf1 = getName(paramInt);
      f localf2 = readByteString();
      this.headerList.add(new Header(localf1, localf2));
    }

    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      f localf1 = Hpack.checkLowercase(readByteString());
      f localf2 = readByteString();
      this.headerList.add(new Header(localf1, localf2));
    }

    public List<Header> getAndResetHeaderList()
    {
      ArrayList localArrayList = new ArrayList(this.headerList);
      this.headerList.clear();
      return localArrayList;
    }

    int maxDynamicTableByteCount()
    {
      return this.maxDynamicTableByteCount;
    }

    f readByteString()
      throws IOException
    {
      int i = readByte();
      if ((i & 0x80) == 128);
      int k;
      for (int j = 1; ; j = 0)
      {
        k = readInt(i, 127);
        if (j == 0)
          break;
        return f.a(Huffman.get().decode(this.source.h(k)));
      }
      return this.source.d(k);
    }

    void readHeaders()
      throws IOException
    {
      while (!this.source.f())
      {
        int i = 0xFF & this.source.i();
        if (i == 128)
          throw new IOException("index == 0");
        if ((i & 0x80) == 128)
        {
          readIndexedHeader(-1 + readInt(i, 127));
        }
        else if (i == 64)
        {
          readLiteralHeaderWithIncrementalIndexingNewName();
        }
        else if ((i & 0x40) == 64)
        {
          readLiteralHeaderWithIncrementalIndexingIndexedName(-1 + readInt(i, 63));
        }
        else if ((i & 0x20) == 32)
        {
          this.maxDynamicTableByteCount = readInt(i, 31);
          if ((this.maxDynamicTableByteCount < 0) || (this.maxDynamicTableByteCount > this.headerTableSizeSetting))
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
          adjustDynamicTableByteCount();
        }
        else if ((i == 16) || (i == 0))
        {
          readLiteralHeaderWithoutIndexingNewName();
        }
        else
        {
          readLiteralHeaderWithoutIndexingIndexedName(-1 + readInt(i, 15));
        }
      }
    }

    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      int i = paramInt1 & paramInt2;
      if (i < paramInt2)
        return i;
      int k;
      for (int j = 0; ; j += 7)
      {
        k = readByte();
        if ((k & 0x80) == 0)
          break;
        paramInt2 += ((k & 0x7F) << j);
      }
      return paramInt2 + (k << j);
    }
  }

  static final class Writer
  {
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    Header[] dynamicTable = new Header[8];
    int dynamicTableByteCount = 0;
    private boolean emitDynamicTableSizeUpdate;
    int headerCount = 0;
    int headerTableSizeSetting;
    int maxDynamicTableByteCount;
    int nextHeaderIndex = -1 + this.dynamicTable.length;
    private final c out;
    private int smallestHeaderTableSizeSetting = 2147483647;
    private final boolean useCompression;

    Writer(int paramInt, boolean paramBoolean, c paramc)
    {
      this.headerTableSizeSetting = paramInt;
      this.maxDynamicTableByteCount = paramInt;
      this.useCompression = paramBoolean;
      this.out = paramc;
    }

    Writer(c paramc)
    {
      this(4096, true, paramc);
    }

    private void adjustDynamicTableByteCount()
    {
      if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
      {
        if (this.maxDynamicTableByteCount == 0)
          clearDynamicTable();
      }
      else
        return;
      evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
    }

    private void clearDynamicTable()
    {
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (-1 + this.dynamicTable.length);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }

    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      if (paramInt > 0)
      {
        for (int j = -1 + this.dynamicTable.length; (j >= this.nextHeaderIndex) && (paramInt > 0); j--)
        {
          paramInt -= this.dynamicTable[j].hpackSize;
          this.dynamicTableByteCount -= this.dynamicTable[j].hpackSize;
          this.headerCount = (-1 + this.headerCount);
          i++;
        }
        System.arraycopy(this.dynamicTable, 1 + this.nextHeaderIndex, this.dynamicTable, i + (1 + this.nextHeaderIndex), this.headerCount);
        Arrays.fill(this.dynamicTable, 1 + this.nextHeaderIndex, i + (1 + this.nextHeaderIndex), null);
        this.nextHeaderIndex = (i + this.nextHeaderIndex);
      }
      return i;
    }

    private void insertIntoDynamicTable(Header paramHeader)
    {
      int i = paramHeader.hpackSize;
      if (i > this.maxDynamicTableByteCount)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(i + this.dynamicTableByteCount - this.maxDynamicTableByteCount);
      if (1 + this.headerCount > this.dynamicTable.length)
      {
        Header[] arrayOfHeader = new Header[2 * this.dynamicTable.length];
        System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
        this.nextHeaderIndex = (-1 + this.dynamicTable.length);
        this.dynamicTable = arrayOfHeader;
      }
      int j = this.nextHeaderIndex;
      this.nextHeaderIndex = (j - 1);
      this.dynamicTable[j] = paramHeader;
      this.headerCount = (1 + this.headerCount);
      this.dynamicTableByteCount = (i + this.dynamicTableByteCount);
    }

    void setHeaderTableSizeSetting(int paramInt)
    {
      this.headerTableSizeSetting = paramInt;
      int i = Math.min(paramInt, 16384);
      if (this.maxDynamicTableByteCount == i)
        return;
      if (i < this.maxDynamicTableByteCount)
        this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, i);
      this.emitDynamicTableSizeUpdate = true;
      this.maxDynamicTableByteCount = i;
      adjustDynamicTableByteCount();
    }

    void writeByteString(f paramf)
      throws IOException
    {
      if ((this.useCompression) && (Huffman.get().encodedLength(paramf) < paramf.h()))
      {
        c localc = new c();
        Huffman.get().encode(paramf, localc);
        f localf = localc.q();
        writeInt(localf.h(), 127, 128);
        this.out.a(localf);
        return;
      }
      writeInt(paramf.h(), 127, 0);
      this.out.a(paramf);
    }

    void writeHeaders(List<Header> paramList)
      throws IOException
    {
      if (this.emitDynamicTableSizeUpdate)
      {
        if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount)
          writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
        this.emitDynamicTableSizeUpdate = false;
        this.smallestHeaderTableSizeSetting = 2147483647;
        writeInt(this.maxDynamicTableByteCount, 31, 32);
      }
      int i = paramList.size();
      int j = 0;
      Header localHeader;
      f localf1;
      f localf2;
      int k;
      int m;
      if (j < i)
      {
        localHeader = (Header)paramList.get(j);
        localf1 = localHeader.name.g();
        localf2 = localHeader.value;
        Integer localInteger = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(localf1);
        if (localInteger == null)
          break label423;
        k = 1 + localInteger.intValue();
        if ((k <= 1) || (k >= 8))
          break label417;
        if (Util.equal(Hpack.STATIC_HEADER_TABLE[(k - 1)].value, localf2))
          m = k;
      }
      while (true)
      {
        label161: int n;
        if (m == -1)
        {
          n = 1 + this.nextHeaderIndex;
          int i1 = this.dynamicTable.length;
          label182: if (n < i1)
          {
            if (!Util.equal(this.dynamicTable[n].name, localf1))
              break label308;
            if (!Util.equal(this.dynamicTable[n].value, localf2))
              break label288;
            m = n - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
          }
        }
        if (m != -1)
          writeInt(m, 127, 128);
        while (true)
        {
          j++;
          break;
          if (!Util.equal(Hpack.STATIC_HEADER_TABLE[k].value, localf2))
            break label417;
          m = k + 1;
          break label161;
          label288: if (k == -1)
            k = n - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
          label308: n++;
          break label182;
          if (k == -1)
          {
            this.out.b(64);
            writeByteString(localf1);
            writeByteString(localf2);
            insertIntoDynamicTable(localHeader);
          }
          else if ((localf1.a(Header.PSEUDO_PREFIX)) && (!Header.TARGET_AUTHORITY.equals(localf1)))
          {
            writeInt(k, 15, 0);
            writeByteString(localf2);
          }
          else
          {
            writeInt(k, 63, 64);
            writeByteString(localf2);
            insertIntoDynamicTable(localHeader);
          }
        }
        return;
        label417: m = -1;
        continue;
        label423: k = -1;
        m = -1;
      }
    }

    void writeInt(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.out.b(paramInt3 | paramInt1);
        return;
      }
      this.out.b(paramInt3 | paramInt2);
      int i = paramInt1 - paramInt2;
      while (i >= 128)
      {
        int j = i & 0x7F;
        this.out.b(j | 0x80);
        i >>>= 7;
      }
      this.out.b(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack
 * JD-Core Version:    0.6.2
 */