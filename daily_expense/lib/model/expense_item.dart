import 'dart:convert';

import 'package:dailyexpense/utils/local_data_storage.dart';

class ExpenseItem {
  int id;
  int dateTimestamp;
  String date;
  String type;  /// see [LocalDataStorage.presetTypes]
  int amount;
  String comment;
  int? serverId;

  // ExpenseItem(this.id, this.dateTimestamp, this.date, this.type, this.amount, this.comment);
  ExpenseItem(id, dateTimestamp, date, type, amount, comment, {int? serverId})
      : this.id = id,
        this.dateTimestamp = dateTimestamp,
        this.date = date,
        this.type = type,
        this.amount = amount,
        this.comment = comment,
        this.serverId = serverId {}

  factory ExpenseItem.deepCopy(ExpenseItem expenseItem) {
    return ExpenseItem(
      expenseItem.id,
      expenseItem.dateTimestamp,
      expenseItem.date,
      expenseItem.type,
      expenseItem.amount,
      expenseItem.comment,
      serverId: expenseItem.serverId,
    );
  }

  factory ExpenseItem.fromJson(Map<String, dynamic> jsonMap) {
    return ExpenseItem(
      jsonMap["id"],
      jsonMap["dateTimestamp"],
      jsonMap["date"],
      jsonMap["type"],
      jsonMap["amount"],
      jsonMap["comment"],
      serverId: jsonMap["serverId"],
    );
  }

  Map<String, dynamic> toJson() {
    return Map()
      ..["id"] = id
      ..["dateTimestamp"] = dateTimestamp
      ..["date"] = date
      ..["type"] = type
      ..["amount"] = amount
      ..["comment"] = comment
      ..["serverId"] = serverId;
  }

  factory ExpenseItem.fromJsonString(String jsonString) {
    return ExpenseItem.fromJson(jsonDecode(jsonString));
  }
  String toJsonString() {
    return jsonEncode(toJson());
  }

  static List<ExpenseItem> fromJsonArrayString(String jsonString) {
    List<ExpenseItem> result = [];
    try {
      var obj = jsonDecode(jsonString);
      if (obj is List) {
        result = List.from(obj.map((e) => ExpenseItem.fromJson(e)));
      } else {
        print("ExpenseItem.fromJsonArrayString(), param is not a json array");
      }
    } on Exception catch (e){
      print("ExpenseItem.fromJsonArrayString(), catch exception=$e");
    }
    return result;
  }

  static String toJsonArrayString(List<ExpenseItem> expenseItems) {
    return jsonEncode(expenseItems);
  }

  @override
  String toString() {
    return 'ExpenseItem{id: $id, dateTimestamp: $dateTimestamp, date: $date, type: $type, amount: $amount, comment: $comment, serverId: $serverId}';
  }

  static int comparatorDateIncrease(ele1, ele2) {
    if (ele1.dateTimestamp > ele2.dateTimestamp) {
      return 1;
    } else if (ele1.dateTimestamp < ele2.dateTimestamp) {
      return -1;
    } else {
      return 0;
    }
  }

  static int comparatorDateDecrease(ele1, ele2) {
    if (ele1.dateTimestamp > ele2.dateTimestamp) {
      return -1;
    } else if (ele1.dateTimestamp < ele2.dateTimestamp) {
      return 1;
    } else {
      return 0;
    }
  }
}