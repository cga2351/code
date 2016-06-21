package com.example.cga2351.testksoapandroid;

/*
import cc.hwtech.core.util.IdGenerator;
import com.example.cga2351.DiseaseGroup;
import com.example.cga2351.DiseaseGroupDiseaseKey;
import com.xinglin.zhongyi.base.entity.DoctorDisease;
import com.xinglin.zhongyi.base.mapper.DiseaseGroupDiseaseMapper;
import com.xinglin.zhongyi.base.mapper.DiseaseGroupMapper;
import com.xinglin.zhongyi.base.mapper.DiseaseMapper;
import com.xinglin.zhongyi.base.mapper.DoctorDiseaseMapper;
import com.xinglin.zhongyi.domain.DiseaseBean;
import com.xinglin.zhongyi.mapper.DiseaseBeanMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

    @Resource
    private DiseaseMapper diseaseMapper;

    @Resource
    private DiseaseGroupMapper diseaseGroupMapper;

    @Resource
    private DiseaseGroupDiseaseMapper diseaseGroupDiseaseMapper;

    @Resource
    private DoctorDiseaseMapper doctorDiseaseMapper;

    @Resource
    private DiseaseBeanMapper diseaseBeanMapper;

    private static final String drId1 = "5555ad24c06a6d2765a49c41";//13608005400符
    private static final String drId2 = "55890cb108b005b0a93652ed";//15608025857蔡（演示账号）
    private static final String drId3 = "55810aeb08b0e4bdd492b3cb";//13608005498何
    private static final String drId4 = "55890cb108b005b0a93652ed";//15184303375兰
    private static final String drId5 = "558d109608b022fac11daad9";//13438391965蔡（测试账号）
    private static final String drId6 = "55890cb108b005b0a93652ed";//15608025856唐

    @org.junit.Test
    public void test(){

    }

    public void insertDisease(){
        String groupName1 = "妇产科";
        String diseaseName1[] = {
                "妇产科全科", "月经不调", "不孕不育", "卵巢囊肿", "内分泌失调", "闭经",
                "痛经", "经间期出血", "崩漏", "白带异常", "先兆流产", "习惯性流产","乳腺增生", "乳腺炎", "乳汁不足",
                "子宫肌瘤", "子宫内膜异位", "子宫腺肌病", "子宫脱垂", "更年期综合征", "盆腔炎",
                "宫颈炎", "阴道炎", "妇科炎症", "产后风湿", "多囊卵巢综合征", "输卵管堵塞", "功能性子宫出血"
        };
        String groupName2 = "儿科";
        String diseaseName2[] = {
                "儿科全科","感冒","咳嗽","哮喘","支气管炎","发烧","湿疹","（小儿）肺炎",
                "（小儿）鼻炎","（小儿）心肌炎","（小儿）喉炎","水痘","腮腺炎","腹泻",
                "呕吐","厌食","腹痛","便秘","癫痫","脑瘫","遗尿","（小儿）紫癜","汗症",
                "夜啼","（小儿）黄疸","抽动症","营养不良","（小儿）手足口病","（小儿）脑积水","川崎病"
        };
        String groupName3 = "骨科";
        String diseaseName3[] = {
                "骨科全科","腰椎间盘突出","颈椎病","肩周炎","关节损伤","风湿","骨折","腰肌劳损",
                "腱鞘炎","筋膜炎","滑膜炎","骨质疏松","运动创伤","韧带损伤","腱鞘囊肿",
                "类风湿关节炎","重症肌无力","格林巴利综合症"
        };
        String groupName4 = "皮肤";
        String diseaseName4[] = {
                "皮肤全科","痤疮","黄褐斑","湿疹","荨麻疹","银屑病","脱发","白癜风","皮炎","神经性皮炎",
                "皮肤过敏","带状疱疹","脂溢性皮炎","皮肤瘙痒","癣","日光性皮炎","红斑狼疮","口腔溃疡",
                "口腔扁平苔癣","扁平疣","尖锐湿疣","疣","毛囊炎","过敏性紫癜","梅毒","外阴白斑"
        };
        String groupName5 = "内分泌";
        String diseaseName5[] = {
                "内分泌全科","糖尿病","甲亢","甲减","甲状腺炎","黄疸","肥胖病","痛风","高尿酸血症"
        };
        String groupName6 = "肾病";
        String diseaseName6[] = {
                "肾病全科","急性肾炎","慢性肾炎","肾病综合征","肾功能衰竭","尿路感染","紫癜性肾炎","尿毒症"
        };
        String groupName7 = "免疫";
        String diseaseName7[] = {
                "免疫全科","类风湿关节炎","强直性脊柱炎","红斑狼疮","风湿病","痛风","肿瘤","血液病","自体免疫性疾病"
        };
        String groupName8 = "心内";
        String diseaseName8[] = {
                "心内全科","冠心病","高血压","心律失常","心肌炎","高血脂","心肌病","心衰","房颤","风湿性心脏病","心脏神经官能症"
        };
        String groupName9 = "血液";
        String diseaseName9[] = {
                "血液全科","贫血","再生障碍性贫血","血小板减少性紫癜","白血病","白细胞减少症","多发性骨髓瘤"
        };
        String groupName10 = "神经";
        String diseaseName10[] = {
                "神经全科","脑梗塞","失眠","头痛","眩晕","中风","脑血栓","抑郁症","脑出血",
                "脑血管病","面瘫","偏瘫","耳鸣","耳聋","自汗","盗汗","倒汗","心悸", "冠心病","强迫症",
                "焦虑症","癫狂","癫痫","帕金森","神经衰弱","神经炎","遗传代谢病","小儿脑瘫","三叉神经痛"
        };
        String groupName11 = "消化";
        String diseaseName11[] = {
                "消化全科","胃炎","胃溃疡","泄泻","便秘","黄疸","胆囊炎","胆结石","急性肝炎","慢性肝炎",
                "肝硬化","肝癌","乙肝","脂肪肝","肝腹水","酒精肝","自身免疫性肝病","肠炎","消化不良",
                "肠胃炎","结肠炎","溃疡性结肠炎","肠易激综合征","痔疮","外痔","内痔","混合痔","肛瘘","肛裂",
                "肛周脓肿","直肠癌","结肠癌","直肠脱垂","肠息肉","肠粘连",
        };
        String groupName12 = "呼吸";
        String diseaseName12[] = {
                "呼吸全科","感冒","咳嗽","哮喘","慢性支气管炎","支气管炎","肺炎","肺气肿","肺心病","结核病",
                "过敏性鼻炎","鼻窦炎","急性咽炎","慢性咽炎","声带小结","扁桃体炎","间质性肺炎"
        };
        String groupName13 = "肿瘤";
        String diseaseName13[] = {
                "肿瘤全科","肺癌","乳腺癌","胃癌","肝癌","结肠癌","直肠癌","食道癌","胰腺癌","鼻咽癌",
                "宫颈癌","甲状腺癌","子宫内膜癌","膀胱癌","喉癌","卵巢肿瘤","淋巴瘤","肿瘤"
        };
        String groupName14 = "男科";
        String diseaseName14[] = {
                "男科全科","水肿","急性尿路感染","慢性尿路感染","腰痛","遗精","阳痿","早泄",
                "男性不育","前列腺疾病","精索静脉曲张","肾结石","尿结石","急性肾炎","慢性肾炎",
                "尿毒症","前列腺增生","附睾炎","精囊炎","胰腺炎",
        };
        String groupName15 = "五官科";
        String diseaseName15[] = {
                "五官全科" ,"干眼症","白内障","青光眼","角膜炎","结膜炎","视网膜脱落","麦粒肿","弱视","斜视","耳鸣","扁桃体炎"
        };

        Map<String, String[]> data = new HashMap<>();
        data.put(groupName1, diseaseName1);
        data.put(groupName2, diseaseName2);
        data.put(groupName3, diseaseName3);
        data.put(groupName4, diseaseName4);
        data.put(groupName5, diseaseName5);
        data.put(groupName6, diseaseName6);
        data.put(groupName7, diseaseName7);
        data.put(groupName8, diseaseName8);
        data.put(groupName9, diseaseName9);
        data.put(groupName10, diseaseName10);
        data.put(groupName11, diseaseName11);
        data.put(groupName12, diseaseName12);
        data.put(groupName13, diseaseName13);
        data.put(groupName14, diseaseName14);
        data.put(groupName15, diseaseName15);

        Iterator iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String groupName = (String)entry.getKey();
            String diseaseName[] = (String[])entry.getValue();
            DiseaseGroup diseaseGroup = new DiseaseGroup();
            diseaseGroup.setDgpId(IdGenerator.getID());
            diseaseGroup.setDgpName(groupName);
            diseaseGroup.setDgpSort(1);
            diseaseGroup.setDgpStatus(1);
            diseaseGroupMapper.insertSelective(diseaseGroup);

            for(int i = 0; i < diseaseName.length; i++){

                DiseaseBean diseaseBean = diseaseBeanMapper.selectDiseaseBeanByDisName(diseaseName[i]);
                if(diseaseBean == null){
                    diseaseBean = new DiseaseBean();
                    diseaseBean.setDisId(IdGenerator.getID());
                    diseaseBean.setDisName(diseaseName[i]);
                    diseaseBean.setDisSort(i);
                    diseaseBean.setDisRemark(diseaseName[i]);
                    diseaseBean.setDisStatus(1);
                    diseaseBean.setDisLevel(1);
                    diseaseMapper.insertSelective(diseaseBean);
                }
                DiseaseGroupDiseaseKey diseaseGroupDiseaseKey = new DiseaseGroupDiseaseKey();
                diseaseGroupDiseaseKey.setDgpId(diseaseGroup.getDgpId());
                diseaseGroupDiseaseKey.setDisId(diseaseBean.getDisId());
                diseaseGroupDiseaseMapper.insertSelective(diseaseGroupDiseaseKey);

                if(i<7){
                    DoctorDisease doctorDisease = new DoctorDisease();
                    doctorDisease.setDisId(diseaseBean.getDisId());
                    doctorDisease.setDgpId(diseaseGroup.getDgpId());
                    doctorDisease.setDdeId(IdGenerator.getID());
                    doctorDisease.setDdeRefType(2);
                    if(i%6 == 1){
                        doctorDisease.setDdeRefId(drId1);
                    }
                    if(i%6 == 2){
                        doctorDisease.setDdeRefId(drId2);
                    }
                    if(i%6 == 3){
                        doctorDisease.setDdeRefId(drId3);
                    }
                    if(i%6 == 4){
                        doctorDisease.setDdeRefId(drId4);
                    }
                    if(i%6 == 5){
                        doctorDisease.setDdeRefId(drId5);
                    }
                    if(i%6 == 0){
                        doctorDisease.setDdeRefId(drId6);
                    }
                    doctorDiseaseMapper.insertSelective(doctorDisease);
                }
            }
        }
    }


}

*/