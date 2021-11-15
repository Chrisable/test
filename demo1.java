package com.company;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class task1 {
    public static void main(String[] args) throws Exception {
        File f = new File("D:" + File.separator + "engineering training");
        String[] fileList = f.list();
        String s1 = "业务处理时发生了异常: - aop.ModelLogsAspect";
        String s2 = "业务日志保存失败 - aop.BusinessLogAspect";
        int count1;
        int count2;
        int j=0;//控制空格
        Map<String,Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i < fileList.length; i++) {
            count1 = 0;
            count2 = 0;
            File f1 = new File(fileList[i]);
            if (fileList[i] != null && fileList[i].endsWith(".log")) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f+ File.separator+fileList[i]),"gbk");
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if (lineTxt.indexOf(s1)!=-1){
                        count1++;
                    }
                    if (lineTxt.indexOf(s2)!=-1){
                        count2++;
                    }
                }
                map.put(s1,count1);
                map.put(s2,count2);
                bufferedReader.close();
                read.close();
                Set<String> keys = map.keySet();
                for(String key:keys){
                    if (j==0){
                        System.out.println(key+"   "+"【"+map.get(key)+"次】");
                        j++;
                    }else {
                        System.out.println(key+"      "+"【"+map.get(key)+"次】");
                        j--;
                    }

                }
            }

        }

    }
}
