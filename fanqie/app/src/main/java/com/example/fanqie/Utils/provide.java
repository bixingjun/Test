package com.example.fanqie.Utils;
/*
 *  包名: com.example.fanqie.Utils
 * Created by ASUS on 2018/4/17.
 *  描述: TODO
 */

import com.example.fanqie.model.Card;
import com.example.fanqie.model.ContinuousUseModel;
import com.example.fanqie.model.Task;

import java.util.ArrayList;
import java.util.List;

public class provide {

    public static List<Task> getList(){
        ArrayList<Task> arr = new ArrayList<>();
        Task task= new Task(1, "完成工作计划", "重要", 4, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524413406976&di=021ccb590e5b343d7c4f76e31a7a8bb3&imgtype=0&src=http%3A%2F%2Fup.qqya.com%2Fallimg%2F201710-t%2F17-101803_90560.jpg");
        for (int i=1;i<=5;i++) {
        arr.add(task);

        }
        return arr;
    }
    public static List<ContinuousUseModel> gettimeList(){
        ArrayList<ContinuousUseModel> arr = new ArrayList<>();

        ContinuousUseModel model=new ContinuousUseModel(01,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524413406976&di=021ccb590e5b343d7c4f76e31a7a8bb3&imgtype=0&src=http%3A%2F%2Fup.qqya.com%2Fallimg%2F201710-t%2F17-101803_90560.jpg","stomtoto",100);
        for (int i=1;i<=5;i++) {
            arr.add(model);

        }
        return arr;
    }

    public static List<Card> getdayList(){
        ArrayList<Card> arr = new ArrayList<>();

        Card card=new Card(1,4,2,"工作",1);
        for (int i=1;i<=5;i++) {
            arr.add(card);

        }
        return arr;
    }
}
