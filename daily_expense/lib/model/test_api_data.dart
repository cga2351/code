import 'dart:convert';

class TestApiSubData {
  int subCode;
  String subResult;

  TestApiSubData(this.subCode, this.subResult);

  factory TestApiSubData.deepCopy(TestApiSubData testApiDataSubData) {
    return TestApiSubData(
        testApiDataSubData.subCode,
        testApiDataSubData.subResult);
  }

  factory TestApiSubData.fromJson(Map<String, dynamic> jsonMap) {
    return TestApiSubData(
      jsonMap["subCode"],
      jsonMap["subResult"],
    );
  }

  Map<String, dynamic> toJson() {
    return Map()
      ..["subCode"] = subCode
      ..["subResult"] = subResult;
  }

  factory TestApiSubData.fromJsonString(String jsonString) {
    return TestApiSubData.fromJson(jsonDecode(jsonString));
  }
  String toJsonString() {
    return jsonEncode(toJson());
  }

  static List<TestApiSubData> fromJsonArrayString(String jsonString) {
    List<TestApiSubData> resObj = [];
    try {
      var obj = jsonDecode(jsonString);
      if (obj is List) {
        resObj = List.from(obj.map((e) => TestApiSubData.fromJson(e)));
      } else {
        print("TestApiDataSubData.fromJsonArrayString(), param is not a json array");
      }
    } on Exception catch (e){
      print("TestApiDataSubData.fromJsonArrayString(), catch exception=$e");
    }
    return resObj;
  }

  static String toJsonArrayString(List<TestApiSubData> expenseItems) {
    return jsonEncode(expenseItems);
  }

  @override
  String toString() {
    return 'TestApiDataSubData{subCode: $subCode, subResult: $subResult}';
  }
}
//////////////////////////////////////////////////////////////////////////////
class TestApiData {
  int code;
  String result;
  TestApiSubData subData;

  TestApiData(this.code, this.result, this.subData);

  factory TestApiData.deepCopy(TestApiData testApiData) {
    return TestApiData(
        testApiData.code,
        testApiData.result,
        testApiData.subData
    );
  }

  factory TestApiData.fromJson(Map<String, dynamic> jsonMap) {
    return TestApiData(
      jsonMap["code"],
      jsonMap["result"],
      TestApiSubData.fromJson(jsonMap["subData"]),
    );
  }

  Map<String, dynamic> toJson() {
    return Map()
      ..["code"] = code
      ..["result"] = result
      ..["subData"] = subData.toJson();
  }

  factory TestApiData.fromJsonString(String jsonString) {
    return TestApiData.fromJson(jsonDecode(jsonString));
  }
  String toJsonString() {
    return jsonEncode(toJson());
  }

  static List<TestApiData> fromJsonArrayString(String jsonString) {
    List<TestApiData> resObj = [];
    try {
      var obj = jsonDecode(jsonString);
      if (obj is List) {
        resObj = List.from(obj.map((e) => TestApiData.fromJson(e)));
      } else {
        print("TestApiData.fromJsonArrayString(), param is not a json array");
      }
    } on Exception catch (e){
      print("TestApiData.fromJsonArrayString(), catch exception=$e");
    }
    return resObj;
  }

  static String toJsonArrayString(List<TestApiData> expenseItems) {
    return jsonEncode(expenseItems);
  }

  @override
  String toString() {
    return 'TestApiData{code: $code, result: $result, subData: $subData}';
  }
}