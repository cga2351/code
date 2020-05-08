// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'TestJsonSerializable.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TestJsonSerializableEntity1 _$TestJsonSerializableEntity1FromJson(
    Map<String, dynamic> json) {
  return TestJsonSerializableEntity1(
    json['entity1StringParam'] as String,
    json['entity1InParam'] as int,
    (json['entity1DoubleParam'] as num)?.toDouble(),
    json['entity1NullParam'] as int,
    json['testJsonEntity2'] == null
        ? null
        : TestJsonSerializableEntity2.fromJson(
            json['testJsonEntity2'] as Map<String, dynamic>),
  );
}

Map<String, dynamic> _$TestJsonSerializableEntity1ToJson(
        TestJsonSerializableEntity1 instance) =>
    <String, dynamic>{
      'entity1StringParam': instance.entity1StringParam,
      'entity1InParam': instance.entity1InParam,
      'entity1DoubleParam': instance.entity1DoubleParam,
      'entity1NullParam': instance.entity1NullParam,
      'testJsonEntity2': instance.testJsonEntity2,
    };

TestJsonSerializableEntity2 _$TestJsonSerializableEntity2FromJson(
    Map<String, dynamic> json) {
  return TestJsonSerializableEntity2(
    json['entity2StringParam'] as String,
    json['entity2InParam'] as int,
    (json['entity2DoubleParam'] as num)?.toDouble(),
    json['entity2NullParam'] as int,
  );
}

Map<String, dynamic> _$TestJsonSerializableEntity2ToJson(
        TestJsonSerializableEntity2 instance) =>
    <String, dynamic>{
      'entity2StringParam': instance.entity2StringParam,
      'entity2InParam': instance.entity2InParam,
      'entity2DoubleParam': instance.entity2DoubleParam,
      'entity2NullParam': instance.entity2NullParam,
    };
