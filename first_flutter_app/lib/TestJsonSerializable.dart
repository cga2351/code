
import 'dart:convert';

import 'package:json_annotation/json_annotation.dart';

part 'TestJsonSerializable.g.dart';

@JsonSerializable()
class TestJsonSerializableEntity1 {
  String entity1StringParam;
  int entity1InParam;
  double entity1DoubleParam;
  int entity1NullParam;

  TestJsonSerializableEntity2 testJsonEntity2;

  TestJsonSerializableEntity1(
      this.entity1StringParam,
      this.entity1InParam,
      this.entity1DoubleParam,
      this.entity1NullParam,
      this.testJsonEntity2);

  factory TestJsonSerializableEntity1.fromJson(Map<String, dynamic> json) => _$TestJsonSerializableEntity1FromJson(json);
  Map<String, dynamic> toJson() => _$TestJsonSerializableEntity1ToJson(this);

  @override
  String toString() {
    return 'TestJsonSerializableEntity1{entity1StringParam: $entity1StringParam, entity1InParam: $entity1InParam, entity1DoubleParam: $entity1DoubleParam, entity1NullParam: $entity1NullParam, testJsonEntity2: $testJsonEntity2}';
  }


}

@JsonSerializable()
class TestJsonSerializableEntity2 {
  String entity2StringParam;
  int entity2InParam;
  double entity2DoubleParam;
  int entity2NullParam;

  TestJsonSerializableEntity2(
      this.entity2StringParam,
      this.entity2InParam,
      this.entity2DoubleParam,
      this.entity2NullParam);

  factory TestJsonSerializableEntity2.fromJson(Map<String, dynamic> json) => _$TestJsonSerializableEntity2FromJson(json);
  Map<String, dynamic> toJson() => _$TestJsonSerializableEntity2ToJson(this);
}

class Score {
  int score;
  String key1;
  String key2;
  String key3;

  Score();

  static dynamic fromJson(String json) {
   dynamic retObj;
    var jsonObj = jsonDecode(json);
    if (jsonObj is List) {
      retObj = List<Score>();
      for (var map in jsonObj) {
        Score score = Score();
        score.score = map["score"];
        score.key1 = map["key1"];
        score.key2 = map["key2"];
        score.key3 = map["key3"];
        retObj.add(score);
      }
    } else if (jsonObj is Map){
      Score score = Score();
      score.score = jsonObj["score"];
      score.key1 = jsonObj["key1"];
      score.key2 = jsonObj["key2"];
      score.key3 = jsonObj["key3"];
      retObj = score;
    }

    return retObj;
  }


}