
import 'dart:convert';
import 'dart:io';

import 'package:flutter/foundation.dart';

class FileUtils {

  static void appendString(String filePath, String content) {
    File file = File(filePath);
    if (!file.existsSync()) {
      file.createSync(recursive : true);
    }

    RandomAccessFile fileStream = file.openSync(mode: FileMode.append);
    fileStream.writeStringSync(content);
    fileStream.closeSync();
    // print("appendString(), write string, file=$file, content=$content");
  }

  static void writeString(String filePath, String content) {
    File file = File(filePath);
    if (!file.existsSync()) {
      file.createSync(recursive : true);
    }

    RandomAccessFile fileStream = file.openSync(mode: FileMode.write);
    fileStream.writeStringSync(content);
    fileStream.closeSync();
    print("writeString(), write string, file=$file, content=$content");
  }

  static String readString(String filePath) {
    File file = File(filePath);
    RandomAccessFile fileStream = file.openSync(mode: FileMode.read);
    int fileSize = fileStream.lengthSync();
    List<int> fileContentBytes = fileStream.readSync(fileSize);
    String fileContent = Utf8Decoder().convert(fileContentBytes);
    fileStream.closeSync();
    // print("readString(), fileContent=$fileContent");
    return fileContent;
  }
}